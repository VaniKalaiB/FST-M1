package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class liveActivity7 {
    WebDriver driver;

    @BeforeTest
    public void beforeMethod() {
        //Create a new instance of the Firefox driver
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://alchemy.hguy.co/lms");
    }
    @Test
    public void navigate_all_course() {
        //Navigate to all course page and ensure you are at right page
        driver.findElement(By.id("menu-item-1508")).click();
        String course_title = driver.getTitle();
        System.out.println("The title of the my course page is : " + course_title);
        Assert.assertEquals(course_title, "All Courses – Alchemy LMS");
    }

    @Test(dependsOnMethods = {"navigate_all_course"})
    public void count_all_course() {
        //Count the number of courses
        int count = driver.findElements(By.xpath("//*[@class='ld-course-list-items row']/div")).size();
        String my_ac_title = driver.getTitle();
        System.out.println("The number of courses available is : " + count);
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
