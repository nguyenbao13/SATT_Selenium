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
    public HomePage open() {
        Constant.WEBDRIVER.get(Constant.RAILWAY_URL);
        return new HomePage();
    }

    public String getWelcomeMessage() {
        return this.getWelcomeMsg().getText();
    }

    public LoginPage goToLoginPage() {
        this.getTabLogin().click();
        return new LoginPage();
    }

    public void logout() {
        this.getTabLogout().click();
    }

    public ContactPage goToContactPage() {
        this.getTabContact().click();
        return new ContactPage();
    }

    public TimetablePage goToTimetablePage() {
        this.getTabTimetable().click();
        return new TimetablePage();
    }

    public TicketPricePage goToTicketPricePage() {
        this.getTabTicketPrice().click();
        return new TicketPricePage();
    }

    public BookTicketPage goToBookTicketPage() {
        this.getTabBookTicket().click();
        return new BookTicketPage();
    }

    public RegisterPage goToRegisterPage() {
        this.getTabRegister().click();
        return new RegisterPage();
    }

    public HomePage goToHomePage() {
        this.getTabHome().click();
        return new HomePage();
    }

    public MyTicketPage goToMyTicketPage() {
        this.getTabMyTicket().click();
        return new MyTicketPage();
    }

    public ChangePasswordPage goToChangePasswordPage() {
        this.getTabChangePassword().click();
        return new ChangePasswordPage();
    }
}
