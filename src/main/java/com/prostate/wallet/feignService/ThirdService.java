package com.prostate.wallet.feignService;

import com.prostate.wallet.feignService.impl.ThirdServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Author: ykbian
 * @Date: 2018/7/25 16:39
 * @Todo:   调用短信服务
 */
@FeignClient(value = "third-server",fallback = ThirdServiceHystrix.class)
public interface ThirdService {

    /**
     *@Author:      ykbian
     *@date_time:   2018/7/25 16:41
     *@Description: 医生提现的短信提醒
     *@param:       电话号码，发起时间，提现金额
    */
    @PostMapping(value = "/sms/sendBalanceForCash")
    public Map<String,Object> sendBalanceForCash(@RequestParam("phoneNumber")String phoneNumber, @RequestParam("paramTime") String paramTime, @RequestParam("amount") String amount);


}
