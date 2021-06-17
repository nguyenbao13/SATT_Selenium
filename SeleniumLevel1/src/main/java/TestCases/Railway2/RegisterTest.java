package TestCases.Railway2;

import PageObjects.Railway2.GeneralPage;
import PageObjects.Railway2.RegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterTest extends GeneralTest{
    private GeneralPage generalPage = new GeneralPage();
    private RegisterPage registerPage = new RegisterPage();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.goToRegisterPage();
    }

    @Test
    public void TC07() {
        System.out.println("TC07 - User can create new account");

        registerPage.registerAccount("bb@bb.bb", "12345678", "12345678", "12345678");
        String actualMsg = registerPage.getRegisterSuccessMessage();
        String expectedMsg = "Thank you for registering your account";

        Assert.assertEquals(actualMsg, expectedMsg, "Success register message is not displayed as expected");
    }

    @Test
    public void TC10() {
        System.out.println("TC10 - User can't create account with \"Confirm password\" is not the same with \"Password\"");

        registerPage.registerAccount("ccc@ccc.ccc", "12345678", "87654321", "12345678");
        String actualMsg = registerPage.getRegisterErrorMessage();
        String expectedMsg = "There're errors in the form. Please correct the errors and try again.";

        Assert.assertEquals(actualMsg, expectedMsg, "Change password error message is not displayed as expected");
    }

    @Test
    public void TC11() {
        System.out.println("User can't create account while password and PID fields are empty");

        registerPage.registerAccount("ddd@ddd.ddd", "", "", "");
        String actualMsg = "wrong";
        String expectedMsg = "right";
        String registerMsg = registerPage.getRegisterErrorMessage();
        String passwordMsg = registerPage.getValidationErrorMessage("Password (8 - 64 characters)");
        String pidMsg = registerPage.getValidationErrorMessage("PID/Passport number (8 - 20 characters)");

        if(registerMsg.equals("There're errors in the form. Please correct the errors and try again.")) {
            if(passwordMsg.equals("Invalid password length") && pidMsg.equals("Invalid ID length")) {
                actualMsg = "right";
            }
        }

        Assert.assertEquals(actualMsg, expectedMsg, "Register error messages are not displayed as expected");
    }

}
