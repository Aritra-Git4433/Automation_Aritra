package StepDefinition;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.TestBase;
import Utilities.actionMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchFunctionality{
	
	actionMethods am = new actionMethods(TestBase.driver);
	
	
	@Given("User is on the HomePage")
	public void user_is_on_the_home_page() throws InterruptedException {
		TestBase.driver.get("https://www.amazon.in/");
	    String s = TestBase.driver.getCurrentUrl();
	    System.out.println(s);
	    Assert.assertEquals(s,"https://www.amazon.in/");
	    
	}

	@When("User clicks and searches for an item")
	public void user_clicks_and_searches_for_an_item() {
	  TestBase.driver.findElement(By.xpath("//input[contains(@placeholder,'Search Amazon.in')]")).sendKeys(Keys.chord(Keys.SHIFT,"porn videos"));
	  TestBase.driver.findElement(By.xpath("//input[@value='Go']")).click();
	  
	}

	@And("User navigates to the results window")
	public void user_navigates_to_the_results_window() {
	    String searched= TestBase.driver.findElement((By.xpath(".//span[contains(text(),'PORN VIDEOS')]"))).getText().replaceAll("\"","");	
	    Assert.assertEquals(searched, "PORN VIDEOS");
	}

	@Then("User applies different filters and narrows down the search")
	public void user_applies_different_filters_and_narrows_down_the_search() throws InterruptedException {
	    TestBase.driver.findElement(By.xpath(" //li[@id='p_n_feature_three_browse-bin/9141482031']")).click();
	    TestBase.driver.findElement(By.xpath("//span[@class='a-size-base a-color-base'][normalize-space()='English']")).click();
	    WebElement scrolltoElement= TestBase.driver.findElement(By.xpath("//span[contains(text(),'Your Brain on Porn: Internet Pornography and the Emerging Science of Addiction')]"));
	    am.scroll(scrolltoElement);
	    if(scrolltoElement.isDisplayed()==false) {
	    	List<WebElement> indexes=TestBase.driver.findElements(By.xpath("//span[@role='button'][normalize-space()='Previous']/following-sibling::li"));
	    	for(WebElement ele : indexes) {
	    		ele.click();
	    	}
	    }
	    String s= scrolltoElement.getText();
	    Assert.assertEquals(s,"Your Brain on Porn: Internet Pornography and the Emerging Science of Addiction");
	    scrolltoElement.click();
	}

	@When("User clicks on Searchbutton")
	public void user_clicks_on_searchbutton() throws InterruptedException {
		Thread.sleep(1000);
	    TestBase.driver.findElement(By.xpath("//input[@id='nav-search-submit-button']")).click();
	    
	    		}

	@But("User stays in the same page")
	public void user_stays_in_the_same_page() {
		String getUrl= TestBase.driver.getCurrentUrl();
	    Assert.assertEquals(getUrl,"https://www.amazon.in/");
	}

	@When("User searches for an non existent item")
	public void user_searches_for_an_non_existent_item() {
		 TestBase.driver.findElement(By.xpath("//input[contains(@placeholder,'Search Amazon.in')]")).sendKeys("Ge ui ka La ma Kaso");
		 TestBase.driver.findElement(By.xpath("//input[@value='Go']")).click();
		 
	}

	@Then("Checks the auto correction happening and user selects the non existent item instead")
	public void checks_the_auto_correction_happening_and_user_selects_the_non_existent_item_instead() {
		String noResult= TestBase.driver.findElement(By.xpath("//div[@class='s-no-outline']//div[@class='a-row']")).getText();
	    Assert.assertEquals(noResult.substring(15,noResult.length()-1),"Ge ui ka La ma Kaso");
			
	}

	@And("User sees no results found page")
	public void user_sees_no_results_found_page() {
		//List<WebElement> relatedSearches=TestBase.driver.findElements(By.xpath("//div[@role='listitem']"));
		//relatedSearches.get(3).click();
		//String autoSearchtobe=relatedSearches.get(3).getText();
	    String autoSearched=(TestBase.driver.findElement(By.xpath("//div[@class='s-no-outline']//div[@class='a-row']")).getText());
	    Assert.assertEquals(autoSearched.substring(15,autoSearched.length()-1),"Ge ui ka La ma Kaso");
	    
	}

	@When("User enters letters in the search box")
	public void user_enters_letters_in_the_search_box() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@And("User checks auto completion results from the drop-down")
	public void user_checks_auto_completion_results_from_the_drop_down() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("User clicks on the sixth auto completed result from the drop-down")
	public void user_clicks_on_the_sixth_auto_completed_result_from_the_drop_down() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}




}
