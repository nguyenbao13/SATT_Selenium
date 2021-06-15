package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BookTicketPage {
    //Locators
    private final By departDateInput = By.xpath("//label[.='Depart date:']/../select[@name='Date']");
    private final By departStationInput = By.xpath("//select[@name='DepartStation']");
    private final By arriveStationInput = By.xpath("//select[@name='ArriveStation']");
    private final By seatTypeInput = By.xpath("//select[@name='SeatType']");
    private final By ticketAmountInput = By.xpath("//select[@name='TicketAmount']");
    private final By bookTicketButton = By.xpath("//input[@value='Book ticket']");

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
        Select type = new Select(this.getSeatTypeInput());
        type.selectByVisibleText(seatType);
    }

    public void selectTicketAmount(String ticketAmount) {
        Select amount = new Select(this.getTicketAmountInput());
        amount.selectByVisibleText(ticketAmount);
    }

    public void submitBookTicket() {
        this.getBookTicketButton().click();
    }
}
