package com.cydeo.step_definitions;

import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.sql.SQLOutput;

/*
W we will be able to create "pre" and "post" conditions
for all the SCENARIOS and evenn STEPS
 */
public class Hooks {
    //import the @Before coming from io.cucumber.java
    @Before (order = 1)
    public void setupMethod(){
        System.out.println("---> @Before:RUNNING BEFORE EACH SCENARIO");
    }
    @Before (value = "@login", order = 2)
    public void login_scenario_before(){
        System.out.println("---> @Before:RUNNING BEFORE EACH SCENARIO");
    }
    //@after will be executed after every scenario
    @After
    public void teardownMethod(Scenario scenario){

        if(scenario.isFailed()) {

            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        System.out.println("---> @After: RUNNING AFTER EACH STEPS");
        Driver.closeDriver();
    }

   // @BeforeStep
    public void setupStep(){
        System.out.println("----->@BeforeStep:Running after each step");

    }
   // @AfterStep
    public void teardownStep(){
        System.out.println("-----> @AfterStep : Running after each step");
    }

}
