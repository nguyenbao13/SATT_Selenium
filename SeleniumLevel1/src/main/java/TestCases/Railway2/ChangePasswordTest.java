package TestCases.Railway2;

import Common.Constant.Constant;
import PageObjects.Railway2.ChangePasswordPage;
import PageObjects.Railway2.GeneralPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ChangePasswordTest extends GeneralTest{
    private GeneralPage generalPage = new GeneralPage();
    private ChangePasswordPage changePasswordPage = new ChangePasswordPage();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.goToLoginPage().login(Constant.USERNAME, Constant.PASSWORD);
        generalPage.goToChangePasswordPage();
    }

    @Test
    public void TC09() {
        System.out.println("TC09 - User can change password");

        changePasswordPage.changePassword("12345678", "87654321", "87654321");
        String actualMsg = changePasswordPage.getChangePassSuccessMessage();
        String expectedMsg = "Your password has been updated!";

        Assert.assertEquals(actualMsg, expectedMsg, "Change password success message does not display as expected");
    }

}
