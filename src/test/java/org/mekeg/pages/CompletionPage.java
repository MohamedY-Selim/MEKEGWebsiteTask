package org.mekeg.pages;

import io.qameta.allure.Step;
import org.mekeg.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CompletionPage extends BasePage {
    //Constructor
    public CompletionPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//div[@class=\"headthank\"]//h2")
    private WebElement thanksMessage;
    //Methods

    @Step("Get Thanks Message")
    // return boolean of Thanks Message shown
    public boolean getThanksMessage() {
        return thanksMessage.isDisplayed();
    }


}
