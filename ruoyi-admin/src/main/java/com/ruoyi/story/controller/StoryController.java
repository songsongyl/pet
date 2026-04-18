package com.ruoyi.story.controller;

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
import com.ruoyi.story.domain.Story;
import com.ruoyi.story.service.IStoryService;
import com.ruoyi.story.service.IStoryCommentService;
import com.ruoyi.story.domain.StoryComment;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 故事会Controller
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@RestController
@RequestMapping("/story")
public class StoryController extends BaseController
{
    @Autowired
    private IStoryService storyService;

    @Autowired
    private IStoryCommentService storyCommentService;

    /**
     * 查询故事会列表
     */
    @PreAuthorize("@ss.hasPermi('story:story:list')")
    @GetMapping("/list")
    public TableDataInfo list(Story story)
    {
        startPage();
        List<Story> list = storyService.selectStoryList(story);
        return getDataTable(list);
    }

    /**
     * 导出故事会列表
     */
    @PreAuthorize("@ss.hasPermi('story:story:export')")
    @Log(title = "故事会", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Story story)
    {
        List<Story> list = storyService.selectStoryList(story);
        ExcelUtil<Story> util = new ExcelUtil<Story>(Story.class);
        util.exportExcel(response, list, "故事会数据");
    }

    /**
     * 获取故事会详细信息
     */
    @PreAuthorize("@ss.hasPermi('story:story:query')")
    @GetMapping(value = "/{storyId}")
    public AjaxResult getInfo(@PathVariable("storyId") Long storyId)
    {
        return AjaxResult.success(storyService.selectStoryByStoryId(storyId));
    }

    /**
     * 新增故事会
     */
    @PreAuthorize("@ss.hasPermi('story:story:add')")
    @Log(title = "故事会", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Story story)
    {
        return toAjax(storyService.insertStory(story));
    }

    /**
     * 修改故事会
     */
    @PreAuthorize("@ss.hasPermi('story:story:edit')")
    @Log(title = "故事会", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Story story)
    {
        return toAjax(storyService.updateStory(story));
    }

    /**
     * 删除故事会
     */
    @PreAuthorize("@ss.hasPermi('story:story:remove')")
    @Log(title = "故事会", businessType = BusinessType.DELETE)
	@DeleteMapping("/{storyIds}")
    public AjaxResult remove(@PathVariable Long[] storyIds)
    {
        return toAjax(storyService.deleteStoryByStoryIds(storyIds));
    }

    /**
     * 发布故事
     */
    @PostMapping("/publish")
    public AjaxResult publish(@RequestBody Story story)
    {
        story.setStatus(1); // 已发布
        story.setAuthorId(getUserId());
        return toAjax(storyService.insertStory(story));
    }

    /**
     * 点赞故事
     */
    @PostMapping("/{storyId}/like")
    public AjaxResult like(@PathVariable String storyId)
    {
        if (storyId == null || storyId.trim().isEmpty() || "undefined".equals(storyId)) {
            return AjaxResult.error("故事ID不能为空");
        }
        try {
            Long id = Long.parseLong(storyId);
            Story story = storyService.selectStoryByStoryId(id);
            if (story == null) {
                return AjaxResult.error("故事不存在");
            }
            story.setLikeCount(story.getLikeCount() + 1);
            return toAjax(storyService.updateStory(story));
        } catch (NumberFormatException e) {
            return AjaxResult.error("故事ID必须为数字");
        }
    }

    /**
     * 评论故事
     */
    @PostMapping("/{storyId}/comment")
    public AjaxResult comment(@PathVariable String storyId, @RequestBody Map<String, Object> commentData)
    {
        if (storyId == null || storyId.trim().isEmpty() || "undefined".equals(storyId)) {
            return AjaxResult.error("故事ID不能为空");
        }
        try {
            Long id = Long.parseLong(storyId);
            String content = (String) commentData.get("content");
            if (content == null || content.trim().isEmpty()) {
                return AjaxResult.error("评论内容不能为空");
            }
            
            StoryComment storyComment = new StoryComment();
            storyComment.setStoryId(id);
            storyComment.setContent(content);
            storyComment.setAuthorId(getUserId());
            // 这里可以根据用户ID获取用户名，暂时设为空
            storyComment.setAuthor("");
            storyComment.setIsDeleted(0);
            
            int result = storyCommentService.insertStoryComment(storyComment);
            if (result > 0) {
                return AjaxResult.success("评论成功");
            } else {
                return AjaxResult.error("评论失败");
            }
        } catch (NumberFormatException e) {
            return AjaxResult.error("故事ID必须为数字");
        }
    }

    /**
     * 获取故事评论列表
     */
    @GetMapping("/{storyId}/comments")
    public AjaxResult getComments(@PathVariable String storyId)
    {
        if (storyId == null || storyId.trim().isEmpty() || "undefined".equals(storyId)) {
            return AjaxResult.error("故事ID不能为空");
        }
        try {
            Long id = Long.parseLong(storyId);
            StoryComment storyComment = new StoryComment();
            storyComment.setStoryId(id);
            List<StoryComment> comments = storyCommentService.selectStoryCommentList(storyComment);
            return AjaxResult.success(comments);
        } catch (NumberFormatException e) {
            return AjaxResult.error("故事ID必须为数字");
        }
    }
}
