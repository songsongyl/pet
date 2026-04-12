package com.ruoyi.donation.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 捐赠物品明细对象 donation_item
 * 
 * @author ruoyi
 * @date 2026-04-04
 */
public class DonationItem extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物品ID（主键） */
    private Long itemId;

    /** 关联捐赠ID（donation_application.donation_id） */
    @Excel(name = "关联捐赠ID")
    private Long donationId;

    /** 物品名称 */
    @Excel(name = "物品名称")
    private String itemName;

    /** 数量 */
    @Excel(name = "数量")
    private Integer quantity;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 描述 */
    @Excel(name = "描述")
    private String description;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setItemId(Long itemId) 
    {
        this.itemId = itemId;
    }

    public Long getItemId() 
    {
        return itemId;
    }
    public void setDonationId(Long donationId) 
    {
        this.donationId = donationId;
    }

    public Long getDonationId() 
    {
        return donationId;
    }
    public void setItemName(String itemName) 
    {
        this.itemName = itemName;
    }

    public String getItemName() 
    {
        return itemName;
    }
    public void setQuantity(Integer quantity) 
    {
        this.quantity = quantity;
    }

    public Integer getQuantity() 
    {
        return quantity;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
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
            .append("itemId", getItemId())
            .append("donationId", getDonationId())
            .append("itemName", getItemName())
            .append("quantity", getQuantity())
            .append("unit", getUnit())
            .append("description", getDescription())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
