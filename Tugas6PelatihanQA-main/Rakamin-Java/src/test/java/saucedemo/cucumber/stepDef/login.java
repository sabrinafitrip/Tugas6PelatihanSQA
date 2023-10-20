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

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("user open the app")
    public void user_Open_The_App(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//h2[contains(text(),'swags labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "swag labs");
    }

    @When("user input registered username")
    public void user_Input_Registered_Username(){
        driver.findElement(By.id("username")).sendKeys("standard_user");
    }

    @And("user input registered password")
    public void user_Input_Registered_Password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("user tap login button")
    public void user_Tap_Login_Button(){
        driver.findElement(By.xpath("//button[@type='login']")).click();
    }

    @Then("user in page dashboard")
    public void user_In_Page_Dashboard(){
        driver.findElement(By.xpath("//div[contains(text(),'dashboard')]"));
        String username = driver.findElement(By.xpath("//dd[contains(text(),'swags labs')]/preceding-sibling::dt")).getText();
        Assert.assertEquals(username, "tdd-selenium");
        driver.close();
    }

    @When("user input unregistered username")
    public void user_Input_Unregistered_Username(){
        driver.findElement(By.id("username")).sendKeys("user");
    }

    @And("user input unregistered password")
    public void user_Input_Unregistered_Password(){
        driver.findElement(By.id("password")).sendKeys("sauce");
    }

    @Then("user get error message")
    public void user_Get_Error_Message(){
        String errorLogin = driver.findElement(By.xpath("//div[@role='alert']")).getText();
        Assert.assertEquals(errorLogin, "username atau password salah");
        driver.close();
    }




}
