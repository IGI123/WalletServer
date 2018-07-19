package com.prostate.wallet.service.impl;

import com.prostate.wallet.entity.PaymentSign;
import com.prostate.wallet.mapper.read.PaymentSignReadMapper;
import com.prostate.wallet.mapper.write.PaymentSignWriteMapper;
import com.prostate.wallet.service.PaymentSignService;
import com.prostate.wallet.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @Author: bian
 * @Date: 2018/7/18 16:20
 * @Todo:
 */
@Service
public class PaymentSignServiceImpl implements PaymentSignService {

    @Autowired
    private PaymentSignReadMapper paymentSignReadMapper;
    @Autowired
    private PaymentSignWriteMapper paymentSignWriteMapper;
    @Autowired
    private MD5Util md5Util;

    @Override
    public int insertSelective(PaymentSign paymentSign) {
       //将钱包id一部分+ 当前时间毫秒数,加密之后得到盐值
        String l = paymentSign.getWalletId().substring(1,6);
        String str = System.currentTimeMillis()+"";
        String m =str.substring(str.length()-10, str.length());
        String salt =md5Util.getMD5(l+m);
        //将盐值和密码同时加密
        String newPassword =  md5Util.getMD5(salt+paymentSign.getPaymentPassword());
        paymentSign.setPaymentPassword(newPassword);
        paymentSign.setSlat(salt);
        return paymentSignWriteMapper.insertSelective(paymentSign);
    }

    @Override
    public int updateSelective(PaymentSign paymentSign) {
        //同增加支付密码的加密过程一致
        String l = paymentSign.getWalletId().substring(1,6);
        String str = System.currentTimeMillis()+"";
        String m =str.substring(str.length()-10, str.length());
        String salt =md5Util.getMD5(l+m);
        String newPassword =  md5Util.getMD5(salt+paymentSign.getPaymentPassword());
        paymentSign.setSlat(salt);
        paymentSign.setPaymentPassword(newPassword);
        return paymentSignWriteMapper.updateSelective(paymentSign);
    }

    @Override
    public PaymentSign selectById(String id) {
        return null;
    }

    @Override
    public List<PaymentSign> selectByParams(PaymentSign paymentSign) {

        //通过id获取到盐值,如果不存在会报空指针异常
        try {
            PaymentSign paymentSign01 = paymentSignReadMapper.selectById(paymentSign.getId());
            String salt = paymentSign01.getSlat();
            //将盐值和密码进行编译，得到一个新的密码
            String newPassword =  md5Util.getMD5(salt+paymentSign.getPaymentPassword());
            //将新密码赋值给PaymentSign进行查询操作
            paymentSign.setPaymentPassword(newPassword);
        }catch (NullPointerException e){
            //捕获异常，返回一个空的List集合
            return new ArrayList<PaymentSign>();
        }
        //如果信息正确，返回查询到的信息。如果密码不正确，返回的也是一个空的List集合
        return paymentSignReadMapper.selectByParams(paymentSign);
    }

    @Override
    public int deleteById(String id) {
        return 0;
    }
}
