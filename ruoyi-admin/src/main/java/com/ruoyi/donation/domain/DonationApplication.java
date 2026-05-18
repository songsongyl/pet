package com.ruoyi.donation.domain;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 捐赠申请对象（支持物资/资金/志愿服务）
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public class DonationApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 捐赠ID（主键） */
    private Long donationId;

    /** 捐赠人姓名 */
    @Excel(name = "捐赠人姓名")
    private String donorName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /**
     * 捐赠类型：
     * material = 物资
     * money = 资金
     * volunteer = 志愿服务
     */
    @Excel(name = "捐赠类型")
    private String donationType;

    /** 捐赠方式：现场捐赠，快递捐赠，线上转账 */
    @Excel(name = "捐赠方式")
    private String donationMethod;

    /** 捐赠地址 */
    @Excel(name = "捐赠地址")
    private String donationAddress;

    /** 快递/邮寄地址 */
    @Excel(name = "快递地址")
    private String shippingAddress;

    /** 捐赠时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "捐赠时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date donationTime;

    /** 备注 */
    @Excel(name = "备注")
    private String remarks;

    /** 捐赠状态：0-待确认，1-已确认，2-已取消 */
    @Excel(name = "捐赠状态", readConverterExp = "0=待确认,1=已确认,2=已取消")
    private Integer donationStatus;

    /** 确认时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "确认时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date confirmTime;

    // ===================== 资金捐赠专用字段 =====================
    /** 捐赠金额 */
    @Excel(name = "捐赠金额")
    private Integer donationAmount;

    /** 支付方式：支付宝/微信/银行转账 */
    @Excel(name = "支付方式")
    private String payType;

    /** 交易流水号 */
    @Excel(name = "交易流水号")
    private String tradeNo;

    // ===================== 志愿服务专用字段 =====================
    /** 服务时长（小时） */
    @Excel(name = "服务时长")
    private Integer serviceHours;

    /** 服务项目 */
    @Excel(name = "服务项目")
    private String serviceItem;

    /** 服务日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "服务日期")
    private Date serviceDate;

    // ===================== 物资原有字段 =====================
    /** 捐赠物品列表 */
    private List<DonationItem> items;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    // getter & setter
    public Long getDonationId() {
        return donationId;
    }

    public void setDonationId(Long donationId) {
        this.donationId = donationId;
    }

    public String getDonorName() {
        return donorName;
    }

    public void setDonorName(String donorName) {
        this.donorName = donorName;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getDonationType() {
        return donationType;
    }

    public void setDonationType(String donationType) {
        this.donationType = donationType;
    }

    public String getDonationMethod() {
        return donationMethod;
    }

    public void setDonationMethod(String donationMethod) {
        this.donationMethod = donationMethod;
    }

    public String getDonationAddress() {
        return donationAddress;
    }

    public void setDonationAddress(String donationAddress) {
        this.donationAddress = donationAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Date getDonationTime() {
        return donationTime;
    }

    public void setDonationTime(Date donationTime) {
        this.donationTime = donationTime;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getDonationStatus() {
        return donationStatus;
    }

    public void setDonationStatus(Integer donationStatus) {
        this.donationStatus = donationStatus;
    }

    public Date getConfirmTime() {
        return confirmTime;
    }

    public void setConfirmTime(Date confirmTime) {
        this.confirmTime = confirmTime;
    }

    public Integer getDonationAmount() {
        return donationAmount;
    }

    public void setDonationAmount(Integer donationAmount) {
        this.donationAmount = donationAmount;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getTradeNo() {
        return tradeNo;
    }

    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }

    public Integer getServiceHours() {
        return serviceHours;
    }

    public void setServiceHours(Integer serviceHours) {
        this.serviceHours = serviceHours;
    }

    public String getServiceItem() {
        return serviceItem;
    }

    public void setServiceItem(String serviceItem) {
        this.serviceItem = serviceItem;
    }

    public Date getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(Date serviceDate) {
        this.serviceDate = serviceDate;
    }

    public List<DonationItem> getItems() {
        return items;
    }

    public void setItems(List<DonationItem> items) {
        this.items = items;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("donationId", getDonationId())
                .append("donorName", getDonorName())
                .append("contactPhone", getContactPhone())
                .append("donationType", getDonationType())
                .append("donationMethod", getDonationMethod())
                .append("donationAddress", getDonationAddress())
                .append("shippingAddress", getShippingAddress())
                .append("donationTime", getDonationTime())
                .append("remarks", getRemarks())
                .append("donationStatus", getDonationStatus())
                .append("confirmTime", getConfirmTime())
                .append("donationAmount", getDonationAmount())
                .append("payType", getPayType())
                .append("tradeNo", getTradeNo())
                .append("serviceHours", getServiceHours())
                .append("serviceItem", getServiceItem())
                .append("serviceDate", getServiceDate())
                .append("items", getItems())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDeleted", getIsDeleted())
                .toString();
    }
}