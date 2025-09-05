package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    //1 - create the constructor and initialize the driver with object
    public GoogleSearchPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    //2 - use @FindBy instead of findElement()
    @FindBy (name = "q")
    public WebElement searchBox;
}
