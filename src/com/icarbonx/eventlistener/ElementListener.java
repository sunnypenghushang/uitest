package com.icarbonx.eventlistener;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.icarbonx.baseutils.EventLog;

import io.appium.java_client.events.api.general.ElementEventListener;

public class ElementListener implements ElementEventListener {
	@Override
	public void beforeClickOn(WebElement arg0, WebDriver arg1) {
		EventLog.logInfo("准备点击 " + splitElementText(arg0));

	}

	@Override
	public void afterClickOn(WebElement arg0, WebDriver arg1) {
		// TODO Auto-generated method stub
		EventLog.logInfo("点击" + splitElementText(arg0));
	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1) {
		EventLog.logInfo("输入之后控制字符为:" + splitElementText(arg0));

	}

	@Override
	public void afterChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		EventLog.logInfo("输入之后控制字符为:" + splitElementText(arg0));

	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1) {

		EventLog.logInfo("输入之前控制字符为:" + splitElementText(arg0));

	}

	@Override
	public void beforeChangeValueOf(WebElement arg0, WebDriver arg1, CharSequence[] arg2) {
		// TODO Auto-generated method stub

	}

	// 获取操作的控件字符串
	private String splitElementText(WebElement element) {
		String str2 = element.getText();
		return str2;
	}

	// 获取操作的控件id
	private String splitElementId(WebElement element) {
		String str = element.toString().split("-> ")[1];
		return str.substring(0, str.length() - 1);

	}

}
