package com.hzq.project.system.common.web;

import com.hzq.project.system.common.exception.CustomSizeLimitExceededException;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by hzq on 16/9/24.
 */

public class CustomMultiPartResolver extends CommonsMultipartResolver {

    @Override
    protected MultipartParsingResult parseRequest(HttpServletRequest request) {


        String encoding = determineEncoding(request);
        FileUpload fileUpload = prepareFileUpload(encoding);
        try {
            List<FileItem> fileItems = ((ServletFileUpload) fileUpload).parseRequest(request);
            return parseFileItems(fileItems, encoding);
        } catch (FileUploadBase.SizeLimitExceededException ex) {
            System.out.println(fileUpload.getSizeMax());
            throw new CustomSizeLimitExceededException("文件总计大于" + fileUpload.getSizeMax() / (1000 * 1024) + "M,请修改后再次上传");
        } catch (FileUploadException ex) {
            throw new MultipartException("Could not parse multipart servlet request", ex);
        }
    }
}
