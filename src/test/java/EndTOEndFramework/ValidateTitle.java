package EndTOEndFramework;

import EndTOEndFramework.PageObject.LandingPage;
import Resources.BaseClass;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;



public class ValidateTitle extends BaseClass {
    public static WebDriver driver;
   public static Logger log =  LogManager.getLogger(BaseClass.class.getName());
    LandingPage lp = new LandingPage(driver);

    @BeforeTest
    public void openBrowser() throws IOException {
        driver = intializeDriver();
        log.info("Driver is Intialize");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to HomePage");
    }
    @Test
    public void titleValidate()  {

        lp = new LandingPage(driver);
        Assert.assertTrue(lp.gettitle().isDisplayed());
        log.info("Successfully Validated Title.");
    }
    @Test
    public void hello()  {

        lp = new LandingPage(driver);
        Assert.assertTrue(lp.hello().isDisplayed());
        log.info("Successfully Validated Hello.");
    }
    @AfterTest
    public void tearDown(){
        driver.quit();
    }



}
