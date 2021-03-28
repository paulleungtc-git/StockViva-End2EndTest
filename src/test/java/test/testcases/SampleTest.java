package test.testcases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public abstract class SampleTest {

    public static String hubPath = "http://192.168.200.151:4444/wd/hub";

    //chris.au@cbxsoftware.com
    private AppiumDriver driver;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        this.driver = new AndroidDriver(new URL(this.hubPath), this.getPlatformCap());

    }


    public abstract void doTest();

    @AfterMethod
    public void tearDown(){
        this.driver.quit();
    }

    private DesiredCapabilities getPlatformCap(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("platformVersion", "10.0");
        capabilities.setCapability("fullReset", true);
        capabilities.setCapability("autoGrantPermissions", true);
        capabilities.setCapability("app", "/Users/paulleung/Downloads/testing.apk");
        capabilities.setCapability("appPackage", "com.sendbird.android.sample");
        capabilities.setCapability("appActivity", "com.sendbird.android.sample.main.SplashActivity");

        return capabilities;
    }

    protected void errorHandling(Exception e){
        e.printStackTrace();
        Assert.fail();
    }


    protected AppiumDriver getDriver() {
        return driver;
    }
}
