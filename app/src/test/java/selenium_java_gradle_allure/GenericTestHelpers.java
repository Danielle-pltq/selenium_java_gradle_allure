package selenium_java_gradle_allure;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericTestHelpers {

    public static WebDriver getHeadlessDriver(String browserName) {
        switch (browserName.trim().toLowerCase()) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeoptions = new ChromeOptions();
                chromeoptions.addArguments("--disable-search-engine-choice-screen");
                chromeoptions.addArguments("--no-sandbox");
                chromeoptions.addArguments("--headless");
                return new ChromeDriver(chromeoptions);

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                FirefoxOptions firefoxoptions = new FirefoxOptions();
                firefoxoptions.addArguments("--disable-search-engine-choice-screen");
                firefoxoptions.addArguments("--no-sandbox");
                firefoxoptions.addArguments("--headless");
                return new FirefoxDriver(firefoxoptions);

            case "edge":
                WebDriverManager.edgedriver().setup();
                EdgeOptions edgeoptions = new EdgeOptions();
                edgeoptions.addArguments("--disable-search-engine-choice-screen");
                edgeoptions.addArguments("--no-sandbox");
                edgeoptions.addArguments("--headless");
                return new EdgeDriver(edgeoptions);

            default:
                System.err.println("No valid browser name");
                return null;
        }

    }

}
