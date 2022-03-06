package stepdefination;

import io.appium.java_client.MobileElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.Hook;

public class LoginStep {

    private WebDriver driver;

    public LoginStep() {
        this.driver = Hook.getDriver();
    }

    private By loginMenu = By.xpath("//*[@text='Login']");
    private By inputEmail = By.xpath("//*[@content-desc='input-email']");
    private By inputPwd = By.xpath("//*[@content-desc='input-password']");
    private By btnLogin = By.xpath("//*[@content-desc='button-LOGIN']");
    private By titleAlert = By.id("android:id/alertTitle");
    private By msgAlert = By.id("android:id/message");
    private By btnAlert = By.id("android:id/button1");

    @Given("User open the app")
    public void useropenTheApp() throws InterruptedException {
        driver.findElement(loginMenu).click();
        MobileElement eleLogin = driver.findElement(By.xpath("//*[@content-desc='button-login-container']/*/android.widget.TextView"));
        eleLogin.click();

    }


    @When("User fill username and password existing")
    public void userFillUsernameAndPasswordExisting() {
        driver.findElement(inputEmail).sendKeys("test@linkaja.id");
        driver.findElement(inputPwd).sendKeys("12341234");
        driver.findElement(btnLogin).click();
    }

    @Then("User successful login")
    public void userSuccessfulLogin() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, (30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleAlert));
        String popupTitle = driver.findElement(titleAlert).getText();
        String messageSuccess = driver.findElement(msgAlert).getText();
        Assert.assertEquals(popupTitle,"Success");
        Assert.assertEquals(messageSuccess,"You are logged in!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAlert));
        driver.findElement(btnAlert);
    }


}
