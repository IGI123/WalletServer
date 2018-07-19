package com.prostate.wallet.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

public class PaymentSign {

    @NotBlank(message = "id不能为空",groups = GroupID.class)
    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "id必须是32位字符串",groups = GroupID.class)
    private String id;

    @NotBlank(message = "钱包id不能为空",groups = GroupWithoutID.class)
    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "钱包id必须是32位字符串",groups = GroupWithoutID.class)
    private String walletId;

    @NotBlank(message = "密码不能为空",groups = GroupWithoutID.class)
    private String paymentPassword;

    private String slat;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getWalletId() {
        return walletId;
    }

    public void setWalletId(String walletId) {
        this.walletId = walletId == null ? null : walletId.trim();
    }

    public String getPaymentPassword() {
        return paymentPassword;
    }

    public void setPaymentPassword(String paymentPassword) {
        this.paymentPassword = paymentPassword == null ? null : paymentPassword.trim();
    }

    public String getSlat() {
        return slat;
    }

    public void setSlat(String slat) {
        this.slat = slat == null ? null : slat.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}