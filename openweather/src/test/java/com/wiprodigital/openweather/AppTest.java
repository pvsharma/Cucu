package com.wiprodigital.openweather;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class AppTest {

	ChromeDriver driver;

	@BeforeMethod
	@BeforeTest
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get("http://localhost:3000/index.html");
		driver.manage().window().maximize();
	}

	@AfterMethod
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

	@Test
	public void test() throws InterruptedException {
		driver.findElementById("city").clear();
		driver.findElementById("city").sendKeys("Perth");
		driver.findElementById("city").submit();
		Thread.sleep(5000);
		ArrayList<String> days = new ArrayList<String>();
		ArrayList<String> temperature = new ArrayList<String>();
		ArrayList<String> wind = new ArrayList<String>();
		ArrayList<String> rain = new ArrayList<String>();

		try {
			List<WebElement> el1 = driver.findElementsByXPath("//div[starts-with(@style,'padding-bottom')]");
			System.out.println("The size is " + el1.size());

			for (WebElement ele : el1) {
				String a = ele.getText();
				String[] lines = a.split("\\r?\\n");

				days.add(lines[0]);
				temperature.add(lines[1]);
				wind.add(lines[2]);
				rain.add(lines[3]);
				System.out.println(lines[0]);

				/*
				 * List<WebElement>
				 * ele2=ele.findElements(By.xpath("./div[@class='summary']/span"));
				 * System.out.println("Internal span size " + ele2.size() + " " );;
				 */

				/*
				 * for (WebElement summaryElement : ele2) {
				 * System.out.println(summaryElement.findElement(By.xpath(
				 * "./span/span[@class='name')]")).getTagName()); }
				 * System.out.println(ele.findElements(By.xpath("./div[@class='summary']/span"))
				 * .size()); System.out.println(ele.getAttribute("class"));
				 */
				System.out.println("");
				System.out.println("");
			}

			System.out.println("Days " + days);
			System.out.println("Temerature " + temperature);
			System.out.println("Wind " + wind);
			System.out.println("Rain " + rain);
			Assert.assertEquals(5, days.size());
			Assert.assertEquals(6, temperature.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
