package utilsclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @aauthor : mr.muradil
 * @created : 24.11.2024,16:48
 **/
public class ConfigReader {
    public static Properties properties;

    static {
        try {
            FileInputStream file = new FileInputStream("config.properties");
            properties = new Properties();
            properties.load(file);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Could not read config.properties file!");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
