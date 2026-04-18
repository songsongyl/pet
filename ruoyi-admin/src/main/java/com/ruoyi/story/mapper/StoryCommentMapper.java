package com.ruoyi.story.mapper;

import java.util.List;
import com.ruoyi.story.domain.StoryComment;

/**
 * 故事评论Mapper接口
 *
 * @author ruoyi
 * @date 2026-04-18
 */
public interface StoryCommentMapper
{
    /**
     * 查询故事评论列表
     *
     * @param storyComment 故事评论
     * @return 故事评论集合
     */
    public List<StoryComment> selectStoryCommentList(StoryComment storyComment);

    /**
     * 新增故事评论
     *
     * @param storyComment 故事评论
     * @return 结果
     */
    public int insertStoryComment(StoryComment storyComment);
}
