package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignUpTestRunner extends BaseTest {
    @Test
    public void signup(){
        SignupPage signupPage=new SignupPage(driver);
        driver.findElement(By.partialLinkText("Register")).click();
        signupPage.signup();
    }
}
