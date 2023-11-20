package org.mekeg.testcases;

import org.mekeg.base.BaseTest;
import org.mekeg.pages.HomePage;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Donation Feature")
public class DonationTest extends BaseTest {

    @Story("Donation")
    @Description("It will do a donation from home")
    @Test(description = "Test the donation feature")
    public void ShouldBeAbleToDonate() {

        HomePage homePage = new HomePage(getDriver());
        boolean thanksMessage = homePage.load()
                .clickOnDonation()
                .clickOnDonationCause()
                .AddDonation()
                .fillDonationInfo()
                .getThanksMessage();
        Assert.assertTrue(thanksMessage);
    }
}
