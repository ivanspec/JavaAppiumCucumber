package stepdefination;


import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Hook;

public class RegisterStep {

    private WebDriver driver;

    public RegisterStep() {
        this.driver = Hook.getDriver();
    }

    @Given("^User open the application$")
    public void UserOpenTheApplication() throws InterruptedException {
        driver.findElement(By.xpath("//*[@text='Login']")).click();
        Thread.sleep(2000);
        MobileElement eleSignUp = driver.findElement(By.xpath("//*[@content-desc='button-sign-up-container']/*/android.widget.TextView"));
        eleSignUp.click();
            String titleSignUp = eleSignUp.getText();
            String eleLogin = driver.findElement(By.xpath("//*[@content-desc='button-login-container']/*/android.widget.TextView")).getText();
        Assert.assertEquals(titleSignUp,"Sign up");
        Assert.assertEquals(eleLogin,"Login");
    }

    @When("^User fill username and password$")
    public void UserFillUsernameAndPassword() {
        driver.findElement(By.xpath("//*[@content-desc='input-email']")).sendKeys("test@linkaja.id");
        driver.findElement(By.xpath("//*[@content-desc='input-password']")).sendKeys("12341234");
        driver.findElement(By.xpath("//*[@content-desc='input-repeat-password']")).sendKeys("12341234");
        driver.findElement(By.xpath("//*[@content-desc='button-SIGN UP']")).click();
    }

    @Then("^Sucessfull register$")
    public void sucessfullRegister() throws InterruptedException {
        System.out.println("success register");
        String popupTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
        String messageSuccess = driver.findElement(By.id("android:id/message")).getText();
        Assert.assertEquals(popupTitle,"Signed Up!");
        Assert.assertEquals(messageSuccess,"You successfully signed up!");
        driver.findElement(By.id("android:id/button1"));
        Thread.sleep(3000);

    }

}
