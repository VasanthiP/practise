package com.msys.angular.ui.helpers;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {
	
	public static int timeout;
	public static WebDriverWait wait;

	public Wait() {
		timeout = Integer.parseInt(Browser.prop.getProperty("ExplicitTimeout"));
		wait = new WebDriverWait(Browser.driver, timeout);
	}

	/*******************************************************************************************************************************************************************************************************************
	 * 'Created By : kamarv1 'Created On : 09-april-2019 'Last Updated By : NA
	 * 'Last Updated On : NA 'Parameters Used : ele-webelement 'Purpose : wait
	 * till element to be clikable 'Steps:
	 * 
	 * @throws CustomizedException
	 ************************************************************************************************************************************************************************************************************************/
	public static void elementToBeClikable(WebElement ele)
			throws CustomizedException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (TimeoutException e) {
			throw new CustomizedException(
					"Element is not visible in time limit: " + ele);
		} catch (WebDriverException e) {
			throw new CustomizedException(
					"element is not visible or Clikable state." + ele);
		}

	}

	/*******************************************************************************************************************************************************************************************************************
	 * 'Created By : kamarv1 'Created On : 09-april-2019 'Last Updated By : NA
	 * 'Last Updated On : NA 'Parameters Used : element - webelement 'Purpose :
	 * wait till element not visible on page 'Steps:
	 * 
	 * @throws CustomizedException
	 ************************************************************************************************************************************************************************************************************************/
	public static void inVisibilityOfElement(WebElement element)
			throws CustomizedException {
		try {
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			throw new CustomizedException(e.getMessage());
		}

	}




}
