package com.dh.appproject.service.impl;

import com.dh.appproject.mapper.AppUploadInformationMapper;
import com.dh.appproject.model.AppUploadInformation;
import com.dh.appproject.service.AppUploadInformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-14 14:36
 */
@Service
public class AppUploadInformationServiceImpl implements AppUploadInformationService {
    @Autowired
    private AppUploadInformationMapper appUploadInformationMapper;
    @Override
    public int insertSelective(AppUploadInformation record) {
        return appUploadInformationMapper.insertSelective(record);
    }

    @Override
    public List<AppUploadInformation> selectByAllUplodList(Long userId) {
        return appUploadInformationMapper.selectByAllUplodList(userId);
    }

    @Override
    public AppUploadInformation selectByPrimaryKey(Long id) {
        return appUploadInformationMapper.selectByPrimaryKey(id);
    }
}
