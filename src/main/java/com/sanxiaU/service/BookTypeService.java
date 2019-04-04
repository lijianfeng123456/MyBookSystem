package com.sanxiaU.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sanxiaU.dao.BookTypeDao;
import com.sanxiaU.entity.BookType;

@Service
public class BookTypeService {
	@Autowired
	private BookTypeDao btd;
	public List<BookType> showBookType(){
		return btd.findBookType();
	}
	public BookType getBookType(Integer bt_id){
		return btd.getBookType(bt_id);
	}
	public List<BookType> findBookType(Integer currentpage, Integer pagesize,String bt_type){
		// 使用分页插件
		PageHelper.startPage(currentpage, pagesize);
		// 返回图书种类的集合
		return btd.findBookType(bt_type);
	}
	public void removeBookType(String bt_type) {
		btd.removeBookType(bt_type);
	}
	public void addBookType(String bt_type){
		btd.addBookType(bt_type);
	}
	public BookType checkBookType(String bt_type){
		return btd.checkBookType(bt_type);
	}
	public void removeBookTypeList(String[] ids){
		btd.removeBookTypeList(ids);
	}
}
