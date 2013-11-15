package com.epam.helpers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

import com.epam.configuration.WebDriverFactory;

public class ScreenshotsForReporting extends TestListenerAdapter {


//	@Override
//	public void onTestFailure(ITestResult tr) {
//		// TODO Auto-generated method stub
//		super.onTestFailure(tr);
//		System.setProperty("org.uncommons.reportng.escape-output", "false");
//		ITestContext context = tr.getTestContext();
//		
//
//		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//	    Date date = new Date();
//			
//		
//		try {
//			//String outputDir = context.getOutputDirectory();
//			System.out.println("/target/surefire-reports/html");
//			Robot robot = new Robot();
//			BufferedImage bi = robot
//					.createScreenCapture(new Rectangle(600, 700));
//			File newFile = new File("target/surefire-reports/html", "FailTestScreenshot_"
//					+ tr.getMethod().getMethodName() +"_"+ dateFormat.format(date)+".png");
//			ImageIO.write(bi, "jpg", newFile);
//			tr.setAttribute("screenshot", newFile.getName());
//			tr.setAttribute("screenshotURL", newFile.getAbsolutePath());
//			System.out.println(newFile.getAbsolutePath());
//			String logString = String
//					.format("<br /><a href='%s'><img src='%s' hight='100' width='100' /></a>",
//							newFile.getAbsolutePath(),
//							newFile.getAbsolutePath());
//
//			Reporter.log(logString);
//
//		} catch (Exception e) {
//			System.out.println("error generating screenshot: " + e);
//		}
//
//		
//	}
	 private static final String NAME = "<a href=\"%s\"><img src=\"%<s\" width=200 height=150></a><br>";
	  private static WebDriver driver;

	   @Override
	   public void onTestFailure(ITestResult tr) {
	    File scrFile = ((TakesScreenshot) driver)
	      .getScreenshotAs(OutputType.FILE);
	    DateFormat dateFormat = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ssaa");
	    String destDir = "target/surefire-reports/html/reports/";
	    new File(destDir).mkdirs();
	    String destFile = dateFormat.format(new Date()) + ".png";
	    System.out.println(destFile);
	    System.setProperty("org.uncommons.reportng.escape-output", "false");
	    System.out.println(destDir);
	    try {
	     FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
	    } catch (IOException e) {
	     e.printStackTrace();
	    }
	    Reporter.log(String.format(NAME, "screenshots/" + destFile));

	   }
	   
	   public static void setDriver(WebDriver d){
	    driver = d;
	   }
	
	
	
	
	}
		
		



