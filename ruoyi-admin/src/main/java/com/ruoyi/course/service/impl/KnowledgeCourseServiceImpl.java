package com.ruoyi.course.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.course.mapper.KnowledgeCourseMapper;
import com.ruoyi.course.domain.KnowledgeCourse;
import com.ruoyi.course.service.IKnowledgeCourseService;

/**
 * 知识课堂Service业务层处理
 * 
 * @author ruoyi
 * @date 2025-12-20
 */
@Service
public class KnowledgeCourseServiceImpl implements IKnowledgeCourseService 
{
    @Autowired
    private KnowledgeCourseMapper knowledgeCourseMapper;

    /**
     * 查询知识课堂
     * 
     * @param courseId 知识课堂主键
     * @return 知识课堂
     */
    @Override
    public KnowledgeCourse selectKnowledgeCourseByCourseId(Long courseId)
    {
        return knowledgeCourseMapper.selectKnowledgeCourseByCourseId(courseId);
    }

    /**
     * 查询知识课堂列表
     * 
     * @param knowledgeCourse 知识课堂
     * @return 知识课堂
     */
    @Override
    public List<KnowledgeCourse> selectKnowledgeCourseList(KnowledgeCourse knowledgeCourse)
    {
        return knowledgeCourseMapper.selectKnowledgeCourseList(knowledgeCourse);
    }

    /**
     * 新增知识课堂
     * 
     * @param knowledgeCourse 知识课堂
     * @return 结果
     */
    @Override
    public int insertKnowledgeCourse(KnowledgeCourse knowledgeCourse)
    {
        knowledgeCourse.setCreateTime(DateUtils.getNowDate());
        return knowledgeCourseMapper.insertKnowledgeCourse(knowledgeCourse);
    }

    /**
     * 修改知识课堂
     * 
     * @param knowledgeCourse 知识课堂
     * @return 结果
     */
    @Override
    public int updateKnowledgeCourse(KnowledgeCourse knowledgeCourse)
    {
        knowledgeCourse.setUpdateTime(DateUtils.getNowDate());
        return knowledgeCourseMapper.updateKnowledgeCourse(knowledgeCourse);
    }

    /**
     * 批量删除知识课堂
     * 
     * @param courseIds 需要删除的知识课堂主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeCourseByCourseIds(Long[] courseIds)
    {
        return knowledgeCourseMapper.deleteKnowledgeCourseByCourseIds(courseIds);
    }

    /**
     * 删除知识课堂信息
     * 
     * @param courseId 知识课堂主键
     * @return 结果
     */
    @Override
    public int deleteKnowledgeCourseByCourseId(Long courseId)
    {
        return knowledgeCourseMapper.deleteKnowledgeCourseByCourseId(courseId);
    }
}
