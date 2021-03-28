package test.page;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {

    private AppiumDriver driver;
    protected static final String appPackageName = "com.sendbird.android.sample";

    public Page (AppiumDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        isLoad();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public abstract void isLoad() throws Error;
}
