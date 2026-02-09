package pages;
import models.UserModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignupPage {
    WebDriver driver;
    private By txtFirstName= By.id("firstName");
    private By txtLastName=By.id("lastName");
    private By txtEmail= By.id("email");
    private By txtPassword= By.id("password");
    private By txtPhoneNumber= By.id("phoneNumber");
    private By txtAddress=By.id("address");
    private By btnRadio=By.cssSelector("[type=radio]");
    private By chkTerms=By.cssSelector("[type=checkbox]");
    private By btnRegister=By.id("register");

    public SignupPage(WebDriver driver){
        this.driver=driver;
    }
    public void signup(UserModel userModel){
        driver.findElement(txtFirstName).sendKeys(userModel.getFirstname());
        driver.findElement(txtLastName).sendKeys(userModel.getLastname()==null?"":userModel.getLastname());
        driver.findElement(txtEmail).sendKeys(userModel.getEmail());
        driver.findElement(txtPassword).sendKeys(userModel.getPassword());
        driver.findElement(txtPhoneNumber).sendKeys(userModel.getPhonenumber());
        driver.findElement(txtAddress).sendKeys(userModel.getAddress()==null?"":userModel.getAddress());
        driver.findElements(btnRadio).get(0).click();
        driver.findElement(chkTerms).click();
        driver.findElement(btnRegister).click();
    }
}
