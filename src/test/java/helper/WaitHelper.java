package helper;

import locator.GetBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.PlatformManager;

import java.time.Duration;

public class WaitHelper extends GetBy {

    public static final int DEFAULT_SLEEP_IN_MILLIS = 30;
    public static final int DEFAULT_TIME_OUT = 15;

    public WebDriverWait getWebDriverWait(int timeoutInSeconds) {
        return getWebDriverWait(timeoutInSeconds, DEFAULT_SLEEP_IN_MILLIS);
    }

    public WebDriverWait getWebDriverWait() {
        return getWebDriverWait(DEFAULT_TIME_OUT, DEFAULT_SLEEP_IN_MILLIS);
    }

    public WebDriverWait getWebDriverWait(int timeoutInSeconds, int sleepInMillis) {
        WebDriver driver = PlatformManager.getInstances().getDriver();
        return new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds), Duration.ofMillis(sleepInMillis));
    }

    public void waitSomeTime(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}