package com.sanxiaU.controller;


import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.sanxiaU.entity.Manage;
import com.sanxiaU.entity.Message;
import com.sanxiaU.service.ManageService;
import com.sanxiaU.until.GetIpAddress;

/**
 * @author ljf
 * @version v1.0
 * @
 */
@Controller
//@RequestMapping("/s")
public class ManageAction {

	@Autowired
	private ManageService manageService;
	private static int num=1;
	@RequestMapping(value="/ljf",produces="text/html;charset=UTF-8")
	@ResponseBody
	public String index(){
		System.out.println("123");
		num++;	
	return num+" ";	
	}	
	
	
    @PostMapping(value="/login")
    @ResponseBody
	public Message login(Manage manage,HttpServletRequest request) {
    	Manage m=manageService.manageLogin(manage);
    	Message mes =new Message();
		if(m==null){
			mes.setMsg("用户名或者密码错误!");
			mes.setCode(404);
			return mes;
		}else{
			mes.setMsg("登录成功!");
			mes.setCode(200);
			if(m.getMg_time()!=null)
				m.setMg_time(m.getMg_time().split("\\.")[0]);
			System.out.println(m.getMg_time());
			mes.setobj(m);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");//转换格式
			manage.setMg_time(sdf.format(new Date()));
			manage.setMg_ip(GetIpAddress.getLocalIp(request));
			manageService.manageLoginIpAndTime(manage);
			System.out.println(manage.getMg_time());
			return mes;
		}
	}
    
//    @GetMapping(value="/loginOut")
//    @ResponseBody
//    public void loginOut(@RequestParam("mg_user") String mg_user,HttpServletRequest request ){
//    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");//转换格式
//    	Manage m =new Manage(mg_user);
//    	m.setMg_time(sdf.format(new Date()));
//    	m.setMg_ip(GetIpAddress.getLocalIp(request));
//    	try{   		
//    		manageService.manageLoginOut(m);
//    	}catch(Exception e){
//    		e.printStackTrace();
//    	}
//    }
}
