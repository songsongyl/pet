package com.ruoyi.ComplaintReport.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 投诉举报（用户投诉举报记录）对象 complaint_report
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
public class ComplaintReport extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long complaintId;

    /** 举报人ID */
    @Excel(name = "举报人ID")
    private Long reportUserId;

    /** 举报对象类型 */
    @Excel(name = "举报对象类型")
    private Integer targetType;

    /** 举报对象ID（对应类型主键） */
    @Excel(name = "举报对象ID", readConverterExp = "对=应类型主键")
    private Long targetId;

    /** 投诉类型 */
    @Excel(name = "投诉类型")
    private Integer complaintType;

    /** 投诉内容 */
    @Excel(name = "投诉内容")
    private String complaintContent;

    /** 证据图片/文件URL */
    @Excel(name = "证据图片/文件URL")
    private String evidenceUrl;

    /** 是否匿名 */
    @Excel(name = "是否匿名")
    private Integer isAnonymous;

    /** 处理状态 */
    @Excel(name = "处理状态")
    private Integer handleStatus;

    /** 处理人ID（管理员ID） */
    @Excel(name = "处理人ID", readConverterExp = "管=理员ID")
    private Long handleUserId;

    /** 处理结果 */
    @Excel(name = "处理结果")
    private String handleRemark;

    /** 处理时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处理时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date handleTime;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setComplaintId(Long complaintId) 
    {
        this.complaintId = complaintId;
    }

    public Long getComplaintId() 
    {
        return complaintId;
    }

    public void setReportUserId(Long reportUserId) 
    {
        this.reportUserId = reportUserId;
    }

    public Long getReportUserId() 
    {
        return reportUserId;
    }

    public void setTargetType(Integer targetType) 
    {
        this.targetType = targetType;
    }

    public Integer getTargetType() 
    {
        return targetType;
    }

    public void setTargetId(Long targetId) 
    {
        this.targetId = targetId;
    }

    public Long getTargetId() 
    {
        return targetId;
    }

    public void setComplaintType(Integer complaintType) 
    {
        this.complaintType = complaintType;
    }

    public Integer getComplaintType() 
    {
        return complaintType;
    }

    public void setComplaintContent(String complaintContent) 
    {
        this.complaintContent = complaintContent;
    }

    public String getComplaintContent() 
    {
        return complaintContent;
    }

    public void setEvidenceUrl(String evidenceUrl) 
    {
        this.evidenceUrl = evidenceUrl;
    }

    public String getEvidenceUrl() 
    {
        return evidenceUrl;
    }

    public void setIsAnonymous(Integer isAnonymous) 
    {
        this.isAnonymous = isAnonymous;
    }

    public Integer getIsAnonymous() 
    {
        return isAnonymous;
    }

    public void setHandleStatus(Integer handleStatus) 
    {
        this.handleStatus = handleStatus;
    }

    public Integer getHandleStatus() 
    {
        return handleStatus;
    }

    public void setHandleUserId(Long handleUserId) 
    {
        this.handleUserId = handleUserId;
    }

    public Long getHandleUserId() 
    {
        return handleUserId;
    }

    public void setHandleRemark(String handleRemark) 
    {
        this.handleRemark = handleRemark;
    }

    public String getHandleRemark() 
    {
        return handleRemark;
    }

    public void setHandleTime(Date handleTime) 
    {
        this.handleTime = handleTime;
    }

    public Date getHandleTime() 
    {
        return handleTime;
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
            .append("complaintId", getComplaintId())
            .append("reportUserId", getReportUserId())
            .append("targetType", getTargetType())
            .append("targetId", getTargetId())
            .append("complaintType", getComplaintType())
            .append("complaintContent", getComplaintContent())
            .append("evidenceUrl", getEvidenceUrl())
            .append("isAnonymous", getIsAnonymous())
            .append("handleStatus", getHandleStatus())
            .append("handleUserId", getHandleUserId())
            .append("handleRemark", getHandleRemark())
            .append("handleTime", getHandleTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
