package com.wbl.stepdefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.wbl.page.HomePage;
import com.wbl.page.LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSmokeTest {

	WebDriver driver;
	HomePage hm;
	LoginPage lp;
	String actualresp;
	static{
	//load data from excel
	//list of java pojo objects
	}
	
	@Given("^User is able to access TalentScreen HomePage and Click Login button$")
	public void user_is_able_to_access_TalentScreen_HomePage_and_Click_Login_button() throws Throwable {
		driver = Hooks.driver;
		hm = new HomePage(driver);
		lp = hm.clickLogin();
	}

	
	@When("^User Click enters credentials\\.$")
	public void user_Click_enters_credentials(DataTable userdata) throws Throwable {
		//list of map- rows and columns-- list is rows, map is columns(key value pairs)
		List<Map<String,String>> logindata=userdata.asMaps(String.class, String.class);
		actualresp = lp.login(logindata.get(0).get("name"), logindata.get(0).get("password"));
	}

	@When("^User Click Submit button$")
	public void user_Click_Submit_button() throws Throwable {
		System.out.println("click sunmit button");
	}
	
	@Then("^User should be navigated to Login Success Home page\\.$")
	public void user_should_be_navigated_to_Login_Success_Home_page() throws Throwable {
		Assert.assertNotNull(actualresp);
	}


	@When("^User Click on  \"([^\"]*)\"  button$")
	public void user_Click_on_button(String socialLogin) throws Throwable {
		switch (socialLogin) {
		case "Facebook":
			lp.clickFacebookLogin();
			break;
		case "Google":
			lp.clickGoogleLogin();
			break;
		/*
		 * case "twitter":lp.clickFacebookLogin(); break;
		 */
		default:
			lp.clickFacebookLogin();

		}

	}

	@Then("^User should see a new \"([^\"]*)\" window\\.$")
	public void user_should_see_a_new_window(String loginWindow) throws Throwable {
		Assert.assertTrue(driver.getWindowHandles().size() > 1);
	}

}
