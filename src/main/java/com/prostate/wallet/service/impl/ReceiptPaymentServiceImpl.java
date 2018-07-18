package com.prostate.wallet.service.impl;

import com.prostate.wallet.entity.ReceiptPayment;
import com.prostate.wallet.mapper.read.ReceiptPaymentReadMapper;
import com.prostate.wallet.mapper.write.ReceiptPaymentWriteMapper;
import com.prostate.wallet.service.ReceiptPaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Author: bian
 * @Date: 2018/7/18 10:45
 * @Todo:
 */
@Service
public class ReceiptPaymentServiceImpl implements ReceiptPaymentService {

    @Autowired
    private ReceiptPaymentWriteMapper receiptPaymentWriteMapper;

    @Autowired
    private ReceiptPaymentReadMapper receiptPaymentReadMapper;

    @Override
    public int insertSelective(ReceiptPayment receiptPayment) {
        //生成一个流水号（当前时间精确到秒，流水号会重复。所以精确到毫秒）
        String l  = new SimpleDateFormat("yyyyMMdd").format(new Date());
        String str = System.currentTimeMillis()+"";
        String m =str.substring(str.length()-6, str.length());
        String n = receiptPayment.getWalletId().substring(0,10);
        receiptPayment.setSerialNumber(m+l+n);
        return receiptPaymentWriteMapper.insertSelective(receiptPayment);
    }

    @Override
    public int updateSelective(ReceiptPayment receiptPayment) {
        return receiptPaymentWriteMapper.updateSelective(receiptPayment);
    }

    @Override
    public ReceiptPayment selectById(String id) {
        return null;
    }

    @Override
    public int count(String walletId) {
        return receiptPaymentReadMapper.count(walletId);
    }

    @Override
    public List<ReceiptPayment> selectByParams(ReceiptPayment receiptPayment) {
        List<ReceiptPayment> receiptPayments = receiptPaymentReadMapper.selectByParams(receiptPayment);
        return receiptPayments;
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
