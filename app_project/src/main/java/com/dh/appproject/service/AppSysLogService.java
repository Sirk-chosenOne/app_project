package com.dh.appproject.service;

import com.dh.appproject.model.AppSysLog;

import java.util.List;
import java.util.Map;

public interface AppSysLogService {
    /**
     * 系统日志添加描述
     * @param record
     * @return
     */
    void insertSelective(AppSysLog record);

    /**
     * 系统日志列表
     * @param map
     * @return
     */
    List<AppSysLog> selectByAllLogList(Map<String,Object> map);
}
