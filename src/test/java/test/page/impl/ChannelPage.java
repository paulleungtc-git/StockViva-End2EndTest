package test.page.impl;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import test.page.Page;
import test.page.android.impl.GooglePhotoAppPage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ChannelPage extends Page {

    @FindBy(id = appPackageName + ":id/button_open_channel_chat_upload")
    private WebElement btnUpload;

    @FindBy(id = appPackageName + ":id/edittext_chat_message")
    private WebElement txtTextMsg;

    @FindBy(id = appPackageName + ":id/button_open_channel_chat_send")
    private WebElement btnSendMsg;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
    private WebElement btnBack;

    @FindBy(id = appPackageName + ":id/recycler_open_channel_chat")
    private WebElement listMsgList;

    @FindBy(id = appPackageName + ":id/text_open_chat_file_name")
    private List<WebElement> elementImgMsgTitleList;

    @FindBy(id = appPackageName + ":id/text_open_chat_message")
    private List<WebElement> elementTxtMsgTextList;

    public ChannelPage(AppiumDriver driver) {
        super(driver);
    }

    public ChannelPage sendTextMsg(){
        this.txtTextMsg.sendKeys("I am a Text Msg");
        this.btnSendMsg.click();
        return new ChannelPage(super.getDriver());
    }

    public GooglePhotoAppPage sendImgMsg() throws IOException {

        ((AndroidDriver)super.getDriver()).pushFile("/sdcard/Download/toUpload.png", new File("/Users/paulleung/Downloads/toUpload.png"));

        this.btnUpload.click();
        return new GooglePhotoAppPage(super.getDriver());
    }

    public ChannelPage checkTxtMsgIsSent(){

        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(appPackageName + ":id/text_open_chat_message")));

//        System.out.println("elementTxtMsgTextList = " + elementTxtMsgTextList.size());
//        System.out.println("Last text = " + elementTxtMsgTextList.get(elementTxtMsgTextList.size() - 1).getText());

        Assert.assertEquals(elementTxtMsgTextList.get(elementTxtMsgTextList.size() - 1).getText(), "I am a Text Msg");

        return new ChannelPage(super.getDriver());
    }
    
    public ChannelPage checkImgMsgIsSent(){
        new WebDriverWait(super.getDriver(), 60)
            .until(ExpectedConditions.visibilityOfElementLocated(By.id(appPackageName + ":id/text_open_chat_file_name")));

//        System.out.println("elementImgMsgTitleList = " + elementImgMsgTitleList.size());
//        System.out.println("Last text = " + elementImgMsgTitleList.get(elementImgMsgTitleList.size() - 1).getText());

        Assert.assertEquals(elementImgMsgTitleList.get(elementImgMsgTitleList.size() - 1).getText(), "toUpload.png");

        return new ChannelPage(super.getDriver());
    }

    public ChannelPage checkTxtMsgIsReceived(){
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(appPackageName + ":id/text_open_chat_message")));

        Assert.assertEquals(elementTxtMsgTextList.get(elementTxtMsgTextList.size() - 2).getText(), "I am a Text Msg");

        return new ChannelPage(super.getDriver());
    }

    public ChannelPage checkImgMsgIsReceived(){
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id(appPackageName + ":id/text_open_chat_file_name")));

        Assert.assertEquals(elementImgMsgTitleList.get(elementImgMsgTitleList.size() - 1).getText(), "toUpload.png");

        return new ChannelPage(super.getDriver());
    }

    public ChannelListingPage doBack(){
        this.btnBack.click();
        return new ChannelListingPage(super.getDriver());
    }

    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnSendMsg));
    }
}
