package base;

import com.thoughtworks.gauge.*;
import configuration.Configuration;
import enums.Browsers;
import helper.ClickHelper;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.NotFoundException;
import com.thoughtworks.gauge.ExecutionContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import util.ExtentReportUtil;


import java.net.MalformedURLException;


public class TestBase {

    private  final Logger log = LogManager.getLogger(TestBase.class);

    public void lunchLocalDriver() throws NotFoundException {
        String browserType = Configuration.getInstance().getStringValueOfProp("browser");
        PlatformManager.getInstances().createWebDriver(browserType);
    }

    @AfterStep
    public void afterStep(ExecutionContext context) {
        String stepName = context.getCurrentStep().getText();
        ExtentReportUtil.log(stepName+" Step Is Worked");
        if (context.getCurrentScenario().getIsFailing()) {
            String errorMessage = context.getCurrentStep().getErrorMessage();
            ExtentReportUtil.fail(stepName + " Step Failed: " + errorMessage);
            PlatformManager.getInstances().quitDriver();
        }
    }

    @BeforeSuite
    public void beforeSuite(ExecutionContext context) {
        ExtentReportUtil.initReport();

    }
    @AfterSuite
    public void afterSuite(ExecutionContext context) {
        ExtentReportUtil.flushReport();
        String scenarioName = context.getCurrentScenario().getName();

    }

    @BeforeScenario
    public void beforeScenario(ExecutionContext executionContext) throws MalformedURLException {
        String scenarioName = executionContext.getCurrentScenario().getName();
        ExtentReportUtil.startTest(scenarioName, "Gauge Scenario Started");
        log.info("\n\n"+
                "_______________________\n" +
                "|  _________________  |\n" +
                "| |   CANER BASAT   | |\n" +
                "| |_________________| |\n" +
                "|  ___ ___ ___   ___  |\n" +
                "| | 7 | 8 | 9 | | + | |\n" +
                "| |___|___|___| |___| |\n" +
                "| | 4 | 5 | 6 | | - | |\n" +
                "| |___|___|___| |___| |\n" +
                "| | 1 | 2 | 3 | | x | |\n" +
                "| |___|___|___| |___| |\n" +
                "| | . | 0 | = | | / | |\n" +
                "| |___|___|___| |___| |\n" +
                "|_____________________|");
        log.info("_________________________________________________________________________" + "\r\n");
        log.info("------------------------SCENARIO-------------------------");
        log.info("SCENARIO NAME: " + executionContext.getCurrentScenario().getName());
        log.info("SCENARIO TAG: " + executionContext.getCurrentScenario().getTags().toString());
        lunchLocalDriver();
    }


    @AfterSpec
    public void afterSpec(ExecutionContext executionContext) {
        log.info("Spec running finished");
        log.info("=========================================================================" + "\r\n");
        PlatformManager.getInstances().quitDriver();
    }


    @AfterScenario
    public void afterScenario(ExecutionContext executionContext) {
        String scenarioName = executionContext.getCurrentScenario().getName();
        ExtentReportUtil.log(scenarioName+ " Scenario Finished");
        PlatformManager.getInstances().quitDriver();
        if (executionContext.getCurrentScenario().getIsFailing()) {
            log.info("TEST BAŞARISIZ");
        } else {
            log.info("TEST BAŞARILI");
        }

        log.info("_________________________________________________________________________" + "\r\n");
    }




    @AfterStep
    public void takeScreenShot() {
        var take_screens = Boolean.parseBoolean(System.getenv("screenshot_after_each_step"));
        if (take_screens)
            Gauge.captureScreenshot();
    }


}
