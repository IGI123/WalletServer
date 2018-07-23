package com.prostate.wallet.controller;

import com.prostate.wallet.entity.DoctorWallet;
import com.prostate.wallet.entity.GroupID;
import com.prostate.wallet.entity.GroupWithoutID;
import com.prostate.wallet.entity.ReceiptPayment;
import com.prostate.wallet.service.DoctorWalletService;
import com.prostate.wallet.service.ReceiptPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @Author: bian
 * @Date: 2018/7/18 10:40
 * @Todo:
 */
@RestController
@RequestMapping("/receiptPayment")
public class ReceiptPaymentController extends BaseController{

    @Autowired
    private ReceiptPaymentService receiptPaymentService;

    @Autowired
    private DoctorWalletService doctorWalletService;

    @Autowired
    private ReceiptPayment receiptPayment;
    /**
     * @Author: bian
     * @Date: 2018/7/18 10:41
     * @todo: 添加交易记录
     * @param:   * @param null
     */
    @PostMapping(value = "/save",consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public Map save(@RequestBody  @Validated(GroupWithoutID.class)ReceiptPayment receiptPayment,String token){
        //不论用户端传过来的钱包id是什么，都是以token为主
        receiptPayment.setWalletId(token);
        int r = receiptPaymentService.insertSelective(receiptPayment);
        if (r>0){
            //如果交易成功，获取当前余额信息
            try {
                DoctorWallet doctorWallet = doctorWalletService.selectById(receiptPayment.getWalletId());
                //将余额信息重新写入交易记录表
                receiptPayment.setWalletBalance(doctorWallet.getWalletBalance());
                receiptPaymentService.updateSelective(receiptPayment);
                return insertSuccseeResponse();
            }catch (Exception e){
                return queryEmptyResponse();
            }
        } else {
            return insertFailedResponse();
        }
    }

    /**
     * @Author: bian
     * @Date: 2018/7/18 10:41
     * @todo: 查询交易记录
     * @param:   * @param null
     *
     */
    @GetMapping("/getAll")
    public Map getAll( String token){
       receiptPayment.setId(token);
       List<ReceiptPayment> receiptPayments = receiptPaymentService.selectByParams(receiptPayment);
       //分页查询
       if (receiptPayments.isEmpty()){
            return queryEmptyResponse();
        }else {
           return querySuccessResponse(receiptPayments);
        }
    }
}
