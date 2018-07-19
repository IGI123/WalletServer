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
    /**
     * @Author: bian
     * @Date: 2018/7/18 10:41
     * @todo: 添加交易记录
     * @param:   * @param null
     */
    @PostMapping("/save")
    public Map save( @RequestBody @Validated(GroupWithoutID.class)ReceiptPayment receiptPayment){
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
    public Map getAll( ReceiptPayment receiptPayment){
       List<ReceiptPayment> receiptPayments = receiptPaymentService.selectByParams(receiptPayment);
       //分页查询
      // int count = receiptPaymentService.count(receiptPayment.getWalletId());
       if (receiptPayments.isEmpty()){
            return queryEmptyResponse();
        }else {
           //分页查询
            //return querySuccessResponse(receiptPayments, count+"");
           //这是不分页的
           return querySuccessResponse(receiptPayments);
        }
    }
}
