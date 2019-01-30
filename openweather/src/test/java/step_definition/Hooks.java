package step_definition;

import java.net.MalformedURLException;


import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wiprodigital.openweather.helpers.WebDriverHelper;

import cucumber.api.Scenario;
import cucumber.api.java8.En;



public class Hooks implements En {
	 public static ChromeDriver driver ;
public Hooks() {
	 
		/*
		 * Before( () -> {
		 * 
		 * System.out.println("Called openBrowser");
		 * System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 * driver = new ChromeDriver(); driver.manage().deleteAllCookies(); });
		 */
/*	@Before
	public void openBrowser() throws MalformedURLException {
		System.out.println("Called openBrowser");
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		 driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
	}*/

	

	After((Scenario scenario) -> {
		
		if (scenario.isFailed()) {
			try {
				scenario.write("Current Page URL is " + WebDriverHelper.getWebDriver().getCurrentUrl());
				byte[] screenshot = ((TakesScreenshot) WebDriverHelper.getWebDriver()).getScreenshotAs(OutputType.BYTES);
				scenario.embed(screenshot, "image/png");
			} catch (WebDriverException somePlatformsDontSupportScreenshots) {
				System.err.println(somePlatformsDontSupportScreenshots.getMessage());
			}
		}
		WebDriverHelper.getWebDriver().quit();
	});
	
}

}
