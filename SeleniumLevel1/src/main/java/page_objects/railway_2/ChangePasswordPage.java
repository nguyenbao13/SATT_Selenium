package page_objects.railway_2;

import common.Common.Utilities;
import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ChangePasswordPage extends GeneralPage{
    //Locators
    private final By currentPasswordInput = By.id("currentPassword");
    private final By newPasswordInput = By.id("newPassword");
    private final By changePasswordBtn = By.xpath("//input[@title='Change password']");
    private final By changePassSuccessMsg = By.xpath("//p[@class='message success']");

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


    //Methods
    public void changePassword(String current, String newPassword, String confirmPass) {
        getCurrentPasswordInput().sendKeys(current);
        getNewPasswordInput().sendKeys(newPassword);
        getConfirmPasswordInput().sendKeys(confirmPass);
        Utilities.scrollToViewElement(getChangePasswordBtn());
        getChangePasswordBtn().click();
    }

    public String getChangePassSuccessMessage() {
        return getChangePassSuccessMsg().getText();
    }
}
