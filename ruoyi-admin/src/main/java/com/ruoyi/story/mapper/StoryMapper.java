package com.ruoyi.story.mapper;

import java.util.List;
import com.ruoyi.story.domain.Story;

/**
 * 故事会Mapper接口
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public interface StoryMapper
{
    /**
     * 查询故事会
     *
     * @param storyId 故事会主键
     * @return 故事会
     */
    public Story selectStoryByStoryId(Long storyId);

    /**
     * 查询故事会列表
     *
     * @param story 故事会
     * @return 故事会集合
     */
    public List<Story> selectStoryList(Story story);

    /**
     * 新增故事会
     *
     * @param story 故事会
     * @return 结果
     */
    public int insertStory(Story story);

    /**
     * 修改故事会
     *
     * @param story 故事会
     * @return 结果
     */
    public int updateStory(Story story);

    /**
     * 删除故事会
     *
     * @param storyId 故事会主键
     * @return 结果
     */
    public int deleteStoryByStoryId(Long storyId);

    /**
     * 批量删除故事会
     *
     * @param storyIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStoryByStoryIds(Long[] storyIds);
}
