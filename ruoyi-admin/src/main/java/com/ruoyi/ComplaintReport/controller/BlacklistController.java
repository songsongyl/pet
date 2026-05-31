package com.ruoyi.ComplaintReport.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.ruoyi.ComplaintReport.domain.Blacklist;
import com.ruoyi.ComplaintReport.service.IBlacklistService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 黑名单Controller
 *
 * @author songyilin
 * @date 2025-05-29
 */
@RestController
@RequestMapping("/ComplaintReport/blacklist")
public class BlacklistController extends BaseController
{
    @Autowired
    private IBlacklistService blacklistService;

    /**
     * 查询黑名单列表
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:blacklist:list')")
    @GetMapping("/list")
    public TableDataInfo list(Blacklist blacklist)
    {
        startPage();
        List<Blacklist> list = blacklistService.selectBlacklistList(blacklist);
        return getDataTable(list);
    }

    /**
     * 导出黑名单列表
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:blacklist:export')")
    @Log(title = "黑名单", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Blacklist blacklist)
    {
        List<Blacklist> list = blacklistService.selectBlacklistList(blacklist);
        ExcelUtil<Blacklist> util = new ExcelUtil<Blacklist>(Blacklist.class);
        util.exportExcel(response, list, "黑名单数据");
    }

    /**
     * 获取黑名单详细信息
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:blacklist:query')")
    @GetMapping(value = "/{blacklistId}")
    public AjaxResult getInfo(@PathVariable("blacklistId") Long blacklistId)
    {
        return success(blacklistService.selectBlacklistByBlacklistId(blacklistId));
    }

    /**
     * 新增黑名单
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:blacklist:add')")
    @Log(title = "黑名单", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Blacklist blacklist)
    {
        // 检查用户是否已在黑名单中
        Blacklist existing = blacklistService.selectBlacklistByUserId(blacklist.getUserId());
        if (existing != null)
        {
            return error("该用户已在黑名单中");
        }
        return toAjax(blacklistService.insertBlacklist(blacklist));
    }

    /**
     * 修改黑名单
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:blacklist:edit')")
    @Log(title = "黑名单", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Blacklist blacklist)
    {
        return toAjax(blacklistService.updateBlacklist(blacklist));
    }

    /**
     * 删除黑名单
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:blacklist:remove')")
    @Log(title = "黑名单", businessType = BusinessType.DELETE)
    @DeleteMapping("/{blacklistIds}")
    public AjaxResult remove(@PathVariable Long[] blacklistIds)
    {
        return toAjax(blacklistService.deleteBlacklistByBlacklistIds(blacklistIds));
    }

    /**
     * 批量解封用户
     */
    @PreAuthorize("@ss.hasPermi('ComplaintReport:blacklist:unblock')")
    @Log(title = "黑名单", businessType = BusinessType.UPDATE)
    @PutMapping("/unblock/{blacklistIds}")
    public AjaxResult unblock(@PathVariable Long[] blacklistIds)
    {
        return toAjax(blacklistService.unblockBlacklistByBlacklistIds(blacklistIds));
    }

    /**
     * 检查用户是否在黑名单中
     */
    @GetMapping("/check/{userId}")
    public AjaxResult checkUserInBlacklist(@PathVariable("userId") Long userId)
    {
        Blacklist blacklist = blacklistService.selectBlacklistByUserId(userId);
        return success(blacklist != null);
    }
}
