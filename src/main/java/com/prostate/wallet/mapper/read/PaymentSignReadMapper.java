package com.prostate.wallet.mapper.read;

import com.prostate.wallet.entity.PaymentSign;

public interface PaymentSignReadMapper {
    int deleteByPrimaryKey(String id);

    int insert(PaymentSign record);

    int insertSelective(PaymentSign record);

    PaymentSign selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(PaymentSign record);

    int updateByPrimaryKey(PaymentSign record);
}