package com.sanxiaU.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.sanxiaU.entity.BookType;
import com.sanxiaU.entity.Message;
import com.sanxiaU.service.BookTypeService;

@Controller
public class BookTypeAction {
	@Autowired
	private BookTypeService bts;

	@GetMapping(value = "/bookTypeList")
	@ResponseBody
	public PageInfo<BookType> finduserBypage(@RequestParam("page") Integer currentpage,
			@RequestParam("pageSize") Integer pagesize) {
		List<BookType> bookTypeList = bts.findBookType(currentpage, pagesize);
		System.out.println("图书List大小：" + bookTypeList.size());
		PageInfo<BookType> page = new PageInfo<BookType>(bookTypeList);
		return page;
	}

	@GetMapping(value = "/removeBookType")
	@ResponseBody
	public Message removeBookType(@RequestParam("bt_type") String bt_type) {
		Message mes = new Message();
		try {
			bts.removeBookType(bt_type);

		} catch (Exception e) {
			e.printStackTrace();
			mes.setCode(500);
			mes.setMsg("系统错误,删除失败!");
		}
		mes.setCode(200);
		mes.setMsg("删除成功!");
		return mes;
	}
}
