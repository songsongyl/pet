package com.ruoyi.course.controller;

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
import com.ruoyi.course.domain.KnowledgeCourse;
import com.ruoyi.course.service.IKnowledgeCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 知识课堂Controller
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
@RestController
@RequestMapping("/course/course")
public class KnowledgeCourseController extends BaseController
{
    @Autowired
    private IKnowledgeCourseService knowledgeCourseService;

    /**
     * 查询知识课堂列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(KnowledgeCourse knowledgeCourse)
    {
        startPage();
        List<KnowledgeCourse> list = knowledgeCourseService.selectKnowledgeCourseList(knowledgeCourse);
        return getDataTable(list);
    }

    /**
     * 导出知识课堂列表
     */
    @PreAuthorize("@ss.hasPermi('course:course:export')")
    @Log(title = "知识课堂", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, KnowledgeCourse knowledgeCourse)
    {
        List<KnowledgeCourse> list = knowledgeCourseService.selectKnowledgeCourseList(knowledgeCourse);
        ExcelUtil<KnowledgeCourse> util = new ExcelUtil<KnowledgeCourse>(KnowledgeCourse.class);
        util.exportExcel(response, list, "知识课堂数据");
    }

    /**
     * 获取知识课堂详细信息
     */
    @PreAuthorize("@ss.hasPermi('course:course:query')")
    @GetMapping(value = "/{courseId}")
    public AjaxResult getInfo(@PathVariable("courseId") Long courseId)
    {
        return success(knowledgeCourseService.selectKnowledgeCourseByCourseId(courseId));
    }

    /**
     * 新增知识课堂
     */
    @PreAuthorize("@ss.hasPermi('course:course:add')")
    @Log(title = "知识课堂", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KnowledgeCourse knowledgeCourse)
    {
        return toAjax(knowledgeCourseService.insertKnowledgeCourse(knowledgeCourse));
    }

    /**
     * 修改知识课堂
     */
    @PreAuthorize("@ss.hasPermi('course:course:edit')")
    @Log(title = "知识课堂", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KnowledgeCourse knowledgeCourse)
    {
        return toAjax(knowledgeCourseService.updateKnowledgeCourse(knowledgeCourse));
    }

    /**
     * 删除知识课堂
     */
    @PreAuthorize("@ss.hasPermi('course:course:remove')")
    @Log(title = "知识课堂", businessType = BusinessType.DELETE)
	@DeleteMapping("/{courseIds}")
    public AjaxResult remove(@PathVariable Long[] courseIds)
    {
        return toAjax(knowledgeCourseService.deleteKnowledgeCourseByCourseIds(courseIds));
    }
}
