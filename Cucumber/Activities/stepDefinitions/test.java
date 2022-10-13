package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class test extends baseClass{
    @Given("^user is on the TS homepage$")
    public void openTSHomepage() {
        driver.get("https://training-support.net");
    }

    @When("^user clicks on About Us button$")
    public void clickAboutUs_button() {
        driver.findElement(By.id("about-link")).click();
    }

    @Then("user is redirected to About Us page$")
    public void aboutUs_page_verification() {
        String about_us_page_title = driver.findElement(By.xpath("//*[@class='pusher']/div/div[2]/h1")).getText();
        Assert.assertEquals("About Us", about_us_page_title);
    }
}
