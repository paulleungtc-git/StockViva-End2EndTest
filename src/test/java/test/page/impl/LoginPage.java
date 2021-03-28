package test.page.impl;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.page.Page;


public class LoginPage extends Page {

    private static String id = "Some ID";
    private static String nickName = "Some NickName";

    @FindBy(id = appPackageName + ":id/edittext_login_user_id")
    private WebElement txtId;

    @FindBy(id = appPackageName + ":id/edittext_login_user_nickname")
    private WebElement txtNickName;

    @FindBy(id = appPackageName + ":id/button_login_connect")
    private WebElement btnConnect;

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    public MainPage doConnect(){
        this.txtId.sendKeys(id);
        this.txtNickName.sendKeys(nickName);
        this.btnConnect.click();
        return new MainPage(super.getDriver());
    }


    @Override
    public void isLoad() throws Error {
        new WebDriverWait(super.getDriver(), 60)
                .until(ExpectedConditions.visibilityOf(this.btnConnect));
    }



}
