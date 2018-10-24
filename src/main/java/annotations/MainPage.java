package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{
    @FindBy(linkText = "Компетенции")
    private WebElement btnCompetencies;

    @FindBy(id="profile")
    private WebElement txtProfile;

    private WebDriver webDriver = null;
   // private WebDriverWait driverWait = null;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        //driverWait.until(ExpectedConditions.presenceOfElementLocated((By) txtProfile));
        driverWait.until(drv -> { return txtProfile.isDisplayed();});
    }



    public String getCurrentUser(){
        return txtProfile.getText();
    }

    public void submit() {
       // btnCompetencies = webDriver.findElement(By.linkText("Компетенции"));
        btnCompetencies.click();
    }
}
