package com.ruoyi.course.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 知识课堂对象 knowledge_course
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
public class KnowledgeCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 课程ID */
    private Long courseId;

    /** 课程标题 */
    @Excel(name = "课程标题")
    private String courseTitle;

    /** 课程类型 */
    @Excel(name = "课程类型")
    private Integer courseType;

    /** 难度等级 */
    @Excel(name = "难度等级")
    private Integer difficultyLevel;

    /** 封面图片URL */
    @Excel(name = "封面图片URL")
    private String courseCover;

    /** 课程内容 */
    @Excel(name = "课程内容")
    private String courseContent;

    /** 讲师名称 */
    @Excel(name = "讲师名称")
    private String teacherName;

    /** 讲师简介 */
    @Excel(name = "讲师简介")
    private String teacherDesc;

    /** 查看次数 */
    @Excel(name = "查看次数")
    private Long viewCount;

    /** 收藏次数 */
    @Excel(name = "收藏次数")
    private Long collectCount;

    /** 发布状态 */
    @Excel(name = "发布状态")
    private Integer publishStatus;

    /** 发布人 */
    @Excel(name = "发布人")
    private Long publishUserId;

    /** 发布时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date publishTime;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setCourseId(Long courseId) 
    {
        this.courseId = courseId;
    }

    public Long getCourseId() 
    {
        return courseId;
    }

    public void setCourseTitle(String courseTitle) 
    {
        this.courseTitle = courseTitle;
    }

    public String getCourseTitle() 
    {
        return courseTitle;
    }

    public void setCourseType(Integer courseType) 
    {
        this.courseType = courseType;
    }

    public Integer getCourseType() 
    {
        return courseType;
    }

    public void setDifficultyLevel(Integer difficultyLevel) 
    {
        this.difficultyLevel = difficultyLevel;
    }

    public Integer getDifficultyLevel() 
    {
        return difficultyLevel;
    }

    public void setCourseCover(String courseCover) 
    {
        this.courseCover = courseCover;
    }

    public String getCourseCover() 
    {
        return courseCover;
    }

    public void setCourseContent(String courseContent) 
    {
        this.courseContent = courseContent;
    }

    public String getCourseContent() 
    {
        return courseContent;
    }

    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }

    public void setTeacherDesc(String teacherDesc) 
    {
        this.teacherDesc = teacherDesc;
    }

    public String getTeacherDesc() 
    {
        return teacherDesc;
    }

    public void setViewCount(Long viewCount) 
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount() 
    {
        return viewCount;
    }

    public void setCollectCount(Long collectCount) 
    {
        this.collectCount = collectCount;
    }

    public Long getCollectCount() 
    {
        return collectCount;
    }

    public void setPublishStatus(Integer publishStatus) 
    {
        this.publishStatus = publishStatus;
    }

    public Integer getPublishStatus() 
    {
        return publishStatus;
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
            .append("courseId", getCourseId())
            .append("courseTitle", getCourseTitle())
            .append("courseType", getCourseType())
            .append("difficultyLevel", getDifficultyLevel())
            .append("courseCover", getCourseCover())
            .append("courseContent", getCourseContent())
            .append("teacherName", getTeacherName())
            .append("teacherDesc", getTeacherDesc())
            .append("viewCount", getViewCount())
            .append("collectCount", getCollectCount())
            .append("publishStatus", getPublishStatus())
            .append("publishUserId", getPublishUserId())
            .append("publishTime", getPublishTime())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
