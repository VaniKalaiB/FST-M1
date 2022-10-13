package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class liveActivity2 {
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
        String heading = driver.findElement(By.xpath("//*[@class='entry-content clear']/section/div[2]/section/div[2]/div[2]/div[2]/div/div/div/div/div/h1")).getText();
        System.out.println("Heading is: " + heading);
        Assert.assertEquals(heading, "Learn from Industry Experts");
    }


    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }

}
