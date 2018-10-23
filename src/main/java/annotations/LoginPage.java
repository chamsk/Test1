package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{
    @FindBy(id= "login-username")
    private WebElement txtUserName;

    @FindBy(id="login-password")
    private WebElement txtPassword;

    @FindBy(id="login-button")
    private WebElement btnSubmit;

//    public LoginPage(WebDriver webDriver) {
//        this.webDriver = webDriver;
//        webDriver.get("http://at.pflb.ru/matrixboard2/");
//    }
    {
        webDriver.get("http://at.pflb.ru/matrixboard2/");
    }

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillUser(String s){
        txtUserName.sendKeys(s);
    }

    public void fillPass(String s){
        txtPassword.sendKeys(s);
    }

    public void submit(){
        btnSubmit.click();
    }
}
