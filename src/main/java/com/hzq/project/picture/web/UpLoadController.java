package com.hzq.project.picture.web;

import com.hzq.project.picture.exception.PictureException;
import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.AESUtil;
import com.hzq.project.system.security.util.Roles;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

/**
 * UpLoadController
 * Created by hzq on 16/9/24.
 */
@RestController
@RequestMapping("/upload")
public class UpLoadController extends BaseController {


    public static final String USER_RESUME = "userResume";
    public static final String COMPANY_PIC = "companyPic";
    public static final String CAR_MERCHANT = "carMerchant";
    public static final String SECOND_HOUSE = "secondHouse";


    /**
     * 用户简历上传头像
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(value = "userResume", method = RequestMethod.POST)
    public BaseResult userResume(@RequestParam("uploadFile") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        return new BaseResult(UploadAndGetFileName(file, USER_RESUME, request));
    }


    /**
     * 企业注册上传企业照片
     */
    @RequestMapping(value = "companyPic", method = RequestMethod.POST)
    public BaseResult companyPic(@RequestParam("uploadFile") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        return new BaseResult(UploadAndGetFileName(file, COMPANY_PIC, request));
    }

    /**
     * 商家注册,二手车发布图片
     */
    @RequestMapping(value = "carMerchant", method = RequestMethod.POST)
    public BaseResult carMerchant(@RequestParam("uploadFile") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        return new BaseResult(UploadAndGetFileName(file, CAR_MERCHANT, request));
    }


    /**
     * 二手房
     */
    @RequestMapping(value = "secondHouse", method = RequestMethod.POST)
    public BaseResult secondHouse(@RequestParam("uploadFile") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        return new BaseResult(UploadAndGetFileName(file, SECOND_HOUSE, request));
    }


    private String UploadAndGetFileName(@RequestParam("uploadFile") CommonsMultipartFile file, String uploadPath, HttpServletRequest request) throws IOException {
        if (file.getSize() == 0)
            throw new PictureException("请选择文件");
        String fileName = AESUtil.encrypt(file.getOriginalFilename() + System.currentTimeMillis(), getUserId());
        String path = request.getSession().getServletContext().getRealPath("/upload/" + uploadPath) + "/" + fileName;
        File newFile = new File(path);
        file.transferTo(newFile);
        return fileName;
    }

}
