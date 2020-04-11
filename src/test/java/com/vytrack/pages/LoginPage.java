package com.vytrack.pages;

import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="prependedInput")
    private WebElement username;

    @FindBy(id="prependedInput2")
    private WebElement password;

    @FindBy(id="_submit")
    private WebElement login;

    @FindBy(linkText="Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css="[class='alert alert-error']")
    private WebElement warningMessage;

    public LoginPage(){
        // to connect our WebDriver, page class and page factory
        // PageFactory - used to use @FindBy annotations
        // PageFactory - helps to find elements easier
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    // Login as a specific user
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
    }

    // Login as a default user
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }
}
