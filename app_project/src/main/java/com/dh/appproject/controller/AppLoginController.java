package com.dh.appproject.controller;

import com.dh.appproject.model.AppUser;
import com.dh.appproject.service.AppUserService;
import com.dh.appproject.utils.Restful;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-12 13:28
 * <p>
 * 登录
 */
@RestController
@RequestMapping("/app")
public class AppLoginController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private BCryptPasswordEncoder encoder;

    /**
     * 后台管理登录
     *
     * @param
     * @return
     */
    @RequestMapping("/backLogin")
    public Restful backLogin(HttpServletRequest request) {
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String password = appUserService.getUserPassword(userName);
//      密码解析，加密
        boolean matches = encoder.matches(userPassword, password);
        if (matches == true) {
            AppUser appUser = appUserService.login(userName, password);
            if (appUser != null) {
                request.getSession().setAttribute("appUser", appUser);
                return new Restful(1, "登录成功！", null);
            }
        } else {
            return new Restful(0, "密码错误！", null);
        }
        return new Restful(0, "用户不存在！", null);
    }

    /**
     * app端登录
     * @param userName
     * @param userPassword
     * @param request
     * @return
     */
    @RequestMapping("/appLogin")
    public int appLogin(@RequestParam("username") String userName,@RequestParam("password") String userPassword,HttpServletRequest request) {
        String password = appUserService.getUserPassword(userName);
//      密码解析，加密
        boolean matches = encoder.matches(userPassword, password);
        if (matches == true) {
            AppUser appUser = appUserService.login(userName, password);
            if (appUser != null) {
                request.getSession().setAttribute("appUser", appUser);
                return 1;
            }
        } else {
            return 0;
        }
        return 0;
    }
}
