package com.demo.automation.framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.yaml.snakeyaml.Yaml;

import com.demo.utils.InitData;
import com.demo.utils.PropFileHandler;

public class ConfigurationRegistory {

	Map<String, Object> registry;
	private static String OS = System.getProperty("os.name").toLowerCase();

	// public static String url;
	@SuppressWarnings("unchecked")
	public ConfigurationRegistory() {
		registry = (Map<String, Object>) new Yaml()
				.load(getClass().getClassLoader().getResourceAsStream("configurationRegistry.yaml"));
	}

	public WebDriver getDriver(Map<String, Object> config) throws MalformedURLException {
		Map<String, Object> options = new HashMap<String, Object>();
		return getDriver(config, options);
	}

	public WebDriver getDriver(Map<String, Object> config, Map<String, Object> options) throws MalformedURLException {
		String projectPath = System.getProperty("user.dir");
		String driverPathChrome = null;
		String driverPathFF = null;
		String driverPathEdge = null;
		String testConfiguration = null;
		System.out.println(OS);

		if (isWindows()) {
			System.out.println("This is Windows");
			driverPathChrome = projectPath + "" + "/src/main/resources/drivers/window/chromedriver.exe";
			driverPathFF = projectPath + "" + "/src/main/resources/drivers/firefox/geckodriver.exe";
			driverPathEdge = projectPath + "" + "/src/main/resources/drivers/edge/msedgedriver.exe";
		} else if (isMac()) {
			System.out.println("This is Mac");
			driverPathChrome = projectPath + "" + "/src/main/resources/drivers/mac/chromedriver";
		} else if (isUnix()) {
			System.out.println("This is Unix or Linux");
			driverPathChrome = projectPath + "" + "/src/main/resources/drivers/linux/chromedriver";
		} else {
			System.out.println("Your OS is not supported!!");
		}

		System.out.println("The driver path is " + driverPathChrome);

		if (options.containsKey("TEST_CONFIGURATION")) {
			testConfiguration = options.get("TEST_CONFIGURATION").toString();
		}

		TestSession.logger.info("Launching Test Configuration: " + testConfiguration + " ...");
		System.out.println("Launching Test on Configuration: " + testConfiguration + " ...");

		Map<String, String> configRegistory = (Map<String, String>) registry.get(testConfiguration);
		WebDriver driver = null;

		System.out.println(configRegistory);

		// url=configRegistory.get("server");

		ChromeOptions chromeOptions;
		switch (InitData.platformName) {
		case ("mac"):
			// TODO need to check if chromedriver exists
			System.setProperty("webdriver.chrome.driver", driverPathChrome);
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--allow-running-insecure-content");
			driver = new ChromeDriver(chromeOptions);
			break;

		case ("chrome"):
			System.out.println("In Chrome configuration");
			System.setProperty("webdriver.chrome.driver", driverPathChrome);
			chromeOptions = new ChromeOptions();
			chromeOptions.addArguments("test-type");
			chromeOptions.addArguments("start-maximized");
			chromeOptions.addArguments("--incognito");
			chromeOptions.addArguments("--disable-web-security");
			chromeOptions.addArguments("--allow-running-insecure-content");
			driver = new ChromeDriver(chromeOptions);
			driver.get(PropFileHandler.readProperty("url"));
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(180, TimeUnit.SECONDS);
			// driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

			break;

		case ("firefox"):
			System.out.println("In firefox configuration");
			System.setProperty("webdriver.gecko.driver", driverPathFF);
			driver = new FirefoxDriver();
			driver.get(PropFileHandler.readProperty("url"));
			break;

		case ("edge"):
			System.out.println("In edge configuration");
			System.setProperty("webdriver.edge.driver", driverPathEdge);
			driver = new EdgeDriver();
			driver.get(PropFileHandler.readProperty("url"));
			break;

		}

		return driver;
	}

	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);

	}

}
