package test;

import io.appium.java_client.AppiumDriver;
import test.page.android.impl.AndroidUploadConfirmPage;
import test.page.android.impl.GooglePhotoAlbumPage;
import test.page.android.impl.GooglePhotoAppPage;
import test.page.android.impl.GooglePhotoSelectionPage;
import test.page.impl.*;

public class GoogleApp {
    private AppiumDriver driver;

    public GoogleApp(AppiumDriver driver){
        this.driver = driver;
    }

    public AndroidUploadConfirmPage getAndroidUploadConfirmPage(){return new AndroidUploadConfirmPage(this.driver);}

    public GooglePhotoAlbumPage getGooglePhotoAlbumPage() {return new GooglePhotoAlbumPage(this.driver);}

    public GooglePhotoSelectionPage getGooglePhotoSelectionPage() {return new GooglePhotoSelectionPage(this.driver);}

    public GooglePhotoAppPage getGooglePhotoAppPage() {return new GooglePhotoAppPage(this.driver);}

}
