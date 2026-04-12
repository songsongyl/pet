package com.ruoyi.give.controller;

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
import com.ruoyi.give.domain.RescueInfo;
import com.ruoyi.give.service.IRescueInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 救助信息Controller
 * 
 * @author 宋依琳
 * @date 2025-12-20
 */
@RestController
@RequestMapping("/give/give")
public class RescueInfoController extends BaseController
{
    @Autowired
    private IRescueInfoService rescueInfoService;

    /**
     * 查询救助信息列表
     */
    @PreAuthorize("@ss.hasPermi('give:give:list')")
    @GetMapping("/list")
    public TableDataInfo list(RescueInfo rescueInfo)
    {
        startPage();
        List<RescueInfo> list = rescueInfoService.selectRescueInfoList(rescueInfo);
        return getDataTable(list);
    }

    /**
     * 导出救助信息列表
     */
    @PreAuthorize("@ss.hasPermi('give:give:export')")
    @Log(title = "救助信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RescueInfo rescueInfo)
    {
        List<RescueInfo> list = rescueInfoService.selectRescueInfoList(rescueInfo);
        ExcelUtil<RescueInfo> util = new ExcelUtil<RescueInfo>(RescueInfo.class);
        util.exportExcel(response, list, "救助信息数据");
    }

    /**
     * 获取救助信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('give:give:query')")
    @GetMapping(value = "/{rescueId}")
    public AjaxResult getInfo(@PathVariable("rescueId") Long rescueId)
    {
        return success(rescueInfoService.selectRescueInfoByRescueId(rescueId));
    }

    /**
     * 新增救助信息
     */
    @PreAuthorize("@ss.hasPermi('give:give:add')")
    @Log(title = "救助信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RescueInfo rescueInfo)
    {
        return toAjax(rescueInfoService.insertRescueInfo(rescueInfo));
    }

    /**
     * 修改救助信息
     */
    @PreAuthorize("@ss.hasPermi('give:give:edit')")
    @Log(title = "救助信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RescueInfo rescueInfo)
    {
        return toAjax(rescueInfoService.updateRescueInfo(rescueInfo));
    }

    /**
     * 删除救助信息
     */
    @PreAuthorize("@ss.hasPermi('give:give:remove')")
    @Log(title = "救助信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{rescueIds}")
    public AjaxResult remove(@PathVariable Long[] rescueIds)
    {
        return toAjax(rescueInfoService.deleteRescueInfoByRescueIds(rescueIds));
    }
}
