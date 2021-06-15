package TestCases.Railway;

import Common.Constant.Constant;
import PageObjects.Railway2.GeneralPage;
import PageObjects.Railway2.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Pre-condition");
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("Post-condition");
        Constant.WEBDRIVER.quit();
    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");
        GeneralPage generalPage = new GeneralPage();
        generalPage.open();

        generalPage.goToLoginPage();
        LoginPage loginPage = new LoginPage();

        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        String actualMsg = generalPage.getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");
    }
}
