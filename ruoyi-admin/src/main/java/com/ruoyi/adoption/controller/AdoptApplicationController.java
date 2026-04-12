package com.ruoyi.adoption.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.ruoyi.adoption.domain.AdoptApplication;
import com.ruoyi.adoption.service.IAdoptApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 领养申请Controller
 * 
 * @author ruoyi
 * @date 2026-04-04
 */
@RestController
@RequestMapping("/adoption/application")
public class AdoptApplicationController extends BaseController
{
    @Autowired
    private IAdoptApplicationService adoptApplicationService;

    /**
     * 查询领养申请列表
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(AdoptApplication adoptApplication)
    {
        startPage();
        List<AdoptApplication> list = adoptApplicationService.selectAdoptApplicationList(adoptApplication);
        return getDataTable(list);
    }

    /**
     * 导出领养申请列表
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:export')")
    @Log(title = "领养申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AdoptApplication adoptApplication)
    {
        List<AdoptApplication> list = adoptApplicationService.selectAdoptApplicationList(adoptApplication);
        ExcelUtil<AdoptApplication> util = new ExcelUtil<AdoptApplication>(AdoptApplication.class);
        util.exportExcel(response, list, "领养申请数据");
    }

    /**
     * 获取领养申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:query')")
    @GetMapping(value = "/{applicationId}")
    public AjaxResult getInfo(@PathVariable("applicationId") Long applicationId)
    {
        return AjaxResult.success(adoptApplicationService.selectAdoptApplicationByApplicationId(applicationId));
    }

    /**
     * 新增领养申请
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:add')")
    @Log(title = "领养申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AdoptApplication adoptApplication)
    {
        return toAjax(adoptApplicationService.insertAdoptApplication(adoptApplication));
    }

    /**
     * 修改领养申请
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:edit')")
    @Log(title = "领养申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AdoptApplication adoptApplication)
    {
        return toAjax(adoptApplicationService.updateAdoptApplication(adoptApplication));
    }

    /**
     * 删除领养申请
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:remove')")
    @Log(title = "领养申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{applicationIds}")
    public AjaxResult remove(@PathVariable Long[] applicationIds)
    {
        return toAjax(adoptApplicationService.deleteAdoptApplicationByApplicationIds(applicationIds));
    }

    /**
     * 提交领养申请
     */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody AdoptApplication adoptApplication)
    {
        adoptApplication.setApplyStatus(0); // 待审核
        adoptApplication.setUserId(getUserId()); // 设置申请人ID
        int result = adoptApplicationService.insertAdoptApplication(adoptApplication);
        if (result > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("applicationId", adoptApplication.getApplicationId());
            return AjaxResult.success("申请提交成功", data);
        } else {
            return AjaxResult.error("申请提交失败");
        }
    }

    /**
     * 审批领养申请
     */
    @PutMapping("/{applicationId}/approve")
    public AjaxResult approve(@PathVariable Long applicationId, @RequestBody Map<String, Object> params)
    {
        AdoptApplication application = adoptApplicationService.selectAdoptApplicationByApplicationId(applicationId);
        if (application == null) {
            return AjaxResult.error("申请不存在");
        }
        String status = (String) params.get("status");
        String remark = (String) params.get("remark");
        
        if ("approved".equals(status)) {
            application.setApplyStatus(1); // 审核通过
        } else if ("rejected".equals(status)) {
            application.setApplyStatus(2); // 审核驳回
        } else {
            return AjaxResult.error("无效的状态");
        }
        
        application.setReviewUserId(getUserId());
        application.setReviewRemark(remark);
        application.setReviewTime(new Date());
        return toAjax(adoptApplicationService.updateAdoptApplication(application));
    }

    /**
     * 上传签署后的协议
     */
    @PostMapping("/{applicationId}/agreement")
    public AjaxResult uploadAgreement(@PathVariable Long applicationId, @RequestBody AdoptApplication adoptApplication)
    {
        AdoptApplication application = adoptApplicationService.selectAdoptApplicationByApplicationId(applicationId);
        if (application == null) {
            return AjaxResult.error("申请不存在");
        }
        application.setAgreementUrl(adoptApplication.getAgreementUrl());
        return toAjax(adoptApplicationService.updateAdoptApplication(application));
    }

    /**
     * 下载领养协议模板
     */
    @GetMapping("/agreement/download")
    public void downloadAgreementTemplate(HttpServletResponse response)
    {
        try {
            // 这里应该返回领养协议模板文件
            // 暂时返回一个简单的文本响应
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "attachment; filename=adoption_agreement_template.pdf");
            response.getOutputStream().write("领养协议模板内容".getBytes());
        } catch (Exception e) {
            throw new RuntimeException("下载失败", e);
        }
    }

    /**
     * 获取待审批领养申请列表（管理员）
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:admin:list')")
    @GetMapping("/admin/list")
    public TableDataInfo adminList(AdoptApplication adoptApplication)
    {
        startPage();
        adoptApplication.setApplyStatus(0); // 只查询待审核的
        List<AdoptApplication> list = adoptApplicationService.selectAdoptApplicationList(adoptApplication);
        return getDataTable(list);
    }

    /**
     * 批量审批领养申请（管理员）
     */
    @PreAuthorize("@ss.hasPermi('adoption:application:admin:batch-approve')")
    @PutMapping("/admin/batch-approve")
    public AjaxResult batchApprove(@RequestBody Map<String, Object> params)
    {
        @SuppressWarnings("unchecked")
        List<Long> ids = (List<Long>) params.get("ids");
        String status = (String) params.get("status");
        String remark = (String) params.get("remark");
        
        if (ids == null || ids.isEmpty()) {
            return AjaxResult.error("请选择要审批的申请");
        }
        
        Integer statusCode;
        if ("approved".equals(status)) {
            statusCode = 1; // 审核通过
        } else if ("rejected".equals(status)) {
            statusCode = 2; // 审核驳回
        } else {
            return AjaxResult.error("无效的状态");
        }
        
        for (Long id : ids) {
            AdoptApplication application = adoptApplicationService.selectAdoptApplicationByApplicationId(id);
            if (application != null && application.getApplyStatus() == 0) {
                application.setApplyStatus(statusCode);
                application.setReviewUserId(getUserId());
                application.setReviewRemark(remark);
                application.setReviewTime(new Date());
                adoptApplicationService.updateAdoptApplication(application);
            }
        }
        
        return AjaxResult.success("批量审批成功");
    }
}
