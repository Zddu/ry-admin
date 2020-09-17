package com.ruoyi.assets.mapper;

import java.util.List;
import com.ruoyi.assets.domain.AssetsContract;

/**
 * 合同Mapper接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-17
 */
public interface AssetsContractMapper 
{
    /**
     * 查询合同
     * 
     * @param id 合同ID
     * @return 合同
     */
    public AssetsContract selectAssetsContractById(Long id);

    /**
     * 查询合同列表
     * 
     * @param assetsContract 合同
     * @return 合同集合
     */
    public List<AssetsContract> selectAssetsContractList(AssetsContract assetsContract);

    /**
     * 新增合同
     * 
     * @param assetsContract 合同
     * @return 结果
     */
    public int insertAssetsContract(AssetsContract assetsContract);

    /**
     * 修改合同
     * 
     * @param assetsContract 合同
     * @return 结果
     */
    public int updateAssetsContract(AssetsContract assetsContract);

    /**
     * 删除合同
     * 
     * @param id 合同ID
     * @return 结果
     */
    public int deleteAssetsContractById(Long id);

    /**
     * 批量删除合同
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteAssetsContractByIds(Long[] ids);
}
