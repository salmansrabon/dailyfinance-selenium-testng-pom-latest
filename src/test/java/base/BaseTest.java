package base;

import driver.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;

import java.io.IOException;

public class BaseTest {

    public WebDriver driver;

    @BeforeClass
    public void setup() throws IOException {
        new ConfigReader();
        driver = DriverFactory.initDriver(ConfigReader.get("browser"));
        //driver = DriverFactory.getDriver();
        driver.get(ConfigReader.get("baseUrl"));
    }

    @AfterClass
    public void teardown() {
        DriverFactory.quitDriver();
    }
}
