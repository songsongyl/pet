package com.ruoyi.community.controller;

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
import com.ruoyi.community.domain.CommunityPost;
import com.ruoyi.community.service.ICommunityPostService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 社区帖子Controller
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@RestController
@RequestMapping("/community/post")
public class CommunityPostController extends BaseController
{
    @Autowired
    private ICommunityPostService communityPostService;

    /**
     * 查询社区帖子列表
     */
    @PreAuthorize("@ss.hasPermi('community:post:list')")
    @GetMapping("/list")
    public TableDataInfo list(CommunityPost communityPost)
    {
        startPage();
        List<CommunityPost> list = communityPostService.selectCommunityPostList(communityPost);
        return getDataTable(list);
    }

    /**
     * 导出社区帖子列表
     */
    @PreAuthorize("@ss.hasPermi('community:post:export')")
    @Log(title = "社区帖子", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, CommunityPost communityPost)
    {
        List<CommunityPost> list = communityPostService.selectCommunityPostList(communityPost);
        ExcelUtil<CommunityPost> util = new ExcelUtil<CommunityPost>(CommunityPost.class);
        util.exportExcel(response, list, "社区帖子数据");
    }

    /**
     * 获取社区帖子详细信息
     */
    @PreAuthorize("@ss.hasPermi('community:post:query')")
    @GetMapping(value = "/{postId}")
    public AjaxResult getInfo(@PathVariable("postId") Long postId)
    {
        return AjaxResult.success(communityPostService.selectCommunityPostByPostId(postId));
    }

    /**
     * 新增社区帖子
     */
    @PreAuthorize("@ss.hasPermi('community:post:add')")
    @Log(title = "社区帖子", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody CommunityPost communityPost)
    {
        return toAjax(communityPostService.insertCommunityPost(communityPost));
    }

    /**
     * 修改社区帖子
     */
    @PreAuthorize("@ss.hasPermi('community:post:edit')")
    @Log(title = "社区帖子", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody CommunityPost communityPost)
    {
        return toAjax(communityPostService.updateCommunityPost(communityPost));
    }

    /**
     * 删除社区帖子
     */
    @PreAuthorize("@ss.hasPermi('community:post:remove')")
    @Log(title = "社区帖子", businessType = BusinessType.DELETE)
	@DeleteMapping("/{postIds}")
    public AjaxResult remove(@PathVariable Long[] postIds)
    {
        return toAjax(communityPostService.deleteCommunityPostByPostIds(postIds));
    }

    /**
     * 发布帖子
     */
    @PostMapping("/publish")
    public AjaxResult publish(@RequestBody CommunityPost communityPost)
    {
        communityPost.setStatus(1); // 已发布
        communityPost.setAuthorId(getUserId());
        return toAjax(communityPostService.insertCommunityPost(communityPost));
    }

    /**
     * 点赞帖子
     */
    @PostMapping("/{postId}/like")
    public AjaxResult like(@PathVariable Long postId)
    {
        CommunityPost post = communityPostService.selectCommunityPostByPostId(postId);
        if (post == null) {
            return AjaxResult.error("帖子不存在");
        }
        post.setLikeCount(post.getLikeCount() + 1);
        return toAjax(communityPostService.updateCommunityPost(post));
    }

    /**
     * 评论帖子
     */
    @PostMapping("/{postId}/comment")
    public AjaxResult comment(@PathVariable Long postId, @RequestBody CommunityPost communityPost)
    {
        // 这里应该调用评论服务，暂时返回成功
        return AjaxResult.success("评论成功");
    }

    /**
     * 获取帖子评论列表
     */
    @GetMapping("/{postId}/comments")
    public AjaxResult getComments(@PathVariable Long postId)
    {
        // 这里应该调用评论服务，暂时返回空列表
        return AjaxResult.success(new java.util.ArrayList<>());
    }

    /**
     * 收藏帖子
     */
    @PostMapping("/{postId}/collect")
    public AjaxResult collect(@PathVariable Long postId)
    {
        // 这里应该调用收藏服务，暂时返回成功
        return AjaxResult.success("收藏成功");
    }

    /**
     * 获取收藏列表
     */
    @GetMapping("/collection/list")
    public AjaxResult getCollectionList()
    {
        // 这里应该调用收藏服务，暂时返回空列表
        return AjaxResult.success(new java.util.ArrayList<>());
    }
}
