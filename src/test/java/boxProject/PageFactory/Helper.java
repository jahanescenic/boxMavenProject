package PageFactory;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import Utility.Constants;


public class Helper{
    WebDriver driver;
    WebDriverWait wait;

    public Helper(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver, this);
        // wait = new WebDriverWait(driver,Constants);
    }

    public void waitForVisibility(WebElement element, int time) throws Error{
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForClickability(WebElement element, int time) throws Error{
        new WebDriverWait(driver, time).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void clickWhenVisible(WebElement locator, int time){
        waitForVisibility(locator, time);
        locator.click();
    }

    public void clickWhenClickable(WebElement locator, int time){
        waitForClickability(locator, time);
        locator.click();
    }

    public void sendkeysWhenVisible(WebElement locator, String text, int time){
        waitForVisibility(locator, time);
        locator.sendKeys(text);
    }

    // TODO: Should be replaced with repeat until method to withstand flakiness
    public void sleepWhenFlaky(int time){
        try 
        {
            Thread.sleep(time);
        } 
        catch(InterruptedException e)
        {
            System.out.println("Something went wrong with sleep");
        }
    }
}