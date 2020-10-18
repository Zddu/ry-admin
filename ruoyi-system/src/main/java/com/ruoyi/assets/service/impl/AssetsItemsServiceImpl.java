package com.ruoyi.assets.service.impl;

import java.beans.Customizer;
import java.util.*;
import java.util.stream.Collectors;

import com.ruoyi.assets.domain.*;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.SysDeptMapper;
import com.sun.corba.se.impl.orbutil.ObjectUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsItemsMapper;
import com.ruoyi.assets.service.IAssetsItemsService;
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
        if (!StringUtils.isEmpty(assetsItems.getItemBelongerName())){
            result=filterDepartmentsByName(result,assetsItems.getItemBelongerName());
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
        assetsItems.setIsModify(0);
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
    public List<Long> getBatchNum() {
        List<Long> batchNums=assetsItemsMapper.getBatchNum();
        HashSet<Long> objects = new HashSet<>();
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
}
