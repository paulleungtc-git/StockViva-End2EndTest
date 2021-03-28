package test.page.impl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;

import java.util.List;

public class ChannelListingPage extends Page {

    @FindBy(id = appPackageName + ":id/fab_open_channel_list")
    private WebElement btnCreateChannel;

    @FindBy(id = appPackageName + ":id/recycler_open_channel_list")
    private WebElement listChannel;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement btnBack;

    private static final String listChannelItemXpath = "//android.widget.LinearLayout";

    public ChannelListingPage(AppiumDriver driver) {
        super(driver);
    }

    public ChannelCreationPage doCreateChannel(){
        this.btnCreateChannel.click();
        return new ChannelCreationPage(super.getDriver());
    }

    public ChannelPage doClickIntoFirstChannel(){
        List<WebElement> chatRoomList = this.listChannel.findElements(By.xpath(listChannelItemXpath));

        chatRoomList.get(0).click();

        return new ChannelPage(super.getDriver());
    }

    public MainPage doBack(){
        this.btnBack.click();
        return new MainPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnCreateChannel));
    }
}
