package com.ruoyi.assets.service;

import java.util.List;
import com.ruoyi.assets.domain.AssetsContract;

/**
 * 合同管理Service接口
 * 
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
public interface IAssetsContractService 
{
    /**
     * 查询合同管理
     * 
     * @param id 合同管理ID
     * @return 合同管理
     */
    public AssetsContract selectAssetsContractById(Long id);

    /**
     * 查询合同管理列表
     * 
     * @param assetsContract 合同管理
     * @return 合同管理集合
     */
    public List<AssetsContract> selectAssetsContractList(AssetsContract assetsContract);

    /**
     * 新增合同管理
     * 
     * @param assetsContract 合同管理
     * @return 结果
     */
    public int insertAssetsContract(AssetsContract assetsContract);

    /**
     * 修改合同管理
     * 
     * @param assetsContract 合同管理
     * @return 结果
     */
    public int updateAssetsContract(AssetsContract assetsContract);

    /**
     * 批量删除合同管理
     * 
     * @param ids 需要删除的合同管理ID
     * @return 结果
     */
    public int deleteAssetsContractByIds(Long[] ids);

    /**
     * 删除合同管理信息
     * 
     * @param id 合同管理ID
     * @return 结果
     */
    public int deleteAssetsContractById(Long id);
}
