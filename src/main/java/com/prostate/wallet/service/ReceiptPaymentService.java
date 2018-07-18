package com.prostate.wallet.service;

import com.prostate.wallet.entity.ReceiptPayment;

import java.util.List;

/**
 * @Author: bian
 * @Date: 2018/7/18 10:44
 * @Todo:
 */

public interface ReceiptPaymentService extends BaseService<ReceiptPayment>{

    @Override
    int insertSelective(ReceiptPayment receiptPayment);

    @Override
    int updateSelective(ReceiptPayment receiptPayment);

    @Override
    ReceiptPayment selectById(String id);

    @Override
    List<ReceiptPayment> selectByParams(ReceiptPayment receiptPayment);

    @Override
    int deleteById(String id);

    int  count(String walletId);
}
