package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import utils.ConfigReader;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;

    @BeforeTest(groups = "smoke")
    public void setup() throws IOException {
        new ConfigReader();
        driver = DriverFactory.initDriver(ConfigReader.get("browser"));
        //driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterTest(groups = "smoke")
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
