package com.ruoyi.admin.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.admin.mapper.CooperateOrgMapper;
import com.ruoyi.admin.domain.CooperateOrg;
import com.ruoyi.admin.service.ICooperateOrgService;
import org.apache.commons.lang3.StringUtils;

/**
 * 合作机构Service业务层处理
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@Service
public class CooperateOrgServiceImpl implements ICooperateOrgService
{
    @Autowired
    private CooperateOrgMapper cooperateOrgMapper;

    /**
     * 查询合作机构
     *
     * @param orgId 合作机构主键
     * @return 合作机构
     */
    @Override
    public CooperateOrg selectCooperateOrgByOrgId(Long orgId)
    {
        return cooperateOrgMapper.selectCooperateOrgByOrgId(orgId);
    }

    /**
     * 查询合作机构列表
     *
     * @param cooperateOrg 合作机构
     * @return 合作机构
     */
    @Override
    public List<CooperateOrg> selectCooperateOrgList(CooperateOrg cooperateOrg)
    {
        return cooperateOrgMapper.selectCooperateOrgList(cooperateOrg);
    }

    /**
     * 新增合作机构
     *
     * @param cooperateOrg 合作机构
     * @return 结果
     */
    @Override
    public int insertCooperateOrg(CooperateOrg cooperateOrg)
    {
        if (cooperateOrg.getOrgType() == null) {
            cooperateOrg.setOrgType(1);
        }
        if (StringUtils.isBlank(cooperateOrg.getLicenseNo())) {
            cooperateOrg.setLicenseNo("");
        }
        if (StringUtils.isBlank(cooperateOrg.getOrgName())) {
            cooperateOrg.setOrgName("");
        }
        return cooperateOrgMapper.insertCooperateOrg(cooperateOrg);
    }

    /**
     * 修改合作机构
     *
     * @param cooperateOrg 合作机构
     * @return 结果
     */
    @Override
    public int updateCooperateOrg(CooperateOrg cooperateOrg)
    {
        return cooperateOrgMapper.updateCooperateOrg(cooperateOrg);
    }

    /**
     * 批量删除合作机构
     *
     * @param orgIds 需要删除的合作机构主键
     * @return 结果
     */
    @Override
    public int deleteCooperateOrgByOrgIds(Long[] orgIds)
    {
        return cooperateOrgMapper.deleteCooperateOrgByOrgIds(orgIds);
    }

    /**
     * 删除合作机构信息
     *
     * @param orgId 合作机构主键
     * @return 结果
     */
    @Override
    public int deleteCooperateOrgByOrgId(Long orgId)
    {
        return cooperateOrgMapper.deleteCooperateOrgByOrgId(orgId);
    }

    /**
     * 获取合作机构统计数据
     *
     * @return 统计数据
     */
    @Override
    public CooperateOrg getCooperateOrgStats()
    {
        return cooperateOrgMapper.selectCooperateOrgStats();
    }
}
