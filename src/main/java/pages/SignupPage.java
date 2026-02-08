package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;
    private By txtFirstName= By.id("firstName");
    private By txtEmail= By.id("email");
    private By txtPassword= By.id("password");
    private By txtPhoneNumber= By.id("phoneNumber");
    private By btnRadio=By.cssSelector("[type=radio]");

    public SignupPage(WebDriver driver){
        this.driver=driver;
    }
    public void signup(){
        driver.findElement(txtFirstName).sendKeys("Test User");
        driver.findElements(btnRadio).get(0).click();
    }
}
