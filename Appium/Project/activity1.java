package activities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class activity1 {
    // Declare Android driver
    AndroidDriver<MobileElement> driver;
    WebDriverWait wait;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceID", "ZY224GR6WF");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium driver
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);
    }

    @Test
    public void googleTask() {
        String task1 = "task1";
        String task2 = "task2";
        String task3 = "task3";

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("tasks_fab")));
        driver.findElementById("tasks_fab").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("add_task_title")));
        driver.findElementById("add_task_title").sendKeys("task1");

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.AccessibilityId("add_task_done")));
        driver.findElementById("add_task_done").click();

        List<MobileElement> savedTasks = driver.findElementsById("task_name");
        System.out.println(savedTasks);
        //String savedTask1 = driver.findElementById("task_name").getText();

        // Assertion
       // Assert.assertEquals(taskName, "task1");
    }

}

