package com.dh.appproject.service;

import com.dh.appproject.model.AppUser;
import org.apache.ibatis.annotations.Param;

public interface AppUserService {
    /**
     * 用户登录
     * @param userName
     * @param userPassword
     * @return
     */
    AppUser login(@Param("@Param") String userName, @Param("userPassword") String userPassword);

    /**
     * 获取用户密码
     * @param userName
     * @return
     */
    String getUserPassword(@Param("userName") String userName);

    /**
     * 用户注册
     * @param record
     * @return
     */
    int insertSelective(AppUser record);
}
