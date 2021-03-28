package test.page.android.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;
import test.page.impl.ChannelPage;

public class AndroidUploadConfirmPage extends Page {

    @FindBy(id = "android:id/button1")
    private WebElement btnUpload;

    public AndroidUploadConfirmPage(AppiumDriver driver) {
        super(driver);
    }

    public ChannelPage tapUpload(){
        this.btnUpload.click();
        return new ChannelPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnUpload));
    }
}
