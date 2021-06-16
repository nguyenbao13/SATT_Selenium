package TestCases.Railway2;

import Common.Constant.Constant;
import PageObjects.Railway2.GeneralPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class GeneralTest {
    private GeneralPage generalPage = new GeneralPage();

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        Constant.WEBDRIVER = new ChromeDriver();
        Constant.WEBDRIVER.manage().window().maximize();
        generalPage.open();
    }

    @AfterClass
    public void afterClass() {

    }
}
