package imp;

import com.thoughtworks.gauge.Step;
import helper.ClickHelper;

import java.util.Map;


public class ClickElementImp extends ClickHelper {


    @Step("Click the <element> element")
    public void clickElementStep(String element) {
        clickElement(element);
    }








}
