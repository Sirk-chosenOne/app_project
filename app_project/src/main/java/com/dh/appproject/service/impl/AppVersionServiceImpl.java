package com.dh.appproject.service.impl;

import com.dh.appproject.mapper.AppVersionMapper;
import com.dh.appproject.model.AppVersion;
import com.dh.appproject.service.AppVersionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-16 14:52
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {
    @Autowired
    private AppVersionMapper appVersionMapper;
    @Override
    public AppVersion selectByPrimaryKey(Long id) {
        return appVersionMapper.selectByPrimaryKey(id);
    }
}
