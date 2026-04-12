package com.ruoyi.pet.service;

import java.util.List;
import com.ruoyi.pet.domain.PetInfo;

/**
 * 宠物信息Service接口
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
public interface IPetInfoService 
{
    /**
     * 查询宠物信息
     * 
     * @param petId 宠物信息主键
     * @return 宠物信息
     */
    public PetInfo selectPetInfoByPetId(Long petId);

    /**
     * 查询宠物信息列表
     * 
     * @param petInfo 宠物信息
     * @return 宠物信息集合
     */
    public List<PetInfo> selectPetInfoList(PetInfo petInfo);

    /**
     * 新增宠物信息
     * 
     * @param petInfo 宠物信息
     * @return 结果
     */
    public int insertPetInfo(PetInfo petInfo);

    /**
     * 修改宠物信息
     * 
     * @param petInfo 宠物信息
     * @return 结果
     */
    public int updatePetInfo(PetInfo petInfo);

    /**
     * 批量删除宠物信息
     * 
     * @param petIds 需要删除的宠物信息主键集合
     * @return 结果
     */
    public int deletePetInfoByPetIds(Long[] petIds);

    /**
     * 删除宠物信息信息
     * 
     * @param petId 宠物信息主键
     * @return 结果
     */
    public int deletePetInfoByPetId(Long petId);
}
