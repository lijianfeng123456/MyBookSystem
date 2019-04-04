package com.sanxiaU.untils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class ChangeDate {
public static String getDate(String inputText){
	DateFormat inputFormat = new SimpleDateFormat("yyyy-MM-dd  HH:mm:ss");//转换格式
	//inputText = inputText.replace("Z", " UTC");//注意是空格+UTC
	inputFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
	Date date;
	String outputText = null;
	try {
		date = inputFormat.parse(inputText);
		outputText = inputFormat.format(date);
	} catch (ParseException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
      return outputText;

}
}
