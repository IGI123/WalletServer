package com.prostate.wallet.mapper.write;

import com.prostate.wallet.entity.DoctorWallet;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorWalletWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(DoctorWallet record);

    /**
     * 创建钱包
     * **/
    int insertSelective(DoctorWallet record);

    int updateByPrimaryKeySelective(DoctorWallet record);

    int updateByPrimaryKey(DoctorWallet record);
}