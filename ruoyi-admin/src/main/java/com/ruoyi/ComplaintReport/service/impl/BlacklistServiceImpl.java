package com.ruoyi.ComplaintReport.service.impl;

import java.util.List;
import com.ruoyi.ComplaintReport.domain.Blacklist;
import com.ruoyi.ComplaintReport.mapper.BlacklistMapper;
import com.ruoyi.ComplaintReport.service.IBlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 黑名单Service实现
 *
 * @author songyilin
 * @date 2025-05-29
 */
@Service
public class BlacklistServiceImpl implements IBlacklistService
{
    @Autowired
    private BlacklistMapper blacklistMapper;

    /**
     * 查询黑名单
     *
     * @param blacklistId 黑名单主键
     * @return 黑名单
     */
    @Override
    public Blacklist selectBlacklistByBlacklistId(Long blacklistId)
    {
        return blacklistMapper.selectBlacklistByBlacklistId(blacklistId);
    }

    /**
     * 查询黑名单列表
     *
     * @param blacklist 黑名单
     * @return 黑名单
     */
    @Override
    public List<Blacklist> selectBlacklistList(Blacklist blacklist)
    {
        return blacklistMapper.selectBlacklistList(blacklist);
    }

    /**
     * 查询用户是否在黑名单中
     *
     * @param userId 用户ID
     * @return 黑名单
     */
    @Override
    public Blacklist selectBlacklistByUserId(Long userId)
    {
        return blacklistMapper.selectBlacklistByUserId(userId);
    }

    /**
     * 新增黑名单
     *
     * @param blacklist 黑名单
     * @return 结果
     */
    @Override
    public int insertBlacklist(Blacklist blacklist)
    {
        return blacklistMapper.insertBlacklist(blacklist);
    }

    /**
     * 修改黑名单
     *
     * @param blacklist 黑名单
     * @return 结果
     */
    @Override
    public int updateBlacklist(Blacklist blacklist)
    {
        return blacklistMapper.updateBlacklist(blacklist);
    }

    /**
     * 删除黑名单
     *
     * @param blacklistId 黑名单主键
     * @return 结果
     */
    @Override
    public int deleteBlacklistByBlacklistId(Long blacklistId)
    {
        return blacklistMapper.deleteBlacklistByBlacklistId(blacklistId);
    }

    /**
     * 批量删除黑名单
     *
     * @param blacklistIds 需要删除的数据主键集合
     * @return 结果
     */
    @Override
    public int deleteBlacklistByBlacklistIds(Long[] blacklistIds)
    {
        return blacklistMapper.deleteBlacklistByBlacklistIds(blacklistIds);
    }

    /**
     * 批量解封用户
     *
     * @param blacklistIds 需要解封的数据主键集合
     * @return 结果
     */
    @Override
    public int unblockBlacklistByBlacklistIds(Long[] blacklistIds)
    {
        return blacklistMapper.updateBlacklistStatusByBlacklistIds(blacklistIds);
    }
}
