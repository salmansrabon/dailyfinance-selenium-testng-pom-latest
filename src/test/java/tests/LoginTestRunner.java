package tests;

import base.BaseTest;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.JSONManager;

import java.io.IOException;

public class LoginTestRunner extends BaseTest {
    @Test(priority = 1, description = "User tries with wrong creds")
    public void doLoginWithWrongCreds() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.userLogin("wrongemail@test.com","1234");
        String errorMessage= driver.findElement(By.tagName("p")).getText();
        Assert.assertTrue(errorMessage.contains("Invalid email or password"));
    }
    @Test(priority = 2, description = "User tries with correct creds")
    public void doLogin() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        JSONObject userObj= JSONManager.readJSONData();
        String email=userObj.get("email").toString();
        String password=userObj.get("password").toString();
        loginPage.userLogin(email,password);
    }
    @AfterMethod
    public void clearText(){
        LoginPage loginPage=new LoginPage(driver);
        driver.findElement(loginPage.txtEmail).sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
        driver.findElement(loginPage.txtPassword).sendKeys(Keys.CONTROL+"a", Keys.BACK_SPACE);
    }
}
