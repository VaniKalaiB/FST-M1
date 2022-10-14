package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class liveActivity4 {
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
        String most_popular_course2 = driver.findElement(By.xpath("//*[@id='post-71']/div[2]/h3")).getText();
        System.out.println("The second most populate course name is: " + most_popular_course2);
        Assert.assertEquals(most_popular_course2, "Email Marketing Strategies");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
