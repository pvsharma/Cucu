package step_definition;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java8.En;

public class GetWeatherForACity implements En{
	ArrayList<String> days = new ArrayList<>();
	ArrayList<String> temperature = new ArrayList<>();
	ArrayList<String> wind = new ArrayList<>();
	ArrayList<String> rain = new ArrayList<>();
	
	public ChromeDriver driver; 
	
	public GetWeatherForACity() 
	{ 
		
		driver= Hooks.driver;
		
	Given("^I launch the weather page$", () -> {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println(driver==null);
		driver.get("http://localhost:3000/index.html");
		driver.manage().window().maximize();
	});

	When("^I give the city$", () -> {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElementById("city").clear();
		driver.findElementById("city").sendKeys("Perth");
		driver.findElementById("city").submit();
	});

	Then("^I should see the weather forecast for (\\d+) days$", (Integer arg1) -> {
	    // Write code here that turns the phrase above into concrete actions
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
			assertEquals(5, days.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	});

	Then("^Each day should have (\\d+) parameters$", (Integer arg1) -> {
		 System.out.println("Yet to implment");
	   
	});

	
	
	
	
	
	
	
	} 
	



}
