package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    //create a private constructor to remove accese th this object
    private Driver(){}

    /*
    we make the WebDriver private, because we want to close access from outside of the class
    We are making static because we will use it in a static method
     */
    private static WebDriver driver; // default value =null

    /*
    create a reusable utility method which will return the same driver instance once we call it
    -if an instance doesn't exist, it will create first, and then it will always return same instance
     */
    public static WebDriver getDriver(){

        if(driver== null){
            /*
            We will read our browserType from configuration.properties file
            This way, we can control which browser is opened from outside our code
             */
            String browserType=ConfigurationReader.getProperty("browser");

            /*
            Depanding on the browserType return from the configuration.properties
            switch statement will determine the "case", and open the matching browser
             */
            switch (browserType){
                case "chrome":
                  //  WebDriverManager.chromedriver().setup();
                    driver= new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    //WebDriverManager.firefoxdriver().setup();
                    driver= new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            }

        }
        return driver;
    }
    /*
    create a new Driver.closeDriver(); it will use .quit() method to quit browsers, and then set the driver value back to null
     */
    public static void closeDriver(){
        if(driver != null){
            //This line will terminate the currently existing driver completely. It will not exist going forward
            driver.quit();
            /*
            we assign the value back to "null" so that my "signleton" can create a newer one if needed
             */
            driver=null;
        }
    }
}


