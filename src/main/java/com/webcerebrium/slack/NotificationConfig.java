package com.webcerebrium.slack;

import com.google.common.base.Strings;
import java.util.Properties;

public class NotificationConfig {

    /**
     * properties that are loaded from local resource file
     */
    private Properties prop = null;

    public NotificationConfig() {
        this.loadProperties();
    }

    /**
     *  Loading available properties from local resource file
     */
    protected void loadProperties() {
        try {
            prop = new Properties();
            prop.load(this.getClass().getClassLoader().getResourceAsStream("application.properties"));
        } catch (Exception e) {
            // it is fine not to have that resource file.
            // ignoring any error here
        }
    }

    /**
     * Getting variable from one of the multiple sources available
     * @param key variable name
     * @return string result
     */
    public String getVariable(String key) {
        // checking VM options for properties
        String sysPropertyValue = System.getProperty(key);
        if (!Strings.isNullOrEmpty(sysPropertyValue)) return sysPropertyValue;

        // checking enviroment variables for properties
        String envPropertyValue = System.getenv(key);
        if (!Strings.isNullOrEmpty(envPropertyValue)) return envPropertyValue;

        // checking resource file for property
        if (prop != null) {
            String property = prop.getProperty(key);
            if (!Strings.isNullOrEmpty(property)) return property;
        }
        return "";
    }

}
