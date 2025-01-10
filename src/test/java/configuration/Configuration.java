package configuration;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.InputStream;
import java.util.Properties;

import static configuration.PropertiesType.*;


public class Configuration {

    private static Configuration instance;
    Properties configProps;
    protected static final Logger log = LogManager.getLogger(Configuration.class);
    static final String PROP_FILE_NAME = "config.properties";

    private String browser;
    private String baseUrl;


    public static Configuration getInstance() {
        if (instance == null) {
            createInstance();
        }
        return instance;
    }

    private static synchronized void createInstance() {
        if (instance == null) {
            instance = new Configuration();
        }
    }

    private Configuration() {

        try (InputStream is = ClassLoader.getSystemResourceAsStream(PROP_FILE_NAME)) {
            configProps = new Properties();
            configProps.load(is);
            baseUrl = configProps.getProperty(BASE_URL.getText());
            browser = configProps.getProperty(BROWSER.getText());
        } catch (Exception e) {
            log.error(e);
        } finally {
            log.info("Properties read finished.");
        }
    }

    public String getStringValueOfProp(String propKey) {
        return configProps.getProperty(propKey);
    }

    public Integer getIntegerValueOfProp(String propKey) {
        var portString = configProps.getProperty(propKey);
        return portString != null ? Integer.parseInt(portString) : null;
    }


    public String getBrowser() {
        return browser;
    }

    public String getBaseUrl() {
        return baseUrl;
    }
}