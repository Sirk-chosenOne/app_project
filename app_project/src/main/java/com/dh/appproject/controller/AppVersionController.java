package com.dh.appproject.controller;

import com.dh.appproject.model.AppVersion;
import com.dh.appproject.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-16 14:53
 */
@Controller
@RequestMapping("/vs")
public class AppVersionController {
    @Autowired
    private AppVersionService appVersionService;

    /**
     * 版本对比
     * @return
     */
    @RequestMapping("/version")
    @ResponseBody
    public String versionCheck() {
        AppVersion appVersion = appVersionService.selectByPrimaryKey(Long.valueOf(1));
        return appVersion.getVersion();
    }
}
