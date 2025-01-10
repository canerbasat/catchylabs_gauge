package imp;

import com.thoughtworks.gauge.Step;
import helper.AssertHelper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AssertImp extends AssertHelper {

    private final Logger log = LogManager.getLogger(AssertImp.class);

    @Step("Get result with <key> and compare with <assertText>")
    public void assertResult(String key, String assertText) throws Exception{
        assertResultCalculator(assertText, key);
        log.info("Assertion compeleted for \"{}\"", assertText);
    }

    @Step("Get Result of Calculator Hesap makinesinde <element> alanındaki sonuc degeri alinir")
    public void openBrowserTest(String jsonKey) {
        AssertHelper assertHelper = new AssertHelper();
        String caner = assertHelper.getCalculatedResult(jsonKey);
    }
}