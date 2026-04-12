package com.ruoyi.community.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社区帖子对象 community_post
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public class CommunityPost extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 帖子ID（主键） */
    private Long postId;

    /** 帖子标题 */
    @Excel(name = "帖子标题")
    private String title;

    /** 帖子分类：experience-经验分享，help-求助，fun-娱乐，other-其他 */
    @Excel(name = "帖子分类")
    private String category;

    /** 帖子内容 */
    @Excel(name = "帖子内容")
    private String content;

    /** 作者 */
    @Excel(name = "作者")
    private String author;

    /** 作者ID（sys_user.user_id） */
    @Excel(name = "作者ID")
    private Long authorId;

    /** 点赞数 */
    @Excel(name = "点赞数")
    private Long likeCount;

    /** 评论数 */
    @Excel(name = "评论数")
    private Long commentCount;

    /** 收藏数 */
    @Excel(name = "收藏数")
    private Long collectCount;

    /** 浏览数 */
    @Excel(name = "浏览数")
    private Long viewCount;

    /** 状态：0-草稿，1-已发布，2-已删除 */
    @Excel(name = "状态", readConverterExp = "0=草稿,1=已发布,2=已删除")
    private Integer status;

    /** 逻辑删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setPostId(Long postId)
    {
        this.postId = postId;
    }

    public Long getPostId()
    {
        return postId;
    }
    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getTitle()
    {
        return title;
    }
    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getCategory()
    {
        return category;
    }
    public void setContent(String content)
    {
        this.content = content;
    }

    public String getContent()
    {
        return content;
    }
    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String getAuthor()
    {
        return author;
    }
    public void setAuthorId(Long authorId)
    {
        this.authorId = authorId;
    }

    public Long getAuthorId()
    {
        return authorId;
    }
    public void setLikeCount(Long likeCount)
    {
        this.likeCount = likeCount;
    }

    public Long getLikeCount()
    {
        return likeCount;
    }
    public void setCommentCount(Long commentCount)
    {
        this.commentCount = commentCount;
    }

    public Long getCommentCount()
    {
        return commentCount;
    }
    public void setCollectCount(Long collectCount)
    {
        this.collectCount = collectCount;
    }

    public Long getCollectCount()
    {
        return collectCount;
    }
    public void setViewCount(Long viewCount)
    {
        this.viewCount = viewCount;
    }

    public Long getViewCount()
    {
        return viewCount;
    }
    public void setStatus(Integer status)
    {
        this.status = status;
    }

    public Integer getStatus()
    {
        return status;
    }
    public void setIsDeleted(Integer isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public Integer getIsDeleted()
    {
        return isDeleted;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("title", getTitle())
            .append("category", getCategory())
            .append("content", getContent())
            .append("author", getAuthor())
            .append("authorId", getAuthorId())
            .append("likeCount", getLikeCount())
            .append("commentCount", getCommentCount())
            .append("collectCount", getCollectCount())
            .append("viewCount", getViewCount())
            .append("status", getStatus())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
