package com.ruoyi.ComplaintReport.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 黑名单对象 blacklist
 *
 * @author songyilin
 * @date 2025-05-29
 */
public class Blacklist extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 黑名单ID */
    private Long blacklistId;

    /** 被拉黑用户ID */
    @Excel(name = "被拉黑用户ID")
    private Long userId;

    /** 被拉黑用户名 */
    @Excel(name = "被拉黑用户名")
    private String userName;

    /** 被拉黑用户昵称 */
    @Excel(name = "被拉黑用户昵称")
    private String userNickName;

    /** 黑名单类型：1-投诉拉黑，2-主动拉黑 */
    @Excel(name = "黑名单类型", readConverterExp = "1=投诉拉黑,2=主动拉黑")
    private Integer blacklistType;

    /** 拉黑原因 */
    @Excel(name = "拉黑原因")
    private String reason;

    /** 关联投诉ID */
    @Excel(name = "关联投诉ID")
    private Long relatedComplaintId;

    /** 操作人ID */
    @Excel(name = "操作人ID")
    private Long operatorId;

    /** 操作人名称 */
    @Excel(name = "操作人名称")
    private String operatorName;

    /** 解封时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "解封时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date unblockTime;

    /** 状态：0-拉黑中，1-已解封 */
    @Excel(name = "状态", readConverterExp = "0=拉黑中,1=已解封")
    private String status;

    public void setBlacklistId(Long blacklistId)
    {
        this.blacklistId = blacklistId;
    }

    public Long getBlacklistId()
    {
        return blacklistId;
    }

    public void setUserId(Long userId)
    {
        this.userId = userId;
    }

    public Long getUserId()
    {
        return userId;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserNickName(String userNickName)
    {
        this.userNickName = userNickName;
    }

    public String getUserNickName()
    {
        return userNickName;
    }

    public void setBlacklistType(Integer blacklistType)
    {
        this.blacklistType = blacklistType;
    }

    public Integer getBlacklistType()
    {
        return blacklistType;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getReason()
    {
        return reason;
    }

    public void setRelatedComplaintId(Long relatedComplaintId)
    {
        this.relatedComplaintId = relatedComplaintId;
    }

    public Long getRelatedComplaintId()
    {
        return relatedComplaintId;
    }

    public void setOperatorId(Long operatorId)
    {
        this.operatorId = operatorId;
    }

    public Long getOperatorId()
    {
        return operatorId;
    }

    public void setOperatorName(String operatorName)
    {
        this.operatorName = operatorName;
    }

    public String getOperatorName()
    {
        return operatorName;
    }

    public void setUnblockTime(Date unblockTime)
    {
        this.unblockTime = unblockTime;
    }

    public Date getUnblockTime()
    {
        return unblockTime;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public String getStatus()
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
            .append("blacklistId", getBlacklistId())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userNickName", getUserNickName())
            .append("blacklistType", getBlacklistType())
            .append("reason", getReason())
            .append("relatedComplaintId", getRelatedComplaintId())
            .append("operatorId", getOperatorId())
            .append("operatorName", getOperatorName())
            .append("unblockTime", getUnblockTime())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
