package com.ruoyi.community.mapper;

import java.util.List;
import com.ruoyi.community.domain.CommunityPost;

/**
 * 社区帖子Mapper接口
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public interface CommunityPostMapper
{
    /**
     * 查询社区帖子
     *
     * @param postId 社区帖子主键
     * @return 社区帖子
     */
    public CommunityPost selectCommunityPostByPostId(Long postId);

    /**
     * 查询社区帖子列表
     *
     * @param communityPost 社区帖子
     * @return 社区帖子集合
     */
    public List<CommunityPost> selectCommunityPostList(CommunityPost communityPost);

    /**
     * 新增社区帖子
     *
     * @param communityPost 社区帖子
     * @return 结果
     */
    public int insertCommunityPost(CommunityPost communityPost);

    /**
     * 修改社区帖子
     *
     * @param communityPost 社区帖子
     * @return 结果
     */
    public int updateCommunityPost(CommunityPost communityPost);

    /**
     * 删除社区帖子
     *
     * @param postId 社区帖子主键
     * @return 结果
     */
    public int deleteCommunityPostByPostId(Long postId);

    /**
     * 批量删除社区帖子
     *
     * @param postIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommunityPostByPostIds(Long[] postIds);
}
