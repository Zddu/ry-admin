package com.ruoyi.assets.service.impl;

import java.util.*;

import com.ruoyi.assets.domain.*;
import com.ruoyi.assets.mapper.AssetsContractMapper;
import com.ruoyi.assets.mapper.AssetsItemsDistributeMapper;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.SysDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsItemsMapper;
import com.ruoyi.assets.service.IAssetsItemsService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 资产管理Service业务层处理
 *
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@Service
public class AssetsItemsServiceImpl implements IAssetsItemsService {
    @Autowired
    private AssetsItemsMapper assetsItemsMapper;
    @Autowired
    private SysDeptMapper sysDeptMapper;
    @Autowired
    private AssetsContractMapper assetsContractMapper;
    @Autowired
    private AssetsItemsDistributeMapper assetsItemsDistributeMapper;

    /**
     * 查询资产管理
     *
     * @param id 资产管理ID
     * @return 资产管理
     */
    @Override
    public AssetsItems selectAssetsItemsSchoolById(Long id) {
        return assetsItemsMapper.selectAssetsItemsSchoolById(id);
    }

    /**
     * 查询资产管理列表
     *
     * @param assetsItems 资产管理
     * @return 资产管理
     */
    @Override
    public List<AssetsItems> selectAssetsItemsSchoolList(AssetsItems assetsItems) {
        List<AssetsItems> result = assetsItemsMapper.selectAssetsItemsSchoolList(assetsItems);

        for (AssetsItems item : result) {
            SysDept sysDept = sysDeptMapper.selectDeptById(item.getItemBelonger());
            if (sysDept == null) {
                throw new CustomException("单位id无法查询到具体单位");
            }
            item.setItemBelongerName(sysDept.getDeptName());
        }
        return result;
    }
    @Override
    public List<AssetsItems> selectAssetsItemsSchoolListNeed2Review(AssetsItems assetsItems) {
        assetsItems.setIsWriteOff(1);
        List<AssetsItems> result = assetsItemsMapper.selectAssetsItemsSchoolList(assetsItems);
        for (AssetsItems item : result) {
            SysDept sysDept = sysDeptMapper.selectDeptById(item.getItemBelonger());
            if (sysDept == null) {
                throw new CustomException("单位id无法查询到具体单位");
            }
            item.setItemBelongerName(sysDept.getDeptName());
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAssetsItemsSchoolByIds(Long[] ids) {
        int result=0;
        for (Long id : ids) {
            AssetsItems assetsItems = assetsItemsMapper.selectAssetsItemsSchoolById(id);
            assetsItems.setIsWriteOff(2);
            result+=assetsItemsMapper.updateAssetsItemsSchool(assetsItems);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAssetsItemsSchoolWriteOffByIds(Long[] ids) {
        int result=0;
        for (Long id : ids) {
            AssetsItems assetsItems = assetsItemsMapper.selectAssetsItemsSchoolById(id);
            if(assetsItems.getIsWriteOff()!=0){
                throw new CustomException("所选设备包含非未核销项，请重新选择");
            }
            assetsItems.setIsWriteOff(1);
            result+=assetsItemsMapper.updateAssetsItemsSchool(assetsItems);
        }
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateAssetsItemsSchoolByAssetsItems(List<AssetsItems> assetsItems) {
        int result=0;
        for (AssetsItems assetsItem : assetsItems) {
            AssetsItems item = assetsItemsMapper.selectAssetsItemsSchoolById(assetsItem.getId());
            item.setReasons(assetsItem.getReasons());
            item.setIsWriteOff(0);
            result+=assetsItemsMapper.updateAssetsItemsSchool(item);
        }
        return result;
    }

    private List<AssetsItems> filterDepartmentsByName(List<AssetsItems> assetsItems,String name) {
        List<AssetsItems> result =new ArrayList<>();
        for (AssetsItems assetsItem : assetsItems) {
            if(assetsItem.fuzzyMatching(name)){
                result.add(assetsItem);
            }
        }
        return result;
    }

    /**
     * 新增资产管理
     *
     * @param assetsItems 资产管理
     * @return 结果
     */
    @Override
    public int insertAssetsItemsSchool(AssetsItems assetsItems) {
        assetsItems.setCreateTime(DateUtils.getNowDate());
        return assetsItemsMapper.insertAssetsItemsSchool(assetsItems);
    }
    @Deprecated
    private void checkedBatchNum(AssetsItems assetsItems) {
        if (!ObjectUtils.isEmpty(assetsItemsMapper.selectAssetsItemsSchoolList(new AssetsItems(assetsItems.getBatchNum())))){
            throw new CustomException("批次号："+assetsItems.getBatchNum()+"已存在");
        }
    }


    /**
     * 修改资产管理
     *
     * @param assetsItems 资产管理
     * @return 结果
     */
    @Override
    public int updateAssetsItemsSchool(AssetsItems assetsItems) {
        AssetsItems assetsItems1 = assetsItemsMapper.selectAssetsItemsSchoolById(assetsItems.getId());
        System.out.println(assetsItems1);
        if (assetsItems1.getIsWriteOff()==1||assetsItems1.getIsWriteOff()==2){
            throw new CustomException("资产正在核销中或已核销，不能进行修改");
        }
        return assetsItemsMapper.updateAssetsItemsSchool(assetsItems);
    }

    /**
     * 批量删除资产管理
     *
     * @param ids 需要删除的资产管理ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsSchoolByIds(Long[] ids) {
        AssetsItems assetsItems =null;
        AssetsItemsDistribute assetsItemsDistribute=null;
        long num=0;
        for (Long id : ids) {
            assetsItems = assetsItemsMapper.selectAssetsItemsSchoolById(id);
            assetsItemsDistribute =assetsItemsDistributeMapper.selectAssetsItemsDistributeByBelongerAndBatch(assetsItems.getBatchNum(),assetsItems.getItemBelonger());
            num=assetsItemsDistribute.getItemNum()-1L;
            if (num>0){
                assetsItemsDistribute.setItemNum(num);
                assetsItemsDistributeMapper.updateAssetsItemsDistribute(assetsItemsDistribute);
            }else {
                assetsItemsDistributeMapper.deleteAssetsItemsDistributeById(assetsItemsDistribute.getId());
            }

        }
        return assetsItemsMapper.deleteAssetsItemsSchoolByIds(ids);
    }

    /**
     * 删除资产管理信息
     *
     * @param id 资产管理ID
     * @return 结果
     */
    @Override
    public int deleteAssetsItemsSchoolById(Long id) {
        return assetsItemsMapper.deleteAssetsItemsSchoolById(id);
    }

    @Override
    public List<String> getBatchNum() {
        List<String> batchNums=assetsItemsMapper.getBatchNum();
        HashSet<String> objects = new HashSet<>();
        objects.addAll(batchNums);
        return batchNums;
    }

    @Override
    public List<AssetsStatisticsBySchool> AssetsStatisticsBySchool() {

        return assetsItemsMapper.selectAssetsStatisticsBySchool();
    }

    @Override
    public List<AssetsStatisticsByType> AssetsStatisticsByType() {
        return assetsItemsMapper.selectAssetsStatisticsByType();
    }

    @Override
    public List<AssetsStatisticsByBatch> AssetsStatisticsByBatch() {
        return assetsItemsMapper.selectAssetsStatisticsByBatch();
    }

    @Override
    public List<AssetsItemsMaintenance> selectAssetsAssetsItemsMaintenanceList(AssetsItems assetsItems) {
        List<AssetsItems> assetsItemsList = this.selectAssetsItemsSchoolList(assetsItems);
        List<AssetsItemsMaintenance> result =new ArrayList<>();
        for (AssetsItems items : assetsItemsList) {
            result.addAll(items.getMaintenanceRecords());
        }
        return result;
    }

    @Override
    public List<AssetsItems> AssetsItemsStatisticsBySchool() {
        List<AssetsStatisticsBySchool> assetsStatisticsBySchools = this.AssetsStatisticsBySchool();
        List<AssetsItems> result=new ArrayList<>();
        for (AssetsStatisticsBySchool assetsStatisticsBySchool : assetsStatisticsBySchools) {
            result.addAll(assetsStatisticsBySchool.getAssetsItemsList());
        }
        return result;
    }

    @Override
    public List<AssetsStatistics> getAssetsStatistics(AssetsItems assetsItems) {
        List<AssetsStatistics> assetsStatistics = assetsItemsMapper.getAssetsStatistics(assetsItems);
        List<AssetsContract> assetsContracts =null;
        for (AssetsStatistics assetsStatistic : assetsStatistics) {
            assetsContracts = assetsContractMapper.selectAssetsContractByBatch(assetsStatistic.getBatchNum());
            if (assetsContracts.size()==0){
                assetsStatistic.setIsContract(0);
            }else{
                assetsStatistic.setIsContract(1);
            }
        }
        return assetsStatistics;
    }

    @Override
    public List<String> getSchoolsByAssetsItem(AssetsItems assetsItems) {
        return assetsItemsMapper.getSchoolsByAssetsItem(assetsItems);
    }

    @Override
    public List<String> getBatchNumByAssetsItem(AssetsItems assetsItems) {
        return assetsItemsMapper.getBatchNumByAssetsItem(assetsItems);
    }

    @Override
    public List<String> getTypesByAssetsItem(AssetsItems assetsItems) {
        return assetsItemsMapper.getTypesByAssetsItem(assetsItems);
    }


}
