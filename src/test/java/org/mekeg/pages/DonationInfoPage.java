package org.mekeg.pages;

import io.qameta.allure.Step;
import org.mekeg.base.BasePage;
import org.mekeg.utils.InfoUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DonationInfoPage extends BasePage {
    //Constructor
    public DonationInfoPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(id = "cartFirstName")
    private WebElement firstNameInput;
    @FindBy(id = "cartLasttName")
    private WebElement lastNameInput;
    @FindBy(id = "cartMobile")
    private WebElement mobileNumberInput;
    @FindBy(id = "cartEmail")
    private WebElement emailInput;
    @FindBy(id = "street")
    private WebElement streetInput;
    @FindBy(id = "mainStreetSquare")
    private WebElement mainStreetSquareInput;
    @FindBy(id = "landmark")
    private WebElement landmarkInput;
    @FindBy(id = "building")
    private WebElement buildingInput;
    @FindBy(id = "floor")
    private WebElement floorInput;
    @FindBy(id = "flat")
    private WebElement flatInput;
    @FindBy(id = "cartCountry")
    private WebElement countryDropdown;
    @FindBy(xpath = "//div[@id=\"governorate_input\"]/span/span[@class=\"selection\"]/span")
    private WebElement governorateDropdown;
    @FindBy(xpath = "//span[@class=\"select2-results\"]/ul/li[2]")
    private WebElement governorate;
    @FindBy(xpath = "//div[@id=\"city_input\"]/span/span[@class=\"selection\"]/span")
    private WebElement cityDropdown;
    @FindBy(xpath = "//span[@class=\"select2-results\"]/ul/li[2]")
    private WebElement city;
    @FindBy(xpath = "//div[@id=\"district_input\"]/span/span[@class=\"selection\"]/span")
    private WebElement districtDropdown;
    @FindBy(xpath = "//span[@class=\"select2-results\"]/ul/li[2]")
    private WebElement district;
    @FindBy(id = "no_direct")
    private WebElement noDirectRadio;
    @FindBy(id = "recurring")
    private WebElement recurringDropdown;
    @FindBy(id = "paymentMethod")
    private WebElement paymentMethodDropdown;
    @FindBy(id = "cartPayHome")
    private WebElement submitButton;

    //Methods

    @Step("Fill Donation Info")
    public CompletionPage fillDonationInfo() {
        //Filling First Name
        firstNameInput.sendKeys(InfoUtils.generateRandomInfo().getFirstName());
        //Filling Last Name
        lastNameInput.sendKeys(InfoUtils.generateRandomInfo().getLastName());
        //Filling Mobile Number
        mobileNumberInput.sendKeys(InfoUtils.generateRandomInfo().getMobileNumber());
        //Filling Email
        emailInput.sendKeys(InfoUtils.generateRandomInfo().getEmail());
        //Selecting Country
        new Select(countryDropdown).selectByValue("9");
        //Selecting No Direct to specific governorate
        noDirectRadio.click();
        //Selecting No recurring
        new Select(recurringDropdown).selectByValue("none");
        //Selecting Payment Method
        new Select(paymentMethodDropdown).selectByValue("pay_home");
        //Waiting for Governorate Dropdown to be shown
        wait.until(ExpectedConditions.visibilityOf(governorateDropdown));
        //Opening Dropdown
        act.moveToElement(governorateDropdown).click().perform();
        //Waiting for Governorate options to be shown
        wait.until(ExpectedConditions.visibilityOf(governorate));
        //Selecting governorate
        act.moveToElement(governorate).click().perform();
        //Waiting for City Dropdown to be shown
        wait.until(ExpectedConditions.visibilityOf(cityDropdown));
        //Opening Dropdown
        act.moveToElement(cityDropdown).click().perform();
        //Waiting for City options to be shown
        wait.until(ExpectedConditions.visibilityOf(city));
        //Selecting City
        act.moveToElement(city).click().perform();
        //Waiting for District Dropdown to be shown
        wait.until(ExpectedConditions.visibilityOf(districtDropdown));
        //Opening Dropdown
        act.moveToElement(districtDropdown).click().perform();
        //Waiting for District options to be shown
        wait.until(ExpectedConditions.visibilityOf(district));
        //Selecting District
        act.moveToElement(district).click().perform();
        //Wait for Street to be shown
        wait.until(ExpectedConditions.visibilityOf(streetInput));
        //Fill Street
        streetInput.sendKeys(InfoUtils.generateRandomInfo().getStreet());
        //Fill Square
        mainStreetSquareInput.sendKeys(InfoUtils.generateRandomInfo().getSquare());
        //Fill Landmark
        landmarkInput.sendKeys(InfoUtils.generateRandomInfo().getLandMark());
        //Fill Building
        buildingInput.sendKeys(InfoUtils.generateRandomInfo().getBuilding());
        //Fill Floor
        floorInput.sendKeys(InfoUtils.generateRandomInfo().getFloor());
        //Fill Flat
        flatInput.sendKeys(InfoUtils.generateRandomInfo().getFlat());
        //Wait for Submit button to be shown
        wait.until(ExpectedConditions.visibilityOf(submitButton));
        //Click on Submit Button
        submitButton.click();
        //Wait for Thanks Message to be shown
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("headthank")));
        return new CompletionPage(driver);
    }


}
