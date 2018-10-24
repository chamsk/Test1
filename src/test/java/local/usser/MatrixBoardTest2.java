package local.usser;
import annotations.CompetenciesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;
import annotations.LoginPage;
import annotations.MainPage;

public class MatrixBoardTest2 {
    private WebDriver webDriver = null;



    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\school\\chromedriver.exe");
        webDriver = new ChromeDriver();

        //Implisit wait
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void loggin(){
        LoginPage loginPage = new LoginPage(webDriver);
        loginPage.fillUser("admin");
        loginPage.fillPass("admin");
        loginPage.submit();
        MainPage mainPage = new MainPage(webDriver);
        //Assert.assertEquals("admin",mainPage.getCurrentUser());
        mainPage.submit();
        CompetenciesPage competenciesPage = new CompetenciesPage(webDriver);
        Assert.assertEquals("Создать",competenciesPage.getBtnAddSectionText());


    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
