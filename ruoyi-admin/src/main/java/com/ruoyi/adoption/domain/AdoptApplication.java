package com.ruoyi.adoption.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 领养申请对象 adopt_application
 * 
 * @author ruoyi
 * @date 2026-04-04
 */
public class AdoptApplication extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 申请ID（主键） */
    private Long applicationId;

    /** 关联送养ID（adopt_release.release_id） */
    @Excel(name = "关联送养ID", readConverterExp = "adopt_release.release_id")
    private Long releaseId;

    /** 关联宠物ID（pet_info.pet_id） */
    @Excel(name = "关联宠物ID", readConverterExp = "pet_info.pet_id")
    private Long petId;

    /** 申请人ID（sys_user.user_id） */
    @Excel(name = "申请人ID", readConverterExp = "sys_user.user_id")
    private Long userId;

    /** 住房类型：owned-自有，rented-租住，dormitory-宿舍 */
    @Excel(name = "住房类型")
    private String housingType;

    /** 是否允许养宠：0-否，1-是 */
    @Excel(name = "是否允许养宠", readConverterExp = "0=否,1=是")
    private Integer petAllowed;

    /** 是否有封闭阳台/纱窗：0-否，1-是 */
    @Excel(name = "是否有封闭阳台/纱窗", readConverterExp = "0=否,1=是")
    private Integer hasEnclosedBalcony;

    /** 家庭成员是否同意：0-否，1-是 */
    @Excel(name = "家庭成员是否同意", readConverterExp = "0=否,1=是")
    private Integer familyAgree;

    /** 有无过敏情况：0-无，1-有 */
    @Excel(name = "有无过敏情况", readConverterExp = "0=无,1=有")
    private Integer hasAllergy;

    /** 工作作息 */
    @Excel(name = "工作作息")
    private String workSchedule;

    /** 每天陪伴时间：less1-小于1小时，1-3-1-3小时，3-6-3-6小时，more6-大于6小时 */
    @Excel(name = "每天陪伴时间")
    private String companionTime;

    /** 是否了解基础开销：0-否，1-是 */
    @Excel(name = "是否了解基础开销", readConverterExp = "0=否,1=是")
    private Integer knowBasicCost;

    /** 是否能承担医疗费用：0-否，1-是 */
    @Excel(name = "是否能承担医疗费用", readConverterExp = "0=否,1=是")
    private Integer canAffordMedical;

    /** 是否接受科学喂养：0-否，1-是 */
    @Excel(name = "是否接受科学喂养", readConverterExp = "0=否,1=是")
    private Integer scientificFeeding;

    /** 是否同意绝育/牵引：0-否，1-是 */
    @Excel(name = "是否同意绝育/牵引", readConverterExp = "0=否,1=是")
    private Integer agreeSterilization;

    /** 养宠经验 */
    @Excel(name = "养宠经验")
    private String petExperience;

    /** 未来计划 */
    @Excel(name = "未来计划")
    private String futurePlans;

    /** 是否承诺不随意弃养：0-否，1-是 */
    @Excel(name = "是否承诺不随意弃养", readConverterExp = "0=否,1=是")
    private Integer noAbandon;

    /** 是否接受回访：0-否，1-是 */
    @Excel(name = "是否接受回访", readConverterExp = "0=否,1=是")
    private Integer acceptVisit;

    /** 申请人姓名 */
    @Excel(name = "申请人姓名")
    private String applicantName;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String contactPhone;

    /** 居住地址 */
    @Excel(name = "居住地址")
    private String address;

    /** 居住证明图片URL（多个用逗号分隔） */
    @Excel(name = "居住证明图片URL")
    private String livingProveUrl;

    /** 签署协议URL */
    @Excel(name = "签署协议URL")
    private String agreementUrl;

    /** 申请状态：0-待审核，1-审核通过，2-审核驳回，3-已领养，4-已取消 */
    @Excel(name = "申请状态", readConverterExp = "0=待审核,1=审核通过,2=审核驳回,3=已领养,4=已取消")
    private Integer applyStatus;

    /** 审核人ID（送养人ID或管理员ID） */
    @Excel(name = "审核人ID")
    private Long reviewUserId;

    /** 审核备注 */
    @Excel(name = "审核备注")
    private String reviewRemark;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date reviewTime;

    /** 押金金额（元） */
    @Excel(name = "押金金额")
    private Double depositAmount;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setApplicationId(Long applicationId) 
    {
        this.applicationId = applicationId;
    }

    public Long getApplicationId() 
    {
        return applicationId;
    }
    public void setReleaseId(Long releaseId) 
    {
        this.releaseId = releaseId;
    }

    public Long getReleaseId() 
    {
        return releaseId;
    }
    public void setPetId(Long petId) 
    {
        this.petId = petId;
    }

    public Long getPetId() 
    {
        return petId;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setHousingType(String housingType) 
    {
        this.housingType = housingType;
    }

    public String getHousingType() 
    {
        return housingType;
    }
    public void setPetAllowed(Integer petAllowed) 
    {
        this.petAllowed = petAllowed;
    }

    public Integer getPetAllowed() 
    {
        return petAllowed;
    }
    public void setHasEnclosedBalcony(Integer hasEnclosedBalcony) 
    {
        this.hasEnclosedBalcony = hasEnclosedBalcony;
    }

    public Integer getHasEnclosedBalcony() 
    {
        return hasEnclosedBalcony;
    }
    public void setFamilyAgree(Integer familyAgree) 
    {
        this.familyAgree = familyAgree;
    }

    public Integer getFamilyAgree() 
    {
        return familyAgree;
    }
    public void setHasAllergy(Integer hasAllergy) 
    {
        this.hasAllergy = hasAllergy;
    }

    public Integer getHasAllergy() 
    {
        return hasAllergy;
    }
    public void setWorkSchedule(String workSchedule) 
    {
        this.workSchedule = workSchedule;
    }

    public String getWorkSchedule() 
    {
        return workSchedule;
    }
    public void setCompanionTime(String companionTime) 
    {
        this.companionTime = companionTime;
    }

    public String getCompanionTime() 
    {
        return companionTime;
    }
    public void setKnowBasicCost(Integer knowBasicCost) 
    {
        this.knowBasicCost = knowBasicCost;
    }

    public Integer getKnowBasicCost() 
    {
        return knowBasicCost;
    }
    public void setCanAffordMedical(Integer canAffordMedical) 
    {
        this.canAffordMedical = canAffordMedical;
    }

    public Integer getCanAffordMedical() 
    {
        return canAffordMedical;
    }
    public void setScientificFeeding(Integer scientificFeeding) 
    {
        this.scientificFeeding = scientificFeeding;
    }

    public Integer getScientificFeeding() 
    {
        return scientificFeeding;
    }
    public void setAgreeSterilization(Integer agreeSterilization) 
    {
        this.agreeSterilization = agreeSterilization;
    }

    public Integer getAgreeSterilization() 
    {
        return agreeSterilization;
    }
    public void setPetExperience(String petExperience) 
    {
        this.petExperience = petExperience;
    }

    public String getPetExperience() 
    {
        return petExperience;
    }
    public void setFuturePlans(String futurePlans) 
    {
        this.futurePlans = futurePlans;
    }

    public String getFuturePlans() 
    {
        return futurePlans;
    }
    public void setNoAbandon(Integer noAbandon) 
    {
        this.noAbandon = noAbandon;
    }

    public Integer getNoAbandon() 
    {
        return noAbandon;
    }
    public void setAcceptVisit(Integer acceptVisit) 
    {
        this.acceptVisit = acceptVisit;
    }

    public Integer getAcceptVisit() 
    {
        return acceptVisit;
    }
    public void setApplicantName(String applicantName) 
    {
        this.applicantName = applicantName;
    }

    public String getApplicantName() 
    {
        return applicantName;
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
    public void setLivingProveUrl(String livingProveUrl) 
    {
        this.livingProveUrl = livingProveUrl;
    }

    public String getLivingProveUrl() 
    {
        return livingProveUrl;
    }
    public void setAgreementUrl(String agreementUrl) 
    {
        this.agreementUrl = agreementUrl;
    }

    public String getAgreementUrl() 
    {
        return agreementUrl;
    }
    public void setApplyStatus(Integer applyStatus) 
    {
        this.applyStatus = applyStatus;
    }

    public Integer getApplyStatus() 
    {
        return applyStatus;
    }
    public void setReviewUserId(Long reviewUserId) 
    {
        this.reviewUserId = reviewUserId;
    }

    public Long getReviewUserId() 
    {
        return reviewUserId;
    }
    public void setReviewRemark(String reviewRemark) 
    {
        this.reviewRemark = reviewRemark;
    }

    public String getReviewRemark() 
    {
        return reviewRemark;
    }
    public void setReviewTime(Date reviewTime) 
    {
        this.reviewTime = reviewTime;
    }

    public Date getReviewTime() 
    {
        return reviewTime;
    }
    public void setDepositAmount(Double depositAmount) 
    {
        this.depositAmount = depositAmount;
    }

    public Double getDepositAmount() 
    {
        return depositAmount;
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
            .append("applicationId", getApplicationId())
            .append("releaseId", getReleaseId())
            .append("petId", getPetId())
            .append("userId", getUserId())
            .append("housingType", getHousingType())
            .append("petAllowed", getPetAllowed())
            .append("hasEnclosedBalcony", getHasEnclosedBalcony())
            .append("familyAgree", getFamilyAgree())
            .append("hasAllergy", getHasAllergy())
            .append("workSchedule", getWorkSchedule())
            .append("companionTime", getCompanionTime())
            .append("knowBasicCost", getKnowBasicCost())
            .append("canAffordMedical", getCanAffordMedical())
            .append("scientificFeeding", getScientificFeeding())
            .append("agreeSterilization", getAgreeSterilization())
            .append("petExperience", getPetExperience())
            .append("futurePlans", getFuturePlans())
            .append("noAbandon", getNoAbandon())
            .append("acceptVisit", getAcceptVisit())
            .append("applicantName", getApplicantName())
            .append("contactPhone", getContactPhone())
            .append("address", getAddress())
            .append("livingProveUrl", getLivingProveUrl())
            .append("agreementUrl", getAgreementUrl())
            .append("applyStatus", getApplyStatus())
            .append("reviewUserId", getReviewUserId())
            .append("reviewRemark", getReviewRemark())
            .append("reviewTime", getReviewTime())
            .append("depositAmount", getDepositAmount())
            .append("isDeleted", getIsDeleted())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
