package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class activity2 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceId", "ZY224GR6WF");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void googleKeep() {
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("plus-dinf")));
        driver.findElementById("find button id").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("title")));
        driver.findElementById("title name").sendKeys("title");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("note element")));
        driver.findElementById("note element").sendKeys("notes");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("press back")));
        driver.findElementById("press back").click();

        //Assertion
        String note = driver.findElementById("press back").getText();
        Assert.assertEquals("test", note);

    }
}
