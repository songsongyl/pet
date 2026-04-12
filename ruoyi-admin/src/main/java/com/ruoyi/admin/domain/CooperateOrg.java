package com.ruoyi.admin.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 合作机构对象 cooperate_org
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public class CooperateOrg extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 机构ID（主键） */
    private Long orgId;

    /** 机构名称 */
    @Excel(name = "机构名称")
    @JsonAlias({"orgName", "name", "org_name"})
    private String orgName;

    /** 机构类型：1-宠物医院，2-宠物用品商家，3-公益组织 */
    @Excel(name = "机构类型", readConverterExp = "1=宠物医院,2=宠物用品商家,3=公益组织")
    private Integer orgType;

    /** 资质许可证号 */
    @Excel(name = "资质许可证号")
    private String licenseNo;

    /** 联系人 */
    @Excel(name = "联系人")
    private String contactPerson;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 机构地址 */
    @Excel(name = "机构地址")
    private String address;

    /** 业务范围 */
    @Excel(name = "业务范围")
    @JsonAlias({"businessScope", "remark", "business_scope"})
    private String businessScope;

    /** 合作状态：0-待审核，1-正常合作，2-暂停合作，3-终止合作 */
    @Excel(name = "合作状态", readConverterExp = "0=待审核,1=正常合作,2=暂停合作,3=终止合作")
    @JsonDeserialize(using = StatusDeserializer.class)
    private Integer status;

    /** 审核通过时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核通过时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date auditTime;

    /** 审核管理员ID（关联sys_user.user_id） */
    @Excel(name = "审核管理员ID")
    private Long auditUserId;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setOrgId(Long orgId)
    {
        this.orgId = orgId;
    }

    public Long getOrgId()
    {
        return orgId;
    }
    public void setOrgName(String orgName)
    {
        this.orgName = orgName;
    }

    public String getOrgName()
    {
        return orgName;
    }
    public void setOrgType(Integer orgType)
    {
        this.orgType = orgType;
    }

    public Integer getOrgType()
    {
        return orgType;
    }
    public void setLicenseNo(String licenseNo)
    {
        this.licenseNo = licenseNo;
    }

    public String getLicenseNo()
    {
        return licenseNo;
    }
    public void setContactPerson(String contactPerson)
    {
        this.contactPerson = contactPerson;
    }

    public String getContactPerson()
    {
        return contactPerson;
    }
    public void setContactPhone(String contactPhone)
    {
        this.contactPhone = contactPhone;
    }

    public String getContactPhone()
    {
        return contactPhone;
    }
    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getAddress()
    {
        return address;
    }
    public void setBusinessScope(String businessScope)
    {
        this.businessScope = businessScope;
    }

    public String getBusinessScope()
    {
        return businessScope;
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
            .append("orgId", getOrgId())
            .append("orgName", getOrgName())
            .append("orgType", getOrgType())
            .append("licenseNo", getLicenseNo())
            .append("contactPerson", getContactPerson())
            .append("contactPhone", getContactPhone())
            .append("address", getAddress())
            .append("businessScope", getBusinessScope())
            .append("status", getStatus())
            .append("auditTime", getAuditTime())
            .append("auditUserId", getAuditUserId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
