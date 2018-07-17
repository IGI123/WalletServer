package com.prostate.wallet.mapper.write;

import com.prostate.wallet.entity.ReceiptPayment;

public interface ReceiptPaymentWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(ReceiptPayment record);

    int insertSelective(ReceiptPayment record);


    int updateByPrimaryKeySelective(ReceiptPayment record);

    int updateByPrimaryKey(ReceiptPayment record);
}