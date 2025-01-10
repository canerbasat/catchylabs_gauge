package base;

import com.thoughtworks.gauge.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.FileNotFoundException;

public class LunchApp {
    private  final Logger log = LogManager.getLogger(TestBase.class);


    @Step("Getcapabilities from resource with JSON file and lunch app")
    public void lunchApp() throws FileNotFoundException {
        var app = new TestBase();
        app.lunchLocalDriver();
        log.info("appium lunched with capabilities {}");
    }
    @Step("Deneme Get <jsonKey> capabilities from resource with JSON <json file> file and lunch app")
    public void lunchAppJSON(String jsonKey, String jsonFile) throws FileNotFoundException {
        var app = new TestBase();
        app.lunchLocalDriver();
        log.info("appium lunched with capabilities {}", jsonFile);
    }



    @Step("Close App")
    public void quitApp() {
        PlatformManager.getInstances().quitDriver();

    }

}
