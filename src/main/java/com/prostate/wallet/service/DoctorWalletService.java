package com.prostate.wallet.service;

import com.prostate.wallet.entity.DoctorWallet;

import java.util.List;

/**
 * @Author: bian
 * @Date: 2018/7/17 13:34
 * @Todo:
 */

public interface DoctorWalletService extends BaseService<DoctorWallet>{

    @Override
    int insertSelective(DoctorWallet e);

    @Override
    int updateSelective(DoctorWallet e);

    @Override
    DoctorWallet selectById(String id);

    @Override
    List<DoctorWallet> selectByParams(DoctorWallet e);

    @Override
    int deleteById(String id);

    DoctorWallet selectByDoctorId(String doctorId);

}
