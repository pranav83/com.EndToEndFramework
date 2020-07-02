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

    @BeforeMethod
    public void openBrowser() throws IOException {
        driver = intializeDriver();
        log.info("Driver is Intialize");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to HomePage");
    }
    @Test
    public void titleValidate()  {

        LandingPage lp = new LandingPage(driver);
        Assert.assertTrue(lp.gettitle().isDisplayed());
        log.info("Successfully Validated Title.");


    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
