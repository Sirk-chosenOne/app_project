package com.dh.appproject.controller;

import com.alibaba.fastjson.JSONObject;
import com.dh.appproject.model.AppCentent;
import com.dh.appproject.model.AppUploadInformation;
import com.dh.appproject.service.AppCententService;
import com.dh.appproject.service.AppUploadInformationService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * @author qk
 * @site www.nihaodonghao.com
 * @company 东昊传媒
 * @create 2022-03-14 15:08
 */
@RestController
@RequestMapping("/app")
public class AppUploadController {
    @Autowired
    private AppUploadInformationService appUploadInformationService;
    @Autowired
    private AppCententService appCententService;

    /**
     * 文件byte数组上传
     *
     * @param request
     * @param multipartFile
     * @throws IOException
     */
    @RequestMapping("/upload")
    public String upload(HttpServletRequest request, @RequestParam(value = "file") MultipartFile[] multipartFile) throws IOException {
        String userId = request.getParameter("userId");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String snNo = request.getParameter("snNo");
        String type = request.getParameter("type");
        AppUploadInformation appUploadInformation = new AppUploadInformation();
        appUploadInformation.setContent(content);
        appUploadInformation.setTitle(title);
        appUploadInformation.setType(type);
        appUploadInformation.setUserId(Long.valueOf(userId));
        appUploadInformation.setCreateTime(new Date());
        appUploadInformation.setIsitvalid("1");
        int uploadFlag = appUploadInformationService.insertSelective(appUploadInformation);
        if (multipartFile != null && multipartFile.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < multipartFile.length; i++) {
                InputStream stream = null;
                BufferedInputStream in = null;
                BufferedOutputStream out = null;
                try {
                    MultipartFile multipart = multipartFile[i];
                    //保存文件
                    stream = multipart.getInputStream();
                    String filename = multipart.getOriginalFilename();
                    String mkdirUrl = "D:\\wwwroot\\nihaodonghao\\wwwroot\\TSTK\\" + userId + "\\" + snNo;
                    String fileUrl = "D:\\wwwroot\\nihaodonghao\\wwwroot\\TSTK\\" + userId + "\\" + snNo + "\\" + filename;
                    File folder = new File(mkdirUrl);
                    if (!folder.exists() && !folder.isDirectory()) {
                        folder.mkdirs();
                    }
                    File file = new File(fileUrl);
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    in = new BufferedInputStream(stream);
                    out = new BufferedOutputStream(new FileOutputStream(fileUrl));
                    int len = -1;
                    byte[] b = new byte[1024];
                    while ((len = in.read(b)) != -1) {
                        out.write(b, 0, len);
                    }
                    String savaUrl = "http://nihaodonghao.com/TSTK/" + userId + "/" + snNo + "/" + filename;
                    if (uploadFlag == 1) {
                        AppCentent appCentent = new AppCentent();
                        appCentent.setUrl(savaUrl);
                        appCentent.setPictureName(filename);
                        appCentent.setUploadId(appUploadInformation.getId());
                        appCentent.setIsitvalid("1");
                        appCententService.insertSelective(appCentent);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    stream.close();
                    in.close();
                    out.close();
                }
            }
        }
        return "1";
    }

    /**
     * 内容查看
     *
     * @param pageNum
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/uploadList")
    public PageInfo uploadAllList(@RequestParam(value = "page", defaultValue = "1") Integer pageNum, @RequestParam(value = "rows", defaultValue = "8") Integer pageSize, HttpServletRequest request) {
        PageHelper.startPage(pageNum, pageSize);
        String userId = request.getParameter("userId");
        List<AppUploadInformation> uploadInformations = null;
        if (StringUtils.isNotBlank(userId)) {
            uploadInformations = appUploadInformationService.selectByAllUplodList(Long.valueOf(userId));
        } else {
            uploadInformations = appUploadInformationService.selectByAllUplodList(null);
        }
        if (uploadInformations.size() > 0 && uploadInformations != null) {
            for (AppUploadInformation uploadInformation : uploadInformations) {
                AppCentent appCentent = appCententService.PrimaryKeyOne(uploadInformation.getId());
                uploadInformation.setUrl(appCentent.getUrl());
            }
        }
        PageInfo<AppUploadInformation> PageInfo = new PageInfo<>(uploadInformations);
        return PageInfo;
    }

    /**
     * 内容详细查看
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/contentList")
    @ResponseBody
    public JSONObject uploadAllList(HttpServletRequest request) {
        String uploadId = request.getParameter("uploadId");
        AppUploadInformation information = appUploadInformationService.selectByPrimaryKey(Long.valueOf(uploadId));
        List<AppCentent> appCentents = appCententService.selectByAllCententList(Long.valueOf(uploadId));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("appCentents", appCentents);
        jsonObject.put("information", information);
        return jsonObject;
    }
//    /**
//     * 纯文件上传
//     *
//     * @param multipartFile
//     * @throws IOException
//     */
//    @RequestMapping("/contentUpload")
//    public void cententupload(@RequestParam(value = "file") MultipartFile multipartFile) throws IOException {
//        String filename = multipartFile.getOriginalFilename();
//        InputStream stream = multipartFile.getInputStream();
//        String mkdirUrl = "http://nihaodonghao.com/TSTK/test";
//        String fileUrl = "http://nihaodonghao.com/TSTK/test" + filename;
//        File folder = new File(mkdirUrl);
//        if (!folder.exists() && !folder.isDirectory()) {
//            folder.mkdirs();
//        }
//        File file = new File(fileUrl);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//        BufferedInputStream in = new BufferedInputStream(stream);
//        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileUrl));
//        int len = -1;
//        byte[] b = new byte[1024];
//        while ((len = in.read(b)) != -1) {
//            out.write(b, 0, len);
//        }
//        stream.close();
//        in.close();
//        out.close();
//    }
}
