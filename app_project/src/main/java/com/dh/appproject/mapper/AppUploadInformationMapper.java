package com.dh.appproject.mapper;

import com.dh.appproject.model.AppUploadInformation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface AppUploadInformationMapper {
    int deleteByPrimaryKey(Long id);

    int insert(AppUploadInformation record);

    int insertSelective(AppUploadInformation record);

    AppUploadInformation selectByPrimaryKey(@Param("id")Long id);

    int updateByPrimaryKeySelective(AppUploadInformation record);

    int updateByPrimaryKey(AppUploadInformation record);

    List<AppUploadInformation> selectByAllUplodList(@Param("userId")Long userId);
}