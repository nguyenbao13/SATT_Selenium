package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    //Locators
    private final By currentPasswordInput = By.id("currentPassword");
    private final By newPasswordInput = By.id("newPassword");
    private final By changePasswordBtn = By.xpath("//input[@title='Change password']");

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

    //Methods
    public void enterCurrentPassword(String password) {
        this.getCurrentPasswordInput().sendKeys(password);
    }

    public void enterNewPassword(String password) {
        this.getNewPasswordInput().sendKeys(password);
    }

    public void submitChangePassword() {
        this.getChangePasswordBtn().click();
    }
}
