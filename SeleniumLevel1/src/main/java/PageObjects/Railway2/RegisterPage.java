package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegisterPage extends GeneralPage {
    //Locators
    private final By PIDInput = By.id("pid");
    private final By registerBtn = By.xpath("//input[@title='Register']");
    private final By registerErrMsg = By.xpath("//p[@class='message error']");
    private final By loginLink = By.xpath("//a[.='login']");

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

    //Methods
    public void enterPID(String pid) {
        this.getPIDInput().sendKeys(pid);
    }

    public void submitRegister() {
        this.getRegisterBtn().click();
    }

    public void getRegisterErrorMessage() {
        this.getRegisterErrMsg().getText();
    }

    public void goToLoginPage() {
        this.getLoginLink().click();
    }
}
