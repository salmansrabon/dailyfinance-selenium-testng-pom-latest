package tests;

import base.BaseTest;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;

public class AdminUserTestRunner extends BaseTest {
    @BeforeTest
    public void adminLogin() throws IOException, ParseException {
        LoginPage loginPage=new LoginPage(driver);
        if(System.getProperty("email")!=null && System.getProperty("password")!=null){
            loginPage.userLogin(System.getProperty("email"),System.getProperty("password"));
        }
        else{
            loginPage.userLogin("admin@test.com","admin123");
        }

    }
    @Test
    public void ViewUsers(){
        String headerActual= driver.findElement(By.tagName("h2")).getText();
        Assert.assertTrue(headerActual.contains("Admin Dashboard"));
    }
}
