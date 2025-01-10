package pages;

import com.thoughtworks.gauge.Step;
import helper.ClickHelper;
import org.checkerframework.checker.units.qual.C;
import util.StoreUtil;

import java.util.AbstractMap;
import java.util.Map;

public class CalculatorPage {
    ClickHelper clickHelper = new ClickHelper();
    private static final Map<String, String> elementMap = Map.ofEntries(
            new AbstractMap.SimpleEntry<>(",", "calculator_page_comma_button"),
            new AbstractMap.SimpleEntry<>("0", "calculator_page_zero_button"),
            new AbstractMap.SimpleEntry<>("1", "calculator_page_one_button"),
            new AbstractMap.SimpleEntry<>("2", "calculator_page_two_button"),
            new AbstractMap.SimpleEntry<>("3", "calculator_page_three_button"),
            new AbstractMap.SimpleEntry<>("4", "calculator_page_four_button"),
            new AbstractMap.SimpleEntry<>("5", "calculator_page_five_button"),
            new AbstractMap.SimpleEntry<>("6", "calculator_page_six_button"),
            new AbstractMap.SimpleEntry<>("7", "calculator_page_seven_button"),
            new AbstractMap.SimpleEntry<>("8", "calculator_page_eight_button"),
            new AbstractMap.SimpleEntry<>("9", "calculator_page_nine_button")
    );
    @Step("Send <number> number to calculator")
    public void enterNumber(String number) {
        for (char digit : number.toCharArray()) {
            String jsonKey = elementMap.get(String.valueOf(digit));
            if (jsonKey != null) {
                clickHelper.clickElement(jsonKey);
            } else {
                throw new IllegalArgumentException("Unsupported digit: " + digit);
            }
        }
    }

    @Step("Send <number> number to calculator <loop> times and multiply")
    public void enterNumberWithLoop(String number, int loop) throws InterruptedException {
        for (int i = 1; i < loop; i++) {
            Thread.sleep(120);
            clickHelper.clickElement("calculator_page_multiply_button");
            for (char digit : number.toCharArray()) {
                String jsonKey = elementMap.get(String.valueOf(digit));
                if (jsonKey != null) {
                    Thread.sleep(120);
                    clickHelper.clickElement(jsonKey);
                }else {
                    throw new IllegalArgumentException("Unsupported digit: " + digit);
                }
            }
            Thread.sleep(120);
            clickHelper.clickElement("calculator_page_result_button");
        }
    }
    @Step("Get <storedElement> stored value and send number to calculator")
    public void getTextAndStoresScenarioStore(String storeKey) {
        StoreUtil storeUtil = new StoreUtil();
        String storedValue = storeUtil.get(storeKey).toString();
        enterNumber(storedValue);
    }
}
