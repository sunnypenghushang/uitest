package com.icarbonx.systemutils;



import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

import com.icarbonx.baseutils.EventLog;
import com.icarbonx.baseutils.TimeUtils;

import io.appium.java_client.android.AndroidDriver;

public class Pictrue {
	
	/*
	 *截图
	 * @param driver 
	 * @param addinfo 图片标题
	 */
	public static void getScreenCap(AndroidDriver driver,String addinfo)
	{   
		String path=FilePath.getScreencapFilePath();
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenShot,new File(path,addinfo+TimeUtils.gettime()+".png"));
			String picname = addinfo+TimeUtils.gettime()+".png";
		} catch (IOException e) {
			
			e.printStackTrace();
		}	

	}
	
	
	
	
	
	
	public static void cutJPG(InputStream input, OutputStream out, int x,
			int y, int width, int height) throws IOException {
		ImageInputStream imageStream = null;
		try {
			Iterator<ImageReader> readers = ImageIO
					.getImageReadersByFormatName("jpg");
			ImageReader reader = readers.next();
			imageStream = ImageIO.createImageInputStream(input);
			reader.setInput(imageStream, true);
			ImageReadParam param = reader.getDefaultReadParam();

			// System.out.println(reader.getWidth(0));
			// System.out.println(reader.getHeight(0));
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, "jpg", out);
		} finally {
			imageStream.close();
		}
	}

	public static void cutPNG(InputStream input, OutputStream out, int x,
			int y, int width, int height) throws IOException {
		ImageInputStream imageStream = null;
		try {
			
			Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName("png");
			ImageReader reader = readers.next();
			imageStream = ImageIO.createImageInputStream(input);
			reader.setInput(imageStream, true);
			ImageReadParam param = reader.getDefaultReadParam();

			// System.out.println(reader.getWidth(0));
			// System.out.println(reader.getHeight(0));

			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, "png", out);
		} finally {
			imageStream.close();
		}
	}

	public static void cutImage(InputStream input, OutputStream out,String type, int x, int y, int width, int height)throws IOException {
		ImageInputStream imageStream = null;
		try {
			String imageType = (null == type || "".equals(type)) ? "jpg" : type;
			Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(imageType);
			ImageReader reader = readers.next();
			imageStream = ImageIO.createImageInputStream(input);
			reader.setInput(imageStream, true);
			ImageReadParam param = reader.getDefaultReadParam();
			Rectangle rect = new Rectangle(x, y, width, height);
			param.setSourceRegion(rect);
			BufferedImage bi = reader.read(0, param);
			ImageIO.write(bi, imageType, out);
		} finally {
			imageStream.close();
		}
	}

	/*
	 * 对比图片是否一致
	 * @param targetImagePath 目标图片
	 * @param myImagePath 源图片
	 * @param percent 相似百分比
	 * @return
	 */
	public static boolean sameAs(String targetImagePath, String myImagePath,double percent){
		BufferedImage otherImage = null;
		BufferedImage myImage = null;
		try {
			otherImage = ImageIO.read(new FileInputStream(targetImagePath));
			myImage = ImageIO.read(new FileInputStream(myImagePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			EventLog.logInfo("读取文件异常");
		}
        
		if (otherImage.getWidth() != myImage.getWidth()) {
			return false;
		}
		if (otherImage.getHeight() != myImage.getHeight()) {
			return false;
		}

		int width = myImage.getWidth();
		int height = myImage.getHeight();

		int numDiffPixels = 0;
		
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				if (myImage.getRGB(x, y) != otherImage.getRGB(x, y)) {
					numDiffPixels++;
				}
			}
		}
		EventLog.logInfo("对比图片:"+targetImagePath+"与图片:"+myImage+"的相似度");
		double numberPixels = (height * width);
		double diffPercent = numDiffPixels / numberPixels;
		return percent <= 1.0 - diffPercent;
	}
	
	


}
