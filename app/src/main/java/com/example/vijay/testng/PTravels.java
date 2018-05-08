package com.example.vijay.testng;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.jar.Attributes;

import io.appium.java_client.android.AndroidDriver;

import static java.util.jar.Attributes.*;

/**
 * Created by vijay on 07-May-18.
 */

public class PTravels {
    AndroidDriver driver;

    @BeforeTest
    public  void capabilities() throws MalformedURLException {
        System.out.println("Before");
        //File appDir = new File("src/test/java/com.example.vijay.myapplication");
        //File app = new File(appDir, "ApiDemos-debug.apk");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "Android Device");
        capabilities.setCapability("automationName","uiautomator2");
        // capabilities.setCapability("app", "E:\\Users\\vijay\\AndroidStudioProjects\\MyApplication\\app\\src\\test\\java\\com\\example\\vijay\\myapplication\\ApiDemos-debug.apk");
        capabilities.setCapability("appPackage", "com.ptravels");
        capabilities.setCapability("appActivity", "com.ptravels.splash.presentation.SplashActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
    }

    @Test
    public void flogin() throws InterruptedException {
        driver.findElementById("com.ptravels:id/hamburgerMenuIv").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Sign Up / Log in']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Login using Facebook']").click();
        WebElement toastView = driver.findElementByXPath("//android.widget.Toast[1]");
        String text = toastView.getAttribute("name");
        System.out.println(text);
    }
    @AfterMethod
    public void loggout() throws InterruptedException {
        driver.findElementById("com.ptravels:id/hamburgerMenuIv").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Logout']").click();
        System.out.println(" LOGOUT Executes after every test");
        Thread.sleep(3000);
    }

    @Test
    public void glogin() {
        driver.findElementById("com.ptravels:id/hamburgerMenuIv").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Sign Up / Log in']").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Login using Google']").click();
        driver.findElementById("com.google.android.gms:id/account_name").click();
        WebElement toastView = driver.findElementByXPath("//android.widget.Toast[1]");
        String text2 = toastView.getAttribute("name");
        System.out.println(text2);
    }

    @Test
    public void signup() throws InterruptedException {
        driver.findElementById("com.ptravels:id/hamburgerMenuIv").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Sign Up / Log in']").click();
        driver.findElementById("com.ptravels:id/signUpBtn").click();
        List<WebElement> a=driver.findElementsByClassName("android.widget.EditText");
        driver.findElementById("com.ptravels:id/signUpBtn").click();
        a.get(0).sendKeys("vijay12358");
        driver.findElementById("com.ptravels:id/signUpBtn").click();
        a.get(1).sendKeys("9035253309");
        driver.findElementById("com.ptravels:id/signUpBtn").click();
        String gmail = getSaltString()+"@gmail.com";
        a.get(2).sendKeys(gmail);
        driver.findElementById("com.ptravels:id/signUpBtn").click();
        a.get(3).sendKeys("vijay12358");
        driver.findElementById("com.ptravels:id/signUpBtn").click();
        driver.findElementById("com.ptravels:id/loginBtn").click();
           List<WebElement> b = driver.findElementsByClassName("android.widget.EditText");
           b.get(1).sendKeys("vijay12358");
           driver.findElementById("com.ptravels:id/loginBtn").click();

    }

    @Test
    public void login()
    {
        driver.findElementById("com.ptravels:id/hamburgerMenuIv").click();
        driver.findElementByXPath("//android.widget.TextView[@text='Sign Up / Log in']").click();
        driver.findElementById("com.ptravels:id/signInBtn").click();
        List<WebElement> b=driver.findElementsByClassName("android.widget.EditText");
        b.get(0).sendKeys("vijay12358@yopmail.com");
        b.get(1).sendKeys("vijay12358");
        driver.findElementById("com.ptravels:id/loginBtn").click();
    }

    protected String getSaltString() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 10) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;

    }
   @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
