package test_cases.railway_2;

import common.Constant.Constant;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import page_objects.railway_2.GeneralPage;

import java.util.concurrent.TimeUnit;


public class BaseTest {
    protected GeneralPage generalPage = new GeneralPage();

    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception{
        if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            Constant.WEBDRIVER = new FirefoxDriver();
        }
        else if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            Constant.WEBDRIVER = new ChromeDriver();
        }
        else if(browser.equalsIgnoreCase("Edge")){
            WebDriverManager.edgedriver().setup();
            Constant.WEBDRIVER = new EdgeDriver();
        }
        else{
            throw new Exception("Browser is not available");
        }
        Constant.WEBDRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        Constant.WEBDRIVER.manage().window().setSize(new Dimension(1300, 1080));
        Constant.EXTENT.attachReporter(Constant.SPARK);
    }

    @AfterClass
    public void afterClass() {
        Constant.WEBDRIVER.quit();
        Constant.EXTENT.flush();
    }
}
