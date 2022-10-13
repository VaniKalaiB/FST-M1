package stepDefinitions;

import io.cucumber.java.en.And;

public class closeBrowser extends baseClass{
    @And("^the About Us page title is verified$")
    public void closeBrowser(){
        driver.close();
    }
}
