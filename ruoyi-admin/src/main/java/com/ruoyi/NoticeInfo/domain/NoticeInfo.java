package com.ruoyi.NoticeInfo.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 公告信息对象 notice_info
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
public class NoticeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long noticeId;

    /** 公告标题 */
    @Excel(name = "公告标题")
    private String noticeTitle;

    /** 公告类型 */
    @Excel(name = "公告类型")
    private Integer noticeType;

    /** 公告内容 */
    @Excel(name = "公告内容")
    private String noticeContent;

    /** 目标用户 */
    @Excel(name = "目标用户")
    private String targetUserType;

    /** 是否弹窗 */
    @Excel(name = "是否弹窗")
    private Integer isPopup;

    /** 发布人ID */
    @Excel(name = "发布人ID")
    private Long publishUserId;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 下架时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下架时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date offlineTime;

    /** 查看次数 */
    @Excel(name = "查看次数")
    private Long viewCount;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setNoticeId(Long noticeId) 
    {
        this.noticeId = noticeId;
    }

    public Long getNoticeId() 
    {
        return noticeId;
    }

    public void setNoticeTitle(String noticeTitle) 
    {
        this.noticeTitle = noticeTitle;
    }

    public String getNoticeTitle() 
    {
        return noticeTitle;
    }

    public void setNoticeType(Integer noticeType) 
    {
        this.noticeType = noticeType;
    }

    public Integer getNoticeType() 
    {
        return noticeType;
    }

    public void setNoticeContent(String noticeContent) 
    {
        this.noticeContent = noticeContent;
    }

    public String getNoticeContent() 
    {
        return noticeContent;
    }

    public void setTargetUserType(String targetUserType) 
    {
        this.targetUserType = targetUserType;
    }

    public String getTargetUserType() 
    {
        return targetUserType;
    }

    public void setIsPopup(Integer isPopup) 
    {
        this.isPopup = isPopup;
    }

    public Integer getIsPopup() 
    {
        return isPopup;
    }

    public void setPublishUserId(Long publishUserId) 
    {
        this.publishUserId = publishUserId;
    }

    public Long getPublishUserId() 
    {
        return publishUserId;
    }

    public void setPublishTime(Date publishTime) 
    {
        this.publishTime = publishTime;
    }

    public Date getPublishTime() 
    {
        return publishTime;
    }

    public void setOfflineTime(Date offlineTime) 
    {
        this.offlineTime = offlineTime;
    }

    public Date getOfflineTime() 
    {
        return offlineTime;
    }

    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
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
            .append("noticeId", getNoticeId())
            .append("noticeTitle", getNoticeTitle())
            .append("noticeType", getNoticeType())
            .append("noticeContent", getNoticeContent())
            .append("targetUserType", getTargetUserType())
            .append("isPopup", getIsPopup())
            .append("publishUserId", getPublishUserId())
            .append("publishTime", getPublishTime())
            .append("offlineTime", getOfflineTime())
            .append("viewCount", getViewCount())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
