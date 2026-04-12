package com.ruoyi.give.service;

import java.util.List;
import com.ruoyi.give.domain.RescueInfo;

/**
 * 救助信息Service接口
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
public interface IRescueInfoService 
{
    /**
     * 查询救助信息
     * 
     * @param rescueId 救助信息主键
     * @return 救助信息
     */
    public RescueInfo selectRescueInfoByRescueId(Long rescueId);

    /**
     * 查询救助信息列表
     * 
     * @param rescueInfo 救助信息
     * @return 救助信息集合
     */
    public List<RescueInfo> selectRescueInfoList(RescueInfo rescueInfo);

    /**
     * 新增救助信息
     * 
     * @param rescueInfo 救助信息
     * @return 结果
     */
    public int insertRescueInfo(RescueInfo rescueInfo);

    /**
     * 修改救助信息
     * 
     * @param rescueInfo 救助信息
     * @return 结果
     */
    public int updateRescueInfo(RescueInfo rescueInfo);

    /**
     * 批量删除救助信息
     * 
     * @param rescueIds 需要删除的救助信息主键集合
     * @return 结果
     */
    public int deleteRescueInfoByRescueIds(Long[] rescueIds);

    /**
     * 删除救助信息信息
     * 
     * @param rescueId 救助信息主键
     * @return 结果
     */
    public int deleteRescueInfoByRescueId(Long rescueId);
}
