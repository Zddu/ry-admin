package com.ruoyi.assets.service.impl;

import java.util.List;

import com.ruoyi.common.exception.CustomException;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.assets.mapper.AssetsContractMapper;
import com.ruoyi.assets.domain.AssetsContract;
import com.ruoyi.assets.service.IAssetsContractService;
import org.springframework.util.ObjectUtils;

/**
 * 合同管理Service业务层处理
 *
 * @author Zddeä¸¶
 * @date 2020-09-23
 */
@Service
public class AssetsContractServiceImpl implements IAssetsContractService {
    @Autowired
    private AssetsContractMapper assetsContractMapper;

    /**
     * 查询合同管理
     *
     * @param id 合同管理ID
     * @return 合同管理
     */
    @Override
    public AssetsContract selectAssetsContractById(Long id) {
        return assetsContractMapper.selectAssetsContractById(id);
    }

    /**
     * 查询合同管理列表
     *
     * @param assetsContract 合同管理
     * @return 合同管理
     */
    @Override
    public List<AssetsContract> selectAssetsContractList(AssetsContract assetsContract) {
        return assetsContractMapper.selectAssetsContractList(assetsContract);
    }

    /**
     * 新增合同管理
     *
     * @param assetsContract 合同管理
     * @return 结果
     */
    @Override
    public int insertAssetsContract(AssetsContract assetsContract) {
        assetsContract.setCreateTime(DateUtils.getNowDate());
        assetsContract.setUpdateTime(DateUtils.getNowDate());
        return assetsContractMapper.insertAssetsContract(assetsContract);
    }

    /**
     * 修改合同管理
     *
     * @param assetsContract 合同管理
     * @return 结果
     */
    @Override
    public int updateAssetsContract(AssetsContract assetsContract) {
        assetsContract.setUpdateTime(DateUtils.getNowDate());
        return assetsContractMapper.updateAssetsContract(assetsContract);
    }

    /**
     * 批量删除合同管理
     *
     * @param ids 需要删除的合同管理ID
     * @return 结果
     */
    @Override
    public int deleteAssetsContractByIds(Long[] ids) {
        return assetsContractMapper.deleteAssetsContractByIds(ids);
    }

    /**
     * 删除合同管理信息
     *
     * @param id 合同管理ID
     * @return 结果
     */
    @Override
    public int deleteAssetsContractById(Long id) {
        return assetsContractMapper.deleteAssetsContractById(id);
    }

    @Override
    public List<AssetsContract> selectAssetsContractByBatch(String batch) {
        return assetsContractMapper.selectAssetsContractByBatch(batch);
    }

//    private void checkContractBatchNum(Long batchNum) {
//        if (batchNum==null){
//            return;
//        }
//        List<AssetsContract> assetsContracts = assetsContractMapper.selectAssetsContractList(new AssetsContract(batchNum));
//        if (!ObjectUtils.isEmpty(assetsContracts)){
//            throw new CustomException("批次号重复，请校验后再提交");
//        }
//    }
}
