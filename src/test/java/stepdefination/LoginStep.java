package stepdefination;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Hook;

public class LoginStep {

    private WebDriver driver;

    public LoginStep() {
        this.driver = Hook.getDriver();
    }

    @Given("User open the app")
    public void useropenTheApp() throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        Thread.sleep(2000);
        MobileElement eleLogin = driver.findElement(By.xpath("//*[@content-desc='button-login-container']/*/android.widget.TextView"));
        eleLogin.click();
        String titleLogin = eleLogin.getText();
        Assert.assertEquals(titleLogin,"Login");
    }


    @When("User fill username and password existing")
    public void userFillUsernameAndPasswordExisting() {
        driver.findElement(By.xpath("//*[@content-desc='input-email']")).sendKeys("test@linkaja.id");
        driver.findElement(By.xpath("//*[@content-desc='input-password']")).sendKeys("12341234");
        driver.findElement(By.xpath("//*[@content-desc='button-LOGIN']")).click();
    }

    @Then("User successful login")
    public void userSuccessfulLogin() throws InterruptedException {
        System.out.println("success register");
        String popupTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        String messageSuccess = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(popupTitle,"Success");
        Assert.assertEquals(messageSuccess,"You are logged in!");
        driver.findElement(By.id("android:id/button1"));
        Thread.sleep(3000);
    }


}
