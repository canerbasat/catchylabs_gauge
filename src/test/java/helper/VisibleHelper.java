package helper;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class VisibleHelper extends WaitHelper{

    public WebElement waitUntilVisible (By by, int timeout){
        return (WebElement) getWebDriverWait(timeout).until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitUntilVisible (By by){
        return waitUntilVisible(by,DEFAULT_TIME_OUT);
    }

    public List<WebElement> waitUntilVisibleAll (By by, int timeout){
        var webElements = getWebDriverWait(timeout)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        var webElement = new ArrayList<WebElement>();
        webElements.stream().map(e -> (WebElement) e).forEach(webElement::add);
        return webElement;
    }

    public List<WebElement> waitUntilVisibleAll (By by){
        return waitUntilVisibleAll(by,DEFAULT_TIME_OUT);
    }
}
