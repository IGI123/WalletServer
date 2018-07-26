package com.prostate.wallet.controller;


import com.prostate.wallet.entity.PaymentSign;
import com.prostate.wallet.service.DoctorWalletService;
import com.prostate.wallet.service.PaymentSignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: bian
 * @Date: 2018/7/18 16:13
 * @Todo:  支付密码控制
 */
@Slf4j
@RestController
@RequestMapping("/paymentSign")
public class PaymentSignController  extends BaseController {


    @Autowired
    private PaymentSignService paymentSignService;

    @Autowired
    private DoctorWalletService doctorWalletService;

    @Autowired
    private PaymentSign paymentSign;


    /**
     * @Author: bian
     * @Date: 2018/7/18 16:17
     * @todo: 添加支付密码
     * @param:   * @param null
     */
    @PostMapping("/save")
    public Map savePass(String paymentPassword,String token){
        paymentSign.setWalletId(token);
        paymentSign.setId(token);
        paymentSign.setPaymentPassword(paymentPassword);
        //首先判断这个钱包存不存在
        if(doctorWalletService.selectById(paymentSign.getWalletId()) == null){
            return queryEmptyResponse();
        }
        if (paymentSignService.insertSelective(paymentSign) > 0){
            log.info("创建支付密码");
            return insertSuccseeResponse();
        }else {
            return  insertFailedResponse();
        }

    }

    /**
     * @Author: bian
     * @Date: 2018/7/18 16:17
     * @todo:   修改支付密码
     * @param:   * @param null
     */
    @PostMapping("/update")
    public Map updatePass(String paymentPassword,String token){
        paymentSign.setPaymentPassword(paymentPassword);
        //医生token==医生id==钱包id==支付密码id
        //医生未登录的话这些操作都是不允许的
        paymentSign.setId(token);
        paymentSign.setWalletId(token);
        if (paymentSignService.updateSelective(paymentSign) > 0){
            log.info("修改支付密码");
            return updateSuccseeResponse();
        }else {
            return updateFailedResponse();
        }

    }

    /**
     * @Author: bian
     * @Date: 2018/7/18 16:17
     * @todo: 校验支付密码=======select操作的参数一般不做校验，这里做了校验
     * @param:   * @param null
     */
    @GetMapping("/check")
    public Map checkPass(String paymentPassword,String token){
        paymentSign.setWalletId(token);
        paymentSign.setId(token);
        paymentSign.setPaymentPassword(paymentPassword);
        List<PaymentSign> paymentSigns  = paymentSignService.selectByParams(paymentSign);
        if (paymentSigns.isEmpty()){
            return queryEmptyResponse();
        }else {
            return querySuccessResponse(paymentSigns);
        }
    }
}
