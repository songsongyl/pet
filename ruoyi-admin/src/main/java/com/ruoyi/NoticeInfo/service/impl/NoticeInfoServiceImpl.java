package com.ruoyi.NoticeInfo.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.NoticeInfo.mapper.NoticeInfoMapper;
import com.ruoyi.NoticeInfo.domain.NoticeInfo;
import com.ruoyi.NoticeInfo.service.INoticeInfoService;

/**
 * 公告信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
@Service
public class NoticeInfoServiceImpl implements INoticeInfoService 
{
    @Autowired
    private NoticeInfoMapper noticeInfoMapper;

    /**
     * 查询公告信息
     * 
     * @param noticeId 公告信息主键
     * @return 公告信息
     */
    @Override
    public NoticeInfo selectNoticeInfoByNoticeId(Long noticeId)
    {
        return noticeInfoMapper.selectNoticeInfoByNoticeId(noticeId);
    }

    /**
     * 查询公告信息列表
     * 
     * @param noticeInfo 公告信息
     * @return 公告信息
     */
    @Override
    public List<NoticeInfo> selectNoticeInfoList(NoticeInfo noticeInfo)
    {
        return noticeInfoMapper.selectNoticeInfoList(noticeInfo);
    }

    /**
     * 新增公告信息
     * 
     * @param noticeInfo 公告信息
     * @return 结果
     */
    @Override
    public int insertNoticeInfo(NoticeInfo noticeInfo)
    {
        noticeInfo.setCreateTime(DateUtils.getNowDate());
        return noticeInfoMapper.insertNoticeInfo(noticeInfo);
    }

    /**
     * 修改公告信息
     * 
     * @param noticeInfo 公告信息
     * @return 结果
     */
    @Override
    public int updateNoticeInfo(NoticeInfo noticeInfo)
    {
        noticeInfo.setUpdateTime(DateUtils.getNowDate());
        return noticeInfoMapper.updateNoticeInfo(noticeInfo);
    }

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告信息主键
     * @return 结果
     */
    @Override
    public int deleteNoticeInfoByNoticeIds(Long[] noticeIds)
    {
        return noticeInfoMapper.deleteNoticeInfoByNoticeIds(noticeIds);
    }

    /**
     * 删除公告信息信息
     * 
     * @param noticeId 公告信息主键
     * @return 结果
     */
    @Override
    public int deleteNoticeInfoByNoticeId(Long noticeId)
    {
        return noticeInfoMapper.deleteNoticeInfoByNoticeId(noticeId);
    }
}
