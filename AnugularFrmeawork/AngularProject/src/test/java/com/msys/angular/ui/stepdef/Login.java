package com.msys.angular.ui.stepdef;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;

import com.cucumber.listener.Reporter;
import com.msys.angular.ui.TestRunner.TestRunner;
import com.msys.angular.ui.helpers.Browser;
import com.msys.angular.ui.helpers.Generic;
import com.msys.angular.ui.pageobjects.LoginPO;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login extends Browser {
	
    Generic  gen = new Generic();
    LoginPO login = new LoginPO();
    
	public Login() throws Exception {
		super();
	}

	@Given("^User Navigate to the application$")
	public void user_Navigate_to_the_application() throws Throwable {
	
	
	}
	
	@When("^User click on \"([^\"]*)\" button$")
	public void user_click_on_button(String strLinkName) throws Throwable {
		Generic.webClick(Generic.FindElementByLinkText(strLinkName));
	}
	
	
	@When("^Uesr login with Registered Credentials \"([^\"]*)\",\"([^\"]*)\" and click on login button$")
	public void uesr_login_with_Registered_Credentials_and_click_on_login_button(String strUserName, String strPassword) throws Throwable {
		login.LoginUser(strUserName, strPassword);
	}
	
	@Then("^Verify Login is sucessful with \"([^\"]*)\" is displayed$")
	public void verify_Login_is_sucessful_with_is_displayed(String strTitle) throws Throwable {
		Assert.assertTrue(login.VerifyLogin(strTitle));
	}

	
	 @After
	    public void embedScreenshot(Scenario scenario) throws IOException {
	        if (scenario.isFailed()) {
	            String strDestinationPath = TestRunner.strFolderName + "\\Screenshots\\Screenshot_"
	                    + Generic.getCuttentTimeStamp() + ".png";
	            System.out.println(strDestinationPath);
	            File destination = new File(strDestinationPath);
	            File scrFile = ((TakesScreenshot) Browser.driver).getScreenshotAs(OutputType.FILE);
	            FileUtils.copyFile(scrFile, destination.getAbsoluteFile());
	            Reporter.addScreenCaptureFromPath(strDestinationPath);
	        }
	    }


}
