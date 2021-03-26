package boxProject;
 
import org.testng.annotations.*;
import org.testng.Assert;
import PageFactory.Folder;
import PageFactory.Login;
import PageFactory.Logout;
import Utility.Constants;

public class FolderTest extends DriverTest{ 
    Folder folder;
    Login login;
    Logout logout;

@Test(priority = 3)
  public void loginToBox() {
    // Perform Login Functionality
    login = new Login(driver);
    login.loginToBox(Constants.USER_EMAIL, Constants.PASSWORD);

    // Assertion to LoggedIn page
    logout = new Logout(driver);
    Assert.assertTrue((logout.avatar).isDisplayed(), "Login Failed");
}

@Test(priority = 4)
  public void createANewFolder() {
    folder = new Folder(driver);
    folder.createFolder(Constants.FOLDER_NAME);
}

@Test(priority = 5)
  public void uploadFile() {
    folder = new Folder(driver);
    folder.uploadFile(Constants.FILE_LOCATION);
    Assert.assertTrue((folder.fileLink).isDisplayed(), "Failed to Upload");
  }
}