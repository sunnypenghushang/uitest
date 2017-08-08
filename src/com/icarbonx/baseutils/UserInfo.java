package com.icarbonx.baseutils;



import java.net.URL;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

/**
 * 保存登陆的账号信息
 * @author Administrator
 *
 */
public class UserInfo {
	private String account ="13480732317";//保存登录账号
	private String passWord = "123456";//保存登录密码
	private String oldPW;//保存旧密码
	private String newPW;//保存新密码
	private int logingType;//登录类型 邮箱 1，手机  2,
/*	public String getOldPW() {
		return oldPW;
	}*/
	public int getLogingType() {
		return logingType;
	}
	public void setLogingType(int logingType) {
		this.logingType = logingType;
	}

	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
		//根据输入的账号信直接判断输入的类型
		if (account.contains("@")) {
			logingType = Constant.LOGING_TYPE_EMAIL;		
		} else{
			logingType = Constant.LOGING_TYPE_PHONE;	
		}
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		
		this.passWord = passWord;
	}
	private static UserInfo userinfo ;

	public static  UserInfo  getUserInfo(){
		try {
			if (userinfo == null )
          	userinfo = new UserInfo();
			} catch (Exception e) {
				e.printStackTrace();
			}       
			return userinfo;  
		} 

	}
