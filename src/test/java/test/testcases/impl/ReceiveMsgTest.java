package test.testcases.impl;

import org.testng.annotations.Test;
import test.SampleApp;
import test.testcases.SampleTest;

public class ReceiveMsgTest extends SampleTest {

    @Test//(dependsOnGroups = { "SendMsg" })
    public void doTest(){


        try {
            SampleApp sampleApp = new SampleApp(super.getDriver());

            sampleApp.getLoginPage().doConnect();
            sampleApp.getMainPage().tapOpenChannelList();
            sampleApp.getChannelListingPage().doClickIntoFirstChannel();
            sampleApp.getChannelPage().checkTxtMsgIsReceived();
            sampleApp.getChannelPage().checkImgMsgIsReceived();

        } catch (Exception e){
            super.errorHandling(e);
        }
    }
}
