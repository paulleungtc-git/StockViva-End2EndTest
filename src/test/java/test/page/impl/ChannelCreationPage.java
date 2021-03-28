package test.page.impl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;

public class ChannelCreationPage extends Page {

    @FindBy(id = appPackageName + ":id/edittext_create_open_channel_name")
    private WebElement txtChannelName;

    @FindBy(id = appPackageName + ":id/button_create_open_channel")
    private WebElement btnCreate;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement btnBack;

    public ChannelCreationPage(AppiumDriver driver) {
        super(driver);
    }

    public ChannelListingPage doFillChannelInfo(){
        this.txtChannelName.sendKeys("M");
        this.btnCreate.click();
        return new ChannelListingPage(super.getDriver());
    }

    public ChannelListingPage doBack(){
        this.btnBack.click();
        return new ChannelListingPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnCreate));
    }
}
