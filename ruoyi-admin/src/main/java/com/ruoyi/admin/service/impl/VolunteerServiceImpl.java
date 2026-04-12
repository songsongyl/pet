package com.ruoyi.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.admin.mapper.VolunteerMapper;
import com.ruoyi.admin.domain.Volunteer;
import com.ruoyi.admin.service.IVolunteerService;

/**
 * 志愿者Service业务层处理
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@Service
public class VolunteerServiceImpl implements IVolunteerService
{
    @Autowired
    private VolunteerMapper volunteerMapper;

    /**
     * 查询志愿者
     *
     * @param volunteerId 志愿者主键
     * @return 志愿者
     */
    @Override
    public Volunteer selectVolunteerByVolunteerId(Long volunteerId)
    {
        return volunteerMapper.selectVolunteerByVolunteerId(volunteerId);
    }

    /**
     * 查询志愿者列表
     *
     * @param volunteer 志愿者
     * @return 志愿者
     */
    @Override
    public List<Volunteer> selectVolunteerList(Volunteer volunteer)
    {
        return volunteerMapper.selectVolunteerList(volunteer);
    }

    /**
     * 新增志愿者
     *
     * @param volunteer 志愿者
     * @return 结果
     */
    @Override
    public int insertVolunteer(Volunteer volunteer)
    {
        return volunteerMapper.insertVolunteer(volunteer);
    }

    /**
     * 修改志愿者
     *
     * @param volunteer 志愿者
     * @return 结果
     */
    @Override
    public int updateVolunteer(Volunteer volunteer)
    {
        return volunteerMapper.updateVolunteer(volunteer);
    }

    /**
     * 批量删除志愿者
     *
     * @param volunteerIds 需要删除的志愿者主键
     * @return 结果
     */
    @Override
    public int deleteVolunteerByVolunteerIds(Long[] volunteerIds)
    {
        return volunteerMapper.deleteVolunteerByVolunteerIds(volunteerIds);
    }

    /**
     * 删除志愿者信息
     *
     * @param volunteerId 志愿者主键
     * @return 结果
     */
    @Override
    public int deleteVolunteerByVolunteerId(Long volunteerId)
    {
        return volunteerMapper.deleteVolunteerByVolunteerId(volunteerId);
    }

    /**
     * 获取志愿者统计数据
     *
     * @return 统计数据
     */
    @Override
    public Volunteer getVolunteerStats()
    {
        return volunteerMapper.selectVolunteerStats();
    }
}
