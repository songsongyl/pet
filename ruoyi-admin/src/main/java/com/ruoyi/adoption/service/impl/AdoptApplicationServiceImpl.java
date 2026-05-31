package com.ruoyi.adoption.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.adoption.mapper.AdoptApplicationMapper;
import com.ruoyi.adoption.domain.AdoptApplication;
import com.ruoyi.adoption.domain.PetRecommendationRequest;
import com.ruoyi.adoption.domain.PetRecommendationResult;
import com.ruoyi.adoption.service.IAdoptApplicationService;
import com.ruoyi.pet.domain.PetInfo;
import com.ruoyi.pet.mapper.PetInfoMapper;

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

    @Autowired
    private PetInfoMapper petInfoMapper;

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
     * @param applicationIds 需要删除的领养申请
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

    /**
     * 根据用户偏好推荐宠物
     *
     * 匹配权重分配：
     * - 宠物类型匹配：25%权重
     * - 品种匹配（模糊）：25%权重
     * - 性别匹配：15%权重
     * - 年龄偏好匹配：15%权重
     * - 健康状态匹配：10%权重
     * - 位置邻近性：10%权重
     *
     * @param request 推荐请求（包含用户偏好）
     * @return 推荐的宠物列表（按匹配度降序）
     */
    @Override
    public List<PetRecommendationResult> recommendPets(PetRecommendationRequest request)
    {
        // 查询所有宠物（不限制状态）
        List<PetInfo> allPets = petInfoMapper.selectPetInfoList(new PetInfo());

        if (allPets == null || allPets.isEmpty())
        {
            return new ArrayList<>();
        }

        // 过滤掉已领养(4)和死亡(6)的宠物
        final Integer ADOPTED_STATUS = 4;
        final Integer DEAD_STATUS = 6;
        allPets = allPets.stream()
                .filter(pet -> {
                    Integer status = pet.getPetStatus();
                    return status != null && !status.equals(ADOPTED_STATUS) && !status.equals(DEAD_STATUS);
                })
                .collect(Collectors.toList());

        // 权重常量
        final double PET_TYPE_WEIGHT = 0.25;
        final double BREED_WEIGHT = 0.25;
        final double GENDER_WEIGHT = 0.15;
        final double AGE_WEIGHT = 0.15;
        final double HEALTH_WEIGHT = 0.10;
        final double LOCATION_WEIGHT = 0.10;

        List<PetRecommendationResult> results = new ArrayList<>();

        for (PetInfo pet : allPets)
        {
            double totalScore = 0;
            StringBuilder matchDetails = new StringBuilder();

            // 1. 宠物类型匹配（25%权重）
            double petTypeScore = calculatePetTypeScore(request.getPreferPetType(), pet.getPetType());
            // 如果用户明确选择了宠物类型，但宠物类型不匹配，则跳过这只宠物
            if (request.getPreferPetType() != null && request.getPreferPetType() != 0 && petTypeScore == 0)
            {
                continue; // 类型不匹配，不返回这只宠物
            }
            totalScore += petTypeScore * PET_TYPE_WEIGHT;
            if (petTypeScore > 0)
            {
                matchDetails.append("类型匹配+" + String.format("%.1f", petTypeScore * PET_TYPE_WEIGHT) + " ");
            }

            // 2. 品种匹配（25%权重）- 支持模糊匹配
            double breedScore = calculateBreedScore(request.getPreferBreed(), pet.getBreed(), pet.getPetType());
            totalScore += breedScore * BREED_WEIGHT;
            if (breedScore > 0)
            {
                matchDetails.append("品种匹配+" + String.format("%.1f", breedScore * BREED_WEIGHT) + " ");
            }

            // 3. 性别匹配（15%权重）
            double genderScore = calculateGenderScore(request.getPreferGender(), pet.getGender());
            totalScore += genderScore * GENDER_WEIGHT;
            if (genderScore > 0)
            {
                matchDetails.append("性别匹配+" + String.format("%.1f", genderScore * GENDER_WEIGHT) + " ");
            }

            // 4. 年龄偏好匹配（15%权重）
            double ageScore = calculateAgeScore(request.getPreferAge(), pet.getAge());
            totalScore += ageScore * AGE_WEIGHT;
            if (ageScore > 0)
            {
                matchDetails.append("年龄适配+" + String.format("%.1f", ageScore * AGE_WEIGHT) + " ");
            }

            // 5. 健康状态匹配（10%权重）
            double healthScore = calculateHealthScore(request.getPreferHealthStatus(), pet.getHealthStatus());
            totalScore += healthScore * HEALTH_WEIGHT;
            if (healthScore > 0)
            {
                matchDetails.append("健康适配+" + String.format("%.1f", healthScore * HEALTH_WEIGHT) + " ");
            }

            // 6. 位置邻近性（10%权重）
            double locationScore = calculateLocationScore(request.getPreferLocation(), pet.getFoundPlace());
            totalScore += locationScore * LOCATION_WEIGHT;
            if (locationScore > 0)
            {
                matchDetails.append("位置邻近+" + String.format("%.1f", locationScore * LOCATION_WEIGHT) + " ");
            }

            // 转换为百分制
            double finalScore = totalScore * 100;

            PetRecommendationResult result = new PetRecommendationResult(pet);
            result.setMatchScore(finalScore);
            result.setMatchDetails(matchDetails.toString().trim());
            result.setMatchTag(getMatchTag(finalScore));

            results.add(result);
        }

        // 按匹配度降序排序
        return results.stream()
                .sorted(Comparator.comparingDouble(PetRecommendationResult::getMatchScore).reversed())
                .collect(Collectors.toList());
    }

    /**
     * 计算宠物类型匹配得分
     * 完全匹配得100分，不限/null得100分，不匹配得0分
     */
    private double calculatePetTypeScore(Integer preferType, Integer petType)
    {
        if (preferType == null || preferType == 0)
        {
            return 1.0; // 不限
        }
        if (petType == null)
        {
            return 0.5; // 未知
        }
        return preferType.equals(petType) ? 1.0 : 0.0;
    }

    /**
     * 计算品种匹配得分（支持模糊匹配）
     * 完全匹配得100分，品种相似（如都是猫）得50分，完全不匹配得0分
     */
    private double calculateBreedScore(String preferBreed, String petBreed, Integer petType)
    {
        if (preferBreed == null || preferBreed.trim().isEmpty())
        {
            return 1.0; // 不限
        }
        if (petBreed == null || petBreed.trim().isEmpty())
        {
            return 0.5; // 未知
        }

        String prefer = preferBreed.trim().toLowerCase();
        String breed = petBreed.trim().toLowerCase();

        // 完全匹配
        if (breed.contains(prefer) || prefer.contains(breed))
        {
            return 1.0;
        }

        // 品种类型关键词匹配（用于模糊匹配）
        String[] catKeywords = {"猫", "cat", "喵"};
        String[] dogKeywords = {"狗", "dog", "犬"};
        String[] rabbitKeywords = {"兔", "rabbit", " bunny"};
        String[] hamsterKeywords = {"仓鼠", "hamster", "鼠"};

        // 检查是否都属于同一大类
        boolean preferIsCat = containsAny(prefer, catKeywords);
        boolean preferIsDog = containsAny(prefer, dogKeywords);
        boolean preferIsRabbit = containsAny(prefer, rabbitKeywords);
        boolean preferIsHamster = containsAny(prefer, hamsterKeywords);

        boolean petIsCat = containsAny(breed, catKeywords);
        boolean petIsDog = containsAny(breed, dogKeywords);
        boolean petIsRabbit = containsAny(breed, rabbitKeywords);
        boolean petIsHamster = containsAny(breed, hamsterKeywords);

        if ((preferIsCat && petIsCat) || (preferIsDog && petIsDog) ||
            (preferIsRabbit && petIsRabbit) || (preferIsHamster && petIsHamster))
        {
            return 0.5; // 同类型但具体品种不同
        }

        return 0.0;
    }

    /**
     * 计算性别匹配得分
     * 完全匹配得100分，不限/null得100分，不匹配得0分
     */
    private double calculateGenderScore(Integer preferGender, Integer petGender)
    {
        if (preferGender == null || preferGender == 0)
        {
            return 1.0; // 不限
        }
        if (petGender == null)
        {
            return 0.5; // 未知
        }
        return preferGender.equals(petGender) ? 1.0 : 0.0;
    }

    /**
     * 计算年龄偏好匹配得分
     * 偏好不限得100分，偏好与实际匹配得100分
     * 1-幼年，2-成年，3-老年
     */
    private double calculateAgeScore(Integer preferAge, String petAge)
    {
        if (preferAge == null || preferAge == 0)
        {
            return 1.0; // 不限
        }
        if (petAge == null || petAge.trim().isEmpty())
        {
            return 0.5; // 未知
        }

        String age = petAge.toLowerCase().trim();

        // 判断宠物实际年龄类型
        int actualAgeType = 2; // 默认成年
        if (age.contains("幼") || age.contains("小") || age.contains("kitten") || age.contains("puppy") ||
            age.contains("baby") || age.matches("\\d+月") || age.matches("\\d+个月"))
        {
            actualAgeType = 1; // 幼年
        }
        else if (age.contains("老") || age.contains("年迈") || age.contains("old"))
        {
            actualAgeType = 3; // 老年
        }

        // 完全匹配
        if (preferAge.equals(actualAgeType))
        {
            return 1.0;
        }

        // 成年比较百搭，可以适配大部分偏好
        if (actualAgeType == 2 && (preferAge == 1 || preferAge == 3))
        {
            return 0.7; // 成年宠物可以适配幼年或老年偏好
        }

        return 0.0;
    }

    /**
     * 计算健康状态匹配得分
     * 偏好不限得100分，健康宠物得100分，有需求但可接受得60分
     */
    private double calculateHealthScore(Integer preferHealth, Integer petHealth)
    {
        if (preferHealth == null || preferHealth == 0)
        {
            return 1.0; // 不限
        }
        if (petHealth == null)
        {
            return 0.5; // 未知
        }

        // 健康状态：1-健康，2-需治疗，3-康复中
        if (preferHealth == 1)
        {
            // 用户偏好健康宠物
            return petHealth == 1 ? 1.0 : (petHealth == 3 ? 0.6 : 0.0);
        }
        else if (preferHealth == 2)
        {
            // 用户接受需治疗的宠物
            return petHealth == 2 ? 1.0 : 0.3;
        }

        return 1.0;
    }

    /**
     * 计算位置邻近性得分
     * 完全匹配得100分，模糊匹配得60分，不匹配得0分
     */
    private double calculateLocationScore(String preferLocation, String petLocation)
    {
        if (preferLocation == null || preferLocation.trim().isEmpty())
        {
            return 1.0; // 不限
        }
        if (petLocation == null || petLocation.trim().isEmpty())
        {
            return 0.5; // 未知
        }

        String prefer = preferLocation.trim().toLowerCase();
        String location = petLocation.toLowerCase().trim();

        // 完全匹配
        if (location.contains(prefer) || prefer.contains(location))
        {
            return 1.0;
        }

        // 省市匹配（如：四川省-成都，匹配到四川省）
        String[] preferParts = prefer.split("省|市|区|县");
        for (String part : preferParts)
        {
            if (!part.trim().isEmpty() && location.contains(part.trim()))
            {
                return 0.6; // 部分匹配
            }
        }

        return 0.0;
    }

    /**
     * 检查字符串是否包含任意关键词
     */
    private boolean containsAny(String text, String[] keywords)
    {
        for (String keyword : keywords)
        {
            if (text.contains(keyword))
            {
                return true;
            }
        }
        return false;
    }

    /**
     * 根据匹配分数获取匹配标签
     */
    private String getMatchTag(double score)
    {
        if (score >= 90)
        {
            return "完美匹配";
        }
        else if (score >= 75)
        {
            return "高度匹配";
        }
        else if (score >= 60)
        {
            return "较好匹配";
        }
        else if (score >= 40)
        {
            return "一般匹配";
        }
        else
        {
            return "低匹配";
        }
    }
}
