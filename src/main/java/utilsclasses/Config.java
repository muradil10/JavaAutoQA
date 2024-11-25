package utilsclasses;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * @aauthor : mr.muradil
 * @created : 16.08.2024,15:32
 **/
public class Config {
    public static String readFromConfig(String fileName, String key) {
        Properties properties = new Properties();
        try (FileInputStream inputStream = new FileInputStream(fileName)) {
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Config file not found: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new RuntimeException("Error reading config file: " + e.getMessage(), e);
        }
        return properties.getProperty(key);
    }
}
