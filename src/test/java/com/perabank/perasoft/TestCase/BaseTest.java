package com.perabank.perasoft.TestCase;

import com.perabank.perasoft.Pages.BasePage;
import com.perabank.perasoft.Pages.Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;

    protected Properties properties;
    public BaseTest ()  {
        properties=new Properties();
        String filePath=System.getProperty("user.dir")+"/src/test/resources/config.properties";
        try {
            FileInputStream inputStream=new FileInputStream (filePath);

                properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) { 
            throw new RuntimeException(e);
        }
    }

    @BeforeMethod

    public void setUpBrowser(){
        driver=new FirefoxDriver();
        driver.get("https://parabank.parasoft.com/");
        driver.manage().window().maximize();

        page= new BasePage(driver);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
