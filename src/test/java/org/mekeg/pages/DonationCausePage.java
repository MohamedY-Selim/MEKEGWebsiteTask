package org.mekeg.pages;

import io.qameta.allure.Step;
import org.mekeg.base.BasePage;
import org.mekeg.utils.ConfigUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DonationCausePage extends BasePage {
    //Constructor
    public DonationCausePage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(css = "[type=\"currency\"]")
    private WebElement donateValue;

    @FindBy(xpath = "//div[@class=\"causeWide-form\"]/button[@type=\"submit\"]")
    private WebElement submitButton;

    @FindBy(xpath = "//div[@class=\"cart-body\"]/div[2]/div[3]/input")
    private WebElement zakatRadio;

    @FindBy(xpath = "//div[@id=\"cart-menu\"]/a")
    private WebElement continueButton;

    //Methods

    @Step("Click on Donation Cause")
    public DonationInfoPage AddDonation() {
        donateValue.sendKeys("1000");
        submitButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cart-menu")));
        zakatRadio.click();
        continueButton.click();
        return new DonationInfoPage(driver);
    }


}
