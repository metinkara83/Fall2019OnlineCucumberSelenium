package com.vytrack.pages;

import com.vytrack.utilities.*;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase{

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

    public String getWarningMessageText(){
        return warningMessage.getText();
    }

    // Login as a specific user
    public void login(String usernameValue, String passwordValue){
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    // Login as a default user
    public void login(){
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtilities.waitForPageToLoad(10);
        BrowserUtilities.wait(3);
    }

    public void login(String role){
        String username ="";
        if (role.equalsIgnoreCase("driver")){
            username = "user15";
        } else if (role.equalsIgnoreCase("sales manager")){
            username = "salesmanager110";
        } else if (role.equalsIgnoreCase("store manager")){
            username = "storemanager85";
        } else {
            throw new RuntimeException("Invalid role!");
        }
        System.out.println("Login as "+role);
        login(username,"UserUser123");
    }
}
