package com.prostate.wallet.controller;

import com.prostate.wallet.entity.PaymentSign;
import com.prostate.wallet.service.PaymentSignService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RestController
@RequestMapping("/paymentSign")
public class PaymentSignController  extends BaseController {


    @Autowired
    private PaymentSignService paymentSignService;
    /**
     * @Author: bian
     * @Date: 2018/7/18 16:17
     * @todo: 添加支付密码
     * @param:   * @param null
     */
    @PostMapping("/save")
    public Map savePass(PaymentSign paymentSign){
        if (paymentSignService.insertSelective(paymentSign) > 0){
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
    public Map updatePass(PaymentSign paymentSign){
        if (paymentSignService.updateSelective(paymentSign) > 0){
            return updateSuccseeResponse();
        }else {
            return updateFailedResponse();
        }

    }

    /**
     * @Author: bian
     * @Date: 2018/7/18 16:17
     * @todo: 校验支付密码
     * @param:   * @param null
     */
    @PostMapping("/check")
    public Map checkPass(PaymentSign paymentSign){
        List<PaymentSign> paymentSigns  = paymentSignService.selectByParams(paymentSign);
        if (paymentSigns.isEmpty()){
            return queryEmptyResponse();
        }else {
            return querySuccessResponse(paymentSigns);
        }
    }
}
