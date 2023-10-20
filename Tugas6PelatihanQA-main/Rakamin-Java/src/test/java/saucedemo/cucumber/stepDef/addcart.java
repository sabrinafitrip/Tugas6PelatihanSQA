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


public class addcart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user login the app")
    public void user_login_the_Cart(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'swags labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "swag labs");
    }

    @When("user add product to cart")
    public void user_Add_Product_To_Cart(){
        driver.findElement(By.xpath("//button[@type='add to cart']")).click();
    }

    @And("user tap icon cart")
    public void user_Tap_Icon_Cart(){
        driver.findElement(By.xpath("//button[@type='icon cart']")).click();
    }

    @And("user tap checkout button")
    public void user_Tap_Checkout_Button(){
        driver.findElement(By.xpath("//button[@type='checkout']")).click();
    }

    @Then("user in next page")
    public void user_In_Next_Page(){
        driver.findElement(By.xpath("//div[contains(text(),'checkoutinformation')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'swags labs')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "tdd-selenium");
        driver.close();
    }

}
