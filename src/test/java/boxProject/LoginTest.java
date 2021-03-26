package boxProject;
 
import org.testng.annotations.*;
import org.testng.Assert;
import PageFactory.Login;
import PageFactory.Folder;
import PageFactory.Logout;
import PageFactory.Helper;
import Utility.Constants;

public class LoginTest extends DriverTest{ 
    Login login;
    Folder folder;
    Logout logout;
    Helper helper;

@Test(priority = 1)
  public void loginToBox() {
    // Perform Login Functionality
    login = new Login(driver);
    login.loginToBox(Constants.USER_EMAIL, Constants.PASSWORD);

    // Assertion to LoggedIn page
    logout = new Logout(driver);
    Assert.assertTrue((logout.avatar).isDisplayed(), "Login Failed");
  }


@Test(priority = 2)
  public void logoutToBox() {

    // Perform Logout Functionality
    logout = new Logout(driver);
    logout.logoutToBox();

    // Assertion to login page
    Assert.assertTrue((login.loginContainer).isDisplayed(), "Logout Failed");
  }

}