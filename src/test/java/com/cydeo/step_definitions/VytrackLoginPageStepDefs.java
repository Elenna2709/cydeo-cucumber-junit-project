package com.cydeo.step_definitions;

import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class VytrackLoginPageStepDefs {

    VytrackLoginPage vytrackLoginPage=new VytrackLoginPage();

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("vyTrackUrl"));
    }
    @When("user enters the driver information")
    public void user_enters_the_driver_information() {

       /* vytrackLoginPage.usernameField.sendKeys(ConfigurationReader.getProperty("driver_username"));
        vytrackLoginPage.passwordField.sendKeys(ConfigurationReader.getProperty("driver_password"));
        vytrackLoginPage.loginButton.click();

        */
        vytrackLoginPage.loginAsDriver();

    }
    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
       // Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
        BrowserUtils.verifyTitleContains("Dashboard");

    }
    @When("user enters the sales manager information")
    public void user_enters_the_sales_manager_information() {
       vytrackLoginPage.loginAsSalesManager();
    }

    @When("user enters the store manager information")
    public void user_enters_the_store_manager_information() {
        vytrackLoginPage.loginAsStoreManager();
    }
    @When("user enters the username {string} and password {string}")
    public void user_enters_the_username_and_password(String username, String password) {
        //username=storemanager523
        //password=UserUser123
        vytrackLoginPage.login(username,password);
    }
    @When("user enters the {string} information")
    public void user_enters_the_information(String user) {
        vytrackLoginPage.login(user);

    }



}
