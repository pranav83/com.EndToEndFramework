package SauceLab;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class Sauce {
    public static final String USERNAME = "pranav83";
    public static final String ACCESS_KEY = "ec61aa10-e2aa-4bac-aa35-a16e382d3e4b";
    public static final String URL = "http://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:80/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("platform","Windows 7");
        cap.setCapability("version","51.0");
        WebDriver driver = new RemoteWebDriver(new URL(URL),cap);
        driver.get("https://indiancouture.uk/");
        driver.manage().window().maximize();
        driver.quit();
    }
}
