package imp;

import com.thoughtworks.gauge.Step;
import helper.AssertHelper;
import helper.SendKeysHelper;
import util.StoreUtil;


public class SendKeysImp extends SendKeysHelper {



    AssertHelper assertHelper = new AssertHelper();
    @Step("Send <keys> text to the <element> element")
    public void sendKeyStep(String key, String element) {
        sendKeys(element, key);
    }

    @Step("Clear text from the <element> element")
    public void sendKeyStep(String element) {
        sendClear(element);
    }


    @Step("Get <storedElement> stored text and text to the <element> element")
    public void getTextAndStoresScenarioStore(String storeKey,String jsonKey) {
        StoreUtil storeUtil = new StoreUtil();
        String ca = storeUtil.get(storeKey).toString();
        sendKeys(jsonKey, ca);
        //String text = assertHelper.getElmText(jsonKey);
    }


}
