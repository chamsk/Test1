package annotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage extends AbstractPage{
    @FindBy(xpath = "//a[contains(@href, 'index.jsp')]")
    private WebElement btnPeople;

    @FindBy(id="profile")
    private WebElement txtProfile;

    @FindBy (id = "add-person")
    private WebElement btnAddPerson;

    @FindBy (id = "person-last-name")
    private WebElement txtLastName;

    @FindBy (id = "person-first-name")
    private WebElement txtFirstName;

    @FindBy (id = "person-patronymic-name")
    private WebElement txtpatronymicName;



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

    public void addPeroson() {
        btnAddPerson.click();
    }

    public void fillLastName(String s){
        txtLastName.sendKeys(s);
    }

    public void fillFirstName(String s){
        txtFirstName.sendKeys(s);
    }

    public void fillPatronymicName(String s){
        txtpatronymicName.sendKeys(s);
    }
}
