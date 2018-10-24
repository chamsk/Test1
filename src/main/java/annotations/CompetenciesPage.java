package annotations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class CompetenciesPage extends AbstractPage {

    @FindBy(id = "add-section")
    private WebElement btnAddSection ;

    public CompetenciesPage(WebDriver webDriver) {
        super(webDriver);
        driverWait.until(drv -> { return btnAddSection.isDisplayed();});
    }

    public String getBtnAddSectionText() {
        return btnAddSection.getText();
    }
}
