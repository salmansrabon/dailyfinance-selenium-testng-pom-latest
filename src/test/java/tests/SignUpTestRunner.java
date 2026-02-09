package tests;

import base.BaseTest;
import com.github.javafaker.Faker;
import models.UserModel;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.collections.SetMultiMap;
import pages.SignupPage;
import utils.JSONManager;
import utils.Utils;

import java.io.IOException;

public class SignUpTestRunner extends BaseTest {
    @Test(priority = 1, description = "Signup with all user data", groups = "smoke")
    public void signup_full() throws IOException, ParseException {
        SignupPage signupPage=new SignupPage(driver);
        driver.findElement(By.partialLinkText("Register")).click();
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String email="salmansrabon+"+ Utils.generateRandomNumber(100,999)+"@gmail.com";
        String password="1234";
        String phoneNumber="0170"+Utils.generateRandomNumber(1000000,9999999);
        String address="Dhaka";
        UserModel userModel=new UserModel();
        userModel.setFirstname(firstName);
        userModel.setLastname(lastName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhonenumber(phoneNumber);
        userModel.setAddress(address);
        signupPage.signup(userModel);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",firstName);
        jsonObject.put("lastName",lastName);
        jsonObject.put("email",email);
        jsonObject.put("password",password);
        jsonObject.put("phoneNumber",phoneNumber);
        jsonObject.put("address",address);
        JSONManager.saveJSONData(jsonObject);
    }
    @Test(priority = 2, description = "Signup with only mandatory data")
    public void signup() throws IOException, ParseException {
        SignupPage signupPage=new SignupPage(driver);
        driver.findElement(By.partialLinkText("Register")).click();
        Faker faker=new Faker();
        String firstName=faker.name().firstName();
        String email="salmansrabon+"+ Utils.generateRandomNumber(100,999)+"@gmail.com";
        String password="1234";
        String phoneNumber="0170"+Utils.generateRandomNumber(1000000,9999999);
        UserModel userModel=new UserModel();
        userModel.setFirstname(firstName);
        userModel.setEmail(email);
        userModel.setPassword(password);
        userModel.setPhonenumber(phoneNumber);
        signupPage.signup(userModel);
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("firstName",firstName);
        jsonObject.put("email",email);
        jsonObject.put("password",password);
        jsonObject.put("phoneNumber",phoneNumber);
        JSONManager.saveJSONData(jsonObject);
    }
}
