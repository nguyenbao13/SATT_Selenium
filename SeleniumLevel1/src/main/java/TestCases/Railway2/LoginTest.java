package TestCases.Railway2;

import Common.Constant.Constant;
import PageObjects.Railway2.GeneralPage;
import PageObjects.Railway2.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends GeneralTest {
    private GeneralPage generalPage = new GeneralPage();
    private LoginPage loginPage = new LoginPage();

    @BeforeMethod
    public void beforeMethod() {
        generalPage.goToLoginPage();
    }

//    @AfterMethod
//    public void afterMethod() {
//        generalPage.logout();
//    }

    @Test
    public void TC01() {
        System.out.println("TC01 - User can log into Railway with valid username and password");

        String actualMsg = loginPage.login(Constant.USERNAME, Constant.PASSWORD).getWelcomeMessage();
        String expectedMsg = "Welcome " + Constant.USERNAME;

        Assert.assertEquals(actualMsg, expectedMsg, "Welcome message is not displayed as expected");

        generalPage.logout();
    }

    @Test
    public void TC02() {
        System.out.println("TC02 - User can't login with blank \"Username\" textbox");

        String actualMsg = loginPage.login("", Constant.PASSWORD).getLoginErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Username error message is not displayed as expected");
    }

    @Test
    public void TC03() {
        System.out.println("TC03 - User cannot log into Railway with invalid password");

        String actualMsg = loginPage.login(Constant.USERNAME, "1").getLoginErrorMessage();
        String expectedMsg = "There was a problem with your login and/or errors exist in your form.";

        Assert.assertEquals(actualMsg, expectedMsg, "Login error message is not displayed as expected");
    }

    @Test
    public void TC04() {
        System.out.println("TC04 - Login page displays when un-logged User clicks on \"Book ticket\" tab");

        generalPage.goToBookTicketPage();
        String actualTitle = Constant.WEBDRIVER.getTitle();
        String expectedTitle = "Safe Railway - Login";

        Assert.assertEquals(actualTitle, expectedTitle, "Login page does not display");
    }

    @Test
    public void TC05() {
        System.out.println("TC05 - System shows message when user enters wrong password several times");

        for (int i = 1; i < 5; i++) {
            loginPage.login(Constant.USERNAME, "1");
        }
        String actualMsg = loginPage.getLoginErrorMessage();
        String expectedMsg = "You have used 4 out of 5 login attempts. After all 5 have been used, you will be unable to login for 15 minutes.";

        Assert.assertEquals(actualMsg, expectedMsg, "Out of attempts to login message is not displayed as expected");
    }

    @Test
    public void TC06() {
        System.out.println("TC06 - Additional pages display once user logged in");

        String actualDisplay = "wrong";
        String expectedDisplay = "right";
        String myTicketTitle;
        String changePasswordTitle;
        loginPage.login(Constant.USERNAME, Constant.PASSWORD);
        Boolean myTicket = generalPage.checkMyTicketTabExists();
        Boolean changePassword = generalPage.checkChangePasswordTabExists();
        Boolean logout = generalPage.checkLogoutTabExists();

        if (myTicket && changePassword && logout) {
            generalPage.goToMyTicketPage();
            myTicketTitle = Constant.WEBDRIVER.getTitle();
            generalPage.goToChangePasswordPage();
            changePasswordTitle = Constant.WEBDRIVER.getTitle();
            if (myTicketTitle.equals("Safe Railway - My Ticket") && changePasswordTitle.equals("Safe Railway - Change Password")) {
                actualDisplay = "right";
            }
        }

        Assert.assertEquals(actualDisplay, expectedDisplay, "Additional pages do not display as expected");
    }

}
