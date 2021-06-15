package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class GeneralPage {
    //Locators
    private final By tabLogin = By.xpath("//div[@id='menu']//a[@href='/Account/Login.cshtml']");
    private final By tabLogout = By.xpath("//div[@id='menu']//a[@href='/Account/Logout']");
    private final By welcomeMessage = By.xpath("//div[@class='account']/strong");
    private final By tabHome = By.linkText("Home");
    private final By tabContact = By.xpath("//div[@id='menu']//a[@href='/Page/Contact.cshtml']");
    private final By tabTimetable = By.xpath("//div[@id='menu']//a[@href='TrainTimeListPage.cshtml']");
    private final By tabTicketPrice = By.xpath("//div[@id='menu']//a[@href='/Page/TrainPriceListPage.cshtml']");
    private final By tabBookTicket = By.xpath("//div[@id='menu']//a[@href='/Page/BookTicketPage.cshtml']");
    private final By tabRegister = By.xpath("//div[@id='menu']//a[@href='/Account/Register.cshtml']");
    private final By tabMyTicket = By.xpath("//div[@id='menu']//a[@href='/Page/ManageTicket.cshtml']");
    private final By tabChangePassword = By.xpath("//div[@id='menu']//a[@href='/Account/ChangePassword.cshtml']");
    private final By confirmPasswordInput = By.id("confirmPassword");
    private final By emailInput = By.id("email");
    private final By passwordInput = By.id("password");

    //Elements
    protected WebElement getTabLogin() {
        return Constant.WEBDRIVER.findElement(tabLogin);
    }

    protected WebElement getTabLogout() {
        return Constant.WEBDRIVER.findElement(tabLogout);
    }

    protected WebElement getWelcomeMsg() {
        return Constant.WEBDRIVER.findElement(welcomeMessage);
    }

    protected WebElement getTabHome() {
        return Constant.WEBDRIVER.findElement(tabHome);
    }

    protected WebElement getTabContact() {
        return Constant.WEBDRIVER.findElement(tabContact);
    }

    protected WebElement getTabTimetable() {
        return Constant.WEBDRIVER.findElement(tabTimetable);
    }

    protected WebElement getTabTicketPrice() {
        return Constant.WEBDRIVER.findElement(tabTicketPrice);
    }

    protected WebElement getTabBookTicket() {
        return Constant.WEBDRIVER.findElement(tabBookTicket);
    }

    protected WebElement getTabRegister() {
        return Constant.WEBDRIVER.findElement(tabRegister);
    }

    protected WebElement getTabMyTicket() {
        return Constant.WEBDRIVER.findElement(tabMyTicket);
    }

    protected WebElement getTabChangePassword() {
        return Constant.WEBDRIVER.findElement(tabChangePassword);
    }

    protected WebElement getConfirmPasswordInput() {
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

    public void goToLoginPage() {
        this.getTabLogin().click();
    }

    public void logout() {
        this.getTabLogout().click();
    }

    public void goToContactPage() {
        this.getTabContact().click();
    }

    public void goToTimetablePage() {
        this.getTabTimetable().click();
    }

    public void goToTicketPricePage() {
        this.getTabTicketPrice().click();
    }

    public void goToBookTicketPage() {
        this.getTabBookTicket().click();
    }

    public void goToRegisterPage() {
        this.getTabRegister().click();
    }

    public void goToHomePage() {
        this.getTabHome().click();
    }

    public void goToMyTicketPage() {
        this.getTabMyTicket().click();
    }

    public void goToChangePasswordPage() {
        this.getTabChangePassword().click();
    }

    public void getValidationErrorMessage(String field) {
        this.getValidationErrMsg(field).getText();
    }

    public void enterEmail(String email) {
        this.getEmailInput().sendKeys(email);
    }

    public void enterPassword(String password) {
        this.getPasswordInput().sendKeys(password);
    }
}
