package examples;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;

public class calAddCapture {
          // Declare Android driver
        AndroidDriver<MobileElement> driver;

        @BeforeClass
        public void beforeClass() throws MalformedURLException {
            // Set the Desired Capabilities
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("deviceName", "<Your device name>");
            caps.setCapability("platformName", "Android");
            caps.setCapability("automationName", "UiAutomator2");
            caps.setCapability("appPackage", "com.google.android.calculator");
            caps.setCapability("appActivity", "com.android.calculator2.Calculator");
            caps.setCapability("noReset", true);

            // Instantiate Appium driver
            URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
            driver = new AndroidDriver<>(appServer, caps);
        }

        @Test
        public void add() throws IOException {
            driver.findElementById("digit_5").click();
            driver.findElementById("op_add").click();
            driver.findElementById("digit_9").click();
            // Perform Calculation
            driver.findElementById("eq").click();

            // Display Result
            String result = driver.findElementById("result_final").getText();
            System.out.println(result);
            takeScreenshot();
            Assert.assertEquals(result, "14");
        }

        @Test
        public void subtract() throws IOException {
            driver.findElementById("digit_1").click();
            driver.findElementById("digit_0").click();
            driver.findElementById("op_sub").click();
            driver.findElementById("digit_5").click();
            // Perform Calculation
            driver.findElementById("eq").click();

            // Display Result
            String result = driver.findElementById("result_final").getText();
            System.out.println(result);
            takeScreenshot();
            Assert.assertEquals(result, "5");
        }

        @Test
        public void multiply() throws IOException {
            driver.findElementById("digit_5").click();
            driver.findElementById("op_mul").click();
            driver.findElementById("digit_1").click();
            driver.findElementById("digit_0").click();
            driver.findElementById("digit_0").click();
            // Perform Calculation
            driver.findElementById("eq").click();

            // Display Result
            String result = driver.findElementById("result_final").getText();
            System.out.println(result);
            takeScreenshot();
            Assert.assertEquals(result, "500");
        }

        @Test
        public void divide() throws IOException {
            driver.findElementById("digit_5").click();
            driver.findElementById("digit_0").click();
            driver.findElementById("op_div").click();
            driver.findElementById("digit_2").click();
            // Perform Calculation
            driver.findElementById("eq").click();

            // Display Result
            String result = driver.findElementById("result_final").getText();
            System.out.println(result);
            takeScreenshot();
            Assert.assertEquals(result, "25");
        }

        public void takeScreenshot() throws IOException {
            //take screenshot
            File snap_shot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            //where the screenshot will be saved
            File snap_name = new File("src/test/resources/screenshot"+ Calendar.getInstance().getTimeInMillis() +".jpg");
            //this will copy the screenshot to the file created
            FileUtils.copyFile(snap_shot, snap_name);
            //set filepath for image
            String filePath = "../" + snap_name;

            String path = "<img src='"+filePath+"'/>";

            Reporter.log(path);

        }

        @AfterClass
        public void afterClass() {
            driver.quit();
        }
    }

