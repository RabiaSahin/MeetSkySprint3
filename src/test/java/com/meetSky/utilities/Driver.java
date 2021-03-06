package com.meetSky.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor, so we are closing
    access to the object of this class from outside the class
     */
    private Driver(){}

    /*
    We make WebDriver private, because we want to close access from outside the class.
    We make it static because we will use it in a static method.
     */
   // private static WebDriver driver; // value is null by default

    private static InheritableThreadLocal<WebDriver> driverPoll = new InheritableThreadLocal<>();

    /*
    Create a re-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver(){

        if (driverPoll.get() == null){  //   if (driver == null){
            /*
            We read our browserType from configuration.properties.
            This way, we can control which browser is opened from outside our code, from configuration.properties.
             */
            String browserType = ConfigurationReader.getProperty("browser");

            /*
                Depending on the browserType that will be return from configuration.properties file
                switch statement will determine the case, and open the matching browser
            */
            switch (browserType){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPoll.set(new ChromeDriver());      //driver = new ChromeDriver();
                    driverPoll.get().manage().window().maximize();    //driver.manage().window().maximize();
                    driverPoll.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPoll.set(new FirefoxDriver());    //driver = new FirefoxDriver();
                    driverPoll.get().manage().window().maximize();    //driver.manage().window().maximize();
                    driverPoll.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }

        return driverPoll.get();  //return driver;

        //driver.quit() --> nosuchsession
        //driver.close() -->

    }
    /*
   This method will make sure our driver value is always null after using quit() method
    */
    public static void closeDriver(){
        if (driverPoll.get() != null){
            driverPoll.get().quit(); // this line will terminate the existing session. value will not even be null
            driverPoll.remove();
            }

     //   if (driver != null){
     //       driver.quit(); // this line will terminate the existing session. value will not even be null
     //       driver = null;
     //   }

    }
}
