package page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.Hook;

public class LoginPage {

    private WebDriver driver;
    WebDriverWait wait ;

    public LoginPage() {
        this.driver = Hook.getDriver();
    }

    private By loginMenu = By.xpath("//*[@text='Login']");
    private By inputEmail = By.xpath("//*[@content-desc='input-email']");
    private By inputPwd = By.xpath("//*[@content-desc='input-password']");
    private By btnLogin = By.xpath("//*[@content-desc='button-LOGIN']");
    private By titleAlert = By.id("android:id/alertTitle");
    private By msgAlert = By.id("android:id/message");
    private By btnAlert = By.id("android:id/button1");

    public void loginMenu() {
        wait = new WebDriverWait(driver,15);
        driver.findElement(loginMenu).click();
        MobileElement eleLogin = driver.findElement(By.xpath("//*[@content-desc='button-login-container']/*/android.widget.TextView"));
        eleLogin.click();
    }

    public void setUsernameAndPassword() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys("test@linkaja.id");
        driver.findElement(inputPwd).sendKeys("12341234");
    }

    public void btnLogin(){
        driver.findElement(btnLogin).click();
    }

    public void AssertAlert(){
        WebDriverWait wait = new WebDriverWait(driver, (30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleAlert));
        String popupTitle = driver.findElement(titleAlert).getText();
        String messageSuccess = driver.findElement(msgAlert).getText();
        Assert.assertEquals(popupTitle,"Success");
        Assert.assertEquals(messageSuccess,"You are logged in!");
    }

    public void closeAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAlert));
        driver.findElement(btnAlert);
    }
}