package com.xxx.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping(value = "/file")
public class UploadController {
    /**
     * 传统文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/upload")
    public String upload(HttpServletRequest request) throws Exception{
        //获取指定文件夹的真实路径
        String path = request.getSession().getServletContext().getRealPath("/uploads");

        //创建磁盘文件工厂处理对象
        DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
        //创建表单解析对象
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

        //获取所有表单数据
        List<FileItem> fileItems = servletFileUpload.parseRequest(request);

        //循环表单数据
        for (FileItem fileItem : fileItems) {
            //不是普通的文本表单，也就是文件上传表单
            if (!fileItem.isFormField()) {
                //获取文件后缀名字
                String extName = StringUtils.getFilenameExtension(fileItem.getName());

                //随机给上传的文件取名字
                String fileName = UUID.randomUUID().toString();

                //数据写入磁盘
                fileItem.write(new File(path,fileName+"."+extName));
                //然后删除临时文件
                fileItem.delete();
            }
        }

        return "success";
    }

    @RequestMapping("/mvc/upload")
    public String upload(MultipartFile upload, HttpServletRequest request) throws IOException {
        String dir = request.getSession().getServletContext().getRealPath("/uploads");
        String path = UUID.randomUUID().toString() + "." + StringUtils.getFilenameExtension(upload.getOriginalFilename());

        upload.transferTo(new File(dir, path));
        return "success";
    }

    @RequestMapping("/remote/upload")
    public String remoteUpload(HttpServletRequest request, MultipartFile upload) throws Exception {
        //获取到上传文件的名称
        String filename = upload.getOriginalFilename();
        //获取文件后缀
        String extName = StringUtils.getFilenameExtension(filename);

        //随机给上传的文件取名字
        String newFileName = UUID.randomUUID().toString();

        //创建客户端
        Client client = Client.create();

        //创建文件上传对象
        WebResource webResource = client.resource("http://localhost:18082/uploads/"+newFileName+"."+extName);

        //文件上传
        webResource.put(upload.getBytes());

        return "success";
    }
}