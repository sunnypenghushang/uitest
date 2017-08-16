package com.icarbonx.eventlistener;

import org.openqa.selenium.ScreenOrientation;
import org.openqa.selenium.WebDriver;

import io.appium.java_client.events.api.mobile.RotationEventListener;


/**
 * 监听屏幕旋转
 * @author Administrator
 *
 */
public class RotationListener implements RotationEventListener{

	@Override
	public void afterRotation(WebDriver arg0, ScreenOrientation arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeRotation(WebDriver arg0, ScreenOrientation arg1) {
		// TODO Auto-generated method stub
		
	}

}
