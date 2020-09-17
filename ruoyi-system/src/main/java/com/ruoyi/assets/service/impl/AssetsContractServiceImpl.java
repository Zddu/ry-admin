package com.ruoyi.assets.service.impl;

import java.util.List;

import com.ruoyi.assets.domain.AssetsItems;
import com.ruoyi.assets.domain.AssetsSupplier;
import com.ruoyi.assets.mapper.AssetsItemsMapper;
import com.ruoyi.assets.mapper.AssetsSupplierMapper;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsContractMapper;
import com.ruoyi.assets.domain.AssetsContract;
import com.ruoyi.assets.service.IAssetsContractService;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

/**
 * 合同Service业务层处理
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
@Service
public class AssetsContractServiceImpl implements IAssetsContractService 
{
    @Autowired
    private AssetsContractMapper assetsContractMapper;
    @Autowired
    private AssetsItemsMapper assetsItemsMapper;
    @Autowired
    private AssetsSupplierMapper assetsSupplierMapper;

    /**
     * 查询合同
     * 
     * @param id 合同ID
     * @return 合同
     */
    @Override
    public AssetsContract selectAssetsContractById(Long id)
    {
        return assetsContractMapper.selectAssetsContractById(id);
    }

    /**
     * 查询合同列表
     * 
     * @param assetsContract 合同
     * @return 合同
     */
    @Override
    public List<AssetsContract> selectAssetsContractList(AssetsContract assetsContract)
    {
        return assetsContractMapper.selectAssetsContractList(assetsContract);
    }

    /**
     * 新增合同
     * 
     * @param assetsContract 合同
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertAssetsContract(AssetsContract assetsContract) {
        int result = assetsContractMapper.insertAssetsContract(assetsContract);
        if (result<=0){
            return -1;
        }
        if (!ObjectUtils.isEmpty(assetsContract.getItemsId())){
            for (Long id :  assetsContract.getItemsId()) {
                AssetsItems assetsItems = assetsItemsMapper.selectAssetsItemsById(id);
                assetsItems.setContractId(assetsContract.getId());
                assetsItemsMapper.updateAssetsItems(assetsItems) ;
            }
        }
        if (!ObjectUtils.isEmpty(assetsContract.getSupplierId())){
            AssetsSupplier assetsSupplier = assetsSupplierMapper.selectAssetsSupplierById(assetsContract.getSupplierId());
            assetsSupplier.setContractId(assetsContract.getId());
            assetsSupplierMapper.updateAssetsSupplier(assetsSupplier);
        }
        return result;
    }

    /**
     * 修改合同
     * 
     * @param assetsContract 合同
     * @return 结果
     */
    @Override
    public int updateAssetsContract(AssetsContract assetsContract)
    {
        assetsContract.setUpdateTime(DateUtils.getNowDate());
        return assetsContractMapper.updateAssetsContract(assetsContract);
    }

    /**
     * 批量删除合同
     * 
     * @param ids 需要删除的合同ID
     * @return 结果
     */
    @Override
    public int deleteAssetsContractByIds(Long[] ids)
    {
        return assetsContractMapper.deleteAssetsContractByIds(ids);
    }

    /**
     * 删除合同信息
     * 
     * @param id 合同ID
     * @return 结果
     */
    @Override
    public int deleteAssetsContractById(Long id)
    {
        return assetsContractMapper.deleteAssetsContractById(id);
    }
}
