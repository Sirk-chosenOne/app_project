package com.dh.appproject.service;

import com.dh.appproject.model.AppCentent;

import java.util.List;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-14 14:32
 */
public interface AppCententService {
    /**
     * 文件上传
     * @param record
     * @return
     */
    int insertSelective(AppCentent record);

    /**
     * 内容查看
     * @param uploadId
     * @return
     */
    List<AppCentent> selectByAllCententList(Long uploadId);

    /**
     * 首页展示
     * @param id
     * @return
     */
    AppCentent PrimaryKeyOne(Long id);
}
