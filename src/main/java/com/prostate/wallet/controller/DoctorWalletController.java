package com.prostate.wallet.controller;

import com.prostate.wallet.entity.DoctorWallet;
import com.prostate.wallet.entity.GroupID;
import com.prostate.wallet.entity.GroupWithoutID;
import com.prostate.wallet.service.DoctorWalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private  DoctorWallet doctorWallet;

    /**
     * @Author: bian
     * @Date: 2018/7/17 16:32
     * @todo:   创建钱包
     * @param:   不含id的钱包对象，其中医生id不能为空，
     */
    @PostMapping("/save")
    public Map save(String token){
        doctorWallet.setWalletBalance("0");
        doctorWallet.setCreateUser(token);
        doctorWallet.setDoctorId(token);
        doctorWallet.setId(token);
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
     * @todo:   根据医生信息（医生token）查询钱包信息
     * @param:   医生id
     */
    @GetMapping("/selectByToken")
    public Map selectByDoctorId( String token){
        //查询钱包信息====因为token和id的值相等，所以把token当做id当做查询条件
        DoctorWallet doctorWallet = doctorWalletService.selectByDoctorId(token);
        //查询结果为空
        if (doctorWallet == null ){
            return  queryEmptyResponse();
        }
        //查询结果不为空
        else {
            return querySuccessResponse(doctorWallet);
        }
    }

    /**
     * @Author: bian
     * @Date: 2018/7/17 16:32
     * @todo:   修改钱包金额=============>支付订单和提现通用
     * @param:
     */
    @PostMapping(value = "/updateBalance")
    public Map updateBalance(@RequestBody @Validated({GroupID.class,GroupWithoutID.class})DoctorWallet doctorWallet,String token){
        //医生的token 和钱包id值是一样的，因此这里使用token获取钱包信息。如果医生未登录，就不能修改钱包信息了
        DoctorWallet doctorWalletFromDatabase = doctorWalletService.selectById(token);
        //如果查询对象为空，直接返回。
        if (doctorWalletFromDatabase == null){
            return queryEmptyResponse();
        }
        //获取钱包余额
        int sum = Integer.parseInt(doctorWalletFromDatabase.getWalletBalance());
        //修改钱包金额
        int newBalance = sum + Integer.parseInt(doctorWallet.getWalletBalance());
        //余额不足
        if (newBalance < 0){
            return updateFailedResponse();
        }
        doctorWallet.setWalletBalance(newBalance+"");
        //将钱包信息存回数据库
        if (doctorWalletService.updateSelective(doctorWallet) > 0){
            return updateSuccseeResponse();
        }else {
            return updateFailedResponse();
        }
    }



}
