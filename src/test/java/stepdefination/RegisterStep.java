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

public class RegisterStep {

    private WebDriver driver;

    public RegisterStep() {
        this.driver = Hook.getDriver();
    }

    private By loginMenu = By.xpath("//*[@text='Login']");
    private By registerTab = By.xpath("//*[@content-desc='button-sign-up-container']/*/android.widget.TextView");
    private By inputEmail = By.xpath("//*[@content-desc='input-email']");
    private By inputPwd = By.xpath("//*[@content-desc='input-password']");
    private By reInputPwd = By.xpath("//*[@content-desc='input-repeat-password']");
    private By btnSignUp = By.xpath("//*[@content-desc='button-SIGN UP']");
    private By titleAlert = By.id("android:id/alertTitle");
    private By msgAlert = By.id("android:id/message");
    private By btnAlert = By.id("android:id/button1");

    @Given("^User open the application$")
    public void UserOpenTheApplication() throws InterruptedException {
        String loginMenuText = driver.findElement(loginMenu).getText();
        Assert.assertEquals(loginMenuText,"Login");
        driver.findElement(loginMenu).click();
        MobileElement eleSignUp = driver.findElement(registerTab);
        eleSignUp.click();
    }

    @When("^User fill username and password$")
    public void UserFillUsernameAndPassword() {
        driver.findElement(inputEmail).sendKeys("test@linkaja.id");
        driver.findElement(inputPwd).sendKeys("12341234");
        driver.findElement(reInputPwd).sendKeys("12341234");
        driver.findElement(btnSignUp).click();
    }

    @Then("^Sucessfull register$")
    public void sucessfullRegister() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, (30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleAlert));
        String popupTitle = driver.findElement(titleAlert).getText();
        String messageSuccess = driver.findElement(msgAlert).getText();
        Assert.assertEquals(popupTitle,"Signed Up!");
        Assert.assertEquals(messageSuccess,"You successfully signed up!");
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAlert));
        driver.findElement(btnAlert);
    }

}
