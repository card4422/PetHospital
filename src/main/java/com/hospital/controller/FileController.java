package com.hospital.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by Jimmy on 2017/3/23.
 */
@Controller
//@RequestMapping(value="/")
public class FileController {

    /**
     * 实现文件上传
     *
     * @param uploadFile 多文件上传的数组
     * @return 返回成功与否的页面
     * @throws Exception
     */
    @RequestMapping(value="upload",method = RequestMethod.POST)
    @ResponseBody
    public String Upload(@RequestParam(value = "file",required = false) MultipartFile uploadFile)throws Exception {
        String fileName = uploadFile.getOriginalFilename();
//        String leftPath = session.getServletContext().getContextPath("/images");
//        String classpath = this.getClass().getResource("/").getPath();

        //target/PetHospital/target/PetHospital/WEB-INF/classes/META-INF/files
//        String leftPath = classpath+"META-INF/files";
        String leftPath = "D:/GradeFour/virtualPetHospital/public/assets";
        File file = new File(leftPath, fileName);
        uploadFile.transferTo(file);
        return "{\"fileName\":\"" + "/assets/pet/" + fileName + "\",\"result\":true}";
    }

    /**
     * 实现文件下载
     * @return 下载实体数据流
     * @throws IOException
     */
    @RequestMapping(value = "download",method = RequestMethod.POST)
    public ResponseEntity<byte[]> Download()throws IOException{
        File file = new File("/Users/zhuzheng/Desktop/StoredFile/download");
        HttpHeaders headers = new HttpHeaders();
        String fileName = new String("你好.jsp".getBytes("UTF-8"),"iso-8859-1");
        headers.setContentDispositionFormData("attachment",fileName);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

}
