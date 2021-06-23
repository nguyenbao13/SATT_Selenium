package common.Constant;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

public class Constant {
    public static WebDriver WEBDRIVER;
    public static final String RAILWAY_URL = "http://railway2.somee.com/Page/HomePage.cshtml";
    public static final String USERNAME = "aaa@aaa.aaa";
    public static final String PASSWORD = System.getenv("PASSWORD");
    public static final String NEW_PASSWORD = System.getenv("NEW_PASSWORD");
    public static String REGISTER_NAME = Instant.ofEpochSecond(Instant.now().getEpochSecond()) + "@yo.lo";
    public static String BOOK_DATE = new SimpleDateFormat("M/dd/yyyy").format(new Date());
    public static String DEPART_DATE = new SimpleDateFormat("M/dd/yyyy").format(new Date(new Date().getTime() + (1000 * 60 * 60 * 24 * 4)));
    public static ExtentReports EXTENT = new ExtentReports();
    public static ExtentSparkReporter SPARK = new ExtentSparkReporter("resources/output/report/railway_2.html");
}
