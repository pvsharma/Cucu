package com.wiprodigital.openweather.helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class WebDriverHelper extends EventFiringWebDriver {

	private static WebDriver REAL_DRIVER = null;
	static {

		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		REAL_DRIVER = new ChromeDriver();

	}

	private WebDriverHelper() {
		super(REAL_DRIVER);
	}

	public static WebDriver getWebDriver() {
		return REAL_DRIVER;
	}
	



}