package com.dh.appproject.service.impl;

import com.dh.appproject.mapper.AppSysLogMapper;
import com.dh.appproject.model.AppSysLog;
import com.dh.appproject.service.AppSysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class AppSysLogServiceImpl implements AppSysLogService {
    @Autowired
    private AppSysLogMapper appSysLogMapper;

    @Override
    public void insertSelective(AppSysLog record) {
        appSysLogMapper.insertSelective(record);
    }

    @Override
    public List<AppSysLog> selectByAllLogList(Map<String, Object> map) {
        return appSysLogMapper.selectByAllLogList(map);
    }
}
