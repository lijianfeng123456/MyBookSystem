package com.sanxiaU.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageInfo;
import com.sanxiaU.entity.BookInfo;
import com.sanxiaU.entity.Message;
import com.sanxiaU.service.BookInfoService;

@RestController
public class BookInfoAction {
   
	@Autowired
	private BookInfoService bis;
    /**
     * 图书管理页面
     */
	
	@GetMapping(value = "/getBookList")
	@ResponseBody
	public PageInfo<BookInfo> findBookList(@RequestParam("page") Integer currentpage,
			@RequestParam("pageSize") Integer pagesize, @RequestParam("bi_name") String bi_name) {
		List<BookInfo> bookInfoList = bis.findBookInfo(currentpage, pagesize, bi_name);
		System.out.println("图书信息List大小：" + bookInfoList.size());
		PageInfo<BookInfo> page = new PageInfo<BookInfo>(bookInfoList);
		return page;
	}
	//新增图书
	@RequestMapping(value="/addBook")
	 public Message add(BookInfo bookinfo, HttpServletRequest request){
		 System.out.println(bookinfo.toString());
		
		 try{
			 if(bis.checkBookInfo(bookinfo.getBi_name())!=null)
				 return new Message("图书名称已存在,请检查!",501,"");
			 
			    // bookinfo.setBi_putTime(ChangeDate.getDate(bookinfo.getBi_putTime()));
			     //bookinfo.setBi_pubDate(ChangeDate.getDate(bookinfo.getBi_pubDate()));
			     bis.addBookInfo(bookinfo);
			 
		 }catch(Exception e){
			 e.printStackTrace();
			 return new Message("新增图书失败,请检查!",500,"");
		 }
		 return new Message("新增图书信息成功！",200,"");
	 }
	 @RequestMapping("/addImg")
	 public Message addImg(@RequestParam("picture") MultipartFile picture){
		return new Message("添加图片成功！",200,"");
	 }
	//上传图书图片
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
