package PageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Helper;
import Utility.Constants;

public class Logout {

    WebDriver driver;
    Helper helper;
    
    @FindBy(css=".ProfileButton-avatar")
    public WebElement avatar;

    @FindBy(css="a[href='/logout']")
    WebElement logoutLink;


    public Logout(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);

    }


    // Go to Avater Menu
    public void goToAvaterMenu(){
        helper.waitForClickability(avatar, Constants.WAIT_FOR_LOCATOR);
        avatar.click();
    }


    // Click Logout
    public void clickLogout(){
        helper.waitForClickability(logoutLink, Constants.WAIT_FOR_LOCATOR);
        logoutLink.click();
    }


    /**

     * This POM method will be exposed in test case to logout in the application

     */
    public void logoutToBox(){
        // Go to Avater Menu
        this.goToAvaterMenu();

        // Click Logout
        this.clickLogout();
    }
}