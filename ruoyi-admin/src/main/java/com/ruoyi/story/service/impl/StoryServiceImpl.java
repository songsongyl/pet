package com.ruoyi.story.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.story.mapper.StoryMapper;
import com.ruoyi.story.domain.Story;
import com.ruoyi.story.service.IStoryService;

/**
 * 故事会Service业务层处理
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@Service
public class StoryServiceImpl implements IStoryService
{
    @Autowired
    private StoryMapper storyMapper;

    /**
     * 查询故事会
     *
     * @param storyId 故事会主键
     * @return 故事会
     */
    @Override
    public Story selectStoryByStoryId(Long storyId)
    {
        return storyMapper.selectStoryByStoryId(storyId);
    }

    /**
     * 查询故事会列表
     *
     * @param story 故事会
     * @return 故事会
     */
    @Override
    public List<Story> selectStoryList(Story story)
    {
        return storyMapper.selectStoryList(story);
    }

    /**
     * 新增故事会
     *
     * @param story 故事会
     * @return 结果
     */
    @Override
    public int insertStory(Story story)
    {
        return storyMapper.insertStory(story);
    }

    /**
     * 修改故事会
     *
     * @param story 故事会
     * @return 结果
     */
    @Override
    public int updateStory(Story story)
    {
        return storyMapper.updateStory(story);
    }

    /**
     * 批量删除故事会
     *
     * @param storyIds 需要删除的故事会主键
     * @return 结果
     */
    @Override
    public int deleteStoryByStoryIds(Long[] storyIds)
    {
        return storyMapper.deleteStoryByStoryIds(storyIds);
    }

    /**
     * 删除故事会信息
     *
     * @param storyId 故事会主键
     * @return 结果
     */
    @Override
    public int deleteStoryByStoryId(Long storyId)
    {
        return storyMapper.deleteStoryByStoryId(storyId);
    }
}
