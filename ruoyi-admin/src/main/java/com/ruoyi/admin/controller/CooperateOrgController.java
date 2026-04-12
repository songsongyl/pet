package com.ruoyi.admin.controller;

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
import com.ruoyi.admin.domain.CooperateOrg;
import com.ruoyi.admin.service.ICooperateOrgService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 合作机构Controller
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@RestController
@RequestMapping("/admin/organization")
public class CooperateOrgController extends BaseController
{
    @Autowired
    private ICooperateOrgService cooperateOrgService;

    /**
     * 查询合作机构列表
     */
    @PreAuthorize("@ss.hasPermi('admin:organization:list')")
    @GetMapping("/list")
    public TableDataInfo list(CooperateOrg cooperateOrg)
    {
        startPage();
        List<CooperateOrg> list = cooperateOrgService.selectCooperateOrgList(cooperateOrg);
        return getDataTable(list);
    }

    /**
     * 导出合作机构列表
     */
    @PreAuthorize("@ss.hasPermi('admin:organization:export')")
    @Log(title = "合作机构", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CooperateOrg cooperateOrg)
    {
        List<CooperateOrg> list = cooperateOrgService.selectCooperateOrgList(cooperateOrg);
        ExcelUtil<CooperateOrg> util = new ExcelUtil<CooperateOrg>(CooperateOrg.class);
        util.exportExcel(response, list, "合作机构数据");
    }

    /**
     * 获取合作机构详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:organization:query')")
    @GetMapping(value = "/{orgId}")
    public AjaxResult getInfo(@PathVariable("orgId") Long orgId)
    {
        return AjaxResult.success(cooperateOrgService.selectCooperateOrgByOrgId(orgId));
    }

    /**
     * 新增合作机构
     */
    @PreAuthorize("@ss.hasPermi('admin:organization:add')")
    @Log(title = "合作机构", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CooperateOrg cooperateOrg)
    {
        return toAjax(cooperateOrgService.insertCooperateOrg(cooperateOrg));
    }

    /**
     * 修改合作机构
     */
    @PreAuthorize("@ss.hasPermi('admin:organization:edit')")
    @Log(title = "合作机构", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CooperateOrg cooperateOrg)
    {
        return toAjax(cooperateOrgService.updateCooperateOrg(cooperateOrg));
    }

    /**
     * 删除合作机构
     */
    @PreAuthorize("@ss.hasPermi('admin:organization:remove')")
    @Log(title = "合作机构", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orgIds}")
    public AjaxResult remove(@PathVariable Long[] orgIds)
    {
        return toAjax(cooperateOrgService.deleteCooperateOrgByOrgIds(orgIds));
    }

    /**
     * 审批合作机构
     */
    @PutMapping("/{orgId}/approve")
    public AjaxResult approve(@PathVariable Long orgId, @RequestBody CooperateOrg cooperateOrg)
    {
        CooperateOrg org = cooperateOrgService.selectCooperateOrgByOrgId(orgId);
        if (org == null) {
            return AjaxResult.error("合作机构不存在");
        }
        org.setStatus(cooperateOrg.getStatus());
        org.setAuditUserId(getUserId());
        return toAjax(cooperateOrgService.updateCooperateOrg(org));
    }

    /**
     * 获取合作机构统计数据
     */
    @GetMapping("/stats")
    public AjaxResult getStats()
    {
        return AjaxResult.success(cooperateOrgService.getCooperateOrgStats());
    }
}
