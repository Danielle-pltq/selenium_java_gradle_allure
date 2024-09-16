package selenium_java_gradle_allure;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericTestHelpers {

    public static List<String> BrowserOptions(boolean headless) {
        if (headless) {
            return Arrays.asList("--disable-search-engine-choice-screen", "--no-sandbox", "--headless",
                    "--start-maximized");
        } else {
            return Arrays.asList("--disable-search-engine-choice-screen", "--no-sandbox", "--start-maximized");
        }
    }

    public static WebDriver getHeadlessDriver(String browserName) {
        return getDriver(browserName, true);
    }

    public static WebDriver getDriver(String browserName, boolean headless) {
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.addArguments(BrowserOptions(headless));
                return new ChromeDriver(chromeoptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxoptions = new FirefoxOptions();
                firefoxoptions.addArguments(BrowserOptions(headless));
                return new FirefoxDriver(firefoxoptions);

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeoptions = new EdgeOptions();
                edgeoptions.addArguments(BrowserOptions(headless));
                return new EdgeDriver(edgeoptions);

            default:
                System.err.println("No valid browser name");
                return null;
        }
    }

}
