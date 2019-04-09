package com.msys.angular.ui.pageobjects;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msys.angular.ui.helpers.Browser;
import com.msys.angular.ui.helpers.CustomizedException;
import com.msys.angular.ui.helpers.Generic;

import cucumber.api.Scenario;

public class RegisterPO {
	
	    @FindBy(xpath = "//input[@formcontrolname='firstName']")
	    WebElement enterFirstName;
	    @FindBy(xpath = "//input[@formcontrolname='lastName']")
	    WebElement enterLastName;
	    @FindBy(xpath = "//input[@formcontrolname='username']")
	    WebElement enterUserName;
	    @FindBy(xpath = "//input[@formcontrolname='password']")
	    WebElement enterPassword;
	    @FindBy(xpath = "//button[@class='btn btn-primary']")
	    WebElement clickRegisterbtn;
	    @FindBy(xpath = "//div[@class='alert alert-success']")
	    WebElement eleAlertMsg;

	    WebDriver driver;
	    Generic gen = new Generic();
	   
	    
	    public RegisterPO() throws Exception {
	        this.driver = Browser.driver;
	        PageFactory.initElements(Browser.driver, this);

	    }
	    
	    public void RegisterLogin(String strFirtName,String strLastName,String strUserName,String strPassword) throws CustomizedException, IOException{		
	    	Generic.webEnter(enterFirstName, strFirtName);
	    	Generic.webEnter(enterLastName, strLastName);
	    	Generic.webEnter(enterUserName,strUserName);
	    	Generic.webEnter(enterPassword,strPassword);
	    	Generic.webClick(clickRegisterbtn);
	    	
	    }
	    
	    public String  VerifySuccessfullRegistration() throws Exception{
	    	return Generic.getText(eleAlertMsg);
	    	
	    }

}
