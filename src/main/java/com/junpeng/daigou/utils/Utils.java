package com.junpeng.daigou.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Utils {
	
	public static <T> boolean isNotEmpty(List<T> list){
		boolean result = false;
		if(null != list && list.size() > 0 ){
			result = true;
		}
		
		return result;
	}
	
	public static <T> boolean isNotEmpty(String str){
		boolean result = false;
		if(null != str && !"".equals(str)){
			result = true;
		}
		
		return result;
	}
	
	public static String convDateToString(Date d){
		if(null == d){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(d);
		
		return dateString;
	}
	
	public static Date convStringToDate(String d){
		if(null == d){
			return null;
		}
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		try {
			date = formatter.parse(d);
		} catch (ParseException e) {
			return null;
		}
		
		return date;
	}
	
	public static String convDouble(double d){
		DecimalFormat df=new DecimalFormat("0.##");
		String st=df.format(d);
		
		return st;
	}
	
	public static double convDoubleToRoundDouble(double d){
		DecimalFormat df=new DecimalFormat("0.##");
		String st=df.format(d);
		
		return Double.parseDouble(st);
	}
	
	public static void setCommonCol(Object o){
		
	}
	
	public static double convBigDecimalToDouble(BigDecimal b){
		
		double result = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		
		return result;
	}
	
	public static double getCurrentRate(){
		return 0.0629;
	}
	
}
