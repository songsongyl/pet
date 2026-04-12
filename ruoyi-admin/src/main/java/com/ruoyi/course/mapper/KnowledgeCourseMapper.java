package com.ruoyi.course.mapper;

import java.util.List;
import com.ruoyi.course.domain.KnowledgeCourse;

/**
 * 知识课堂Mapper接口
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
public interface KnowledgeCourseMapper 
{
    /**
     * 查询知识课堂
     * 
     * @param courseId 知识课堂主键
     * @return 知识课堂
     */
    public KnowledgeCourse selectKnowledgeCourseByCourseId(Long courseId);

    /**
     * 查询知识课堂列表
     * 
     * @param knowledgeCourse 知识课堂
     * @return 知识课堂集合
     */
    public List<KnowledgeCourse> selectKnowledgeCourseList(KnowledgeCourse knowledgeCourse);

    /**
     * 新增知识课堂
     * 
     * @param knowledgeCourse 知识课堂
     * @return 结果
     */
    public int insertKnowledgeCourse(KnowledgeCourse knowledgeCourse);

    /**
     * 修改知识课堂
     * 
     * @param knowledgeCourse 知识课堂
     * @return 结果
     */
    public int updateKnowledgeCourse(KnowledgeCourse knowledgeCourse);

    /**
     * 删除知识课堂
     * 
     * @param courseId 知识课堂主键
     * @return 结果
     */
    public int deleteKnowledgeCourseByCourseId(Long courseId);

    /**
     * 批量删除知识课堂
     * 
     * @param courseIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteKnowledgeCourseByCourseIds(Long[] courseIds);
}
