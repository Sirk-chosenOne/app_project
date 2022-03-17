package com.dh.appproject.service;

import com.dh.appproject.model.AppUploadInformation;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-14 14:35
 */
public interface AppUploadInformationService {
    /**
     * 文件上传
     *
     * @param record
     * @return
     */
    int insertSelective(AppUploadInformation record);

    /**
     * 文件上传列表
     *
     * @param userId
     * @return
     */
    List<AppUploadInformation> selectByAllUplodList(Long userId);

    /**
     * 当个文件查询
     *
     * @param id
     * @return
     */
    AppUploadInformation selectByPrimaryKey(@Param("id") Long id);
}
