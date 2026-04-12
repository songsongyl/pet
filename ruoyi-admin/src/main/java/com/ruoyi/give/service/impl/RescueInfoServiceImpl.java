package com.ruoyi.give.service.impl;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.give.mapper.RescueInfoMapper;
import com.ruoyi.give.domain.RescueInfo;
import com.ruoyi.give.service.IRescueInfoService;
import com.ruoyi.pet.mapper.PetImageMapper;
import com.ruoyi.pet.domain.PetImage;

/**
 * 救助信息Service业务层处理
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
@Service
public class RescueInfoServiceImpl implements IRescueInfoService 
{
    @Autowired
    private RescueInfoMapper rescueInfoMapper;

    @Autowired
    private PetImageMapper petImageMapper;

    /**
     * 查询救助信息
     * 
     * @param rescueId 救助信息主键
     * @return 救助信息
     */
    @Override
    public RescueInfo selectRescueInfoByRescueId(Long rescueId)
    {
        return rescueInfoMapper.selectRescueInfoByRescueId(rescueId);
    }

    /**
     * 查询救助信息列表
     * 
     * @param rescueInfo 救助信息
     * @return 救助信息
     */
    @Override
    public List<RescueInfo> selectRescueInfoList(RescueInfo rescueInfo)
    {
        List<RescueInfo> list = rescueInfoMapper.selectRescueInfoList(rescueInfo);
        for (RescueInfo info : list) {
            if (info.getPetId() != null) {
                List<PetImage> images = petImageMapper.selectPetImagesByPetId(info.getPetId());
                List<String> mediaFiles = images.stream()
                    .map(PetImage::getImageUrl)
                    .collect(Collectors.toList());
                info.setMediaFiles(mediaFiles);
            }
        }
        return list;
    }

    /**
     * 新增救助信息
     * 
     * @param rescueInfo 救助信息
     * @return 结果
     */
    @Override
    public int insertRescueInfo(RescueInfo rescueInfo)
    {
        rescueInfo.setCreateTime(DateUtils.getNowDate());
        return rescueInfoMapper.insertRescueInfo(rescueInfo);
    }

    /**
     * 修改救助信息
     * 
     * @param rescueInfo 救助信息
     * @return 结果
     */
    @Override
    public int updateRescueInfo(RescueInfo rescueInfo)
    {
        rescueInfo.setUpdateTime(DateUtils.getNowDate());
        return rescueInfoMapper.updateRescueInfo(rescueInfo);
    }

    /**
     * 批量删除救助信息
     * 
     * @param rescueIds 需要删除的救助信息主键
     * @return 结果
     */
    @Override
    public int deleteRescueInfoByRescueIds(Long[] rescueIds)
    {
        return rescueInfoMapper.deleteRescueInfoByRescueIds(rescueIds);
    }

    /**
     * 删除救助信息信息
     * 
     * @param rescueId 救助信息主键
     * @return 结果
     */
    @Override
    public int deleteRescueInfoByRescueId(Long rescueId)
    {
        return rescueInfoMapper.deleteRescueInfoByRescueId(rescueId);
    }
}
