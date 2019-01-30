package step_definition;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.wiprodigital.openweather.helpers.WebDriverHelper;

import cucumber.api.java8.En;

public class ThreeHoursWeather implements En {
	public ChromeDriver driver;

	public ThreeHoursWeather() {

		this.driver = (ChromeDriver) WebDriverHelper.getWebDriver();

		Given("^The user has navigated to the weather of city Perth$", () -> {
			// Write code here that turns the phrase above into concrete actions
			try {
				System.out.println("Iam here 2");
				if (driver == null)
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
			int visibityOfFirstRecord = driver.findElementsByXPath(
					"//div[@class='summary']//span[@data-test='date-1']/../../..//div[@class='details'][contains(@style,'max-height: 2000px')]")
					.size();
			Assert.assertEquals(visibityOfFirstRecord, 0);

		});

		Then("^Rows of weather forecast should be displayed with span for three hours$", () -> {
			List<WebElement> timeForTheSelectedDate = driver.findElementsByXPath(
					"//div[@class='summary']//span[@data-test='date-1']/../../..//div[@class='details'][contains(@style,'max-height: 2000px')]//child::span[starts-with(@data-test,'hour-1')]");
			System.out.println("In THEN");
			List<Integer> a1 = new ArrayList<>();
			List<Integer> a2 = new ArrayList<>();

			for (WebElement w1 : timeForTheSelectedDate) {
				System.out.println(w1.getText());
				a1.add(Integer.parseInt(w1.getText()) / 100);
			}
			System.out.println("From UI " + a1);
			int firstItem = a1.get(0);
			a2.add(0, firstItem);
			for (int i = 0; i < timeForTheSelectedDate.size() - 1; i++) {

				a2.add(i + 1, a2.get(i) + 3);

			}
			System.out.println("From UI " + a2);
			Assert.assertEquals(true, (a1.equals(a2)));
			;
		});

		Then("^All the rows should have the same number of columns as overall weather\\.$", () -> {

		});

	}
}
