package com.hzq.project.picture.web;

import com.hzq.project.system.common.web.BaseController;
import com.hzq.project.system.common.web.BaseResult;
import com.hzq.project.system.security.annon.RequiresRoles;
import com.hzq.project.system.security.util.AESUtil;
import com.hzq.project.system.security.util.Roles;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * UpLoadController
 * Created by hzq on 16/9/24.
 */
@RestController
@RequestMapping("/upload")
public class UpLoadController extends BaseController {


    private static final String USER_RESUME = "userResume";

    /**
     * 用户简历上传头像
     */
    @RequiresRoles(Roles.USER)
    @RequestMapping(value = "userResume", method = RequestMethod.POST)
    public BaseResult fileUpload2(@RequestParam("uploadFile") CommonsMultipartFile file, HttpServletRequest request) throws IOException {
        return new BaseResult(UploadAndGetFileName(file, USER_RESUME, request));
    }

    private String UploadAndGetFileName(@RequestParam("uploadFile") CommonsMultipartFile file, String uploadPath, HttpServletRequest request) throws IOException {
        String fileName = AESUtil.encrypt(file.getOriginalFilename() + System.currentTimeMillis(), getUserId());
        String path = request.getSession().getServletContext().getRealPath("/upload/" + uploadPath) + "/" + fileName;
        File newFile = new File(path);
        file.transferTo(newFile);
        return fileName;
    }

}
