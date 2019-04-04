package com.sanxiaU.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.sanxiaU.dao.BookInfoDao;
import com.sanxiaU.entity.BookInfo;

@Service
public class BookInfoService {

	@Autowired
	private BookInfoDao bid;
	
	public void addBookInfo(BookInfo bi){
		bid.addBookInfo(bi);
	}
	public List<BookInfo> findBookInfo(Integer currentpage, Integer pagesize,String bi_name){
		// 使用分页插件
		PageHelper.startPage(currentpage, pagesize);
		// 返回图书的集合
		return bid.findBookInfo();
	}
	public List<BookInfo> showBookType(){
		return bid.findBookInfo();
	}
	public Integer findBookCount(@Param("bt_id")Integer bt_id){
		return bid.findBookCount(bt_id);
	}
	public void removeBookInfo(@Param("bi_name") String bi_name){
		 bid.removeBookInfo(bi_name);
	}
	public void removeBookInfoList(String[] ids){
		bid.removeBookInfoList(ids);
	}

	public BookInfo checkBookInfo(@Param("bi_name") String bi_name){
		return bid.checkBookInfo(bi_name);
	}
}
