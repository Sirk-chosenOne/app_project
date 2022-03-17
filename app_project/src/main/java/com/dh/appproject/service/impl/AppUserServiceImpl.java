package com.dh.appproject.service.impl;

import com.dh.appproject.mapper.AppUserMapper;
import com.dh.appproject.model.AppUser;
import com.dh.appproject.service.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {
    @Autowired
    private AppUserMapper appUserMapper;
    @Override
    public AppUser login(String userName, String userPassword) {
        return this.appUserMapper.login(userName,userPassword);
    }

    @Override
    public String getUserPassword(String userName) {
        return this.appUserMapper.getUserPassword(userName);
    }

    @Override
    public int insertSelective(AppUser record) {
        return appUserMapper.insertSelective(record);
    }
}
