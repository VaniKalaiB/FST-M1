package liveProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class liveActivity9 {
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

    @Test(dependsOnMethods = {"loginLms"})
    public void navigate_all_course() {
        //Navigate to all course page and ensure you are at right page
        driver.findElement(By.id("menu-item-1508")).click();
        String course_page_title = driver.getTitle();
        System.out.println("The title of the course page is : " + course_page_title);
        Assert.assertEquals(course_page_title, "All Courses – Alchemy LMS");
    }

    @Test(dependsOnMethods = {"loginLms","navigate_all_course"})
    public void complete_course() {

        //open first course
        driver.findElement(By.xpath("//*[@class='ld-course-list-items row']/div[1]")).click();
        String first_course_title = driver.getTitle();
        System.out.println("The course page title is : " + first_course_title);
        Assert.assertEquals(first_course_title, "Social Media Marketing – Alchemy LMS");

        //count the topics of the course selected
        int topic_count = driver.findElements(By.xpath("//*[@class='ld-item-list-item-preview']")).size();
        System.out.println("The number of topics for the course " + first_course_title + " are :  " + topic_count);
        driver.findElement(By.xpath("//*[@class='ld-item-list-item-preview'][1]")).click();

        //Verify if the course is already completed
        Boolean course_completed = driver.findElement(By.xpath("//div[text()='100% Complete']")).isDisplayed();
        //Provide a message if the course is already completed
        if(!course_completed) {
            System.out.println("The course " +first_course_title+ " is already completed 100%");
        }

        //If the course is incomplete
        //Case A -- Course started and its partial completion (Means mark complete may not be present at end of every lesson
        //Case B -- Course not started.
        if(course_completed){
            for(int i=1; i<=topic_count; i++){
                Boolean mark_complete_displayed;
                int mark_complete = driver.findElements(By.xpath("//span[text()='Mark Complete']")).size();
                if(mark_complete==0){
                    mark_complete_displayed = false;
                }
                else
                    mark_complete_displayed = true;
                if(mark_complete_displayed){
                    driver.findElement(By.xpath("//span[text()='Mark Complete']")).click();
                    System.out.println(i +"st lesson is completed now");
                }
                if(!mark_complete_displayed && i!=topic_count){
                    driver.findElement(By.xpath("//span[text()='Next Lesson']")).click();
                    System.out.println("Seems" + i +"st lesson is already completed! \n Moving to next lesson.... ");
                }
                if(!mark_complete_displayed && i==topic_count){
                  System.out.println("Last lesson of the course number : " + i + "\nClosing the session.... ");
                }
            }
        }
    }

    @AfterTest
    public void afterMethod() {
        //Close the browser
        driver.close();
    }
}
