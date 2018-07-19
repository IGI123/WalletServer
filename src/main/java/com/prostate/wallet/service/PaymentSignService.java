package com.prostate.wallet.service;

import com.prostate.wallet.entity.PaymentSign;

import java.util.List;

/**
 * @Author: bian
 * @Date: 2018/7/18 16:18
 * @Todo:
 */
public interface PaymentSignService  extends BaseService<PaymentSign> {
    @Override
    int insertSelective(PaymentSign paymentSign);

    @Override
    int updateSelective(PaymentSign paymentSign);

    @Override
    PaymentSign selectById(String id);

    @Override
    List<PaymentSign> selectByParams(PaymentSign paymentSign);

    @Override
    int deleteById(String id);
}
