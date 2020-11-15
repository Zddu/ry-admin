package com.ruoyi.assets.service.impl;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.mapper.AssetsItemsMapper;
import com.ruoyi.assets.service.IAssetsItemsService;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsItemsDistributeMapper;
import com.ruoyi.assets.domain.AssetsItemsDistribute;
import com.ruoyi.assets.service.IAssetsItemsDistributeService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import javax.jws.Oneway;
import javax.xml.transform.Source;

/**
 * 资产分发Service业务层处理
 *
 * @author Zddeä¸¶
 * @date 2020-10-16
 */
@Service
public class AssetsItemsDistributeServiceImpl implements IAssetsItemsDistributeService {
    @Autowired
    private AssetsItemsDistributeMapper assetsItemsDistributeMapper;
    @Autowired
    private AssetsItemsMapper assetsItemsMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private IAssetsItemsService assetsItemsService;

    /**
     * 查询资产分发
     *
     * @param id 资产分发ID
     * @return 资产分发
     */
    @Override
    public AssetsItemsDistribute selectAssetsItemsDistributeById(Long id) {
        return assetsItemsDistributeMapper.selectAssetsItemsDistributeById(id);
    }

    /**
     * 查询资产分发列表
     *
     * @param assetsItemsDistribute 资产分发
     * @return 资产分发
     */
    @Override
    public List<AssetsItemsDistribute> selectAssetsItemsDistributeList(AssetsItemsDistribute assetsItemsDistribute) {
        List<AssetsItemsDistribute> result = assetsItemsDistributeMapper.selectAssetsItemsDistributeList(assetsItemsDistribute);
        for (AssetsItemsDistribute item : result) {
            SysDept sysDept = sysDeptMapper.selectDeptById(item.getItemBelonger());
            if (sysDept == null) {
                throw new CustomException("单位id无法查询到具体单位");
            }
            item.setItemBelongerName(sysDept.getDeptName());
        }
        if (!StringUtils.isEmpty(assetsItemsDistribute.getItemBelongerName())) {
            result = filterDepartmentsByName(result, assetsItemsDistribute.getItemBelongerName());
        }
        return result;
    }

    private List<AssetsItemsDistribute> filterDepartmentsByName(List<AssetsItemsDistribute> assetsItems, String name) {
        List<AssetsItemsDistribute> result = new ArrayList<>();
        for (AssetsItemsDistribute assetsItem : assetsItems) {
            if (assetsItem.fuzzyMatching(name)) {
                result.add(assetsItem);
            }
        }
        return result;
    }

    /**
     * 新增资产分发
     *
     * @param assetsItemsDistribute 资产分发
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAssetsItemsDistribute(AssetsItemsDistribute assetsItemsDistribute) {
        assetsItemsDistribute.setCreateTime(DateUtils.getNowDate());
        Integer result = 0;
        if (ObjectUtils.isEmpty(assetsItemsDistribute.getSchools())) {
            throw new CustomException("学校为空，无法进行发布");
        }
        checkSchool(assetsItemsDistribute);
        result += insertDistributeRecord(assetsItemsDistribute);

        return result;
    }


    /**
     * 判断上传的学校id是根id，则遍历根下的所有学校，否则不变
     *
     * @param assetsItemsDistribute
     * @return
     */
    private AssetsItemsDistribute checkSchool(AssetsItemsDistribute assetsItemsDistribute) {
        List<Long> result=new ArrayList<>();
        for (Long school : assetsItemsDistribute.getSchools()) {
            List<Long> sysDepts = sysDeptMapper.selectChildrenIdDeptById(school);
            if (ObjectUtils.isEmpty(sysDepts)){
                result.add(school);
            }else{
                result.addAll(sysDepts);
            }
        }
        Long[] longs=new Long[result.size()];
        for (int i=0;i<result.size();i++) {
            longs[i]=result.get(i);
        }
        assetsItemsDistribute.setSchools(longs);
        return assetsItemsDistribute;
    }


    /**
     * 修改资产分发
     *
     * @param assetsItemsDistribute 资产分发
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAssetsItemsDistribute(AssetsItemsDistribute assetsItemsDistribute) {
        Integer result=0;
        System.out.println(assetsItemsDistribute.getId());
        result+=assetsItemsMapper.deleteAssetsItemsSchoolByItemsDistributeId(assetsItemsDistribute.getId());
        for (int i=0;i<assetsItemsDistribute.getItemNum();i++) {
            AssetsItems assetsItems = new AssetsItems();
            BeanUtils.copyProperties(assetsItemsDistribute,assetsItems);
            result+=assetsItemsService.insertAssetsItemsSchool(assetsItems);
        }
        result+=assetsItemsDistributeMapper.updateAssetsItemsDistribute(assetsItemsDistribute);
        return result;
    }

    /**
     * 批量删除资产分发
     *
     * @param ids 需要删除的资产分发ID
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteAssetsItemsDistributeByIds(Long[] ids) {
        for (Long id : ids) {
            AssetsItemsDistribute assetsItemsDistribute = assetsItemsDistributeMapper.selectAssetsItemsDistributeById(id);
            if (assetsItemsDistribute.getState()==1){
                throw new CustomException("包含已发布的记录，不能删除");
            }
        }

        int result = 0;
        result += assetsItemsMapper.deleteAssetsItemsByDistributeByIds(ids);
        result += assetsItemsDistributeMapper.deleteAssetsItemsDistributeByIds(ids);
        return result;
    }


    /**
     * 删除资产分发信息
     *
     * @param id 资产分发ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsDistributeById(Long id) {
        return assetsItemsDistributeMapper.deleteAssetsItemsDistributeById(id);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAssetsItemsByDistributeRecode(Long[] ids) {
        int result=0;

        for (Long id : ids) {
            AssetsItemsDistribute assetsItemsDistribute = assetsItemsDistributeMapper.selectAssetsItemsDistributeById(id);
            if (assetsItemsDistribute.getState()==1){
                throw new CustomException("包含已发布的记录，不能进行操作");
            }
            assetsItemsDistribute.setState(1);
            assetsItemsDistributeMapper.updateAssetsItemsDistribute(assetsItemsDistribute);
            AssetsItems assetsItems = new AssetsItems();
            for (int i=0;i<assetsItemsDistribute.getItemNum();i++){
                BeanUtils.copyProperties(assetsItemsDistribute,assetsItems);
                result+=assetsItemsMapper.insertAssetsItemsSchool(assetsItems);
            }

        }
        return result;
    }

    /**
     * 将通过分发的设备数量批量插入分发设备的记录
     *
     * @param assetsItemsDistribute 教体局分发设备数量
     * @return
     */
    private Integer insertAssetsItemsAndDistributeRecord(AssetsItemsDistribute assetsItemsDistribute) {
        Integer result = 0;
        for (Long schoolId : assetsItemsDistribute.getSchools()) {
            assetsItemsDistribute.setItemBelonger(schoolId);
            result += assetsItemsDistributeMapper.insertAssetsItemsDistribute(assetsItemsDistribute);
//            for (int i = 0; i < assetsItemsDistribute.getItemNum(); i++) {
//                AssetsItems assetsItems = new AssetsItems();
//                BeanUtils.copyProperties(assetsItemsDistribute, assetsItems);
//                assetsItems.setIsModify(1);
//                assetsItems.setDistributeId(assetsItemsDistribute.getId());
//                result += assetsItemsService.insertAssetsItemsSchool(assetsItems);
//            }
        }

        return result;
    }

    /**
     * 根据上传的学校数分批插入记录
     */
    private Integer insertDistributeRecord(AssetsItemsDistribute assetsItemsDistribute) {
        int result = 0;
        for (Long school : assetsItemsDistribute.getSchools()) {
            assetsItemsDistribute.setItemBelonger(school);
            assetsItemsDistribute.setState(0);
            result += assetsItemsDistributeMapper.insertAssetsItemsDistribute(assetsItemsDistribute);
        }
        return result;
    }
}
