package com.ruoyi.story.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.story.mapper.StoryCommentMapper;
import com.ruoyi.story.domain.StoryComment;
import com.ruoyi.story.service.IStoryCommentService;

/**
 * 故事评论Service业务层处理
 *
 * @author ruoyi
 * @date 2026-04-18
 */
@Service
public class StoryCommentServiceImpl implements IStoryCommentService
{
    @Autowired
    private StoryCommentMapper storyCommentMapper;

    /**
     * 查询故事评论列表
     *
     * @param storyComment 故事评论
     * @return 故事评论
     */
    @Override
    public List<StoryComment> selectStoryCommentList(StoryComment storyComment)
    {
        return storyCommentMapper.selectStoryCommentList(storyComment);
    }

    /**
     * 新增故事评论
     *
     * @param storyComment 故事评论
     * @return 结果
     */
    @Override
    public int insertStoryComment(StoryComment storyComment)
    {
        return storyCommentMapper.insertStoryComment(storyComment);
    }
}
