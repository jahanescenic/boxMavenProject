package PageFactory;

import java.util.*;
import java.io.File;
import java.util.Random;
import org.openqa.selenium.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import PageFactory.Helper;
import Utility.Constants;


public class Folder{
    WebDriver driver;
    WebDriverWait wait;
    Helper helper;
    
    @FindBy(css="div[data-testid='onboarding-tracker']")
    WebElement onBoardingTracker;

    @FindBy(css="button[data-resin-target=newmenubutton]")
    WebElement newMenu;

    @FindBy(css="li[aria-label='Create a new Folder']")
    WebElement createNewFolder;

    @FindBy(css="input[name=folder-name]")
    WebElement folderNameInput;

    @FindBy(css=".modal-content button[type=submit]")
    WebElement createButton;

    @FindBy(css="button[data-resin-target=uploadmenubutton]")
    WebElement uploadMenu;

    @FindBy(css="span[data-testid=with-targeted-click-span] li[class='menu-item UploadMenuItem']")
    WebElement uploadNewFile;

    @FindBy(css="input[aria-labelledby='upload-input']")
    WebElement inputFileArea;

    @FindBy(linkText=Constants.FILE_NAME)
    public WebElement fileLink;

    @FindBy(css="button[aria-label=Trash]")
    WebElement trash;

    // Generate random integers in range 0 to 999
    Random rand = new Random();
    public int random_num = rand.nextInt(1000);


    public Folder(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Constants.WAIT_FOR_LOCATOR);
        helper = new Helper(driver);
    }


    // Open new menu drag and drop 
    public void goToNewMenu(){
        wait.until(ExpectedConditions.visibilityOf(newMenu));
        helper.sleepWhenFlaky(2000);
        newMenu.click();  
    }


    // Click new folder menu option
    public void clickCreateFolder(){
        helper.clickWhenVisible(createNewFolder, Constants.WAIT_FOR_LOCATOR);
    }


    // Enter Folder Name
    public void setFolderName(String foldername){
        String newfoldername = foldername + random_num;
        helper.sendkeysWhenVisible(folderNameInput, newfoldername, Constants.WAIT_FOR_LOCATOR);
    }


    // Click "Create" Button in new folder pop-up window
    public void clickCreate(){
        helper.clickWhenClickable(createButton, Constants.WAIT_FOR_LOCATOR);
    }


    // Open new menu drag and drop 
    public void goToUploadMenu(){
        wait.until(ExpectedConditions.visibilityOf(uploadMenu));
        helper.sleepWhenFlaky(2000);
        uploadMenu.click();  
    }


    // Click new folder menu option
    public void clickUploadFile(){
        helper.clickWhenVisible(uploadNewFile, Constants.WAIT_FOR_LOCATOR);
    }


    // Upload file
    public void setUploadFile(String filelocation){
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.display = 'block';", inputFileArea);
        File file = new File(filelocation);
        inputFileArea.sendKeys(file.getAbsolutePath()); 
        helper.waitForVisibility(fileLink, Constants.FILE_UPLOAD_WAIT_TIME);
    }


    /**

     * This POM method will be exposed in test case to create folder in the application

     * @param foldername

     */

    public void createFolder(String foldername){
        // Go to New Menu
        this.goToNewMenu();

        // Create A New Folder From Menu Options
        this.clickCreateFolder();

        // Enter Folder Name
        this.setFolderName(foldername);

        //Click Create Button
        this.clickCreate();    
    }

    /**

     * This POM method will be exposed in test case to upload folder in the application

     * @param filelocation

     */

    public void uploadFile(String filelocation){
        // Go to Upload Menu
        this.goToUploadMenu();

        // Click Upload File
        this.clickUploadFile();

        // Perform File Upload with File Location
        this.setUploadFile(filelocation); 
    }

}