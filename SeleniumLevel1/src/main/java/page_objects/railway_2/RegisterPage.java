package page_objects.railway_2;

import common.Common.Utilities;
import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locators
    private final By PIDInput = By.id("pid");
    private final By registerBtn = By.xpath("//input[@title='Register']");
    private final By registerErrMsg = By.xpath("//p[@class='message error']");
    private final By registerSuccessMsg = By.xpath("//div[@id='content']/p");

    //Elements
    public WebElement getPIDInput() {
        return Constant.WEBDRIVER.findElement(PIDInput);
    }

    protected WebElement getRegisterBtn() {
        return Constant.WEBDRIVER.findElement(registerBtn);
    }

    protected WebElement getRegisterErrMsg() {
        return Constant.WEBDRIVER.findElement(registerErrMsg);
    }

    protected WebElement getRegisterSuccessMsg() {
        return Constant.WEBDRIVER.findElement(registerSuccessMsg);
    }

    //Methods
    public void registerAccount(String email, String password, String confirmPass, String pid) {
        getEmailInput().sendKeys(email);
        getPasswordInput().sendKeys(password);
        getConfirmPasswordInput().sendKeys(confirmPass);
        getPIDInput().sendKeys(pid);
        Utilities.scrollToViewElement(getRegisterBtn());
        getRegisterBtn().click();
    }

    public String getRegisterErrorMessage() {
        return getRegisterErrMsg().getText();
    }

    public String getRegisterSuccessMessage() {
        return getRegisterSuccessMsg().getText();
    }
}
