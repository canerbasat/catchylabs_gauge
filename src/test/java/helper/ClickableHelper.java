package helper;

import locator.GetElement;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ClickableHelper extends WaitHelper {

    public WebElement waitForClickable(String jsonKey) {
        By by = findLocator(jsonKey);
        return getWebDriverWait().until(ExpectedConditions.elementToBeClickable(by));
    }

}
