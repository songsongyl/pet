package com.ruoyi.admin.service;

import java.util.List;
import com.ruoyi.admin.domain.Volunteer;

/**
 * 志愿者Service接口
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public interface IVolunteerService
{
    /**
     * 查询志愿者
     *
     * @param volunteerId 志愿者主键
     * @return 志愿者
     */
    public Volunteer selectVolunteerByVolunteerId(Long volunteerId);

    /**
     * 查询志愿者列表
     *
     * @param volunteer 志愿者
     * @return 志愿者集合
     */
    public List<Volunteer> selectVolunteerList(Volunteer volunteer);

    /**
     * 新增志愿者
     *
     * @param volunteer 志愿者
     * @return 结果
     */
    public int insertVolunteer(Volunteer volunteer);

    /**
     * 修改志愿者
     *
     * @param volunteer 志愿者
     * @return 结果
     */
    public int updateVolunteer(Volunteer volunteer);

    /**
     * 批量删除志愿者
     *
     * @param volunteerIds 需要删除的志愿者主键集合
     * @return 结果
     */
    public int deleteVolunteerByVolunteerIds(Long[] volunteerIds);

    /**
     * 删除志愿者信息
     *
     * @param volunteerId 志愿者主键
     * @return 结果
     */
    public int deleteVolunteerByVolunteerId(Long volunteerId);

    /**
     * 获取志愿者统计数据
     *
     * @return 统计数据
     */
    public Volunteer getVolunteerStats();
}
