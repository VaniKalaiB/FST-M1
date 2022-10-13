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

public class activityChrome1 {
    AndroidDriver<MobileElement> driver = null;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<Your device name>");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

        // Open page
        driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void scrollIntoViewTest() {
        String UiScrollable = "UiScrollable(UiSelector().scrollable(true))";
        // Wait for the page to load
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.xpath("//android.view.View")));


        // Scroll element into view and click it
        driver.findElement(MobileBy.AndroidUIAutomator(UiScrollable + ".scrollForward(7).scrollIntoView(text(\"Popups\"))")).click();

        // Wait for the page to load
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("singin")));
        driver.findElementById("signin").click();

        //enter credentials
        driver.findElementById("username").sendKeys("admin");
        driver.findElementById("pwd").sendKeys("wrongpwd");
        driver.findElementById("login button").click();

        // Print page title
        String login_message_fail = driver.findElementByXPath("//android.widget.TextView[contains(@text, 'New Tab')]").getText();
        System.out.println("Login message is: " + login_message_fail);

        // Assertion
        Assert.assertEquals(login_message_fail, "Invalid Credentials");

        //click log in again
        driver.findElementById("signin").click();

        //enter credentials
        driver.findElementById("username").sendKeys("admin");
        driver.findElementById("pwd").sendKeys("password");
        driver.findElementById("login button").click();

        // Print page title
        String login_message_success = driver.findElementByXPath("//android.widget.TextView[contains(@text, 'New Tab')]").getText();
        System.out.println("Login message is: " + login_message_success);

        // Assertion
        Assert.assertEquals(login_message_success, "Welcome Back, admin");
    }


