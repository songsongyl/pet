package com.ruoyi.pet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pet.mapper.PetInfoMapper;
import com.ruoyi.pet.domain.PetInfo;
import com.ruoyi.pet.service.IPetInfoService;

/**
 * 宠物信息Service业务层处理
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
@Service
public class PetInfoServiceImpl implements IPetInfoService 
{
    @Autowired
    private PetInfoMapper petInfoMapper;

    /**
     * 查询宠物信息
     * 
     * @param petId 宠物信息主键
     * @return 宠物信息
     */
    @Override
    public PetInfo selectPetInfoByPetId(Long petId)
    {
        return petInfoMapper.selectPetInfoByPetId(petId);
    }

    /**
     * 查询宠物信息列表
     * 
     * @param petInfo 宠物信息
     * @return 宠物信息
     */
    @Override
    public List<PetInfo> selectPetInfoList(PetInfo petInfo)
    {
        return petInfoMapper.selectPetInfoList(petInfo);
    }

    /**
     * 新增宠物信息
     * 
     * @param petInfo 宠物信息
     * @return 结果
     */
    @Override
    public int insertPetInfo(PetInfo petInfo)
    {
        System.out.println("轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩轩"+petInfo.getMediaUrl());
        petInfo.setCreateTime(DateUtils.getNowDate());
        return petInfoMapper.insertPetInfo(petInfo);
    }

    /**
     * 修改宠物信息
     * 
     * @param petInfo 宠物信息
     * @return 结果
     */
    @Override
    public int updatePetInfo(PetInfo petInfo)
    {
        petInfo.setUpdateTime(DateUtils.getNowDate());
        return petInfoMapper.updatePetInfo(petInfo);
    }

    /**
     * 批量删除宠物信息
     * 
     * @param petIds 需要删除的宠物信息主键
     * @return 结果
     */
    @Override
    public int deletePetInfoByPetIds(Long[] petIds)
    {
        return petInfoMapper.deletePetInfoByPetIds(petIds);
    }

    /**
     * 删除宠物信息信息
     * 
     * @param petId 宠物信息主键
     * @return 结果
     */
    @Override
    public int deletePetInfoByPetId(Long petId)
    {
        return petInfoMapper.deletePetInfoByPetId(petId);
    }
}
