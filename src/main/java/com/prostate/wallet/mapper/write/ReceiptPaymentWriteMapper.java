package com.prostate.wallet.mapper.write;

import com.prostate.wallet.entity.ReceiptPayment;
import com.prostate.wallet.mapper.BaseWriteMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceiptPaymentWriteMapper extends BaseWriteMapper<ReceiptPayment>{


    @Override
    int insertSelective(ReceiptPayment receiptPayment);

    @Override
    int updateSelective(ReceiptPayment receiptPayment);

    @Override
    int deleteById(String id);
}