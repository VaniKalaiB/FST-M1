package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class liveActivity8 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
    }

    @Test
    public void navigate_Contact_Menu() {
        //
        driver.findElement(By.linkText("Contact")).click();
        String title_contact_menu = driver.getTitle();
        System.out.println("Heading of the contact page is: " + title_contact_menu);
        Assert.assertEquals(title_contact_menu, "Contact – Alchemy LMS");
    }

    @Test(dependsOnMethods = {"navigate_Contact_Menu"})
    public void fill_send_message_form() {
        //fill send message form
        driver.findElement(By.xpath("//*[@name='wpforms[fields][0]']")).sendKeys("UserName001");
        driver.findElement(By.xpath("//*[@name='wpforms[fields][1]']")).sendKeys("sample@gmail.com");
        driver.findElement(By.xpath("//*[@name='wpforms[fields][3]']")).sendKeys("Subject_sample");
        driver.findElement(By.xpath("//*[@name='wpforms[fields][2]']")).sendKeys("sample message");
        //click submit button
        driver.findElement(By.xpath("//*[@name='wpforms[submit]']")).click();
        //verify message is submitted successfully
        String send_message_success = driver.findElement(By.xpath("//*[@class='entry-content clear']/section[4]/div[2]/div[2]/div[2]/div[2]")).getText();
        Assert.assertEquals(send_message_success, "Thanks for contacting us! We will be in touch with you shortly.");
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
