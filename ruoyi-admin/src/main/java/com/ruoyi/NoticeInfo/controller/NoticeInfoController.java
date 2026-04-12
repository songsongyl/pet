package com.ruoyi.NoticeInfo.controller;

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
import com.ruoyi.NoticeInfo.domain.NoticeInfo;
import com.ruoyi.NoticeInfo.service.INoticeInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 公告信息Controller
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
@RestController
@RequestMapping("/NoticeInfo/NoticeInfo")
public class NoticeInfoController extends BaseController
{
    @Autowired
    private INoticeInfoService noticeInfoService;

    /**
     * 查询公告信息列表
     */
    @PreAuthorize("@ss.hasPermi('NoticeInfo:NoticeInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(NoticeInfo noticeInfo)
    {
        startPage();
        List<NoticeInfo> list = noticeInfoService.selectNoticeInfoList(noticeInfo);
        return getDataTable(list);
    }

    /**
     * 导出公告信息列表
     */
    @PreAuthorize("@ss.hasPermi('NoticeInfo:NoticeInfo:export')")
    @Log(title = "公告信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, NoticeInfo noticeInfo)
    {
        List<NoticeInfo> list = noticeInfoService.selectNoticeInfoList(noticeInfo);
        ExcelUtil<NoticeInfo> util = new ExcelUtil<NoticeInfo>(NoticeInfo.class);
        util.exportExcel(response, list, "公告信息数据");
    }

    /**
     * 获取公告信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('NoticeInfo:NoticeInfo:query')")
    @GetMapping(value = "/{noticeId}")
    public AjaxResult getInfo(@PathVariable("noticeId") Long noticeId)
    {
        return success(noticeInfoService.selectNoticeInfoByNoticeId(noticeId));
    }

    /**
     * 新增公告信息
     */
    @PreAuthorize("@ss.hasPermi('NoticeInfo:NoticeInfo:add')")
    @Log(title = "公告信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody NoticeInfo noticeInfo)
    {
        return toAjax(noticeInfoService.insertNoticeInfo(noticeInfo));
    }

    /**
     * 修改公告信息
     */
    @PreAuthorize("@ss.hasPermi('NoticeInfo:NoticeInfo:edit')")
    @Log(title = "公告信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody NoticeInfo noticeInfo)
    {
        return toAjax(noticeInfoService.updateNoticeInfo(noticeInfo));
    }

    /**
     * 删除公告信息
     */
    @PreAuthorize("@ss.hasPermi('NoticeInfo:NoticeInfo:remove')")
    @Log(title = "公告信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{noticeIds}")
    public AjaxResult remove(@PathVariable Long[] noticeIds)
    {
        return toAjax(noticeInfoService.deleteNoticeInfoByNoticeIds(noticeIds));
    }
}
