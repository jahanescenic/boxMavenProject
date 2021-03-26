package boxProject;
 
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.*;
import Utility.Constants;

public class DriverTest{ 
    public WebDriver driver;

  @BeforeClass
    public void setupBrowser(){
        // Use this if latest browser version is similar to driver version or later
        // WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized"); 
        options.addArguments("enable-automation"); 
        options.addArguments("--no-sandbox"); 
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation"); 
        options.addArguments("--disable-gpu"); 
        driver = new ChromeDriver(options); 
        driver.get(Constants.URL);
        driver.manage().window().maximize();
    }

    
  @AfterClass
    public void closeBrowser(){
        driver.quit();
    }
}