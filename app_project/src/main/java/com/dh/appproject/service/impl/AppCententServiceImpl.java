package com.dh.appproject.service.impl;

import com.dh.appproject.mapper.AppCententMapper;
import com.dh.appproject.model.AppCentent;
import com.dh.appproject.model.AppUploadInformation;
import com.dh.appproject.service.AppCententService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.java2d.pipe.AAShapePipe;

import java.util.List;
import java.util.Map;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-14 14:33
 */
@Service
public class AppCententServiceImpl implements AppCententService {
    @Autowired
    private AppCententMapper appCententMapper;

    @Override
    public int insertSelective(AppCentent record) {
        return appCententMapper.insertSelective(record);
    }

    @Override
    public List<AppCentent> selectByAllCententList(Long uploadId) {
        return appCententMapper.selectByAllCententList(uploadId);
    }

    @Override
    public AppCentent PrimaryKeyOne(Long id) {
        return appCententMapper.PrimaryKeyOne(id);
    }
}
