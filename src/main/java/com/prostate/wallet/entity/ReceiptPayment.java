package com.prostate.wallet.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @Author: bian
 * @Date: 2018/7/18 10:39
 * @todo:   交易记录实体类
 * @param:   * @param null
 */
public class ReceiptPayment {

    @NotBlank(message = "id不能为空",groups = GroupID.class)
    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "id必须是32位字符串",groups = GroupID.class)
    private String id;

    @NotBlank(message =" 钱包id不能为空" ,groups = {GroupWithoutID.class})
    @Pattern(regexp = "^[A-Za-z0-9]{32}",message = "钱包id必须是32位字符串",groups = GroupWithoutID.class)
    private String walletId;

    private String serialNumber;

    @NotBlank(message =" 交易类型不能为空" ,groups = {GroupWithoutID.class})
    private String receiptPaymentType;

    @NotBlank(message =" 交易金额不能为空" ,groups = {GroupWithoutID.class})
    private String transactionAmount;

    @NotBlank(message =" 支付方式不能为空" ,groups = {GroupWithoutID.class})
    private String paymentType;

    private String walletBalance;

    @Size(max = 200,message = "备注内容不能多于100字。",groups = GroupWithoutID.class)
    private String remark;

    private Date createTime;

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

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber == null ? null : serialNumber.trim();
    }

    public String getReceiptPaymentType() {
        return receiptPaymentType;
    }

    public void setReceiptPaymentType(String receiptPaymentType) {
        this.receiptPaymentType = receiptPaymentType == null ? null : receiptPaymentType.trim();
    }

    public String getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(String transactionAmount) {
        this.transactionAmount = transactionAmount == null ? null : transactionAmount.trim();
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType == null ? null : paymentType.trim();
    }

    public String getWalletBalance() {
        return walletBalance;
    }

    public void setWalletBalance(String walletBalance) {
        this.walletBalance = walletBalance == null ? null : walletBalance.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ReceiptPayment{" +
                "id='" + id + '\'' +
                ", walletId='" + walletId + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", receiptPaymentType='" + receiptPaymentType + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", paymentType='" + paymentType + '\'' +
                ", walletBalance='" + walletBalance + '\'' +
                ", remark='" + remark + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}