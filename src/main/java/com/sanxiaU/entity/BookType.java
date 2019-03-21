package com.sanxiaU.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class BookType implements Serializable,Comparable<BookType>{
	private long bt_id;
	private String bt_type;
	public long getBt_id() {
		return bt_id;
	}
	public void setBt_id(long bt_id) {
		this.bt_id = bt_id;
	}
	public String getBt_type() {
		return bt_type;
	}
	public void setBt_type(String bt_type) {
		this.bt_type = bt_type;
	}
	@Override
	public String toString() {
		return "BookType [bt_id=" + bt_id + ", bt_type=" + bt_type + "]";
	}
	public BookType() {
		super();
		// TODO Auto-generated constructor stub
	}
	public BookType(long bt_id, String bt_type) {
		super();
		this.bt_id = bt_id;
		this.bt_type = bt_type;
	}
	@Override
	public int compareTo(BookType b) {
		// TODO Auto-generated method stub
		return this.getBt_type().compareTo(b.getBt_type());
	}
	
}
