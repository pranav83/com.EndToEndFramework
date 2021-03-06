package EndTOEndFramework.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LandingPage {

    public WebDriver driver;

    private By dismiss_Button = By.xpath("//button[contains(text(),'Dismiss')]");
    private By login = By.xpath("//a[contains(text(),'Sign-in')]");
    private By title = By.xpath("//div[@class='navbar-logo pull-left']//a//img");
    private By navigationBar = By.xpath("//dl[@class='navbar-main-menu hidden-xs']");
    private By hello = By.xpath("//div[contains(text(),'Hello')]");


    public LandingPage(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement getDismiss() {
        return driver.findElement(dismiss_Button);
    }

    public WebElement getLogin() {
        return driver.findElement((By) login);
    }

    public WebElement gettitle() {
        return driver.findElement((By) title);
    }

    public WebElement getNavBar() {
        return driver.findElement((By) navigationBar);
    }
    public WebElement hello(){
        return driver.findElement((By) hello);
    }


}
