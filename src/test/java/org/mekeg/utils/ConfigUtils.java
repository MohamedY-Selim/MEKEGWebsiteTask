package org.mekeg.utils;

import java.util.Properties;

public class ConfigUtils {
    private Properties properties;
    private static ConfigUtils configUtils;

    private ConfigUtils() {
        String env = System.getProperty("env", "PRODUCTION");
        switch (env) {
            case "PRODUCTION" ->
                    properties = PropertiesUtils.loadProperties("src/test/java/org/mekeg/config/production.properties");
            case "LOCAL" ->
                    properties = PropertiesUtils.loadProperties("src/test/java/org/mekeg/config/local.properties");
            default -> throw new RuntimeException("Environment isn't supported");
        }
    }

    public static ConfigUtils getInstance() {
        if (configUtils == null) {
            configUtils = new ConfigUtils();
        }
        return configUtils;
    }

    public String getBaseUrl() {
        String prop = properties.getProperty("baseUrl");
        if (prop != null) return prop;
        throw new RuntimeException("Couldn't find the base url in the property file");
    }
}
