package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{
    @FindBy(id="profile span")
    private WebElement txtProfile;
    private WebDriver webDriver = null;
   // private WebDriverWait driverWait = null;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        driverWait.until(drv -> { return txtProfile.isDisplayed();});
    }

//    public MainPage(WebDriver webDriver) {
//        this.webDriver = webDriver;
//        driverWait = new WebDriverWait(webDriver,10);
//        driverWait.until(drv -> { return txtProfile.isDisplayed();});
//    }

    public String getCurrentUser(){
        return txtProfile.getText();
    }


}
