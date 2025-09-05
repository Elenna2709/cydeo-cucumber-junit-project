package com.cydeo.pages;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VytrackLoginPage {

    public VytrackLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id="prependedInput")
    public WebElement usernameField;

    @FindBy(id="prependedInput2")
    public WebElement passwordField;

    @FindBy(id="_submit")
    public WebElement loginButton;

    public void loginAsDriver(){
        usernameField.sendKeys(ConfigurationReader.getProperty("driver_username"));
        passwordField.sendKeys(ConfigurationReader.getProperty("driver_password"));
        loginButton.click();
    }

    public void loginAsSalesManager() {
        usernameField.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
        passwordField.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
        loginButton.click();
    }

    public void loginAsStoreManager() {
        usernameField.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
        passwordField.sendKeys(ConfigurationReader.getProperty("store_manager_password"));
        loginButton.click();

        BrowserUtils.waitForVisibility(new VyDashboardPage().MainMenu,20);
    }

    public void login(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        loginButton.click();

        BrowserUtils.waitForVisibility(new VyDashboardPage().MainMenu,20);
    }
    public void login (String roleType){

        if(roleType.equals("driver")){
            usernameField.sendKeys(ConfigurationReader.getProperty("driver_username"));
            passwordField.sendKeys(ConfigurationReader.getProperty("driver_password"));
            loginButton.click();
        }else if (roleType.equals("sales manager")) {
            usernameField.sendKeys(ConfigurationReader.getProperty("sales_manager_username"));
            passwordField.sendKeys(ConfigurationReader.getProperty("sales_manager_password"));
            loginButton.click();

        }else if(roleType.equals("store manager")){
            usernameField.sendKeys(ConfigurationReader.getProperty("store_manager_username"));
            passwordField.sendKeys(ConfigurationReader.getProperty("store_manager_password"));
            loginButton.click();

        }else{
            System.out.println("NOT FOUND");
        }
        //roleType can be driver, sales manager or store manager
        //you will read the credentials from configuration.properties file
        BrowserUtils.waitForVisibility(new VyDashboardPage().MainMenu,20);

    }



}

