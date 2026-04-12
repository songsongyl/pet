package com.ruoyi.pet.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

public class PetImage extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    private Long imageId;

    @Excel(name = "关联宠物ID")
    private Long petId;

    @Excel(name = "图片URL地址")
    private String imageUrl;

    @Excel(name = "图片类型")
    private Integer imageType;

    @Excel(name = "排序")
    private Integer sort;

    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setImageId(Long imageId) 
    {
        this.imageId = imageId;
    }

    public Long getImageId() 
    {
        return imageId;
    }

    public void setPetId(Long petId) 
    {
        this.petId = petId;
    }

    public Long getPetId() 
    {
        return petId;
    }

    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }

    public void setImageType(Integer imageType) 
    {
        this.imageType = imageType;
    }

    public Integer getImageType() 
    {
        return imageType;
    }

    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
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
            .append("imageId", getImageId())
            .append("petId", getPetId())
            .append("imageUrl", getImageUrl())
            .append("imageType", getImageType())
            .append("sort", getSort())
            .append("createTime", getCreateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
