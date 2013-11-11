package com.epam.helpers;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.imageio.ImageIO;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class ScreenshotsForReporting extends TestListenerAdapter{
	
	
@Override
public void onTestFailure(ITestResult tr) {
	// TODO Auto-generated method stub
	super.onTestFailure(tr);
	System.setProperty("org.uncommons.reportng.escape-output", "false");
	ITestContext context = tr.getTestContext();
	

	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
    Date date = new Date();
	
	
	
	try {
		String outputDir = context.getOutputDirectory();
		Robot robot = new Robot();
		// Capture the screen shot of the area of the screen defined by the
		// rectangle
		BufferedImage bi = robot
				.createScreenCapture(new Rectangle(600, 700));
		File newFile = new File(outputDir, "FailTestScreenshot_"
				+ tr.getMethod().getMethodName() +"_"+ dateFormat.format(date)+".png");
		ImageIO.write(bi, "jpg", newFile);
		tr.setAttribute("screenshot", newFile.getName());
		tr.setAttribute("screenshotURL", newFile.getAbsolutePath());
		String logString = String
				.format("<br /><a href='%s'><img src='%s' hight='100' width='100' /></a>",
						newFile.getAbsolutePath(),
						newFile.getAbsolutePath());

		Reporter.log(logString);

	} catch (Exception e) {
		System.out.println("error generating screenshot: " + e);
	}

	
}
}
