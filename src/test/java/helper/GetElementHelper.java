package helper;

import locator.GetElement;
import org.openqa.selenium.WebElement;

import java.io.FileNotFoundException;
import java.util.List;

import static locator.GetBy.findLocator;

public class GetElementHelper extends GetElement {

    private static PresenceHelper presenceHelper;
    private static VisibleHelper visibleHelper;

    public GetElementHelper() {
        presenceHelper = new PresenceHelper();
        visibleHelper = new VisibleHelper();
    }

    protected WebElement getElementWithWait(String jsonKey) {
        var by = findLocator(jsonKey);
        presenceHelper.waitUntilPresence(by);
        return visibleHelper.waitUntilVisible(by);
    }
    protected static List<WebElement> getElementsWithWait(String jsonKey){
        var by = findLocator(jsonKey);
        presenceHelper.waitUntilPresenceAll(by);
        return visibleHelper.waitUntilVisibleAll(by);
    }


}
