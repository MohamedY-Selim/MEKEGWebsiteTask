package org.mekeg.pages;

import org.mekeg.base.BasePage;
import org.mekeg.utils.ConfigUtils;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//ul[@id=\"navbar-collapse\"]/li/a[text()=\"التبرعات\"]")
    private WebElement donationButton;

    //Methods
    @Step("Load the Home page")
    public HomePage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    @Step("Click on donation")
    public DonationPage clickOnDonation() {
        donationButton.click();
        return new DonationPage(driver);
    }

}
