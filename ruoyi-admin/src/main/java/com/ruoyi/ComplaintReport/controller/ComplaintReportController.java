package com.ruoyi.ComplaintReport.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.ComplaintReport.domain.ComplaintReport;
import com.ruoyi.ComplaintReport.service.IComplaintReportService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 投诉举报（用户投诉举报记录）Controller
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
@RestController
@RequestMapping("/ComplaintReport/ComplaintReport")
public class ComplaintReportController extends BaseController
{
    @Autowired
    private IComplaintReportService complaintReportService;

    /**
     * 查询投诉举报（用户投诉举报记录）列表
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:ComplaintReport:list')")
    @GetMapping("/list")
    public TableDataInfo list(ComplaintReport complaintReport)
    {
        startPage();
        List<ComplaintReport> list = complaintReportService.selectComplaintReportList(complaintReport);
        return getDataTable(list);
    }

    /**
     * 导出投诉举报（用户投诉举报记录）列表
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:ComplaintReport:export')")
    @Log(title = "投诉举报（用户投诉举报记录）", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ComplaintReport complaintReport)
    {
        List<ComplaintReport> list = complaintReportService.selectComplaintReportList(complaintReport);
        ExcelUtil<ComplaintReport> util = new ExcelUtil<ComplaintReport>(ComplaintReport.class);
        util.exportExcel(response, list, "投诉举报（用户投诉举报记录）数据");
    }

    /**
     * 获取投诉举报（用户投诉举报记录）详细信息
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:ComplaintReport:query')")
    @GetMapping(value = "/{complaintId}")
    public AjaxResult getInfo(@PathVariable("complaintId") Long complaintId)
    {
        return success(complaintReportService.selectComplaintReportByComplaintId(complaintId));
    }

    /**
     * 新增投诉举报（用户投诉举报记录）
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:ComplaintReport:add')")
    @Log(title = "投诉举报（用户投诉举报记录）", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ComplaintReport complaintReport)
    {
        return toAjax(complaintReportService.insertComplaintReport(complaintReport));
    }

    /**
     * 修改投诉举报（用户投诉举报记录）
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:ComplaintReport:edit')")
    @Log(title = "投诉举报（用户投诉举报记录）", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ComplaintReport complaintReport)
    {
        return toAjax(complaintReportService.updateComplaintReport(complaintReport));
    }

    /**
     * 删除投诉举报（用户投诉举报记录）
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:ComplaintReport:remove')")
    @Log(title = "投诉举报（用户投诉举报记录）", businessType = BusinessType.DELETE)
	@DeleteMapping("/{complaintIds}")
    public AjaxResult remove(@PathVariable Long[] complaintIds)
    {
        return toAjax(complaintReportService.deleteComplaintReportByComplaintIds(complaintIds));
    }
}
