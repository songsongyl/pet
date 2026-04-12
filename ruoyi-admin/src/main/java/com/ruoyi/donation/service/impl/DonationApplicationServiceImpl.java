package com.ruoyi.donation.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.donation.mapper.DonationApplicationMapper;
import com.ruoyi.donation.domain.DonationApplication;
import com.ruoyi.donation.service.IDonationApplicationService;

/**
 * 物资捐赠申请Service业务层处理
 *
 * @author ruoyi
 * @date 2026-04-04
 */
@Service
public class DonationApplicationServiceImpl implements IDonationApplicationService
{
    @Autowired
    private DonationApplicationMapper donationApplicationMapper;

    /**
     * 查询物资捐赠申请
     *
     * @param donationId 物资捐赠申请主键
     * @return 物资捐赠申请
     */
    @Override
    public DonationApplication selectDonationApplicationByDonationId(Long donationId)
    {
        return donationApplicationMapper.selectDonationApplicationByDonationId(donationId);
    }

    /**
     * 查询物资捐赠申请列表
     *
     * @param donationApplication 物资捐赠申请
     * @return 物资捐赠申请
     */
    @Override
    public List<DonationApplication> selectDonationApplicationList(DonationApplication donationApplication)
    {
        return donationApplicationMapper.selectDonationApplicationList(donationApplication);
    }

    /**
     * 新增物资捐赠申请
     *
     * @param donationApplication 物资捐赠申请
     * @return 结果
     */
    @Override
    public int insertDonationApplication(DonationApplication donationApplication)
    {
        return donationApplicationMapper.insertDonationApplication(donationApplication);
    }

    /**
     * 修改物资捐赠申请
     *
     * @param donationApplication 物资捐赠申请
     * @return 结果
     */
    @Override
    public int updateDonationApplication(DonationApplication donationApplication)
    {
        return donationApplicationMapper.updateDonationApplication(donationApplication);
    }

    /**
     * 批量删除物资捐赠申请
     *
     * @param donationIds 需要删除的物资捐赠申请主键
     * @return 结果
     */
    @Override
    public int deleteDonationApplicationByDonationIds(Long[] donationIds)
    {
        return donationApplicationMapper.deleteDonationApplicationByDonationIds(donationIds);
    }

    /**
     * 删除物资捐赠申请信息
     *
     * @param donationId 物资捐赠申请主键
     * @return 结果
     */
    @Override
    public int deleteDonationApplicationByDonationId(Long donationId)
    {
        return donationApplicationMapper.deleteDonationApplicationByDonationId(donationId);
    }
}
