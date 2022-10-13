package examples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class firstTest {

    AndroidDriver<MobileElement> driver;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        //DesiredCapabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "ZY224GR6WF");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", true);

        //Appium server url
        URL serverURL = new URL("http://localhost:4723/wd/hub");

        //Driver Initialisation
        driver = new AndroidDriver<>(serverURL, caps);

    }

    @Test
    public void additionWithCal() {
        MobileElement digit5 = driver.findElementById("digit_5");
        //Tap number 5
        digit5.click();
        //tap plus sign
        driver.findElementById("op_add").click();
        //tap 5 again
        digit5.click();
        //tap equals
        driver.findElementById("eq").click();

        //store result
        String result = driver.findElementById("result_final").getText();
        //verify
        Assert.assertEquals(result,"10");
    }

    @AfterClass
    public void tearDown(){
          driver.quit();
        }
    }

