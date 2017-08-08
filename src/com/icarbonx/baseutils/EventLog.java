package com.icarbonx.baseutils;


import org.apache.log4j.*;
import org.testng.Reporter;


import java.io.File;
/**
 * 操作事件日志
 * @author penghong
 *
 */
public class EventLog {
    private static Logger logger;

    private static String filePath = "src/config/log4j.properties";

    static {
        logger = Logger.getLogger("dev_log");
        PropertyConfigurator.configure(new File(filePath).getAbsolutePath());
    }
    /**
     * 记录Info级别日志。
     *
     * @param message the message object.
     */
    public static void logInfo(Object message) {
        logger.info("[INFO] " + message);
        Reporter.log(ToolFunctions.getSimpleDateFormat()+ " : " + "[INFO] " + message);
       
    }

    /**
     * 记录测试步骤信息。
     *
     * @param message the message object.
     */
    public static void logStep(Object message) {
        logger.info("[STEP] " + message);
        Reporter.log(ToolFunctions.getSimpleDateFormat() + " : " + "[STEP] " + message);
    }

    /**
     * 记录测试流日志。
     *
     * @param message the message object.
     */
    public static void logFlow(Object message) {
        logger.info("[FLOW] " + message);
        Reporter.log(ToolFunctions.getSimpleDateFormat() + " : " + "[FLOW] " + message);
    }

    /**
     * 记录Error级别日志。
     *
     *
     * @param message the message object.
     */
    public static void logError(Object message) {
        logger.error("[ERROR]   " + message);
        Reporter.log(ToolFunctions.getSimpleDateFormat()+ " : " + "[ERROR]   " + message);
    }

    /**
     * 记录Warn级别日志。
     *
     * @param message the message object.
     */
    public static void logWarn(Object message) {
        logger.warn("[WARN] " + message);
        Reporter.log(ToolFunctions.getSimpleDateFormat() + " : " + "[WARN] " + message);
    }
    
    public static Logger getLogger4j()
    {
    	return logger;
    }
}
