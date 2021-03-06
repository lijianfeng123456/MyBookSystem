package com.sanxiaU.controller;

import java.util.ArrayList;
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
	
	@GetMapping(value = "/getBookType")
	@ResponseBody
	public BookType getBookType(Integer bt_id) {
		BookType bookType = bts.getBookType(bt_id);
		System.out.println("666");
		return bookType;
	}
	@GetMapping(value = "/allBookType")
	@ResponseBody
	public List<BookType> showBookType() {
		List<BookType> bookTypeList = bts.showBookType();
		System.out.println("666");
		return bookTypeList;
	}
	@GetMapping(value = "/bookTypeList")
	@ResponseBody
	public PageInfo<BookType> findBookTypeList(@RequestParam("page") Integer currentpage,
			@RequestParam("pageSize") Integer pagesize, @RequestParam("bt_type") String bt_type) {
		List<BookType> bookTypeList = bts.findBookType(currentpage, pagesize, bt_type);
		System.out.println("图书List大小：" + bookTypeList.size());
		PageInfo<BookType> page = new PageInfo<BookType>(bookTypeList);
		return page;
	}
	@GetMapping(value = "/batchRemoveBookType")
	@ResponseBody
	public Message batchRemover(@RequestParam("ids")String ids){
		System.out.println(ids);
		String[] bt_ids=ids.split("\\,");
		System.out.println(bt_ids[0]);
		Message mes =new Message();
		try{
			bts.removeBookTypeList(bt_ids);
			mes.setCode(200);
			mes.setMsg("批量删除成功！");
		}catch(Exception e){
			e.printStackTrace();
			mes.setCode(500);
			mes.setMsg("失败,批量删除发生严重错误！");
		}
		return mes;
	}

	@GetMapping(value = "/batchRemoveBookType2")
	@ResponseBody
	public PageInfo<BookType> addBookType(@RequestParam("page") Integer currentpage,
			@RequestParam("pageSize") Integer pagesize, @RequestParam("bt_type") String bt_type) {
		List<BookType> bookTypeList = bts.findBookType(currentpage, pagesize, bt_type);
		System.out.println("图书List大小：" + bookTypeList.size());
		PageInfo<BookType> page = new PageInfo<BookType>(bookTypeList);
		return page;
	}

	@GetMapping(value = "/addBookType")
	@ResponseBody
	public Message addBookType(@RequestParam("bt_type") String bt_type) {
		Message mes = new Message();
		try {
			BookType bt = bts.checkBookType(bt_type);
			if (bt == null) {
				bts.addBookType(bt_type);
				System.out.println("成功？");
				mes.setCode(200);
				mes.setMsg("新增图书类别成功!");
			} else {
				mes.setCode(501);
				mes.setMsg("不能新增已存在的图书类别!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			mes.setCode(500);
			mes.setMsg("新增图书类别失败!");
		}
		return mes;
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
