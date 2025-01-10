package locator;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import configuration.Configuration;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.util.Locale;

public abstract class GetBy {

    public static By findLocator(String jsonKey) {
        File folder = new File(Configuration.getInstance().getStringValueOfProp("locator_folder"));
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            if (folder.isDirectory()) {
                // .json dosyalarını bul
                File[] files = folder.listFiles((dir, name) -> name.endsWith(".json"));

                if (files != null) {
                    for (File file : files) {
                        // JSON dosyasını oku
                        JsonNode rootNode = objectMapper.readTree(file);
                        JsonNode targetNode = rootNode.get(jsonKey);

                        if (targetNode != null) {
                            // JSON'dan locator türü ve değerini al
                            String locatorType = targetNode.fieldNames().next();
                            String locatorValue = targetNode.get(locatorType).asText();

                            // Locator türüne göre By nesnesini oluştur
                            return getByValue(locatorType, locatorValue);
                        }
                    }
                }
            }

            // JSON dosyalarında key bulunamazsa hata
            throw new IllegalArgumentException(String.format("Locator for key '%s' not found in folder '%s'", jsonKey, folder));
        } catch (IOException e) {
            // JSON dosyalarını okurken hata oluşursa
            throw new RuntimeException("Error reading JSON files for locator key: " + jsonKey, e);
        }
    }

    // Locator türüne göre By nesnesini dönen yardımcı yöntem
    private static By getByValue(String locatorType, String locatorValue) {
        switch (locatorType.toUpperCase(Locale.ENGLISH)) {
            case "ID":
                return By.id(locatorValue);
            case "XPATH":
                return By.xpath(locatorValue);
            case "CSSSELECTOR":
                return By.cssSelector(locatorValue);
            default:
                throw new IllegalArgumentException("Unsupported locator type: " + locatorType);
        }
    }
}