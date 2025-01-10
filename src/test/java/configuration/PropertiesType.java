package configuration;

public enum PropertiesType {

    BASE_URL("connectionString"),
    BROWSER("browser");

    public final String propertiesTypeText;

    PropertiesType(String value) {
        this.propertiesTypeText = value;
    }

    public String getText() {
        return propertiesTypeText;
    }
}