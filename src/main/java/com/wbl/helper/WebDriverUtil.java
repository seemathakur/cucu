package com.wbl.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

public class WebDriverUtil {


	static Logger log = LogManager.getLogger(WebDriverUtil.class);
	//Factory Design pattern
	public static WebDriver getDriver(String browsername){
		WebDriver driver =null;
		log.info("In get driver method - browser :"+browsername);
		try{
		
			switch(browsername){
			
			case "chrome":
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
				break;
				
			case "firefox":
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
				break;
				
			case "ie":
				System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/resources/drivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
				
			case "htmlunit":
				driver = new HtmlUnitDriver();
				break;
				
			case "phantom":
				System.setProperty("phantomjs.binary.path", System.getProperty("user.dir") + "/resources/drivers/phantomjs.exe");
				driver = new PhantomJSDriver();
				break;

			default:
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			
		}catch(Exception e){
			log.error("There is an exception when creting WebDriver object");
			log.error(e.getStackTrace());
		}
		return driver;		
	}
}
