package local.usser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    private By profileSelecto = By.cssSelector("#profile span");
    private WebDriver webDriver = null;
    private WebDriverWait driverWait = null;

    public MainPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        driverWait = new WebDriverWait(webDriver,10);
       // driverWait.until(ExpectedConditions.presenceOfElementLocated(profileSelecto));
        driverWait.until(drv -> { return drv.findElement(profileSelecto).isDisplayed();});
    }

    public String getCurrentUser(){
        return webDriver.findElement(profileSelecto).getText();
    }


}
