package com.ruoyi.admin.mapper;

import java.util.List;
import com.ruoyi.admin.domain.CooperateOrg;

/**
 * 合作机构Mapper接口
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public interface CooperateOrgMapper
{
    /**
     * 查询合作机构
     *
     * @param orgId 合作机构主键
     * @return 合作机构
     */
    public CooperateOrg selectCooperateOrgByOrgId(Long orgId);

    /**
     * 查询合作机构列表
     *
     * @param cooperateOrg 合作机构
     * @return 合作机构集合
     */
    public List<CooperateOrg> selectCooperateOrgList(CooperateOrg cooperateOrg);

    /**
     * 新增合作机构
     *
     * @param cooperateOrg 合作机构
     * @return 结果
     */
    public int insertCooperateOrg(CooperateOrg cooperateOrg);

    /**
     * 修改合作机构
     *
     * @param cooperateOrg 合作机构
     * @return 结果
     */
    public int updateCooperateOrg(CooperateOrg cooperateOrg);

    /**
     * 删除合作机构
     *
     * @param orgId 合作机构主键
     * @return 结果
     */
    public int deleteCooperateOrgByOrgId(Long orgId);

    /**
     * 批量删除合作机构
     *
     * @param orgIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCooperateOrgByOrgIds(Long[] orgIds);

    /**
     * 获取合作机构统计数据
     *
     * @return 统计数据
     */
    public CooperateOrg selectCooperateOrgStats();
}
