package PageFactory;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import PageFactory.Helper;
import Utility.Constants;

public class Login {

    WebDriver driver;
    Helper helper;
    
    @FindBy(css="a[class='user-nav--login user-nav--item']")
    WebElement loginLink;

    @FindBy(id="login-email")
    WebElement userId;

    @FindBy(id="login-submit")
    WebElement loginUserSubmit;

    @FindBy(id="password-login")
    WebElement passwordId;

    @FindBy(id="login-submit-password")
    WebElement loginPasswordSubmit;

    @FindBy(css=".login-container")
    public WebElement loginContainer;

    public Login(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
        helper = new Helper(driver);

    }


    //Go to Login Page
    public void goToLoginPage(){
        loginLink.click();    
    }


    //Enter Username
    public void setUserName(String useremail){
        userId.sendKeys(useremail);    
    }


    // Click Next
    public void clickNext(){
        loginUserSubmit.click();    
    }


    //Enter Password
    public void setPassword(String password){
        helper.waitForVisibility(passwordId, Constants.WAIT_FOR_LOCATOR);
        helper.sleepWhenFlaky(1000);
        passwordId.sendKeys(password);    
    }


    // Click Login
    public void clickLogin(){
        loginPasswordSubmit.click();    
    }


    /**

     * This POM method will be exposed in test case to login in the application

     * @param useremail

     * @param password

     */

    public void loginToBox(String useremail,String password){
        
        // Go to Login Page
        this.goToLoginPage();

        // Enter User Email
        this.setUserName(useremail);

        // Click Next Button
        this.clickNext();

        //Fill in Password
        this.setPassword(password);

        // Click Login
        this.clickLogin();         
    }

}