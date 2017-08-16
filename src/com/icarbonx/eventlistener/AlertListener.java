package com.icarbonx.eventlistener;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.security.Credentials;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.events.api.general.AlertEventListener;

public class AlertListener implements AlertEventListener{

	@Override
	public void afterAlertAccept(WebDriver arg0, Alert arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertDismiss(WebDriver arg0, Alert arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAlertSendKeys(WebDriver arg0, Alert arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterAuthentication(WebDriver arg0, Alert arg1, Credentials arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAlertAccept(WebDriver arg0, Alert arg1) {
		// TODO Auto-generated method stub
		AndroidDriver  driver=(AndroidDriver)arg0;
		driver.findElementByAndroidUIAutomator("text(\"设为允许\")").click();
	}

	@Override
	public void beforeAlertDismiss(WebDriver arg0, Alert arg1) {
		// TODO Auto-generated method stub
		AndroidDriver  driver=(AndroidDriver)arg0;
		driver.findElementByAndroidUIAutomator("text(\"设为允许\")").click();
	}

	@Override
	public void beforeAlertSendKeys(WebDriver arg0, Alert arg1, String arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeAuthentication(WebDriver arg0, Alert arg1, Credentials arg2) {
		// TODO Auto-generated method stub
		
	}

}
