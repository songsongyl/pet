package com.ruoyi.admin.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 志愿者对象 volunteer
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public class Volunteer extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 志愿者ID（主键） */
    private Long volunteerId;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String email;

    /** 技能特长 */
    @Excel(name = "技能特长")
    private String skills;

    /** 状态：0-待审核，1-已通过，2-已驳回，3-已注销 */
    @Excel(name = "状态", readConverterExp = "0=待审核,1=已通过,2=已驳回,3=已注销")
    private Integer status;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核管理员ID（sys_user.user_id） */
    @Excel(name = "审核管理员ID")
    private Long auditUserId;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String auditComments;

    public void setVolunteerId(Long volunteerId)
    {
        this.volunteerId = volunteerId;
    }

    public Long getVolunteerId()
    {
        return volunteerId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public String getPhone()
    {
        return phone;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getEmail()
    {
        return email;
    }
    public void setSkills(String skills)
    {
        this.skills = skills;
    }

    public String getSkills()
    {
        return skills;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setAuditTime(Date auditTime)
    {
        this.auditTime = auditTime;
    }

    public Date getAuditTime()
    {
        return auditTime;
    }
    public void setAuditUserId(Long auditUserId)
    {
        this.auditUserId = auditUserId;
    }

    public Long getAuditUserId()
    {
        return auditUserId;
    }
    public void setAuditComments(String auditComments)
    {
        this.auditComments = auditComments;
    }

    public String getAuditComments()
    {
        return auditComments;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("volunteerId", getVolunteerId())
            .append("name", getName())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("skills", getSkills())
            .append("status", getStatus())
            .append("auditTime", getAuditTime())
            .append("auditUserId", getAuditUserId())
            .append("auditComments", getAuditComments())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
