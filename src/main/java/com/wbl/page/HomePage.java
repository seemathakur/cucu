package com.wbl.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.PageObject;

public class HomePage extends PageObject{

	public HomePage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".navbar-right a")
	WebElement loginButton;
	
	@FindBy(css=".nav.navbar-nav.navbar-nav-margin-left>li>a")
	List<WebElement> headerLinks;
	
	public LoginPage clickLogin(){
		loginButton.click();
		return new LoginPage(driver);
	}
	
	
	public int noOfLinks(){
		return headerLinks.size();
	}
}
