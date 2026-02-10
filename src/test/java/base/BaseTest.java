package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest(groups = "smoke")
    public void setup() {
        driver = DriverFactory.initDriver(); //Factory Design
        driver.get(ConfigReader.getInstance().get("baseUrl")); //singleton
    }

    @AfterTest(groups = "smoke")
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
