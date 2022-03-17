package com.dh.appproject.mapper;

import com.dh.appproject.model.AppVersion;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppVersionMapper {

    AppVersion selectByPrimaryKey(Long id);

}