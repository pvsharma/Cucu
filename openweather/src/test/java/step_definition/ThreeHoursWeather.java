package step_definition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import cucumber.api.java8.En;

public class ThreeHoursWeather implements En {
	public ChromeDriver driver ; 
	public ThreeHoursWeather() {
		
		driver= Hooks.driver;

		
		Given("^The user has navigated to the weather of city Perth$", () -> {
			// Write code here that turns the phrase above into concrete actions
			try {
				System.out.println("Iam here 2");
				if(driver==null)
					System.out.println("I am null");
				driver.get("http://localhost:3000/index.html");
				driver.manage().window().maximize();
				driver.findElementById("city").clear();
				driver.findElementById("city").sendKeys("Perth");
				driver.findElementById("city").submit();
				
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		});

		When("^Clicked on the first date displyed for Perth$", () -> {
			driver.findElementByXPath("//span[@data-test='day-1']").click();
			int threeHoursdata=driver.findElementsByXPath("//div[@class='summary']//span[@data-test='date-1']/../../..//div[@class='details'][contains(@style,'max-height: 2000px')]").size();
			Assert.assertEquals(1, threeHoursdata);

		});

		Then("^Rows of weather forecast should be displayed with span for three hours$", () -> {
			// Write code here that turns the phrase above into concrete actions

		});

		Then("^All the rows should have the same number of columns as overall weather\\.$", () -> {

		});

	}
}
