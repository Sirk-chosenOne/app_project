package com.dh.appproject.mapper;

import com.dh.appproject.model.AppCentent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppCententMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppCentent record);

    int insertSelective(AppCentent record);

    int updateByPrimaryKeySelective(AppCentent record);

    int updateByPrimaryKey(AppCentent record);

    List<AppCentent> selectByAllCententList(@Param("uploadId") Long uploadId);

    AppCentent PrimaryKeyOne(Long id);
}