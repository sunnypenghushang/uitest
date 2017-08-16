package com.icarbonx.systemutils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.icarbonx.baseutils.JdbcObject;

public class Data {

    private  String user;
    private  String password;

    /*
     * 获取数据库的ip地址
     */
    public static String getDbip()
    {       
    	 String dbip=null;
         Properties prop=readFile();
    	 dbip=prop.getProperty("dbip");
    	 return dbip;
    }
    

    
    
    /*
     * 获取数据库的用户名
     */
    
    public static String getDbUserName()
    {
    	String dbname=null;
    	Properties prop=readFile();
    	dbname=prop.getProperty("dbname");
    	return dbname;
    }
    
    /*
     * 获取数据库的密码
     */
    public static String getDbPassWord()
    {
    	String dbpassword=null;
    	Properties prop=readFile();
    	dbpassword=prop.getProperty("dbpassword");
    	return dbpassword;
    }
    
    /*
     * 获取APP的登录账号
     */
    public static String getLoginAccount()
    {
    	String loginaccount=null;
    	Properties prop=readFile();
    	loginaccount=prop.getProperty("loginaccount");
    	return loginaccount;
    			
    }
    
    public static void main(String args[])
    {
    	System.out.println(getLoginAccount());
    }
    
    public static  Properties readFile()
    {

 	    Properties prop=null;
	    InputStream in=JdbcObject.class.getClassLoader().getResourceAsStream("testinfo.properties");
    	try {
   
    		prop=new Properties();
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return prop;
    }

}
