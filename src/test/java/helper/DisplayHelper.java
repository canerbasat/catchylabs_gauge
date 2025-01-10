package helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

import java.util.List;


public class DisplayHelper extends GetElementHelper{

    private final Logger log = LogManager.getLogger(ClickHelper.class);

    public void displayedElement(String jsonKey) {
        getElementWithWait(jsonKey).isDisplayed();
         log.info("{} element displayed", jsonKey);
    }
    public void elementNotDisplayed(String jsonKey) {
        List<WebElement> elements = getWebElements(jsonKey);
        Assertions.assertTrue(elements.isEmpty(), "Element is not present");
    }




}
