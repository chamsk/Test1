package local.usser.stepdefinition;


import annotations.LoginPage;
import annotations.MainPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Пусть;
import cucumber.api.java.ru.Также;
import cucumber.api.java.ru.Тогда;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class LoginPageSteps {
    private WebDriver driver = null;

    private LoginPage loginPage = null;
    private MainPage mainPage = null;


    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "D:\\school\\chromedriver.exe");
        driver = new ChromeDriver();
        //Implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Пусть("^открыта страница входа в приложение '(.+)'$")
    public void openLoginPage(String url) {
        loginPage = new LoginPage(driver);
        loginPage.open(url);
    }

    @И("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void setTextToInput(String fieldName, String value) {
        switch (fieldName) {
            case "имя пользователя":
                loginPage.fillUser(value);
                break;

            case "пароль":
                loginPage.fillPass(value);
                break;

            case "фамилия":
                mainPage.fillLastName(value);
                break;

            case "имя":
                mainPage.fillFirstName(value);
                break;

            case "отчество":
                mainPage.fillPatronymicName(value);
                break;


            default:
                throw new IllegalArgumentException("Invalid field name: " + fieldName);
        }
    }

    @И("^нажимает кнопку \"([^\"]*)\"$")
    public void clickButton(String btnName) {
//        if (!btnName.equals("отправить")) {
//            throw new IllegalArgumentException("Invalid button name: " + btnName);
//        }
        switch (btnName){
            case "отправить":
                loginPage.submit();
                break;
            case "добавить человека":
                mainPage.addPeroson();
                break;
             default: throw new IllegalArgumentException("Invalid button name: " + btnName);
        }

    }
    @Тогда("^открылась страница \"([^\"]*)\"$")
    public void openPage(String page){
        switch (page){
            case "главная":
                mainPage = new MainPage(driver);
                break;
            default: throw new IllegalArgumentException("Invalid page : " + page);
        }
    }


    @Также("^на главной странице в правом верхнем углу видно имя пользователя \"([^\"]*)\"$")
    public void checkUserName(String text) {
        Assert.assertEquals(text, mainPage.getCurrentUser());
    }



}
