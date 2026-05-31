package com.ruoyi.adoption.service;

import java.util.List;
import com.ruoyi.adoption.domain.AdoptApplication;
import com.ruoyi.adoption.domain.PetRecommendationRequest;
import com.ruoyi.adoption.domain.PetRecommendationResult;

/**
 * 领养申请Service接口
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public interface IAdoptApplicationService
{
    /**
     * 查询领养申请
     *
     * @param applicationId 领养申请主键
     * @return 领养申请
     */
    public AdoptApplication selectAdoptApplicationByApplicationId(Long applicationId);

    /**
     * 查询领养申请列表
     *
     * @param adoptApplication 领养申请
     * @return 领养申请集合
     */
    public List<AdoptApplication> selectAdoptApplicationList(AdoptApplication adoptApplication);

    /**
     * 新增领养申请
     *
     * @param adoptApplication 领养申请
     * @return 结果
     */
    public int insertAdoptApplication(AdoptApplication adoptApplication);

    /**
     * 修改领养申请
     *
     * @param adoptApplication 领养申请
     * @return 结果
     */
    public int updateAdoptApplication(AdoptApplication adoptApplication);

    /**
     * 批量删除领养申请
     *
     * @param applicationIds 需要删除的领养申请主键集合
     * @return 结果
     */
    public int deleteAdoptApplicationByApplicationIds(Long[] applicationIds);

    /**
     * 删除领养申请信息
     *
     * @param applicationId 领养申请主键
     * @return 结果
     */
    public int deleteAdoptApplicationByApplicationId(Long applicationId);

    /**
     * 根据用户偏好推荐宠物
     *
     * @param request 推荐请求（包含用户偏好）
     * @return 推荐的宠物列表（按匹配度降序）
     */
    public List<PetRecommendationResult> recommendPets(PetRecommendationRequest request);
}
