package page_objects.railway_2;

import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final By welcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By confirmPasswordInput = By.id("confirmPassword");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");

    //Elements
    protected WebElement getTabMenuItem(String item) {
        return Constant.WEBDRIVER.findElement(By.xpath("//div[@id='menu']//span[.='"+item+"']"));
    }

    protected WebElement getWelcomeMsg() {
        return Constant.WEBDRIVER.findElement(welcomeMessage);
    }

    public WebElement getConfirmPasswordInput() {
        return Constant.WEBDRIVER.findElement(confirmPasswordInput);
    }

    protected WebElement getValidationErrMsg(String field) {
        By validationErrMsg = By.xpath("//label[.='"+field+":']/../label[@class='validation-error']");
        return Constant.WEBDRIVER.findElement(validationErrMsg);
    }

    protected WebElement getEmailInput() {
        return Constant.WEBDRIVER.findElement(emailInput);
    }

    protected WebElement getPasswordInput() {
        return Constant.WEBDRIVER.findElement(passwordInput);
    }

    //Methods
    public void open() {
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL);
    }

    public String getWelcomeMessage() {
        return this.getWelcomeMsg().getText();
    }

    public LoginPage goToLoginPage() {
        this.getTabMenuItem("Login").click();
        return new LoginPage();
    }

    public TimetablePage goToTimetablePage() {
        this.getTabMenuItem("Timetable").click();
        return new TimetablePage();
    }

    public BookTicketPage goToBookTicketPage() {
        this.getTabMenuItem("Book ticket").click();
        return new BookTicketPage();
    }

    public RegisterPage goToRegisterPage() {
        this.getTabMenuItem("Register").click();
        return new RegisterPage();
    }

    public MyTicketPage goToMyTicketPage() {
        this.getTabMenuItem("My ticket").click();
        return new MyTicketPage();
    }

    public ChangePasswordPage goToChangePasswordPage() {
        this.getTabMenuItem("Change password").click();
        return new ChangePasswordPage();
    }

    public String getValidationErrorMessage(String field) {
        return this.getValidationErrMsg(field).getText();
    }

    public Boolean checkMyTicketTabExists() {
        return this.getTabMenuItem("My ticket").isDisplayed();
    }

    public Boolean checkChangePasswordTabExists() {
        return this.getTabMenuItem("Change password").isDisplayed();
    }

    public Boolean checkLogoutTabExists() {
        return this.getTabMenuItem("Log out").isDisplayed();
    }

}
