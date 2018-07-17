package com.prostate.wallet.mapper.read;

import com.prostate.wallet.entity.ReceiptPayment;

public interface ReceiptPaymentReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReceiptPayment record);

    int insertSelective(ReceiptPayment record);

    ReceiptPayment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReceiptPayment record);

    int updateByPrimaryKey(ReceiptPayment record);
}