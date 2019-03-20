package com.sanxiaU.entity;

import java.io.Serializable;
@SuppressWarnings("serial")
public class Message implements Serializable{
    private String msg;
 	private Integer code;
 	private Object obj;
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Object getobj() {
		return obj;
	}
	public void setobj(Object obj) {
		this.obj = obj;
	}
	@Override
	public String toString() {
		return "Message [msg=" + msg + ", code=" + code + ", obj=" + obj + "]";
	}
	public Message(){}
 	public Message(String msg,Integer code,Object obj){
 		super();
 		this.msg = msg;
 		this.code =code;
 		this.obj = obj;
 	}
}
