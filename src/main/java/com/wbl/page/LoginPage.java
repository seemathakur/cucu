package com.wbl.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wbl.base.PageObject;

public class LoginPage extends PageObject{

	public LoginPage(WebDriver driver){
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="username")
	WebElement username;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(css=".btn.btn-primary")
	WebElement submitButton;
	
	@FindBy(css="[class*=btn-facebook]")
	WebElement facebookButton;
	
	@FindBy(css="[class*=btn-google]")
	WebElement googleButton;
	
	
	public String login(String name, String pwd){
		username.sendKeys(name);
		password.sendKeys(pwd);
		submitButton.click();
		return driver.getTitle();
	}
	
	public void clickFacebookLogin(){
		facebookButton.click();
	}
	
	public void clickGoogleLogin(){
		googleButton.click();
	}
}
