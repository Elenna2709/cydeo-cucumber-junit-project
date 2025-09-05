package com.cydeo.step_definitions;

import com.cydeo.pages.GoogleSearchPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.text.BreakIterator;

public class Google_StepDefinitions {
    GoogleSearchPage googleSearchPage=new GoogleSearchPage();

    @When("user searches for {word}")
    public void user_searches_for_apple(String word) {
        googleSearchPage.searchBox.sendKeys(word+ Keys.ENTER);
    }

    @Then("user should see {word} in th title")
    public void user_should_see_apple_in_th_title(String word) {
        BrowserUtils.sleep(10);
        BrowserUtils.verifyTitle(word+" - Google Search");


    }

    @When("user is on the Google search page")
    public void user_is_on_the_google_search_page() {
        Driver.getDriver().get("https://www.google.com");
    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String actualTiitle=Driver.getDriver().getTitle();
        String expectedTitle = "Google";

        Assert.assertEquals(actualTiitle,expectedTitle);

        Driver.closeDriver();

    }

  //  @And("user sees {int} apples")
  //  public void userSeesApples(int arg0) {
  //  }
}
