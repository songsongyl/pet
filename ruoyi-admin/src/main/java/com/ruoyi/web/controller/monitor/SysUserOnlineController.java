package com.ruoyi.web.controller.monitor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.constant.CacheConstants;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.domain.SysUserOnline;
import com.ruoyi.system.service.ISysUserOnlineService;

/**
 * 在线用户监控
 * 
 * @author ruoyi
 */
@RestController
@RequestMapping("/monitor/online")
public class SysUserOnlineController extends BaseController
{
    @Autowired
    private ISysUserOnlineService userOnlineService;

    @Autowired
    private RedisCache redisCache;

    @PreAuthorize("@ss.hasPermi('monitor:online:list')")
    @GetMapping("/list")
    public TableDataInfo list(String ipaddr, String userName, 
                              @RequestParam(defaultValue = "1") int pageNum, 
                              @RequestParam(defaultValue = "20") int pageSize)
    {
        // 生成模拟在线用户数据
        List<SysUserOnline> userOnlineList = generateMockOnlineUsers(1100);
        
        // 过滤条件
        if (StringUtils.isNotEmpty(ipaddr))
        {
            userOnlineList.removeIf(user -> !user.getIpaddr().contains(ipaddr));
        }
        if (StringUtils.isNotEmpty(userName))
        {
            userOnlineList.removeIf(user -> !user.getUserName().contains(userName));
        }
        
        // 分页处理
        int total = userOnlineList.size();
        int start = (pageNum - 1) * pageSize;
        int end = Math.min(start + pageSize, total);
        List<SysUserOnline> pageList = start < total ? userOnlineList.subList(start, end) : new ArrayList<>();
        
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(200);
        rspData.setMsg("查询成功");
        rspData.setRows(pageList);
        rspData.setTotal(total);
        return rspData;
    }
    
    /**
     * 生成模拟在线用户数据
     */
    private List<SysUserOnline> generateMockOnlineUsers(int count)
    {
        List<SysUserOnline> userOnlineList = new ArrayList<>();
        String[] deptNames = {"市场部门", "技术部门", "运营部门", "客服部门", "财务部门", "人力资源", "行政部门", "研发中心"};
        String[] locations = {"北京市", "上海市", "广州市", "深圳市", "杭州市", "南京市", "成都市", "武汉市", "西安市", "重庆市", "苏州市", "天津市", "郑州市", "长沙市", "东莞市"};
        String[] osList = {"Windows 10", "Windows 11", "Mac OS X", "Linux", "Android", "iOS"};
        String[] browsers = {"Chrome", "Firefox", "Safari", "Edge", "Opera"};
        
        for (int i = 1; i <= count; i++)
        {
            SysUserOnline userOnline = new SysUserOnline();
            userOnline.setTokenId("SESSION_" + java.util.UUID.randomUUID().toString().substring(0, 18));
            userOnline.setUserName("user" + String.format("%04d", i));
            userOnline.setDeptName(deptNames[(int) (Math.random() * deptNames.length)]);
            userOnline.setIpaddr((int)(Math.random() * 255 + 1) + "." + (int)(Math.random() * 255) + "." + (int)(Math.random() * 255) + "." + (int)(Math.random() * 255));
            userOnline.setLoginLocation(locations[(int) (Math.random() * locations.length)]);
            userOnline.setOs(osList[(int) (Math.random() * osList.length)]);
            userOnline.setBrowser(browsers[(int) (Math.random() * browsers.length)]);
            userOnline.setLoginTime(System.currentTimeMillis() - (long)(Math.random() * 86400000));
            userOnlineList.add(userOnline);
        }
        
        return userOnlineList;
    }

    /**
     * 强退用户
     */
    @PreAuthorize("@ss.hasPermi('monitor:online:forceLogout')")
    @Log(title = "在线用户", businessType = BusinessType.FORCE)
    @DeleteMapping("/{tokenId}")
    public AjaxResult forceLogout(@PathVariable String tokenId)
    {
        redisCache.deleteObject(CacheConstants.LOGIN_TOKEN_KEY + tokenId);
        return success();
    }
}
