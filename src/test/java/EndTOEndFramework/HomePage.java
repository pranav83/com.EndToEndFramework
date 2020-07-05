package EndTOEndFramework;

import EndTOEndFramework.PageObject.LandingPage;
import EndTOEndFramework.PageObject.LoginPage;
import Resources.BaseClass;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class HomePage extends BaseClass {
    public static WebDriver driver;
    public static Logger log = LogManager.getLogger(BaseClass.class.getName());

    @BeforeMethod
    public void openBrowser() throws IOException {
        driver = intializeDriver();
        log.info("Driver is Intialize");
        driver.get(prop.getProperty("url"));
        log.info("Navigated to HomePage");
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String Username, String Password, String text) throws IOException, InterruptedException {

        LandingPage lp = new LandingPage(driver);
        Thread.sleep(2000);
        lp.getDismiss().click();
        log.info("Clicked on Dismiss Button.");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        lp.getLogin().click();
        log.info("Clicked on login link text.");
        LoginPage login = new LoginPage(driver);
        login.getemail().sendKeys(Username);
        log.info("Enter UserName.");
        login.getPassword().sendKeys(Password);
        log.info("Enter Password");
        log.info(text);
        login.clickLoginButton();
        log.info("Clicked on Login Button.");
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Login')]")));
        if (element.isDisplayed()) {
            element.click();
            driver.findElement(By.xpath("//button[contains(@class,'btn btn btn-mega')]")).click();
            login.getemail().clear();
            login.getPassword().clear();
        }
    }
    @AfterMethod
    public void teardown() {
        driver.quit();
    }
    @DataProvider(name = "getData")
    public Object[][] getData() {
//      Array size start with zeroth index but 3 is size of array
//      0,1,2
        Object[][] data = new Object[3][3];
        data[0][0] = "ppothiwala@gmail.com";
        data[0][1] = "Neelraj1";
        data[0][2] = "Test1";
//
        data[1][0] = "jpothiwala@gmail.com";
        data[1][1] = "Neelraj1";
        data[1][2] = "Test2";
//
        data[2][0] = "npothiwala@gmail.com";
        data[2][1] = "Tisha11";
        data[2][2] = "Test3";

        return data;
    }


}



/*import java.io.IOException;

import PageObject.LoginPage;
import Resources.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomePage extends BaseClass {
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get("https://indiancouture.uk/sign-in");
		driver.findElement(By.xpath("//button[text(🙁'Dismiss']")).click();
	}
	@Test(priority = 1, dataProvider = "getData")
	public void basePageNavigation(String Username, String Password, String text)
			throws IOException, InterruptedException {
		LoginPage login = new LoginPage(driver);
		login.getemail().sendKeys(Username);
		login.getPassword().sendKeys(Password);
		System.out.println(text);
		login.clickLoginButton().click();
		WebElement element = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='modal-content']/div[2]/button")));
		if (element.isDisplayed()) {
			element.click();
			login.getemail().clear();
			login.getPassword().clear();
		}
	}
	@DataProvider
	public Object[][] getData() {
// Array size start with zeroth index but 3 is size of array
// 0,1,2
		Object[][] data = new Object[3][3];
		data[0][0] = "ppothiwala@gmail.com";
		data[0][1] = "Neelraj1";
		data[0][2] = "Test1";
		data[1][0] = "jpothiwala@gmail.com";
		data[1][1] = "Neelraj1";
		data[1][2] = "Test2";
		data[2][0] = "npothiwala@gmail.com";
		data[2][1] = "Tisha111";
		data[2][2] = "Test3";
		return data;
	}
}*/
