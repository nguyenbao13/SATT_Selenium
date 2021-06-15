package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ForgotPasswordPage extends GeneralPage {
    //Locators
    private final By sendInstructionBtn = By.xpath("//input[@value='Send Instructions']");

    //Elements
    protected WebElement getSendInstructionBtn() {
        return Constant.WEBDRIVER.findElement(sendInstructionBtn);
    }

    //Methods
    public void submitSendInstruction() {
        this.getSendInstructionBtn().click();
    }
}
