package imp;

import com.thoughtworks.gauge.Step;
import helper.DisplayHelper;


public class DisplayImp extends DisplayHelper {

    @Step("Display the <element> element")
    public void displayedTextImp(String element) {
        displayedElement(element);

    }

    @Step("Is Not Display the <element> element")
    public void elementNotDisplayedImp(String element) {
        elementNotDisplayed(element);

    }


}
