package com.icarbonx.eventlistener;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.appium.java_client.events.api.general.SearchingEventListener;

/**
 * 用来监听搜索事件
 * @author Administrator
 *
 */
public class SearchingListener implements SearchingEventListener{

	@Override
	public void afterFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeFindBy(By arg0, WebElement arg1, WebDriver arg2) {
		// TODO Auto-generated method stub
		
	}

}
