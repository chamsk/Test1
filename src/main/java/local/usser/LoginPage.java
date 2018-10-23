package local.usser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private By login = By.id("login-username");
    private By pass = By.id("login-password");
    private By button = By.id("login-button");

    private WebDriver webDriver = null;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriver.get("http://at.pflb.ru/matrixboard2/");
    }

    public void fillUser(String s){
        webDriver.findElement(login).sendKeys(s);
    }

    public void fillPass(String s){
        webDriver.findElement(pass).sendKeys(s);
    }

    public void submit(){
        webDriver.findElement(button).click();
    }
}
