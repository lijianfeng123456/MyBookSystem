package com.sanxiaU.entity;

import java.io.Serializable;

/**
 * @author ljf
 * 图书信息pojo类
 */
@SuppressWarnings("serial")
public class BookInfo implements Serializable {

	private long bi_id;//id
	private String bi_name; //图书名
	private BookType bt_type; //图书类别
	private String bi_putTime;//上传时间
	private Integer bi_num; //图书数量
	private Integer bi_il; //图书借阅所需的积分
	private String bi_pubDate; //图书出版日期
	private String bi_publish; //图书出版社
	private Integer  bi_pubTime; //图书印刷次数
	private String bi_abstract; //图书的简介
	private String bi_img; // 图书的封面地址
	public long getBi_id() {
		return bi_id;
	}
	public void setBi_id(long bi_id) {
		this.bi_id = bi_id;
	}
	public String getBi_name() {
		return bi_name;
	}
	public void setBi_name(String bi_name) {
		this.bi_name = bi_name;
	}
	public BookType getBt_type() {
		return bt_type;
	}
	public void setBt_type(BookType bt_type) {
		this.bt_type = bt_type;
	}
	public String getBi_putTime() {
		return bi_putTime;
	}
	public void setBi_putTime(String bi_putTime) {
		this.bi_putTime = bi_putTime;
	}
	public Integer getBi_num() {
		return bi_num;
	}
	public void setBi_num(Integer bi_num) {
		this.bi_num = bi_num;
	}
	public Integer getBi_il() {
		return bi_il;
	}
	public void setBi_il(Integer bi_il) {
		this.bi_il = bi_il;
	}
	public String getBi_pubDate() {
		return bi_pubDate;
	}
	public void setBi_pubDate(String bi_pubDate) {
		this.bi_pubDate = bi_pubDate;
	}
	public String getBi_publish() {
		return bi_publish;
	}
	public void setBi_publish(String bi_publish) {
		this.bi_publish = bi_publish;
	}
	public Integer getBi_pubTime() {
		return bi_pubTime;
	}
	public void setBi_pubTime(Integer bi_pubTime) {
		this.bi_pubTime = bi_pubTime;
	}
	public String getBi_abstract() {
		return bi_abstract;
	}
	public void setBi_abstract(String bi_abstract) {
		this.bi_abstract = bi_abstract;
	}
	public String getBi_img() {
		return bi_img;
	}
	public void setBi_img(String bi_img) {
		this.bi_img = bi_img;
	}
	@Override
	public String toString() {
		return "BookInfo [bi_id=" + bi_id + ", bi_name=" + bi_name + ", bt_type=" + bt_type + ", bi_putTime="
				+ bi_putTime + ", bi_num=" + bi_num + ", bi_il=" + bi_il + ", bi_pubDate=" + bi_pubDate
				+ ", bi_publish=" + bi_publish + ", bi_pubTime=" + bi_pubTime + ", bi_abstract=" + bi_abstract
				+ ", bi_img=" + bi_img + "]";
	}
	public BookInfo(String bi_name, BookType bt_type, String bi_putTime, Integer bi_num, Integer bi_il,
			String bi_pubDate, String bi_publish, Integer bi_pubTime, String bi_abstract, String bi_img) {
		this.bi_name = bi_name;
		this.bt_type = bt_type;
		this.bi_putTime = bi_putTime;
		this.bi_num = bi_num;
		this.bi_il = bi_il;
		this.bi_pubDate = bi_pubDate;
		this.bi_publish = bi_publish;
		this.bi_pubTime = bi_pubTime;
		this.bi_abstract = bi_abstract;
		this.bi_img = bi_img;
	}
	public BookInfo() {
		super();
	}
	
	
	
	
}
