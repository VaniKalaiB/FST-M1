package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class liveActivity6 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void findMyAccount() {
        //Click on my account link and verify you are at right page
        driver.findElement(By.xpath("//*[@id='menu-item-1507']/a")).click();
        String my_ac_title = driver.getTitle();
        System.out.println("The title of the my Account page is : " + my_ac_title + "\n you are at right page");
        Assert.assertEquals(my_ac_title, "My Account – Alchemy LMS");
    }
    @Test(dependsOnMethods = {"findMyAccount"})
    public void clickLogin()  {
        //Click login button and ensure you are at login page
    driver.findElement(By.xpath("//*[@href='#login']")).click();
    WebElement loginButton = driver.findElement(By.xpath("//*[@id='wp-submit']"));
    Assert.assertTrue(loginButton.isEnabled());
    }

    @Test(dependsOnMethods = {"findMyAccount", "clickLogin"})
    public void loginLms()  {
        //Find the username and password fields
        WebElement username = driver.findElement(By.id("user_login"));
        WebElement password = driver.findElement(By.id("user_pass"));
        //Enter credentials
        username.sendKeys("root");
        password.sendKeys("pa$$w0rd");

        //Click login
        driver.findElement(By.xpath("//*[@id='wp-submit']")).click();

        //Verify after login
        String ac_username = driver.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a/span")).getText();
        Assert.assertEquals("root", ac_username);
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
