package com.dh.appproject.mapper;

import com.dh.appproject.model.AppSysLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppSysLogMapper {
    /**
     * 系统日志添加描述
     * @param record
     * @return
     */
    void insertSelective(AppSysLog record);

    List<AppSysLog> selectByAllLogList(Map<String,Object> map);
}