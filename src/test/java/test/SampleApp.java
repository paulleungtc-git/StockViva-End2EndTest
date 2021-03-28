package test;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriver;
import test.page.impl.*;

public class SampleApp {
    private AppiumDriver driver;

    public SampleApp(AppiumDriver driver){
        this.driver = driver;
    }

    public ChannelCreationPage getChannelCreationPage(){ return new ChannelCreationPage(this.driver);}

    public ChannelPage getChannelPage(){ return new ChannelPage(this.driver);}

    public ChannelListingPage getChannelListingPage(){ return new ChannelListingPage(this.driver);}

    public MainPage getMainPage(){ return new MainPage(this.driver);}

    public LoginPage getLoginPage(){ return new LoginPage(this.driver);}

}
