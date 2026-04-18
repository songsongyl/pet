package com.ruoyi.donation.controller;

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
import com.ruoyi.donation.domain.DonationApplication;
import com.ruoyi.donation.service.IDonationApplicationService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物资捐赠申请Controller
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@RestController
@RequestMapping("/donation/application")
public class DonationApplicationController extends BaseController
{
    @Autowired
    private IDonationApplicationService donationApplicationService;

    /**
     * 查询物资捐赠申请列表
     */
    @PreAuthorize("@ss.hasPermi('donation:application:list')")
    @GetMapping("/list")
    public TableDataInfo list(DonationApplication donationApplication)
    {
        startPage();
        List<DonationApplication> list = donationApplicationService.selectDonationApplicationList(donationApplication);
        return getDataTable(list);
    }

    /**
     * 导出物资捐赠申请列表
     */
    @PreAuthorize("@ss.hasPermi('donation:application:export')")
    @Log(title = "物资捐赠申请", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DonationApplication donationApplication)
    {
        List<DonationApplication> list = donationApplicationService.selectDonationApplicationList(donationApplication);
        ExcelUtil<DonationApplication> util = new ExcelUtil<DonationApplication>(DonationApplication.class);
        util.exportExcel(response, list, "物资捐赠申请数据");
    }

    /**
     * 获取物资捐赠申请详细信息
     */
    @PreAuthorize("@ss.hasPermi('donation:application:query')")
    @GetMapping(value = "/{donationId}")
    public AjaxResult getInfo(@PathVariable("donationId") Long donationId)
    {
        return AjaxResult.success(donationApplicationService.selectDonationApplicationByDonationId(donationId));
    }

    /**
     * 新增物资捐赠申请
     */
    @PreAuthorize("@ss.hasPermi('donation:application:add')")
    @Log(title = "物资捐赠申请", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DonationApplication donationApplication)
    {
        return toAjax(donationApplicationService.insertDonationApplication(donationApplication));
    }

    /**
     * 修改物资捐赠申请
     */
    @PreAuthorize("@ss.hasPermi('donation:application:edit')")
    @Log(title = "物资捐赠申请", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DonationApplication donationApplication)
    {
        return toAjax(donationApplicationService.updateDonationApplication(donationApplication));
    }

    /**
     * 删除物资捐赠申请
     */
    @PreAuthorize("@ss.hasPermi('donation:application:remove')")
    @Log(title = "物资捐赠申请", businessType = BusinessType.DELETE)
	@DeleteMapping("/{donationIds}")
    public AjaxResult remove(@PathVariable Long[] donationIds)
    {
        return toAjax(donationApplicationService.deleteDonationApplicationByDonationIds(donationIds));
    }

    /**
     * 提交物资捐赠申请
     */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody DonationApplication donationApplication)
    {
        donationApplication.setDonationStatus(0); // 待确认
        int result = donationApplicationService.insertDonationApplication(donationApplication);
        if (result > 0) {
            Map<String, Object> data = new HashMap<>();
            data.put("applicationId", donationApplication.getDonationId());
            return AjaxResult.success("捐赠提交成功", data);
        } else {
            return AjaxResult.error("捐赠提交失败");
        }
    }

    /**
     * 确认收到捐赠
     */
    @PutMapping("/{donationId}/confirm")
    public AjaxResult confirm(@PathVariable Long donationId)
    {
        DonationApplication application = donationApplicationService.selectDonationApplicationByDonationId(donationId);
        if (application == null) {
            return AjaxResult.error("捐赠申请不存在");
        }
        application.setDonationStatus(1); // 已确认
        application.setConfirmTime(new Date());
        return toAjax(donationApplicationService.updateDonationApplication(application));
    }

    /**
     * 取消捐赠
     */
    @PutMapping("/{donationId}/cancel")
    public AjaxResult cancel(@PathVariable Long donationId)
    {
        DonationApplication application = donationApplicationService.selectDonationApplicationByDonationId(donationId);
        if (application == null) {
            return AjaxResult.error("捐赠申请不存在");
        }
        application.setDonationStatus(2); // 已取消
        return toAjax(donationApplicationService.updateDonationApplication(application));
    }

    /**
     * 获取待确认捐赠申请列表（管理员）
     */
    @PreAuthorize("@ss.hasPermi('donation:application:admin:list')")
    @GetMapping("/admin/list")
    public TableDataInfo adminList(DonationApplication donationApplication)
    {
        startPage();
        donationApplication.setDonationStatus(0); // 只查询待确认的
        List<DonationApplication> list = donationApplicationService.selectDonationApplicationList(donationApplication);
        return getDataTable(list);
    }

    /**
     * 批量确认捐赠（管理员）
     */
    @PreAuthorize("@ss.hasPermi('donation:application:admin:batch-confirm')")
    @PutMapping("/admin/batch-confirm")
    public AjaxResult batchConfirm(@RequestBody Map<String, Object> params)
    {
        @SuppressWarnings("unchecked")
        List<Integer> ids = (List<Integer>) params.get("ids");
        
        if (ids == null || ids.isEmpty()) {
            return AjaxResult.error("请选择要确认的捐赠申请");
        }
        
        for (Integer id : ids) {
            DonationApplication application = donationApplicationService.selectDonationApplicationByDonationId(id.longValue());
            if (application != null && application.getDonationStatus() == 0) {
                application.setDonationStatus(1); // 已确认
                application.setConfirmTime(new Date());
                donationApplicationService.updateDonationApplication(application);
            }
        }
        
        return AjaxResult.success("批量确认成功");
    }

    /**
     * 批量取消捐赠（管理员）
     */
    @PreAuthorize("@ss.hasPermi('donation:application:admin:batch-cancel')")
    @PutMapping("/admin/batch-cancel")
    public AjaxResult batchCancel(@RequestBody Map<String, Object> params)
    {
        @SuppressWarnings("unchecked")
        List<Integer> ids = (List<Integer>) params.get("ids");
        String remark = (String) params.get("remark");
        
        if (ids == null || ids.isEmpty()) {
            return AjaxResult.error("请选择要取消的捐赠申请");
        }
        
        for (Integer id : ids) {
            DonationApplication application = donationApplicationService.selectDonationApplicationByDonationId(id.longValue());
            if (application != null && application.getDonationStatus() == 0) {
                application.setDonationStatus(2); // 已取消
                // 如果需要存储取消备注，可以添加字段，这里暂时不处理
                donationApplicationService.updateDonationApplication(application);
            }
        }
        
        return AjaxResult.success("批量取消成功");
    }
}
