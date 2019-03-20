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
	public List<BookType> findBookType(){
		return btd.findBookType();
	}
	public List<BookType> findBookType(Integer currentpage, Integer pagesize){
		// 使用分页插件
		PageHelper.startPage(currentpage, pagesize);
		// 返回图书种类的集合
		return btd.findBookType();
	}
	public void removeBookType(String bt_type) {
		btd.removeBookType(bt_type);
		
	}
}
