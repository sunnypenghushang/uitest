package com.icarbonx.framework;



/**
 * 测试结果监听
 */
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.icarbonx.baseutils.EventLog;
import com.icarbonx.systemutils.ErrorLog;




public class TestResultListener extends TestListenerAdapter{
	String casename=null;
	ITestResult it;
	ErrorLog errorlog;
	Logger logger=EventLog.getLogger4j();
	
   /**
    * 用例执行失败时，抓取日志并进行截图
    */
	@Override
	public void onTestFailure(ITestResult tr) {
		long time=(tr.getEndMillis() - tr.getStartMillis());
		 logger.info("Failed, method:" + tr.getMethod()
         +" #parameters:"+tr.getParameters().length
         + " time:" + time);
		it=Reporter.getCurrentTestResult(); 
		casename=it.getName();
		//抓取日志
		errorlog.catchLog(casename);
		logger.info("执行失败，已抓取日志，日志名为："+ErrorLog.getLogFilename());
		//截图
	
		
	

	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		
		 logger.info("Skipped, method:" + tr.getMethod());
	}
	/**
	 * 每一个测试方法开始执行时
	 */

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		//开始执行用例时清除android缓存日志
		ErrorLog.clearLog();
		//每条用例开始前打印出分组
		ITestNGMethod method=result.getMethod();
		EventLog.logInfo("groups:"+method.getGroups().length);

		
	}

	@Override
	public List<ITestResult> getFailedTests() {
		// TODO Auto-generated method stub
		return super.getFailedTests();
	}

	@Override
	public List<ITestResult> getPassedTests() {
		// TODO Auto-generated method stub
		return super.getPassedTests();
	}

	@Override
	public List<ITestResult> getSkippedTests() {
		// TODO Auto-generated method stub
		return super.getSkippedTests();
	}

	@Override
	public void onFinish(ITestContext testContext) {
		logger.info("All Tests is finished");	
        Iterator<ITestResult> listOfFailedTests = testContext.getFailedTests().getAllResults().iterator();
        while (listOfFailedTests.hasNext()) {
            ITestResult failedTest = listOfFailedTests.next();
            ITestNGMethod method = failedTest.getMethod();
            if (testContext.getFailedTests().getResults(method).size() > 1) {
                listOfFailedTests.remove();
            } else {
                if (testContext.getPassedTests().getResults(method).size() > 0) {
                    listOfFailedTests.remove();
                }
            }
        }
  

	}

	@Override
	public void onStart(ITestContext testContext) {
		// TODO Auto-generated method stub
		super.onStart(testContext);
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		   long time=(tr.getEndMillis() - tr.getStartMillis());
	        logger.info("Success, method:" + tr.getMethod() + " time:" + time);
	}
	
	public void getFailed()
	{
		List<ITestResult> list=getFailedTests();
		Iterator<ITestResult> it=list.iterator();
		ITestResult result;
		ITestNGMethod method;

	}
	

}
