package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    //Locators
    private final By currentPasswordInput = By.id("currentPassword");
    private final By newPasswordInput = By.id("newPassword");
    private final By changePasswordBtn = By.xpath("//input[@title='Change password']");
    private final By changePassSuccessMsg = By.xpath("//p[@class='message success']");
    private final By changePassErrMsg = By.xpath("//p[@class='message error']");

    //Elements
    protected WebElement getCurrentPasswordInput() {
        return Constant.WEBDRIVER.findElement(currentPasswordInput);
    }

    protected WebElement getNewPasswordInput() {
        return Constant.WEBDRIVER.findElement(newPasswordInput);
    }

    protected WebElement getChangePasswordBtn() {
        return Constant.WEBDRIVER.findElement(changePasswordBtn);
    }

    protected WebElement getChangePassSuccessMsg() {
        return Constant.WEBDRIVER.findElement(changePassSuccessMsg);
    }

    protected WebElement getChangePassErrMsg() {
        return Constant.WEBDRIVER.findElement(changePassErrMsg);
    }

    //Methods
    public ChangePasswordPage changePassword(String current, String newPassword, String confirmPass) {
        this.getCurrentPasswordInput().sendKeys(current);
        this.getNewPasswordInput().sendKeys(newPassword);
        super.getConfirmPasswordInput().sendKeys(confirmPass, Keys.ENTER);
        return new ChangePasswordPage();
    }

    public String getChangePassSuccessMessage() {
        return this.getChangePassSuccessMsg().getText();
    }

    public String getChangePassErrorMessage() {
        return this.getChangePassErrMsg().getText();
    }
}
