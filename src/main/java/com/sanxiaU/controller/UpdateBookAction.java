package com.sanxiaU.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.sanxiaU.entity.Message;

@RestController
public class UpdateBookAction {

    /**
     * 文件上传
     * @param picture
     * @param request
     * @return
     */
    @RequestMapping("/upload")
    public Message upload(@RequestParam("picture") MultipartFile picture, HttpServletRequest request) {

        //获取文件在服务器的储存位置
    	 String t=Thread.currentThread().getContextClassLoader().getResource("").getPath(); 
    	 int num=t.indexOf(".metadata");
    	 String path=t.substring(1,num).replace('/', '\\')+request.getContextPath()+"\\WebContent\\WEB-INF\\img";
    	//System.out.println(this.getClass().getClassLoader().getResource("").getPath());
    	//System.out.println("request.getSession().getServletContext()==="+request.getSession().getServletContext());
       // String path = request.getSession().getServletContext().getRealPath("/img");
        File filePath = new File(path);
        System.out.println("文件的保存路径：" + path);
        if (!filePath.exists() && !filePath.isDirectory()) {
            System.out.println("目录不存在，创建目录:" + filePath);
            filePath.mkdir();
        }

        //获取原始文件名称(包含格式)
        String originalFileName = picture.getOriginalFilename();
        System.out.println("原始文件名称：" + originalFileName);

        //获取文件类型，以最后一个`.`为标识
        String type = originalFileName.substring(originalFileName.lastIndexOf(".") + 1);
        System.out.println("文件类型：" + type);
        //获取文件名称（不包含格式）
        String name = originalFileName.substring(0, originalFileName.lastIndexOf("."));

        //设置文件新名称: 当前时间+文件名称（不包含格式）
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String date = sdf.format(d);
        String fileName = date + name + "." + type;
        System.out.println("新文件名称：" + fileName);

        //在指定路径下创建一个文件
        File targetFile = new File(path, fileName);
        
        //将文件保存到服务器指定位置
        try {
            picture.transferTo(targetFile);
            System.out.println("上传成功");
            //将文件在服务器的存储路径返回
            String serverPath=request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort();
System.out.println(serverPath);
System.out.println(serverPath+"\\"+request.getContextPath()+"\\img?url="+fileName);
            return new Message("上传成功！",200,serverPath+"\\"+request.getContextPath()+"\\img?url="+fileName);
        } catch (IOException e) {
            System.out.println("上传失败");
            e.printStackTrace();
            return new Message("上传失败！",500,"");
        }
    }
}
