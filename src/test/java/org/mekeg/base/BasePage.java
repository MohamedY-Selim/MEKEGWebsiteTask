package org.mekeg.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    //Driver
    protected WebDriver driver;
    protected Actions act;
    protected WebDriverWait wait;


    //Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.act = new Actions(driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        PageFactory.initElements(driver, this);
    }

}
