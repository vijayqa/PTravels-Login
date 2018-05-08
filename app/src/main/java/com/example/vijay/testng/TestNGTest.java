package com.example.vijay.testng;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.android.AndroidDriver;

/**
 * Created by vijay on 04-May-18.
 */

public class TestNGTest {

    AndroidDriver driver;

    @BeforeTest
    public  void capabilities() throws MalformedURLException {
        System.out.println("Before");
        //File appDir = new File("src/test/java/com.example.vijay.myapplication");
        //File app = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        // capabilities.setCapability("app", "E:\\Users\\vijay\\AndroidStudioProjects\\MyApplication\\app\\src\\test\\java\\com\\example\\vijay\\myapplication\\ApiDemos-debug.apk");
        capabilities.setCapability("appPackage", "io.appium.android.apis");
        capabilities.setCapability("appActivity", "io.appium.android.apis.ApiDemos");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @BeforeMethod
    public  void Btest()
    {
        System.out.println("Execute before every Test");
    }

    @Test
    public void test()
    {
        System.out.println("First Test");
        driver.findElementByXPath("//android.widget.TextView[@text='Graphics']").click();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Regions\"));").click();
    }
    @Test
    public void test2()
    {
        System.out.println("Second Test");
    }

    @AfterTest
    public void tearDown() {
        System.out.println("After");
        driver.quit();
    }


}

