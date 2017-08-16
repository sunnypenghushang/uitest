package com.icarbonx.eventlistener;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Window;

import io.appium.java_client.events.api.general.WindowEventListener;

public class WindowListener implements WindowEventListener{

	@Override
	public void afterWindowChangeSize(WebDriver arg0, Window arg1, Dimension arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterWindowIsMaximized(WebDriver arg0, Window arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterWindowIsMoved(WebDriver arg0, Window arg1, Point arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeWindowChangeSize(WebDriver arg0, Window arg1, Dimension arg2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeWindowIsMaximized(WebDriver arg0, Window arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void beforeWindowIsMoved(WebDriver arg0, Window arg1, Point arg2) {
		// TODO Auto-generated method stub
		
	}

}
