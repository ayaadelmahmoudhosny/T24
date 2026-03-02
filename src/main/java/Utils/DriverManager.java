package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DriverManager {
    public static WebDriver driver;

    public static void openApp() throws IOException {
        ConfigurationReader reader = new ConfigurationReader();
        String url = reader.readConfigValue("Url");
        String browser_prop = reader.readConfigValue("browser");
        ChromeOptions options = new ChromeOptions();

        // Ignore SSL certificate errors
        options.setAcceptInsecureCerts(true);
        options.addArguments("--ignore-certificate-errors");
        driver = new ChromeDriver(options);


        driver.get(url);
    }

    public static void closeApp() {
        driver.quit();
    }
}