package com.prostate.wallet.mapper.write;

import com.prostate.wallet.entity.PaymentSign;

public interface PaymentSignWriteMapper {
    int deleteByPrimaryKey(String id);

    int insert(PaymentSign record);

    int insertSelective(PaymentSign record);

    int updateByPrimaryKeySelective(PaymentSign record);

    int updateByPrimaryKey(PaymentSign record);
}