package Resources;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass  {
    public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream fis;
    public static WebDriverWait wait;

    public static Logger log =  LogManager.getLogger(BaseClass.class.getName());

    public WebDriver intializeDriver() throws IOException {
        prop = new Properties();
        fis = new FileInputStream("D:\\com.EndToEndFramework\\src\\test\\Utils.resources\\data.properties");
        prop.load(fis);
        String browserName = prop.getProperty("browser");
        log.info(browserName);
        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\com.EndToEndFramework\\Drivers.resources\\chromedriver.exe");
          driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            wait = new WebDriverWait(driver, 10);


        }
        else if (browserName.equals("firefox")){
            driver = new FirefoxDriver();
        }
        else if (browserName.equals("IE")){
            driver = new InternetExplorerDriver();
        }
        else if (browserName.equals("edge")){
            driver = new EdgeDriver();
        }
        else if (browserName.equals("safari")){
            driver = new SafariDriver();

        }

        driver.manage().window().maximize();
        return driver;
    }
    public void getScreenShot(String testcaseName, WebDriver driver) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source =  ts.getScreenshotAs(OutputType.FILE);
        String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testcaseName+".png";
        FileUtils.copyFile(source,new File(destinationFile));


    }
}



