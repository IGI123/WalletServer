package com.prostate.wallet.mapper.read;

import com.prostate.wallet.entity.DoctorWallet;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DoctorWalletReadMapper{

    DoctorWallet selectById(String id);

    DoctorWallet selectByDoctorId(String doctorId);

    List<DoctorWallet> selectByParams(DoctorWallet DoctorWallet);

}