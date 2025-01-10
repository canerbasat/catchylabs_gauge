package helper;

import enums.Browsers;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import base.PlatformManager;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.time.Duration;


public class SendKeysHelper extends GetElementHelper {

    private static final Logger logger = LogManager.getLogger(SendKeysHelper.class);

    public void sendKeys(String jsonKey, String text) {
            WebElement element = getElementWithWait(jsonKey);
            element.sendKeys(text);
            logger.info("The text, {} was sent to the element that {}", text, jsonKey);
    }

    public void sendKeysWithDelay(String jsonKey, String text) {
        WebElement element = getElementWithWait(jsonKey);
        for (char c : text.toCharArray()) {
            element.sendKeys(Character.toString(c));
        }
    }

    public void sendClear(String jsonKey) {
        WebElement element = getElementWithWait(jsonKey);
        element.clear();
    }



}
