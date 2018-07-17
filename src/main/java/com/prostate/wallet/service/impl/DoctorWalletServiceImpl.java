package com.prostate.wallet.service.impl;

import com.prostate.wallet.entity.DoctorWallet;
import com.prostate.wallet.mapper.read.DoctorWalletReadMapper;
import com.prostate.wallet.mapper.write.DoctorWalletWriteMapper;
import com.prostate.wallet.service.DoctorWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: bian
 * @Date: 2018/7/17 13:50
 * @Todo:
 */
@Service
public class DoctorWalletServiceImpl implements DoctorWalletService {

    @Autowired
    private DoctorWalletWriteMapper doctorWalletWriteMapper;

    @Autowired
    private DoctorWalletReadMapper  doctorWalletReadMapper;


    @Override
    public int insertSelective(DoctorWallet e) {
       return doctorWalletWriteMapper.insertSelective(e);
    }

    @Override
    public int updateSelective(DoctorWallet e) {
        return 0;
    }

    @Override
    public DoctorWallet selectById(String id) {
        return null;
    }

    @Override
    public DoctorWallet selectByDoctorId(String doctorId) {
        return doctorWalletReadMapper.selectByDoctorId(doctorId);
    }

    @Override
    public List<DoctorWallet> selectByParams(DoctorWallet e) {
        return doctorWalletReadMapper.selectByParams(e);
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
