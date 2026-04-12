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
import com.ruoyi.admin.domain.Volunteer;
import com.ruoyi.admin.service.IVolunteerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 志愿者Controller
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@RestController
@RequestMapping("/admin/volunteer")
public class VolunteerController extends BaseController
{
    @Autowired
    private IVolunteerService volunteerService;

    /**
     * 查询志愿者列表
     */
    @PreAuthorize("@ss.hasPermi('admin:volunteer:list')")
    @GetMapping("/list")
    public TableDataInfo list(Volunteer volunteer)
    {
        startPage();
        List<Volunteer> list = volunteerService.selectVolunteerList(volunteer);
        return getDataTable(list);
    }

    /**
     * 导出志愿者列表
     */
    @PreAuthorize("@ss.hasPermi('admin:volunteer:export')")
    @Log(title = "志愿者", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Volunteer volunteer)
    {
        List<Volunteer> list = volunteerService.selectVolunteerList(volunteer);
        ExcelUtil<Volunteer> util = new ExcelUtil<Volunteer>(Volunteer.class);
        util.exportExcel(response, list, "志愿者数据");
    }

    /**
     * 获取志愿者详细信息
     */
    @PreAuthorize("@ss.hasPermi('admin:volunteer:query')")
    @GetMapping(value = "/{volunteerId}")
    public AjaxResult getInfo(@PathVariable("volunteerId") Long volunteerId)
    {
        return AjaxResult.success(volunteerService.selectVolunteerByVolunteerId(volunteerId));
    }

    /**
     * 新增志愿者
     */
    @PreAuthorize("@ss.hasPermi('admin:volunteer:add')")
    @Log(title = "志愿者", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Volunteer volunteer)
    {
        return toAjax(volunteerService.insertVolunteer(volunteer));
    }

    /**
     * 修改志愿者
     */
    @PreAuthorize("@ss.hasPermi('admin:volunteer:edit')")
    @Log(title = "志愿者", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Volunteer volunteer)
    {
        return toAjax(volunteerService.updateVolunteer(volunteer));
    }

    /**
     * 删除志愿者
     */
    @PreAuthorize("@ss.hasPermi('admin:volunteer:remove')")
    @Log(title = "志愿者", businessType = BusinessType.DELETE)
	@DeleteMapping("/{volunteerIds}")
    public AjaxResult remove(@PathVariable Long[] volunteerIds)
    {
        return toAjax(volunteerService.deleteVolunteerByVolunteerIds(volunteerIds));
    }

    /**
     * 审批志愿者
     */
    @PutMapping("/{volunteerId}/approve")
    public AjaxResult approve(@PathVariable Long volunteerId, @RequestBody Volunteer volunteer)
    {
        Volunteer vol = volunteerService.selectVolunteerByVolunteerId(volunteerId);
        if (vol == null) {
            return AjaxResult.error("志愿者不存在");
        }
        vol.setStatus(volunteer.getStatus());
        vol.setAuditUserId(getUserId());
        vol.setAuditComments(volunteer.getAuditComments());
        return toAjax(volunteerService.updateVolunteer(vol));
    }

    /**
     * 获取志愿者统计数据
     */
    @GetMapping("/stats")
    public AjaxResult getStats()
    {
        return AjaxResult.success(volunteerService.getVolunteerStats());
    }
}
