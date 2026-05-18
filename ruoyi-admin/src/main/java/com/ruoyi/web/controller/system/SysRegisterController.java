package com.ruoyi.web.controller.system;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.RegisterBody;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.web.service.SysRegisterService;
import com.ruoyi.system.service.ISysConfigService;

/**
 * 注册验证
 *
 * @author ruoyi
 */
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        // 1. 判断系统是否开启用户注册功能
        if (!"true".equals(configService.selectConfigByKey("sys.account.registerUser")))
        {
            return error("当前系统没有开启注册功能！");
        }

        // 2. 执行注册逻辑
        String msg = registerService.register(user);

        // 3. 注册成功返回success，失败返回错误信息
        return StringUtils.isEmpty(msg) ? success("注册成功") : error(msg);
    }
}