package helper;

import exceptions.InvalidPropertyKeyException;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Properties;

public class PropertiesHelper {

    private static Properties properties;

    /**
     * function to initialize properties helper
     */
    public static void initializePropertiesHelper() {
        try {
            // check if properties helper is already initialized
            if (properties == null) {
                properties = new Properties();
                properties.load(new FileInputStream(Paths.get(System.getProperty("user.dir")).getParent().toString()
                        + "\\credentials.properties"));
            }
        }
        catch (IOException e) {
            System.out.println("SOME ERROR OCCURRED INITIALIZING PROPERTIES!");
        }
    }

    /**
     * function to get a specific property value using corresponding key
     * @param key: key for the required property value
     * @return: property value for the provided key
     */
    public static String getPropertyValue(String key) {
        String value = properties.getProperty(key);
        // check if property value exists for given key
        if (value == null) {
            throw new InvalidPropertyKeyException("Invalid Key: "+key);
        }
        else return value.trim();
    }
}
