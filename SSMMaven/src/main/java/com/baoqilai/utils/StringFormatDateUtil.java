package com.baoqilai.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringFormatDateUtil {

	
	/**
	 * 将String类型的日期转换成Date类型
	 * @param dateTime
	 * @return
	 * @throws ParseException
	 */
	public static Date formatDate(String dateTime) throws ParseException{
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = format.parse(dateTime);
		String str =format.format(date);
		Date formatDate = format.parse(str);
		return formatDate;
	}

}
