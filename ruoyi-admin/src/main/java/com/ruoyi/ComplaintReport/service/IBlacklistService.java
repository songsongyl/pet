package com.ruoyi.ComplaintReport.service;

import java.util.List;
import com.ruoyi.ComplaintReport.domain.Blacklist;

/**
 * 黑名单Service接口
 *
 * @author songyilin
 * @date 2025-05-29
 */
public interface IBlacklistService
{
    /**
     * 查询黑名单
     *
     * @param blacklistId 黑名单主键
     * @return 黑名单
     */
    public Blacklist selectBlacklistByBlacklistId(Long blacklistId);

    /**
     * 查询黑名单列表
     *
     * @param blacklist 黑名单
     * @return 黑名单集合
     */
    public List<Blacklist> selectBlacklistList(Blacklist blacklist);

    /**
     * 查询用户是否在黑名单中
     *
     * @param userId 用户ID
     * @return 黑名单
     */
    public Blacklist selectBlacklistByUserId(Long userId);

    /**
     * 新增黑名单
     *
     * @param blacklist 黑名单
     * @return 结果
     */
    public int insertBlacklist(Blacklist blacklist);

    /**
     * 修改黑名单
     *
     * @param blacklist 黑名单
     * @return 结果
     */
    public int updateBlacklist(Blacklist blacklist);

    /**
     * 删除黑名单
     *
     * @param blacklistId 黑名单主键
     * @return 结果
     */
    public int deleteBlacklistByBlacklistId(Long blacklistId);

    /**
     * 批量删除黑名单
     *
     * @param blacklistIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBlacklistByBlacklistIds(Long[] blacklistIds);

    /**
     * 批量解封用户（状态改为已解封）
     *
     * @param blacklistIds 需要解封的数据主键集合
     * @return 结果
     */
    public int unblockBlacklistByBlacklistIds(Long[] blacklistIds);
}
