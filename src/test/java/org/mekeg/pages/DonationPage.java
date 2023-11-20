package org.mekeg.pages;

import org.mekeg.base.BasePage;
import org.mekeg.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DonationPage extends BasePage {
    //Constructor
    public DonationPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//div[@data-id=\"875\"]")
    private WebElement donationCause;

    //Methods
    @Step("Load the Donation Page page")
    public DonationPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    @Step("Click on Donation Cause")
    public DonationCausePage clickOnDonationCause() {
        donationCause.click();
        return new DonationCausePage(driver);
    }

}
