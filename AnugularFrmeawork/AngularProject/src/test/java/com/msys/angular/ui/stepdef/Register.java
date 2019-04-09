package com.msys.angular.ui.stepdef;



import org.testng.Assert;

import com.msys.angular.ui.helpers.Browser;
import com.msys.angular.ui.pageobjects.RegisterPO;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Register extends Browser{
	
	RegisterPO register = new RegisterPO();
	
	public Register() throws Exception {
		super();
	}

	
	@When("^User enter \"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\",\"([^\"]*)\" and click on RegisterButton$")
	public void user_enter_and_click_on_RegisterButton(String strFirtName, String strLastName, String strUserName, String strPassword) throws Throwable {
		register.RegisterLogin(strFirtName, strLastName, strUserName, strPassword);
	}

	@Then("^Verify  \"([^\"]*)\"$")
	public void verify(String strExpectedMessage) throws Throwable {
		Assert.assertEquals(strExpectedMessage,register.VerifySuccessfullRegistration());
	
	}


}
