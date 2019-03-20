package com.sanxiaU.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ResourceAction {
	@RequestMapping(value="/img")
	public String img(@Param("url") String url){
		
		return url;
	}
}
