package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locators
    private final By PIDInput = By.id("pid");
    private final By registerBtn = By.xpath("//input[@title='Register']");
    private final By registerErrMsg = By.xpath("//p[.='There're errors in the form. Please correct the errors and try again.']");
    private final By loginLink = By.xpath("//a[.='login']");
    private final By registerSuccessMsg = By.xpath("//p[.='You\'re here']");

    //Elements
    protected WebElement getPIDInput() {
        return Constant.WEBDRIVER.findElement(PIDInput);
    }

    protected WebElement getRegisterBtn() {
        return Constant.WEBDRIVER.findElement(registerBtn);
    }

    protected WebElement getRegisterErrMsg() {
        return Constant.WEBDRIVER.findElement(registerErrMsg);
    }

    protected WebElement getLoginLink() {
        return Constant.WEBDRIVER.findElement(loginLink);
    }

    protected WebElement getRegisterSuccessMsg() {
        return Constant.WEBDRIVER.findElement(registerSuccessMsg);
    }

    //Methods
    public void enterPID(String pid) {
        this.getPIDInput().sendKeys(pid);
    }

    public void submitRegister() {
        this.getRegisterBtn().click();
    }

    public String getRegisterErrorMessage() {
        return this.getRegisterErrMsg().getText();
    }

    public LoginPage goToLoginPageByLink() {
        this.getLoginLink().click();
        return new LoginPage();
    }

    public String getRegisterSuccessMessage() {
        return this.getRegisterSuccessMsg().getText();
    }
}
