package local.usser;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

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
        loginPage.fillUser("user");
        loginPage.fillPass("user");
        loginPage.submit();
        MainPage mainPage = new MainPage(webDriver);
        Assert.assertEquals("user",mainPage.getCurrentUser());
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
