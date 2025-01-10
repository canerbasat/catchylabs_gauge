package pages;

import com.thoughtworks.gauge.Step;
import helper.ClickHelper;

public class HomePage {
    ClickHelper clickHelper = new ClickHelper();
    @Step("Hesap Makinesi <key> elementine tiklanarak acilir")
    public void openCalculator(String jsonKey) {
        clickHelper.clickElement(jsonKey);
    }

}
