package saucedemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdn.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
public class checkoutinformation {

    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user tap icon cart")
    public void user_Tap_Icon_Cart(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        //Assertion
        String CheckoutInformationPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'swags labs')]")).getText();
        Assert.assertEquals(CheckoutInformationPageAssert, "swag labs");
    }

    @When("user tap checkout button")
    public void user_Tap_Checkout_Button(){
        driver.findElement(By.xpath("//button[@type='checkout']")).click();
    }

    @And("user input personal data information")
    public void user_Input_Personal_Data_Information(){
        driver.findElement(By.id("firstname, lastname, postalcode")).sendKeys("kiya, ara, 5436");
    }

    @And("user tap continue button")
    public void user_Tap_Continue_Button(){
        driver.findElement(By.xpath("//button[@type='continue']")).click();
    }

    @Then("user in next page")
    public void user_In_Next_Page(){
        driver.findElement(By.xpath("//div[contains(text(),'checkoutoverview')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'swags labs')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "tdd-selenium");
        driver.close();
    }



}
