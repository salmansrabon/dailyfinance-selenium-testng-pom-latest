package pages;

import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.JSONManager;

import java.io.IOException;

public class LoginPage {
    public By txtEmail= By.id("email");
    public By txtPassword=By.id("password");
    By btnLogin=By.cssSelector("[type=submit]");
    public WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver=driver;
    }
    public void userLogin(String email, String password) throws IOException, ParseException {
        driver.findElement(txtEmail).sendKeys(email);
        driver.findElement(txtPassword).sendKeys(password);
        driver.findElement(btnLogin).click();
    }
}
