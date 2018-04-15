package com.wbl.stepdefinitions;

import org.openqa.selenium.WebDriver;

import com.wbl.helper.WebDriverUtil;
import com.wbl.helper.ConfigUtils;
import com.wbl.helper.Constants;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks{

	public static WebDriver driver;
	protected static String url;
	protected static String browser;

	static {
		ConfigUtils configUtils = new ConfigUtils(Constants.RESOURCES_PROPERTIES_PATH + "config.properties");
		url = configUtils.getProperty("qaUrl");
		browser = configUtils.getProperty("browser");
	}

	@Before
	public void before() {
		System.out.println("In BEFORE METHOD!!!");
		driver = WebDriverUtil.getDriver(browser);
		driver.get(url);
		driver.manage().window().maximize();
	}

	@After
	public void after() {
		System.out.println("In AFTER METHOD!!!");
		driver.quit();
	}

}
