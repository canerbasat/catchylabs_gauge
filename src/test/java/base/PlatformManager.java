package base;

import configuration.Configuration;
import enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Locale;
import java.util.Objects;

public class PlatformManager {
    private static PlatformManager instance;
    private WebDriver driver;
    private PlatformManager() {
    }

    public static PlatformManager getInstances() {
        if (instance == null) {
            instance = new PlatformManager();
        }
        return instance;
    }

    // WebDriver başlatma
    public void createWebDriver(String browserName) {
        switch (Objects.requireNonNull(browserName).toLowerCase(Locale.ENGLISH)) {
            case "chrome" -> {
                driver = new ChromeDriver();
            }
            case "firefox" -> {
                driver = new FirefoxDriver();
            }
            case "safari" -> {
                driver = new SafariDriver();
            }
            case "edge" -> {
                driver = new EdgeDriver();
            }
            default -> throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }
        configureDriver();
    }

    private void configureDriver() {
        if (driver != null) {
            String BASE_URL = Configuration.getInstance().getStringValueOfProp("baseUrl");
            driver.manage().window().maximize();
            driver.navigate().to(BASE_URL);
        }
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }
}

