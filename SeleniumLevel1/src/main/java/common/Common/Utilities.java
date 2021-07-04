package common.Common;

import common.Constant.Constant;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {

    public static WebDriverWait WAIT = new WebDriverWait(Constant.WEBDRIVER, 3);

    public static void scrollToViewElement(WebElement webElement) {
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", webElement);
    }

    public static void selectDropdownItem(WebElement selectField, String item) {
        Select select = new Select(selectField);
        select.selectByVisibleText(item);
    }

    public static String getScreenshot() {
        return ((TakesScreenshot) Constant.WEBDRIVER).getScreenshotAs(OutputType.BASE64);
    }
}
