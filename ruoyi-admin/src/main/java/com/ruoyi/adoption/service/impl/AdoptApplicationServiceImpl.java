package com.ruoyi.adoption.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.adoption.mapper.AdoptApplicationMapper;
import com.ruoyi.adoption.domain.AdoptApplication;
import com.ruoyi.adoption.service.IAdoptApplicationService;

/**
 * 领养申请Service业务层处理
 * 
 * @author ruoyi
 * @date 2026-04-04
 */
@Service
public class AdoptApplicationServiceImpl implements IAdoptApplicationService 
{
    @Autowired
    private AdoptApplicationMapper adoptApplicationMapper;

    /**
     * 查询领养申请
     * 
     * @param applicationId 领养申请主键
     * @return 领养申请
     */
    @Override
    public AdoptApplication selectAdoptApplicationByApplicationId(Long applicationId)
    {
        return adoptApplicationMapper.selectAdoptApplicationByApplicationId(applicationId);
    }

    /**
     * 查询领养申请列表
     * 
     * @param adoptApplication 领养申请
     * @return 领养申请
     */
    @Override
    public List<AdoptApplication> selectAdoptApplicationList(AdoptApplication adoptApplication)
    {
        return adoptApplicationMapper.selectAdoptApplicationList(adoptApplication);
    }

    /**
     * 新增领养申请
     * 
     * @param adoptApplication 领养申请
     * @return 结果
     */
    @Override
    public int insertAdoptApplication(AdoptApplication adoptApplication)
    {
        return adoptApplicationMapper.insertAdoptApplication(adoptApplication);
    }

    /**
     * 修改领养申请
     * 
     * @param adoptApplication 领养申请
     * @return 结果
     */
    @Override
    public int updateAdoptApplication(AdoptApplication adoptApplication)
    {
        return adoptApplicationMapper.updateAdoptApplication(adoptApplication);
    }

    /**
     * 批量删除领养申请
     * 
     * @param applicationIds 需要删除的领养申请主键
     * @return 结果
     */
    @Override
    public int deleteAdoptApplicationByApplicationIds(Long[] applicationIds)
    {
        return adoptApplicationMapper.deleteAdoptApplicationByApplicationIds(applicationIds);
    }

    /**
     * 删除领养申请信息
     * 
     * @param applicationId 领养申请主键
     * @return 结果
     */
    @Override
    public int deleteAdoptApplicationByApplicationId(Long applicationId)
    {
        return adoptApplicationMapper.deleteAdoptApplicationByApplicationId(applicationId);
    }
}
