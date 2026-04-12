package com.ruoyi.donation.service;

import java.util.List;
import com.ruoyi.donation.domain.DonationApplication;

/**
 * 物资捐赠申请Service接口
 *
 * @author ruoyi
 * @date 2026-04-04
 */
public interface IDonationApplicationService
{
    /**
     * 查询物资捐赠申请
     *
     * @param donationId 物资捐赠申请主键
     * @return 物资捐赠申请
     */
    public DonationApplication selectDonationApplicationByDonationId(Long donationId);

    /**
     * 查询物资捐赠申请列表
     *
     * @param donationApplication 物资捐赠申请
     * @return 物资捐赠申请集合
     */
    public List<DonationApplication> selectDonationApplicationList(DonationApplication donationApplication);

    /**
     * 新增物资捐赠申请
     *
     * @param donationApplication 物资捐赠申请
     * @return 结果
     */
    public int insertDonationApplication(DonationApplication donationApplication);

    /**
     * 修改物资捐赠申请
     *
     * @param donationApplication 物资捐赠申请
     * @return 结果
     */
    public int updateDonationApplication(DonationApplication donationApplication);

    /**
     * 批量删除物资捐赠申请
     *
     * @param donationIds 需要删除的物资捐赠申请主键集合
     * @return 结果
     */
    public int deleteDonationApplicationByDonationIds(Long[] donationIds);

    /**
     * 删除物资捐赠申请信息
     *
     * @param donationId 物资捐赠申请主键
     * @return 结果
     */
    public int deleteDonationApplicationByDonationId(Long donationId);
}
