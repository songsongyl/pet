package com.ruoyi.community.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.community.mapper.CommunityPostMapper;
import com.ruoyi.community.domain.CommunityPost;
import com.ruoyi.community.service.ICommunityPostService;

/**
 * 社区帖子Service业务层处理
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@Service
public class CommunityPostServiceImpl implements ICommunityPostService
{
    @Autowired
    private CommunityPostMapper communityPostMapper;

    /**
     * 查询社区帖子
     *
     * @param postId 社区帖子主键
     * @return 社区帖子
     */
    @Override
    public CommunityPost selectCommunityPostByPostId(Long postId)
    {
        return communityPostMapper.selectCommunityPostByPostId(postId);
    }

    /**
     * 查询社区帖子列表
     *
     * @param communityPost 社区帖子
     * @return 社区帖子
     */
    @Override
    public List<CommunityPost> selectCommunityPostList(CommunityPost communityPost)
    {
        return communityPostMapper.selectCommunityPostList(communityPost);
    }

    /**
     * 新增社区帖子
     *
     * @param communityPost 社区帖子
     * @return 结果
     */
    @Override
    public int insertCommunityPost(CommunityPost communityPost)
    {
        return communityPostMapper.insertCommunityPost(communityPost);
    }

    /**
     * 修改社区帖子
     *
     * @param communityPost 社区帖子
     * @return 结果
     */
    @Override
    public int updateCommunityPost(CommunityPost communityPost)
    {
        return communityPostMapper.updateCommunityPost(communityPost);
    }

    /**
     * 批量删除社区帖子
     *
     * @param postIds 需要删除的社区帖子主键
     * @return 结果
     */
    @Override
    public int deleteCommunityPostByPostIds(Long[] postIds)
    {
        return communityPostMapper.deleteCommunityPostByPostIds(postIds);
    }

    /**
     * 删除社区帖子信息
     *
     * @param postId 社区帖子主键
     * @return 结果
     */
    @Override
    public int deleteCommunityPostByPostId(Long postId)
    {
        return communityPostMapper.deleteCommunityPostByPostId(postId);
    }
}
