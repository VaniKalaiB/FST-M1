package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class liveActivity3 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void testCase() {
        //
        String title_first_info_box = driver.findElement(By.xpath("//*[@id='uagb-columns-b716f703-7e60-4f50-8f1a-3b8146865f1d']/div/div/div[2]/div/div/div/div/div[2]/h3")).getText();
        System.out.println("Heading is: " + title_first_info_box);
        Assert.assertEquals(title_first_info_box, "Actionable Training");
    }


    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
