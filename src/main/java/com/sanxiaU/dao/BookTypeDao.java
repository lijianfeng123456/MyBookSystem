package com.sanxiaU.dao;

import java.util.List;

import com.sanxiaU.entity.BookType;

public interface BookTypeDao {

	 List<BookType> findBookType();

	void removeBookType(String bt_type);
}
