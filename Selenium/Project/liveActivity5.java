package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class liveActivity5 {
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
        driver.findElement(By.xpath("//*[@id='menu-item-1507']/a")).click();
        String my_ac_title = driver.getTitle();
        System.out.println("The title of the my Account page is : " + my_ac_title);
        Assert.assertEquals(my_ac_title, "My Account – Alchemy LMS");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
