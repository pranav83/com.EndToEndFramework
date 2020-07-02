package EndTOEndFramework.PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    By email = By.id("username");
    By password = By.id("password");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");
    By  closeButton = By.xpath("//button[contains(@class,'btn btn btn-mega')]");


    public LoginPage(WebDriver driver){
        this.driver = driver;

    }


    public WebElement getemail(){
     return driver.findElement((By) email);
    }
    public WebElement getPassword(){
      return driver.findElement((By) password);
    }
    public WebElement clickLoginButton(){
       return driver.findElement((By) loginButton);
    }
   // public WebElement clickClose(){ return driver.findElement((By) closeButton);}


}
