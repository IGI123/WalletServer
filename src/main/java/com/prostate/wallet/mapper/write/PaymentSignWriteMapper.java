package com.prostate.wallet.mapper.write;

import com.prostate.wallet.entity.PaymentSign;
import com.prostate.wallet.mapper.BaseWriteMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentSignWriteMapper extends BaseWriteMapper<PaymentSign>{
    @Override
    int insertSelective(PaymentSign paymentSign);

    @Override
    int updateSelective(PaymentSign paymentSign);

    @Override
    int deleteById(String id);
}