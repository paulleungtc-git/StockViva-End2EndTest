package test.page.android.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;

public class GooglePhotoAlbumPage extends Page {

    @FindBy(id = "com.google.android.apps.photos:id/fragment_container")
    private WebElement btnAlbumList;

    private static final String googleAlbumListItemXpath = "//android.support.v7.widget.RecyclerView/android.widget.RelativeLayout";

    public GooglePhotoAlbumPage(AppiumDriver driver) {
        super(driver);
    }

    public GooglePhotoSelectionPage tapAlbum(){
        this.btnAlbumList.findElement(By.xpath(googleAlbumListItemXpath)).click();

        return new GooglePhotoSelectionPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnAlbumList));
    }
}
