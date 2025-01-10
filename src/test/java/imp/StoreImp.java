package imp;

import com.thoughtworks.gauge.Step;
import helper.AssertHelper;
import helper.GetElementHelper;
import util.StoreUtil;

public class StoreImp {
    AssertHelper assertHelper = new AssertHelper();
    StoreUtil storeUtil = new StoreUtil();

    @Step("Get <key> element text and store it Scenario Store with <storeKey> key")
    public void getTextAndStoreScenarioStore(String jsonKey, String storeKey) {
        String text = assertHelper.getElmText(jsonKey);
        text = text.split("=")[1].trim();
        storeUtil.put(storeKey, text);
    }


}
