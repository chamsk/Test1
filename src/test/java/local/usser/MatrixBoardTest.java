package local.usser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MatrixBoardTest {
    private WebDriver webDriver = null;
    private WebDriverWait webDriverWait = null;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\school\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriverWait = new WebDriverWait(webDriver,5);
    }

    @Test
    public void loginTest(){
        webDriver.get("http://at.pflb.ru/matrixboard2/");
        WebElement login =  webDriver.findElement(By.id("login-username"));
        WebElement pass = webDriver.findElement(By.cssSelector("#login-password"));
        WebElement button = webDriver.findElement(By.xpath("//*[@id='login-button']"));


        login.sendKeys("user");
        pass.sendKeys("user");
        button.click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#profile span")));

        WebElement userName = webDriver.findElement(By.cssSelector("#profile > a > span"));
        Assert.assertEquals("user",userName.getText());
    }

    @AfterTest
    public void tearDown(){
        webDriver.quit();
    }
}
