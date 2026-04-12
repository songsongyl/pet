package com.ruoyi.NoticeInfo.service;

import java.util.List;
import com.ruoyi.NoticeInfo.domain.NoticeInfo;

/**
 * 公告信息Service接口
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
public interface INoticeInfoService 
{
    /**
     * 查询公告信息
     * 
     * @param noticeId 公告信息主键
     * @return 公告信息
     */
    public NoticeInfo selectNoticeInfoByNoticeId(Long noticeId);

    /**
     * 查询公告信息列表
     * 
     * @param noticeInfo 公告信息
     * @return 公告信息集合
     */
    public List<NoticeInfo> selectNoticeInfoList(NoticeInfo noticeInfo);

    /**
     * 新增公告信息
     * 
     * @param noticeInfo 公告信息
     * @return 结果
     */
    public int insertNoticeInfo(NoticeInfo noticeInfo);

    /**
     * 修改公告信息
     * 
     * @param noticeInfo 公告信息
     * @return 结果
     */
    public int updateNoticeInfo(NoticeInfo noticeInfo);

    /**
     * 批量删除公告信息
     * 
     * @param noticeIds 需要删除的公告信息主键集合
     * @return 结果
     */
    public int deleteNoticeInfoByNoticeIds(Long[] noticeIds);

    /**
     * 删除公告信息信息
     * 
     * @param noticeId 公告信息主键
     * @return 结果
     */
    public int deleteNoticeInfoByNoticeId(Long noticeId);
}
