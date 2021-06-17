package PageObjects.Railway2;

import Common.Constant.Constant;
import net.bytebuddy.implementation.bind.annotation.Super;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage extends GeneralPage{
    //Locators
    private final By departDateInput = By.xpath("//label[.='Depart date:']/../select[@name='Date']");
    private final By departStationInput = By.xpath("//select[@name='DepartStation']");
    private final By departStationSelected = By.xpath("//select[@name='DepartStation']/option[@selected='selected']");
    private final By arriveStationInput = By.xpath("//select[@name='ArriveStation']");
    private final By arriveStationSelected = By.xpath("//select[@name='ArriveStation']/option[@selected='selected']");
    private final By seatTypeInput = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountInput = By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketButton = By.xpath("//input[@value='Book ticket']");
    private final By bookSuccessMsg = By.xpath("//div[@id='content']/h1");

    //Elements
    protected WebElement getDepartDateInput() {
        return Constant.WEBDRIVER.findElement(departDateInput);
    }

    protected WebElement getDepartStationInput() {
        return Constant.WEBDRIVER.findElement(departStationInput);
    }

    protected WebElement getArriveStationInput() {
        return Constant.WEBDRIVER.findElement(arriveStationInput);
    }

    protected WebElement getSeatTypeInput() {
        return Constant.WEBDRIVER.findElement(seatTypeInput);
    }

    protected WebElement getTicketAmountInput() {
        return Constant.WEBDRIVER.findElement(ticketAmountInput);
    }

    protected WebElement getBookTicketButton() {
        return Constant.WEBDRIVER.findElement(bookTicketButton);
    }

    protected WebElement getBookSuccessMsg() {
        return Constant.WEBDRIVER.findElement(bookSuccessMsg);
    }

    //Methods
    public void selectDepartDate(String departDate) {
        Select date = new Select(this.getDepartDateInput());
        date.selectByVisibleText(departDate);
    }

    public void selectDepartStation(String departStation) {
        Select station = new Select(this.getDepartStationInput());
        station.selectByVisibleText(departStation);
    }

    public void selectArriveStation(String arriveStation) {
        Select station = new Select(this.getArriveStationInput());
        station.selectByVisibleText(arriveStation);
    }

    public void selectSeatType(String seatType) {
        Select seat = new Select(this.getSeatTypeInput());
        seat.selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        Select amount = new Select(this.getTicketAmountInput());
        amount.selectByVisibleText(ticketAmount);
    }

    public void submitBookTicket() {
        this.getBookTicketButton().click();
    }

    public BookTicketPage bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        this.selectDepartDate(departDate);
        this.selectDepartStation(departStation);
        this.selectArriveStation(arriveStation);
        this.selectSeatType(seatType);
        this.selectTicketAmount(ticketAmount);
        JavascriptExecutor js = (JavascriptExecutor) Constant.WEBDRIVER;
        js.executeScript("arguments[0].scrollIntoView();", this.getBookTicketButton());
        this.submitBookTicket();
        return new BookTicketPage();
    }

    public String getBookSuccessMessage() {
        return this.getBookSuccessMsg().getText();
    }

    public String getDepartStationSelected() {
        return Constant.WEBDRIVER.findElement(departStationSelected).getText();
    }

    public String getArriveStationSelected() {
        return Constant.WEBDRIVER.findElement(arriveStationSelected).getText();
    }
}
