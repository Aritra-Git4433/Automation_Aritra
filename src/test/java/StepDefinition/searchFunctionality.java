package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utilities.TestBase;
import Utilities.actionMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchFunctionality {

	actionMethods am = new actionMethods(TestBase.driver);

	@Given("User is on the HomePage")
	public void user_is_on_the_home_page() throws InterruptedException {
		TestBase.driver.get("https://www.amazon.in/");
		String s = TestBase.driver.getCurrentUrl();
		System.out.println(s);
		Assert.assertEquals(s, "https://www.amazon.in/");

	}

	@When("User clicks and searches for an item")
	public void user_clicks_and_searches_for_an_item() {
		TestBase.driver.findElement(By.xpath("//input[contains(@placeholder,'Search Amazon.in')]"))
				.sendKeys(Keys.chord(Keys.SHIFT, "porn videos"));
		TestBase.driver.findElement(By.xpath("//input[@value='Go']")).click();

	}

	@And("User navigates to the results window")
	public void user_navigates_to_the_results_window() {
		String searched = TestBase.driver.findElement((By.xpath(".//span[contains(text(),'PORN VIDEOS')]"))).getText()
				.replaceAll("\"", "");
		Assert.assertEquals(searched, "PORN VIDEOS");
	}

	@Then("User applies different filters and narrows down the search")
	public void user_applies_different_filters_and_narrows_down_the_search() throws InterruptedException {
		TestBase.driver.findElement(By.xpath(" //li[@id='p_n_feature_three_browse-bin/9141482031']")).click();
		TestBase.driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='English']"))
				.click();

		WebDriverWait wait = new WebDriverWait(TestBase.driver, Duration.ofSeconds(5));
		// WebDriverWait wait1=(WebDriverWait) new
		// FluentWait<>(TestBase.driver).withTimeout(Duration.ofSeconds(5)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		while (true) {
			try {
				// Always freshly locate the element inside try
				WebElement scrollToElement = wait.until(ExpectedConditions.presenceOfElementLocated(
						By.xpath("//span[contains(text(),'Porn Archives')]")));

				wait.until(ExpectedConditions.elementToBeClickable(scrollToElement));
				am.scroll(scrollToElement);
				String text = scrollToElement.getText();
				System.out.println(text);
				Assert.assertEquals(text, "Porn Archives");
				scrollToElement.click();
				break;

			} catch (TimeoutException | NoSuchElementException | StaleElementReferenceException e) {
				System.out.println("Element not found or stale on current page. Moving to next page.");

				// Attempt to click on the 'Next' button if it's available
				try {
					// Locate and ensure that the "Next" button is clickable
					WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(
							By.xpath("//a[@role='button'][normalize-space()='Next']")));

					if (nextButton.isEnabled()) {
						nextButton.click(); // Click on Next to go to the next page
						System.out.println("Moved to next page.");

					} else {
						System.out.println("No more pages to navigate.");
						break; // Exit the loop if no more pages are available
					}

				} catch (NoSuchElementException | TimeoutException ex) {
					System.out.println("Next button not found or timeout while navigating.");
					break; // Exit if the "Next" button is not found or navigation fails
				}
			}
		}
	}

	/*
	 * TestBase.driver.findElement(By.
	 * xpath(" //li[@id='p_n_feature_three_browse-bin/9141482031']")).click();
	 * TestBase.driver.findElement(By.
	 * xpath("//span[@class='a-size-base a-color-base'][normalize-space()='English']"
	 * )).click();
	 * 
	 * WebDriverWait wait = new
	 * WebDriverWait(TestBase.driver,Duration.ofSeconds(10));
	 * while(true) {
	 * try {
	 * WebElement
	 * scrolltoElement=wait.until(ExpectedConditions.refreshed(ExpectedConditions.
	 * presenceOfElementLocated(By.
	 * xpath("//span[contains(text(),'Your Brain on Porn: Internet Pornography and the Emerging Science of Addiction')]"
	 * ))));
	 * wait.until(ExpectedConditions.elementToBeClickable(scrolltoElement));
	 * am.scroll(scrolltoElement);
	 * String s= scrolltoElement.getText();
	 * Assert.assertEquals(
	 * s,"Your Brain on Porn: Internet Pornography and the Emerging Science of Addiction"
	 * );
	 * scrolltoElement.click();
	 * break;
	 * }
	 * catch (TimeoutException | NoSuchElementException |
	 * StaleElementReferenceException e){
	 * System.out.println("Element not found on current page.");
	 * WebElement scrolltoElement=TestBase.driver.findElement(By.
	 * xpath("//span[contains(text(),'Your Brain on Porn: Internet Pornography and the Emerging Science of Addiction')]"
	 * ));
	 * wait.until(ExpectedConditions.elementToBeClickable(scrolltoElement));
	 * try {
	 * am.scroll(TestBase.driver.findElement(By.xpath(
	 * "//span[@role='button'][normalize-space()='Previous']/following-sibling::li")
	 * ));
	 * List<WebElement> indexes=TestBase.driver.findElements(By.xpath(
	 * "//span[@role='button'][normalize-space()='Previous']/following-sibling::li")
	 * );
	 * for(WebElement ele : indexes) {
	 * if(ele.isEnabled()) {
	 * ele.click();
	 * }
	 * else {
	 * System.out.println("The book is not available");
	 * }
	 * }
	 * }
	 * catch (NoSuchElementException ex) {
	 * System.out.println("No more pages to navigate.");
	 * break;
	 * }
	 * }
	 * }
	 * }
	 */

	@When("User clicks on Searchbutton")
	public void user_clicks_on_searchbutton() throws InterruptedException {
		Thread.sleep(1000);
		TestBase.driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();

	}

	@But("User stays in the same page")
	public void user_stays_in_the_same_page() {
		String getUrl = TestBase.driver.getCurrentUrl();
		Assert.assertEquals(getUrl, "https://www.amazon.in/");
	}

	@When("User searches for an non existent item")
	public void user_searches_for_an_non_existent_item() {
		TestBase.driver.findElement(By.xpath("//input[contains(@placeholder,'Search Amazon.in')]"))
				.sendKeys("Ge ui ka La ma Kaso");
		TestBase.driver.findElement(By.xpath("//input[@value='Go']")).click();

	}

	@Then("Checks the auto correction happening and user selects the non existent item instead")
	public void checks_the_auto_correction_happening_and_user_selects_the_non_existent_item_instead() {
		String noResult = TestBase.driver.findElement(By.xpath("//div[@class='s-no-outline']//div[@class='a-row']"))
				.getText();
		Assert.assertEquals(noResult.substring(15, noResult.length() - 1), "Ge ui ka La ma Kaso");

	}

	@And("User sees no results found page")
	public void user_sees_no_results_found_page() {
		// List<WebElement>
		// relatedSearches=TestBase.driver.findElements(By.xpath("//div[@role='listitem']"));
		// relatedSearches.get(3).click();
		// String autoSearchtobe=relatedSearches.get(3).getText();
		String autoSearched = (TestBase.driver
				.findElement(By.xpath("//div[@class='s-no-outline']//div[@class='a-row']")).getText());
		Assert.assertEquals(autoSearched.substring(15, autoSearched.length() - 1), "Ge ui ka La ma Kaso");

	}

}
