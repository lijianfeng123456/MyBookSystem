package com.sanxiaU.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sanxiaU.entity.BookInfo;

public interface BookInfoDao {

	void addBookInfo(BookInfo bi);
	List<BookInfo> findBookInfo();
	List<BookInfo> findBookInfo(@Param("bi_name") String bi_name);
	Integer findBookCount(@Param("bt_id")Integer bt_id);
	void removeBookInfo(@Param("bi_name") String bi_name);
	void removeBookInfoList(String[] ids);//TODO批量删除
	BookInfo checkBookInfo(@Param("bi_name") String bi_name);
}
