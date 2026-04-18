package com.ruoyi.story.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 故事评论对象 story_comment
 *
 * @author ruoyi
 * @date 2026-04-18
 */
public class StoryComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 评论ID（主键） */
    private Long commentId;

    /** 关联故事ID（story.story_id） */
    @Excel(name = "关联故事ID")
    private Long storyId;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 评论作者 */
    @Excel(name = "评论作者")
    private String author;

    /** 评论作者ID（sys_user.user_id） */
    @Excel(name = "评论作者ID")
    private Long authorId;

    /** 评论时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "评论时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /** 更新时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "更新时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /** 逻辑删除：0-正常，1-删除 */
    @Excel(name = "逻辑删除")
    private Integer isDeleted;

    public void setCommentId(Long commentId)
    {
        this.commentId = commentId;
    }

    public Long getCommentId()
    {
        return commentId;
    }
    public void setStoryId(Long storyId)
    {
        this.storyId = storyId;
    }

    public Long getStoryId()
    {
        return storyId;
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
    public void setCreateTime(Date createTime)
    {
        this.createTime = createTime;
    }

    public Date getCreateTime()
    {
        return createTime;
    }
    public void setUpdateTime(Date updateTime)
    {
        this.updateTime = updateTime;
    }

    public Date getUpdateTime()
    {
        return updateTime;
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
            .append("commentId", getCommentId())
            .append("storyId", getStoryId())
            .append("content", getContent())
            .append("author", getAuthor())
            .append("authorId", getAuthorId())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("isDeleted", getIsDeleted())
            .toString();
    }
}
