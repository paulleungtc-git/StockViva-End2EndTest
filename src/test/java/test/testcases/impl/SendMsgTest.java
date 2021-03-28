package test.testcases.impl;

import org.testng.annotations.Test;
import test.GoogleApp;
import test.SampleApp;
import test.testcases.SampleTest;

public class SendMsgTest extends SampleTest {

    @Test(groups = { "SendMsg" })
    public void doTest(){

        try {
            SampleApp sampleApp = new SampleApp(super.getDriver());
            GoogleApp googleApp = new GoogleApp(super.getDriver());

            sampleApp.getLoginPage().doConnect();

            sampleApp.getMainPage().tapOpenChannelList();

            sampleApp.getChannelListingPage().doCreateChannel();

            sampleApp.getChannelCreationPage().doFillChannelInfo();

            sampleApp.getChannelListingPage().doClickIntoFirstChannel();

            sampleApp.getChannelPage().sendTextMsg();
            sampleApp.getChannelPage().checkTxtMsgIsSent();

            sampleApp.getChannelPage().sendImgMsg();

            googleApp.getGooglePhotoAppPage().selectPhotoApp();
            googleApp.getGooglePhotoAlbumPage().tapAlbum();
            googleApp.getGooglePhotoSelectionPage().selectPhoto();
            googleApp.getAndroidUploadConfirmPage().tapUpload();
            sampleApp.getChannelPage().checkImgMsgIsSent();

            sampleApp.getChannelPage().doBack();
            sampleApp.getChannelListingPage().doBack();
            sampleApp.getMainPage().disconnect();
        } catch (Exception e){
            super.errorHandling(e);
        }
    }
}
