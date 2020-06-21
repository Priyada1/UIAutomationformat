package com.pageObjects;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.Status;
import com.base.utilities.BaseClass;
import com.base.utilities.WebdriverActions;

public class ClooudThingWelcomePage {
	
	BaseClass base ;
    Map<String,Map<String,String>> objectLocators;
    WebDriver driver;
    WebdriverActions actions;

    public ClooudThingWelcomePage(String pageLocatorFile){
        this.base = BaseClass.getInstance();
        this.actions = WebdriverActions.getInstance();
        try {
            objectLocators = base.getMapper().readValue(new File(pageLocatorFile).getAbsoluteFile(), HashMap.class);
            driver = base.getWebDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    
    public void getTheWelcomePage(String url) {
        try {
            driver.get(url);
            base.getTestCase().log(Status.INFO, "Landed on "+url);
        }catch (Exception e){
            throw new RuntimeException("failed to navigate to"+url+" : " +e);
        }
    }

}
