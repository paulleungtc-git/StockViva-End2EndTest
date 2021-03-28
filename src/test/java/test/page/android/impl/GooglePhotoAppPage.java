package test.page.android.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;
import test.page.impl.ChannelListingPage;

public class GooglePhotoAppPage extends Page {

    @FindBy(id = "com.android.documentsui:id/apps_group")
    private WebElement btnGoogleDocAppGroup;

    private static final String googlePhotoAppXpath = "//android.widget.LinearLayout[2]";

    public GooglePhotoAppPage(AppiumDriver driver) {
        super(driver);
    }

    public GooglePhotoAlbumPage selectPhotoApp(){
        btnGoogleDocAppGroup.findElement(By.xpath(googlePhotoAppXpath)).click();
        return new GooglePhotoAlbumPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnGoogleDocAppGroup));
    }
}
