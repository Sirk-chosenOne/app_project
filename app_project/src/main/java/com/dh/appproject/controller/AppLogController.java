package com.dh.appproject.controller;

import com.dh.appproject.model.AppSysLog;
import com.dh.appproject.service.AppSysLogService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-12 14:28
 * <p>
 * 日志管理
 */
@RestController
@RequestMapping("/sys/log")
public class AppLogController {
    @Autowired
    private AppSysLogService appSysLogService;

    /**
     * 日志列表
     *
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/list")
    public PageInfo AppLogAllList(@RequestParam(value = "page", defaultValue = "1") Integer pageNum, @RequestParam(value = "rows", defaultValue = "10") Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        Map<String, Object> map = new HashMap<>();
        String operation = request.getParameter("operation");
        if (StringUtils.isNotBlank(operation)) {
            map.put("operation", operation);
        }
        String userName = request.getParameter("userName");
        if (StringUtils.isNotBlank(userName)) {
            map.put("userName", userName);
        }
        String ip = request.getParameter("ip");
        if (StringUtils.isNotBlank(ip)) {
            map.put("ip", ip);
        }
        List<AppSysLog> appSysLogs = appSysLogService.selectByAllLogList(map);
        PageInfo<AppSysLog> PageInfo = new PageInfo<AppSysLog>(appSysLogs);
        return PageInfo;
    }

    @RequestMapping("/upload")
    public void upload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
        String filea = request.getParameter("file2");
        InputStream stream = multipartFile.getInputStream();
        String filename = multipartFile.getOriginalFilename();
        File file = new File("E:\\temp\\" + filea + ".png");
        if (!file.exists()) {
            file.createNewFile();
        }
        BufferedInputStream in = new BufferedInputStream(stream);
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("E:\\temp\\" + filea + ".png"));
        int len = -1;
        byte[] b = new byte[1024];
        while ((len = in.read(b)) != -1) {
            out.write(b, 0, len);
        }
        out.close();
        in.close();
        stream.close();
    }
}
