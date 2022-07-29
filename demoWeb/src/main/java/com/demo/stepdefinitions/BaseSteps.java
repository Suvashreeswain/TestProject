package com.demo.stepdefinitions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class BaseSteps extends StepDefinitionInit {

	public static Scenario scenario;
	public static String featureName;

	@Before
	public void setUp() throws Exception {

		WebDriver driver;

		System.out.println("STARTING TEST..... ");
		session = getTestSession();
		Thread.sleep(5000);

	}

	@After
	public void tearDown(Scenario scenario) throws Exception {
		String output = scenario.getId().split(";")[0];

		featureName = output.substring(0, 1).toUpperCase() + output.substring(1);
		System.out.println("Feature File Name:********************************" + " " + featureName);

		this.scenario = scenario;

		if (scenario.isFailed()) {

			// Take a screenshot...

			System.out.println("The error message is " + scenario.getName());
			System.out.println("The  message is " + scenario.getStatus());

//			final byte[] screenshot = ((TakesScreenshot) session.driver).getScreenshotAs(OutputType.BYTES);
//			scenario.embed(screenshot, "image/png"); // ... and embed it in the report.
//
//			InputStream in = new ByteArrayInputStream(screenshot);
//			BufferedImage bImageFromConvert = ImageIO.read(in);
//
//			ImageIO.write(bImageFromConvert, "png",
//
//					(ImageOutputStream) new File("./screenshot" + scenario.getName().replaceAll(" ", "") + ".png"));
			
			 //Convert web driver object to TakeScreenshot

	        TakesScreenshot scrShot =((TakesScreenshot)session.driver);

	        //Call getScreenshotAs method to create image file

	                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                File DestFile=new File("./screenshot" + scenario.getName().replaceAll(" ", "") + ".png");

	                //Copy file at destination

	                FileUtils.copyFile(SrcFile, DestFile);

		} else {

			System.out.println("Updated Pass testcase");
		}
		System.out.println("I am in the tear function...");
		try {
			session.quit();
			System.out.println("Session is not terminated!!!");
		} finally {
			session = null;
		}
	}

}
