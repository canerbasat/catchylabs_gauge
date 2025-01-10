package helper;

import com.thoughtworks.gauge.datastore.ScenarioDataStore;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.util.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;


import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AssertHelper extends GetElementHelper {

    private final Logger log = LogManager.getLogger(AssertHelper.class);
    public void assertString(String val1, String val2)
    {
        Assertions.assertEquals(val1,val2);
    }

    public void assertResultCalculator(String assertText, String key)
    {
        String rawText = getElementWithWait(key).getText();
        rawText = rawText.split("=")[1].trim();
        assertString(assertText,rawText);

    }
    public void assertText(String assertText, String key)
    {
        assertString(assertText,getElmText(key));
    }

    public String getElmText(String jsonKey){
        return getElementWithWait(jsonKey).getText();
    }

    public String getCalculatedResult(String jsonKey){
    String rawText = getElementWithWait(jsonKey).getText();
    return rawText.split("=")[1].trim();
    }

}