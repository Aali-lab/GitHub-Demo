package com.testcases;

import org.testng.annotations.Test;

import util.CommonFunctions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginTest extends CommonFunctions {

	@Test

	public void test() {
		launchBrowser();
		navigateToURL("https://www.saucedemo.com/");
		sendKeys("standard_user", "//input[@id='user-name']");
		sendKeys("secret_sauce", "//input[@id='password']");
		clickOnElement("//input[@id='login-button']");

	}
}
