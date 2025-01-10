package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import base.PlatformManager;

import java.util.List;

public class GetElement extends GetBy {

    // Tek bir WebElement'i al
    protected WebElement getWebElement(String jsonKey) {
        // Locator'ı bul
        var by = findLocator(jsonKey);
        // Driver kullanarak elementi bul
        return PlatformManager.getInstances().getDriver().findElement(by);
    }

    // By ile WebElement al (statik yöntem)
    public static WebElement getWebElement(By by) {
        return PlatformManager.getInstances().getDriver().findElement(by);
    }

    // Birden fazla WebElement al
    protected List<WebElement> getWebElements(String jsonKey) {
        // Locator'ı bul
        var by = findLocator(jsonKey);
        // Driver kullanarak elementleri bul
        return PlatformManager.getInstances().getDriver().findElements(by);
    }

    // By ile birden fazla WebElement al
    protected List<WebElement> getWebElements(By by) {
        return PlatformManager.getInstances().getDriver().findElements(by);
    }
}