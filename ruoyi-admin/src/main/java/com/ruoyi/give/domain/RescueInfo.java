package com.ruoyi.give.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 救助信息对象 rescue_info
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
public class RescueInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 救助ID */
    private Long rescueId;

    /** 宠物ID */
    @Excel(name = "宠物ID")
    private Long petId;



    /** 救助状态 */
    @Excel(name = "救助状态")
    private Integer rescueStatus;

    @Excel(name = "发现地点")
    private String foundPlace;
    /** 紧急程度 */
    @Excel(name = "紧急程度")
    private Integer urgentLevel;

    /** 需求类型 */
    @Excel(name = "需求类型")
    private String needType;

    /** 需求描述 */
    @Excel(name = "需求描述")
    private String needDesc;

    /** 目标资金（元） */
    @Excel(name = "目标资金", readConverterExp = "元=")
    private BigDecimal targetAmount;

    /** 已筹资金（元） */
    @Excel(name = "已筹资金", readConverterExp = "元=")
    private BigDecimal raisedAmount;

    /** 开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 审核状态 */
    @Excel(name = "审核状态")
    private Integer verifyStatus;

    /** 审核管理员ID（sys_user.user_id） */
    @Excel(name = "审核管理员ID", readConverterExp = "s=ys_user.user_id")
    private Long verifyUserId;

    /** 审核备注 */
    @Excel(name = "审核备注")
    private String verifyRemark;

    // 发现地点

    // 照片

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    private java.util.List<String> mediaFiles;

    public void setFoundPlace(String foundPlace) 
    {
        this.foundPlace = foundPlace;
    }

    public String getFoundPlace() 
    {
        return foundPlace;
    }

    public void setMediaFiles(java.util.List<String> mediaFiles) 
    {
        this.mediaFiles = mediaFiles;
    }

    public java.util.List<String> getMediaFiles() 
    {
        return mediaFiles;
    }

    public void setRescueId(Long rescueId) 
    {
        this.rescueId = rescueId;
    }

    public Long getRescueId() 
    {
        return rescueId;
    }

    public void setPetId(Long petId) 
    {
        this.petId = petId;
    }

    public Long getPetId() 
    {
        return petId;
    }



    public void setRescueStatus(Integer rescueStatus) 
    {
        this.rescueStatus = rescueStatus;
    }

    public Integer getRescueStatus() 
    {
        return rescueStatus;
    }

    public void setUrgentLevel(Integer urgentLevel) 
    {
        this.urgentLevel = urgentLevel;
    }

    public Integer getUrgentLevel() 
    {
        return urgentLevel;
    }

    public void setNeedType(String needType) 
    {
        this.needType = needType;
    }

    public String getNeedType() 
    {
        return needType;
    }

    public void setNeedDesc(String needDesc) 
    {
        this.needDesc = needDesc;
    }

    public String getNeedDesc() 
    {
        return needDesc;
    }

    public void setTargetAmount(BigDecimal targetAmount) 
    {
        this.targetAmount = targetAmount;
    }

    public BigDecimal getTargetAmount() 
    {
        return targetAmount;
    }

    public void setRaisedAmount(BigDecimal raisedAmount) 
    {
        this.raisedAmount = raisedAmount;
    }

    public BigDecimal getRaisedAmount() 
    {
        return raisedAmount;
    }

    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }

    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }

    public void setVerifyStatus(Integer verifyStatus) 
    {
        this.verifyStatus = verifyStatus;
    }

    public Integer getVerifyStatus() 
    {
        return verifyStatus;
    }

    public void setVerifyUserId(Long verifyUserId) 
    {
        this.verifyUserId = verifyUserId;
    }

    public Long getVerifyUserId() 
    {
        return verifyUserId;
    }

    public void setVerifyRemark(String verifyRemark) 
    {
        this.verifyRemark = verifyRemark;
    }

    public String getVerifyRemark() 
    {
        return verifyRemark;
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
            .append("rescueId", getRescueId())
            .append("petId", getPetId())
            .append("rescueStatus", getRescueStatus())
            .append("urgentLevel", getUrgentLevel())
            .append("needType", getNeedType())
            .append("needDesc", getNeedDesc())
            .append("targetAmount", getTargetAmount())
            .append("raisedAmount", getRaisedAmount())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("verifyStatus", getVerifyStatus())
            .append("verifyUserId", getVerifyUserId())
            .append("verifyRemark", getVerifyRemark())
            .append("foundPlace", getFoundPlace())
            .append("mediaFiles", getMediaFiles())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
