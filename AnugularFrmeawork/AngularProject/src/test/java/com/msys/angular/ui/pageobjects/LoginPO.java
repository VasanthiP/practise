package com.msys.angular.ui.pageobjects;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.msys.angular.ui.helpers.Browser;
import com.msys.angular.ui.helpers.CustomizedException;
import com.msys.angular.ui.helpers.Generic;

import cucumber.api.Scenario;

public class LoginPO {
	
	    @FindBy(xpath = "//input[@formcontrolname='username']")
	    WebElement enterUserName;
	    @FindBy(xpath = "//input[@formcontrolname='password']")
	    WebElement enterPassword;
	    @FindBy(xpath = "//button[@class='btn btn-primary']")
	    WebElement clickLoginBtn;
	   
	    WebDriver driver;
	    Scenario scenario;
	    Generic gen = new Generic();
	
	  

	    public LoginPO() throws Exception {
	        this.driver = Browser.driver;
	        PageFactory.initElements(Browser.driver, this);

	    }

	    /*******************************************************************************************************************************************************************************************************************
	     This function will login to Application
	     ************************************************************************************************************************************************************************************************************************/
	    public void LoginUser(String strUserName,String strPassword) throws CustomizedException, IOException {		
	            Generic.webEnter(enterUserName,strUserName);
	            Generic.webEnter(enterPassword,strPassword);
	            Generic.webClick(clickLoginBtn);
	            Generic.waitForPageLoaded();
	    }
	    
	    
	    /*******************************************************************************************************************************************************************************************************************
	     This function will verify the Login Page
	     ************************************************************************************************************************************************************************************************************************/
	    public boolean VerifyLogin(String strTitle) throws Exception{
	    	boolean blnLoginStatus = false;
	    	
	    	List<WebElement> list = Generic.findElementsByTagName("p");
	    	for(int i=0;i<=list.size()-1;i++){
	    		if(list.get(i).getText().contains(strTitle)){
	    			blnLoginStatus = true;
	    			break;
	    			
	    		}
	    	}
			return blnLoginStatus;   	
	    }

	
	}


