package com.ruoyi.pet.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 宠物信息对象 pet_info
 *
 * @author 宋依琳
 * @date 2025-12-20
 */
public class PetInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 宠物ID（主键） */
    private Integer petId;

    /** 宠物唯一编码（电子身份证） */
//    @Excel(name = "宠物唯一编码", readConverterExp = "电=子身份证")
//    private String petCode;

    /** 宠物图片 */
    @Excel(name = "宠物图片")
    private String mediaUrl;

    /** 宠物名称 */
    @Excel(name = "宠物名称")
    private String petName;

    /** 宠物类型 */
    @Excel(name = "宠物类型")
    private Integer petType;

    /** 品种 */
    @Excel(name = "品种")
    private String breed;

    /** 年龄 */
    @Excel(name = "年龄")
    private String age;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    /** 健康状态 */
    @Excel(name = "健康状态")
    private Integer healthStatus;

    /** 是否绝育 */
    @Excel(name = "是否绝育")
    private Integer sterilization;

    /** 疫苗状态 */
    @Excel(name = "疫苗状态")
    private Integer vaccineStatus;

    /** 芯片编号（如有） */
    private String chipNo;

    /** 发现地点 */
    @Excel(name = "发现地点")
    private String foundPlace;

    /** 发现时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发现时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date foundTime;

    /** 宠物描述 */
    @Excel(name = "宠物描述")
    private String petDesc;

    /** 宠物状态 */
    @Excel(name = "宠物状态")
    private Integer petStatus;

    /** 发布者ID */
    @Excel(name = "发布者ID")
    private Long publisherId;

    /** 发布者类型 */
    @Excel(name = "发布者类型")
    private Integer publisherType;

    /** 关联机构ID（如医疗托管，关联cooperate_org.org_id） */
    @Excel(name = "关联机构ID", readConverterExp = "如=医疗托管，关联cooperate_org.org_id")
    private Long orgId;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

//    public String getPetCode() {
//        return petCode;
//    }
//
//    public void setPetCode(String petCode) {
//        this.petCode = petCode;
//    }

    public String getMediaUrl() {
        return mediaUrl;
    }

    public void setMediaUrl(String mediaUrl) {
        this.mediaUrl = mediaUrl;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Integer getPetType() {
        return petType;
    }

    public void setPetType(Integer petType) {
        this.petType = petType;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Integer getHealthStatus() {
        return healthStatus;
    }

    public void setHealthStatus(Integer healthStatus) {
        this.healthStatus = healthStatus;
    }

    public Integer getSterilization() {
        return sterilization;
    }

    public void setSterilization(Integer sterilization) {
        this.sterilization = sterilization;
    }

    public Integer getVaccineStatus() {
        return vaccineStatus;
    }

    public void setVaccineStatus(Integer vaccineStatus) {
        this.vaccineStatus = vaccineStatus;
    }

    public String getChipNo() {
        return chipNo;
    }

    public void setChipNo(String chipNo) {
        this.chipNo = chipNo;
    }

    public String getFoundPlace() {
        return foundPlace;
    }

    public void setFoundPlace(String foundPlace) {
        this.foundPlace = foundPlace;
    }

    public Date getFoundTime() {
        return foundTime;
    }

    public void setFoundTime(Date foundTime) {
        this.foundTime = foundTime;
    }

    public String getPetDesc() {
        return petDesc;
    }

    public void setPetDesc(String petDesc) {
        this.petDesc = petDesc;
    }

    public Integer getPetStatus() {
        return petStatus;
    }

    public void setPetStatus(Integer petStatus) {
        this.petStatus = petStatus;
    }

    public Long getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Long publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getPublisherType() {
        return publisherType;
    }

    public void setPublisherType(Integer publisherType) {
        this.publisherType = publisherType;
    }

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
        this.orgId = orgId;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("petId", getPetId())
//            .append("petCode", getPetCode())
                .append("mediaUrl", getMediaUrl())
                .append("petName", getPetName())
                .append("petType", getPetType())
                .append("breed", getBreed())
                .append("age", getAge())
                .append("gender", getGender())
                .append("healthStatus", getHealthStatus())
                .append("sterilization", getSterilization())
                .append("vaccineStatus", getVaccineStatus())
                .append("chipNo", getChipNo())
                .append("foundPlace", getFoundPlace())
                .append("foundTime", getFoundTime())
                .append("petDesc", getPetDesc())
                .append("petStatus", getPetStatus())
                .append("publisherId", getPublisherId())
                .append("publisherType", getPublisherType())
                .append("orgId", getOrgId())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("isDeleted", getIsDeleted())
                .toString();
    }
}