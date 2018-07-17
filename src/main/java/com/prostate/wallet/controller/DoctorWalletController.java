package com.prostate.wallet.controller;

import com.prostate.wallet.entity.DoctorWallet;
import com.prostate.wallet.entity.GroupWithoutID;
import com.prostate.wallet.service.DoctorWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * @Author: bian
 * @Date: 2018/7/17 13:38
 * @Todo:
 */
@RestController
@RequestMapping("/doctorWallet")
public class DoctorWalletController  extends BaseController {

    @Autowired
    private DoctorWalletService doctorWalletService;


    /**
     * @Author: bian
     * @Date: 2018/7/17 16:32
     * @todo:   创建钱包
     * @param:   不含id的钱包对象，其中医生id不能为空，
     */
    @PostMapping("/save")
    public Map save(@Validated(GroupWithoutID.class) DoctorWallet doctorWallet){
        doctorWallet.setWalletBalance("0.00");
        int r = doctorWalletService.insertSelective(doctorWallet);
        if (r>0){
            return insertSuccseeResponse();
        }else {
            return insertFailedResponse();
        }
    }


    /**
     * @Author: bian
     * @Date: 2018/7/17 16:41
     * @todo:   根据医生信息（医生id）查询钱包信息
     * @param:   医生id
     */
    @GetMapping("/selectByDoctorId")
    public Map selectByDoctorId( String doctorId){
        //查询钱包信息
        DoctorWallet doctorWallet = doctorWalletService.selectByDoctorId(doctorId);
        //查询结果为空
        if (doctorWallet == null ){
            return  queryEmptyResponse();
        }
        //查询结果不为空
        else {
            return querySuccessResponse(doctorWallet);
        }
    }
}
