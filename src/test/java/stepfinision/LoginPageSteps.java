package stepfinision;

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
    private WebDriver webDriver = null;
    LoginPage loginPage=null;
    MainPage mainPage = null;


    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\school\\chromedriver.exe");
        webDriver = new ChromeDriver();

        //Implisit wait
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @After
    public void tearDown(){
        webDriver.quit();
    }


    @Пусть("^открыта страница входа в приложение '(.+)'$")
    public void openLoginPage(String url){
       loginPage = new LoginPage(webDriver);
       loginPage.open(url);
    }

    @И ("^пользователь вводит в поле \"([^\"]*)\" значение \"([^\"]*)\"$")
    public void setTextToInput(String fieldName,String value){
        switch (fieldName){
            case "имя пользователя":
                loginPage.fillUser(value);
                break;
            case "пароль":
                loginPage.fillPass(value);
                break;
                default:throw new IllegalArgumentException("Invalid field name:" + fieldName);
        }
    }
    @И ("^нажимает кнопку \"([^\"]*)\"$")
    public void clickButton(String btnName){
        if(!btnName.equals("отправить")){
            throw new IllegalArgumentException("Invalid button name" + btnName);
        }
        loginPage.submit();
    }

    @Тогда("^открывается главная страница")
    public void openMainPage(){
        MainPage mainPage = new MainPage(webDriver);
    }

    @Также("^на главной странице в правом верхнем углу видно имя пользователя \"([^\"]*)\"$")
    public void checkUsName(String text){
        Assert.assertEquals(text,mainPage.getCurrentUser());
    }



}
