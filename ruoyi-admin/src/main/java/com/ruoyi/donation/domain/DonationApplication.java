package com.ruoyi.donation.domain;

import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物资捐赠申请对象 donation_application
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

    /** 捐赠类型：food-食物，supplies-用品，medicine-药品，other-其他 */
    @Excel(name = "捐赠类型")
    private String donationType;

    /** 捐赠方式：现场捐赠，快递捐赠 */
    @Excel(name = "捐赠方式")
    private String donationMethod;

    /** 捐赠地址（现场捐赠时必填） */
    @Excel(name = "捐赠地址")
    private String donationAddress;

    /** 快递地址（快递捐赠时必填） */
    @Excel(name = "快递地址")
    private String shippingAddress;

    /** 捐赠时间 */
    @JsonFormat
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

    /** 捐赠物品列表 */
    private List<DonationItem> items;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setDonationId(Long donationId) 
    {
        this.donationId = donationId;
    }

    public Long getDonationId() 
    {
        return donationId;
    }
    public void setDonorName(String donorName) 
    {
        this.donorName = donorName;
    }

    public String getDonorName() 
    {
        return donorName;
    }
    public void setContactPhone(String contactPhone) 
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone() 
    {
        return contactPhone;
    }
    public void setDonationType(String donationType) 
    {
        this.donationType = donationType;
    }

    public String getDonationType() 
    {
        return donationType;
    }
    public void setDonationMethod(String donationMethod) 
    {
        this.donationMethod = donationMethod;
    }

    public String getDonationMethod() 
    {
        return donationMethod;
    }
    public void setDonationAddress(String donationAddress) 
    {
        this.donationAddress = donationAddress;
    }

    public String getDonationAddress() 
    {
        return donationAddress;
    }
    public void setShippingAddress(String shippingAddress) 
    {
        this.shippingAddress = shippingAddress;
    }

    public String getShippingAddress() 
    {
        return shippingAddress;
    }
    public void setDonationTime(Date donationTime) 
    {
        this.donationTime = donationTime;
    }

    public Date getDonationTime() 
    {
        return donationTime;
    }
    public void setRemarks(String remarks) 
    {
        this.remarks = remarks;
    }

    public String getRemarks() 
    {
        return remarks;
    }
    public void setDonationStatus(Integer donationStatus) 
    {
        this.donationStatus = donationStatus;
    }

    public Integer getDonationStatus() 
    {
        return donationStatus;
    }
    public void setConfirmTime(Date confirmTime) 
    {
        this.confirmTime = confirmTime;
    }

    public Date getConfirmTime() 
    {
        return confirmTime;
    }
    public void setItems(List<DonationItem> items) 
    {
        this.items = items;
    }

    public List<DonationItem> getItems() 
    {
        return items;
    }
    public void setIsDeleted(Integer isDeleted) 
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted() 
    {
        return isDeleted;
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
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .append("items", getItems())
            .toString();
    }
}
