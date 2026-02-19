# Selenium POM – Design Patterns & SOLID

This Selenium automation framework is built using Page Object Model (POM) and follows Design Patterns and SOLID principles to ensure the framework is maintainable, scalable, and easy to extend.

The project structure separates responsibilities into packages such as:
- base
- driver
- pages
- tests
- utils

---

## Singleton

Definition:  
Singleton ensures a class has only one instance and provides a global access point to it.

Use in this project:  
Configuration is managed using a single shared instance.

Example (ConfigReader):

public class ConfigReader {

    private static ConfigReader instance = new ConfigReader();
    private Properties prop;

    private ConfigReader() {
        // load config.properties
    }

    public static ConfigReader getInstance() {
        return instance;
    }

    public String get(String key) {
        return prop.getProperty(key);
    }
}

---

## Factory Pattern

Definition:  
Factory pattern centralizes object creation and hides the creation logic from the client.

Use in this project:  
DriverFactory creates browser instances based on configuration.

Example:

public class DriverFactory {

    public static WebDriver initDriver(String browser) {

        if (browser.equalsIgnoreCase("chrome")) {
            return new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox")) {
            return new FirefoxDriver();
        }

        throw new RuntimeException("Browser not supported: " + browser);
    }
}

Usage in BaseTest:

driver = DriverFactory.initDriver(ConfigReader.getInstance().get("browser"));

---

## SRP – Single Responsibility Principle

Definition:  
A class should have only one responsibility.

Use in this project:

BaseTest       → Test setup and teardown  
DriverFactory  → Browser creation  
ConfigReader   → Configuration loading  
Page classes   → Page actions only

Example (Page class):

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("loginBtn")).click();
    }
}

---

## OCP – Open/Closed Principle

Definition:  
Software should be open for extension but closed for modification.

Use in this project:  
New browser support can be added in DriverFactory without changing test classes.

Test code:

WebDriver driver = DriverFactory.initDriver("chrome");

To support a new browser, only DriverFactory is updated.

---

## LSP – Liskov Substitution Principle

Definition:  
Objects of implementations should be replaceable without affecting program behavior.

Use in this project:

WebDriver driver;

driver = new ChromeDriver();
driver = new FirefoxDriver();

Tests work with WebDriver interface, so any browser can replace another without changing test logic.

---

## ISP – Interface Segregation Principle

Definition:  
Clients should not be forced to depend on methods they do not use.

Use in this project:  
Utility classes are separated inside the utils package.

Examples:
- ConfigReader → configuration
- (Other helpers separated by responsibility)

Each class provides only its specific functionality.

---

## DIP – Dependency Inversion Principle

Definition:  
High-level modules should depend on abstractions, not concrete implementations.

Use in this project:

Tests and page classes depend on:

WebDriver driver;

instead of:

ChromeDriver driver;

Driver is provided through BaseTest using DriverFactory.

Example:

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        String browser = ConfigReader.getInstance().get("browser");
        driver = DriverFactory.initDriver(browser);
    }
}

---

## Summary

Singleton  : ConfigReader instance  
Factory    : DriverFactory for browser creation  
SRP        : Separate responsibilities across packages  
OCP        : Extend browsers without changing tests  
LSP        : Any browser works via WebDriver interface  
ISP        : Separate utility classes in utils package  
DIP        : Tests depend on WebDriver abstraction

---

This framework demonstrates how Design Patterns and SOLID principles help build a clean, scalable, and maintainable Selenium automation architecture.
