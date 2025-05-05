package StepDefinition;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.TestBase;
import Utilities.actionMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class sortingandFiltering{
	
	
	actionMethods am = new actionMethods(TestBase.driver);

	

	@When("User clicks on Mobile page")
	public void user_clicks_on_mobile_page() {
	  TestBase.driver.findElement(By.xpath("//a[contains(text(),'Mobiles')]")).click();
	  String mobileUrl=TestBase.driver.getCurrentUrl();
	  System.out.println(mobileUrl);
	  Assert.assertEquals("https://www.amazon.in/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles", mobileUrl);
	}
	@SuppressWarnings("deprecation")
	@And("Sorts it down with {string}")
	public void sorts_it_down_with(String brand) throws IOException, InterruptedException {
		
		WebDriverWait wait=new WebDriverWait(TestBase.driver,Duration.ofSeconds(5));
		Actions action = new Actions(TestBase.driver);
		
		WebElement filter=wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='" + brand + "']")));
		filter.click();
		//System.out.println(TestBase.driver.findElement(By.xpath("//a[@aria-label='Apply the filter " + brand + " to narrow results']//input[@type='checkbox']")).isSelected());
		
		
		WebElement dropdown=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.a-dropdown-container")));
		//TestBase.driver.switchTo().alert().dismiss();
		action.moveToElement(dropdown).click().perform();
		WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	    By.xpath("//a[contains(@id,'s-result-sort-select') and text()='Newest Arrivals']")));
		option.click();

		action.scrollToElement(TestBase.driver.findElement(By.xpath("//span[normalize-space()='Price']")));
		
		/*
		 * WebElement minSlider =
		 * wait.until(ExpectedConditions.elementToBeClickable(By.id(
		 * "p_36/range-slider_slider-item_lower-bound-slider"))); WebElement maxSlider =
		 * wait.until(ExpectedConditions.elementToBeClickable(
		 * By.id("p_36/range-slider_slider-item_upper-bound-slider"))); String
		 * valuePreset=TestBase.driver.findElement(By.xpath(
		 * "//label[@for='p_36/range-slider_slider-item_upper-bound-slider']/span[@class='a-size-base a-color-base a-text-bold']"
		 * )) .getText(); System.out.println(maxSlider.getLocation());
		 * am.moveSlider(maxSlider,200); System.out.println(maxSlider.getLocation());
		 * String valueSet=TestBase.driver.findElement(By.xpath(
		 * "//label[@for='p_36/range-slider_slider-item_upper-bound-slider']/span[@class='a-size-base a-color-base a-text-bold']"
		 * )) .getText(); System.out.println(valuePreset); System.out.println(valueSet);
		 */
		
		WebElement maxSlider = TestBase.driver.findElement(By.id("p_36/range-slider_slider-item_upper-bound-slider"));

		// Desired value to set (ensure it's within the slider's min and max range)
		String valueToSet = "130";
		System.out.println(maxSlider.getAttribute("value"));
		// Use JavaScript to set the value and dispatch input and change events
		JavascriptExecutor js = (JavascriptExecutor) TestBase.driver;
		js.executeScript(
		    "arguments[0].value = arguments[1];" +
		    "arguments[0].dispatchEvent(new Event('input', { bubbles: true }));" +
		    "arguments[0].dispatchEvent(new Event('change', { bubbles: true }));",
		    maxSlider, valueToSet
		);
		System.out.println(maxSlider.getAttribute("value"));
		TestBase.driver.findElement(By.xpath("//input[@aria-label='Go - Submit price range']")).click();
		
	}
	@Then("Click on a product and verify")
	public void click_on_a_product_and_verify() throws IOException {
		am.screenshotTaker();
	}
	

}
