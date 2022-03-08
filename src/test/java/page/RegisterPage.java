package page;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.Hook;

public class RegisterPage {

    private WebDriver driver;
    WebDriverWait wait ;

    public RegisterPage() {
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

    public void loginMenu(){
        wait = new WebDriverWait(driver,15);
        String loginMenuText = driver.findElement(loginMenu).getText();
        Assert.assertEquals(loginMenuText,"Login");
        driver.findElement(loginMenu).click();
    }

    public void clickRegister(){
        MobileElement eleSignUp = driver.findElement(registerTab);
        eleSignUp.click();
    }

    public void setUsernameAndPassword(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(inputEmail));
        driver.findElement(inputEmail).sendKeys("test@linkaja.id");
        driver.findElement(inputPwd).sendKeys("12341234");
        driver.findElement(reInputPwd).sendKeys("12341234");
    }

    public void clickBtnSignUp(){
        driver.findElement(btnSignUp).click();
    }

    public void assertAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleAlert));
        String popupTitle = driver.findElement(titleAlert).getText();
        String messageSuccess = driver.findElement(msgAlert).getText();
        Assert.assertEquals(popupTitle,"Signed Up!");
        Assert.assertEquals(messageSuccess,"You successfully signed up!");
    }

    public void closeBtnAlert(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(btnAlert));
        driver.findElement(btnAlert);
    }
}
