package utility;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class Hook {

    private static WebDriver driver;

    @Before
    public void setUpAppium() throws MalformedURLException
    {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        cap.setCapability(MobileCapabilityType.PLATFORM_VERSION, "11");
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
        cap.setCapability(MobileCapabilityType.APP, System.getProperty("user.dir")+"/src/app/Android_WebDriverio.apk");
        cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.wdiodemoapp");
        cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.wdiodemoapp.MainActivity");
        driver = new AndroidDriver<>(new URL("http://0.0.0.0:4723/wd/hub"), cap);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }

    public static WebDriver getDriver()
    {
        return driver;
    }
}
