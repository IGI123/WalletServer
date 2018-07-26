package com.prostate.wallet.feignService.impl;

import com.prostate.wallet.feignService.ThirdService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/7/25 16:44
 * @Todo:
 */
@Component
public class ThirdServiceHystrix  extends BaseServerHystrix implements ThirdService {


    @Override
    public Map<String, Object> sendBalanceForCash(String phoneNumber,String paramTime,String amount) {

        System.out.println(phoneNumber+paramTime+amount);
        return resultMap;
    }

}
