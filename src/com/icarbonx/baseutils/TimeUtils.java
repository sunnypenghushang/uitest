package com.icarbonx.baseutils;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.util.TextUtils;

/**
 * 
 * @项目名:FcuhMerchant
 * @包名:com.fcuh.merchant.utils
 * @类名:TimeUtils
 * @创建者:wayne
 * @创建时间:2016年3月3日 下午2:22:25
 * @描述:时间日期工具类
 * 
 * @SVN版本:$Rev: 1560 $
 * @更新人:$Author$
 * @更新时间:$Date: 2016-04-08 16:38:27 +0800 (星期五, 08 四月 2016) $
 * @描述:TODO
 *
 */
public class TimeUtils {
	private static final Calendar calendar = Calendar.getInstance();
	//格式化时间
	public static String formatTime(long timeStamp, long standardTimeStamp) {
		String formatDateResult;
		int timeDValue = (int) (standardTimeStamp - timeStamp);
		int tempValue = timeDValue / 60;//分钟
		if (tempValue < 15) {
			formatDateResult = "刚刚";
			return formatDateResult;
		} else if (tempValue < 60) {
			formatDateResult = tempValue + "分钟前";
			return formatDateResult;
		}
		tempValue = tempValue / 60;//小时
		if (tempValue < 24) {
			formatDateResult = tempValue + "小时前";
			return formatDateResult;
		}
		tempValue = tempValue / 24;//天
		if (tempValue < 7) {
			formatDateResult = tempValue + "天前";
			return formatDateResult;
		} else {
			String date;
			//获得发送信息的年份
			int standardYear = timeStampToDateYear(timeStamp);
			int dYear = getCurrentYear() - standardYear;
			if (dYear > 1) {
				SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				date = formatter.format(new Date(Long.valueOf(timeStamp + "000")));
			} else {
				SimpleDateFormat formatter = new SimpleDateFormat("MM-dd");
				date = formatter.format(new Date(Long.valueOf(timeStamp + "000")));
			}
			return date;
		}
	}

	/**
	 * 获得当前年份
	 * @return
	 */
	public static int getCurrentYear() {
		return calendar.get(Calendar.YEAR);
	}
	
	

	/**
	 * 获得当前月份
	 * @return
	 */
	public static int getCurrentMonth() {
		return calendar.get(Calendar.MONTH);
	}

	//获得当前日期
	public static int getCurrentDay() {
		return calendar.get(Calendar.DAY_OF_MONTH);
	}

	//获得指定时间戳年份
	public static int timeStampToDateYear(long millSec) {
		calendar.setTimeInMillis(Long.valueOf(millSec + "000"));
		int year = calendar.get(Calendar.YEAR);
		return year;
	}

	//获得指定时间戳月份
	public static int timeStampToDateMonth(long millSec) {
		calendar.setTimeInMillis(Long.valueOf(millSec + "000"));
		int month = calendar.get(Calendar.MONTH);
		return month;
	}

	//获得指定时间戳日期
	public static int timeStampToDateDay(long millSec) {
		calendar.setTimeInMillis(Long.valueOf(millSec + "000"));
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		return day;
	}

	public static String timeStampToString(long timeStamp,String formatStr){
		SimpleDateFormat formatter = new SimpleDateFormat(formatStr);
		return formatter.format(new Date(Long.valueOf(timeStamp)));
	}


	/**
	 * 获得xx年xx月x日
	 * @param time
	 * @return
	 */
	public static String getYearMonthDay(String time) {
		String year = time.substring(0, time.indexOf("-"));
		String moth = time.substring(time.indexOf("-") + 1, time.lastIndexOf("-"));
		if (moth.indexOf("0") == 0) {
			moth = moth.substring(1, moth.length());
		}
		String day=time.substring(time.lastIndexOf("-")+1);
		return year + "年" + moth + "月" + day + "日";
	}


	/** 
	 * 时间戳转换成日期格式字符串 
	 * @param seconds 精确到秒的字符串 
	 * @param
	 * @return 
	 */  
	public static String timeStamp2Date(String seconds,String format) {  
		if(seconds == null || seconds.isEmpty() || seconds.equals("null")){  
			return "";  
		}  
		if(format == null || format.isEmpty()) format = "yyyy-MM-dd HH:mm:ss";  
		SimpleDateFormat sdf = new SimpleDateFormat(format);  
		String date = sdf.format(new Date(Long.valueOf(seconds)));
		return date;
	}  

	/** 
	 * 日期格式字符串转换成时间戳 
	 * @param
	 * @param format 如：yyyy-MM-dd HH:mm:ss 
	 * @return 
	 */
	public static String date2TimeStamp(String date_str,String format){  
		try {  
			SimpleDateFormat sdf = new SimpleDateFormat(format);  
			return String.valueOf(sdf.parse(date_str).getTime()/1000);  
		} catch (Exception e) {  
			e.printStackTrace();  
		}  
		return "";  
	}  


	/** 
	 * 取得当前时间戳（精确到秒） 
	 * @return 
	 */  
	public static String timeStamp(){  
		long time = System.currentTimeMillis();  
		String t = String.valueOf(time/1000);  
		return t;  
	}  
	
	public static String gettime()
	{   
        Date date=new Date();
		SimpleDateFormat format=new SimpleDateFormat("yyyyMMddHHmm");
		String time=format.format(date);
		return time;
	}



	/**
	 * 获得月份
	 */
	public static String getMoth(String seconds,String format ) {
		String time = timeStamp2Date(seconds,  format);
		if (TextUtils.isEmpty(time)) {
			return null;
		}
		String moth=time.substring(time.indexOf("-")+1, time.lastIndexOf("-"));
		return moth;
	}



	/**
	 * 获取年月
	 */
	public static String getyearmoth(String seconds,String format) {
		//String time=data.get(position).getDate();
		String time = timeStamp2Date(seconds,  format);
		if (TextUtils.isEmpty(time)) {
			return null;
		}
		String year=time.substring(0,time.indexOf("-"));
		String moth=time.substring(time.indexOf("-")+1, time.lastIndexOf("-"));
		if (moth.indexOf("0")==0) {
			moth=moth.substring(1, moth.length());
		}
		//String day=time.substring(time.lastIndexOf("-")+1,time.length());
		return year+"年"+moth+"月";
	}


	/**
	 * 获取月日 具体时间
	 */
	public static String getSpecifictime(String seconds,String format) {
		//String time=data.get(position).getDate();
		String time = timeStamp2Date(seconds, format);
		if (TextUtils.isEmpty(time)) {
			return null;
		}
		String moth=time.substring(time.indexOf("-")+1, time.lastIndexOf("-"));
		String  mintime= time.substring(time.indexOf(" ")+1,time.length());
		if (moth.indexOf("0")==0) {
			moth=moth.substring(1, moth.length());
		}
		String day=time.substring(time.lastIndexOf("-")+1, time.indexOf(" "));
		return moth+"月"+day+"日"+"  "+mintime;
	}
	
	
	/**
	 * 获取 具体时间
	 */
	public static String getSpecifictime(String time) {
		//String time=data.get(position).getDate();	
		if (TextUtils.isEmpty(time)) {
			return null;
		}		
		String  mintime= time.substring(time.indexOf(" ")+1,time.length());	
		return mintime;
	}
	

}
