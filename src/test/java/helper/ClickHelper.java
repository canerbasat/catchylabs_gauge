package helper;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ClickHelper extends GetElementHelper {

    private static final Logger log = LogManager.getLogger(ClickHelper.class);


    public void clickElement(String jsonKey) {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new ClickableHelper().waitForClickable(jsonKey).click();
        log.info("{} element clicked", jsonKey);
    }


}
