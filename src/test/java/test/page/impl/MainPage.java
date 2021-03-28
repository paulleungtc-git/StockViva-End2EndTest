package test.page.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;

public class MainPage extends Page {

    @FindBy(id = appPackageName + ":id/button_disconnect")
    private WebElement btnDisConnect;

    @FindBy(id = appPackageName + ":id/linear_layout_open_channels")
    private WebElement btnOpenChannelList;

    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public LoginPage disconnect(){
        this.btnDisConnect.click();
        return new LoginPage(super.getDriver());
    }

    public ChannelListingPage tapOpenChannelList(){
        this.btnOpenChannelList.click();
        return new ChannelListingPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnDisConnect));
    }
}
