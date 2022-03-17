package com.dh.appproject.service;

import com.dh.appproject.model.AppVersion;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-16 14:52
 */
public interface AppVersionService {
    /**
     * 版本号对比
     * @param id
     * @return
     */
    AppVersion selectByPrimaryKey(Long id);
}
