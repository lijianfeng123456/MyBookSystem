package com.sanxiaU.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.sanxiaU.entity.BookType;

public interface BookTypeDao {

	List<BookType> findBookType(@Param("bt_type") String bt_type);

	void removeBookType(@Param("bt_type") String bt_type);
	void removeBookTypeList(@Param("ids") Map ids);//TODO批量删除

	void addBookType(@Param("bt_type") String bt_type);
	
	BookType checkBookType(@Param("bt_type") String bt_type);
	
}
