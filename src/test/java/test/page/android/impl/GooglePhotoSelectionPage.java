package test.page.android.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;

public class GooglePhotoSelectionPage extends Page {

    @FindBy(id = "com.google.android.apps.photos:id/recycler_view")
    private WebElement btnGooglePhotoList;

    private static final String xpathPhotoSelect = "//android.view.ViewGroup[2]";

    public GooglePhotoSelectionPage(AppiumDriver driver) {
        super(driver);
    }

    public AndroidUploadConfirmPage selectPhoto(){
        this.btnGooglePhotoList.findElement(By.xpath(xpathPhotoSelect)).click();
        return new AndroidUploadConfirmPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnGooglePhotoList));
    }
}
