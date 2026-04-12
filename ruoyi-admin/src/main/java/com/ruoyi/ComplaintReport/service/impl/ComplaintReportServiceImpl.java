package com.ruoyi.ComplaintReport.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.ComplaintReport.mapper.ComplaintReportMapper;
import com.ruoyi.ComplaintReport.domain.ComplaintReport;
import com.ruoyi.ComplaintReport.service.IComplaintReportService;

/**
 * 投诉举报（用户投诉举报记录）Service业务层处理
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
@Service
public class ComplaintReportServiceImpl implements IComplaintReportService 
{
    @Autowired
    private ComplaintReportMapper complaintReportMapper;

    /**
     * 查询投诉举报（用户投诉举报记录）
     * 
     * @param complaintId 投诉举报（用户投诉举报记录）主键
     * @return 投诉举报（用户投诉举报记录）
     */
    @Override
    public ComplaintReport selectComplaintReportByComplaintId(Long complaintId)
    {
        return complaintReportMapper.selectComplaintReportByComplaintId(complaintId);
    }

    /**
     * 查询投诉举报（用户投诉举报记录）列表
     * 
     * @param complaintReport 投诉举报（用户投诉举报记录）
     * @return 投诉举报（用户投诉举报记录）
     */
    @Override
    public List<ComplaintReport> selectComplaintReportList(ComplaintReport complaintReport)
    {
        return complaintReportMapper.selectComplaintReportList(complaintReport);
    }

    /**
     * 新增投诉举报（用户投诉举报记录）
     * 
     * @param complaintReport 投诉举报（用户投诉举报记录）
     * @return 结果
     */
    @Override
    public int insertComplaintReport(ComplaintReport complaintReport)
    {
        complaintReport.setCreateTime(DateUtils.getNowDate());
        return complaintReportMapper.insertComplaintReport(complaintReport);
    }

    /**
     * 修改投诉举报（用户投诉举报记录）
     * 
     * @param complaintReport 投诉举报（用户投诉举报记录）
     * @return 结果
     */
    @Override
    public int updateComplaintReport(ComplaintReport complaintReport)
    {
        complaintReport.setUpdateTime(DateUtils.getNowDate());
        return complaintReportMapper.updateComplaintReport(complaintReport);
    }

    /**
     * 批量删除投诉举报（用户投诉举报记录）
     * 
     * @param complaintIds 需要删除的投诉举报（用户投诉举报记录）主键
     * @return 结果
     */
    @Override
    public int deleteComplaintReportByComplaintIds(Long[] complaintIds)
    {
        return complaintReportMapper.deleteComplaintReportByComplaintIds(complaintIds);
    }

    /**
     * 删除投诉举报（用户投诉举报记录）信息
     * 
     * @param complaintId 投诉举报（用户投诉举报记录）主键
     * @return 结果
     */
    @Override
    public int deleteComplaintReportByComplaintId(Long complaintId)
    {
        return complaintReportMapper.deleteComplaintReportByComplaintId(complaintId);
    }
}
