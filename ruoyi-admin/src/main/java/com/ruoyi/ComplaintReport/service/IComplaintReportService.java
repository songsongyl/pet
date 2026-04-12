package com.ruoyi.ComplaintReport.service;

import java.util.List;
import com.ruoyi.ComplaintReport.domain.ComplaintReport;

/**
 * 投诉举报（用户投诉举报记录）Service接口
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
public interface IComplaintReportService 
{
    /**
     * 查询投诉举报（用户投诉举报记录）
     * 
     * @param complaintId 投诉举报（用户投诉举报记录）主键
     * @return 投诉举报（用户投诉举报记录）
     */
    public ComplaintReport selectComplaintReportByComplaintId(Long complaintId);

    /**
     * 查询投诉举报（用户投诉举报记录）列表
     * 
     * @param complaintReport 投诉举报（用户投诉举报记录）
     * @return 投诉举报（用户投诉举报记录）集合
     */
    public List<ComplaintReport> selectComplaintReportList(ComplaintReport complaintReport);

    /**
     * 新增投诉举报（用户投诉举报记录）
     * 
     * @param complaintReport 投诉举报（用户投诉举报记录）
     * @return 结果
     */
    public int insertComplaintReport(ComplaintReport complaintReport);

    /**
     * 修改投诉举报（用户投诉举报记录）
     * 
     * @param complaintReport 投诉举报（用户投诉举报记录）
     * @return 结果
     */
    public int updateComplaintReport(ComplaintReport complaintReport);

    /**
     * 批量删除投诉举报（用户投诉举报记录）
     * 
     * @param complaintIds 需要删除的投诉举报（用户投诉举报记录）主键集合
     * @return 结果
     */
    public int deleteComplaintReportByComplaintIds(Long[] complaintIds);

    /**
     * 删除投诉举报（用户投诉举报记录）信息
     * 
     * @param complaintId 投诉举报（用户投诉举报记录）主键
     * @return 结果
     */
    public int deleteComplaintReportByComplaintId(Long complaintId);
}
