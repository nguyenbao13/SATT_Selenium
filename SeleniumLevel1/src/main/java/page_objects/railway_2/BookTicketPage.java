package page_objects.railway_2;

import common.Common.Utilities;
import common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

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
    public void bookTicket(String departDate, String departStation, String arriveStation, String seatType, String ticketAmount) {
        Utilities.selectDropdownItem(getDepartDateInput(), departDate);
        Utilities.selectDropdownItem(getDepartStationInput(), departStation);
        Utilities.selectDropdownItem(getArriveStationInput(), arriveStation);
        Utilities.selectDropdownItem(getSeatTypeInput(), seatType);
        Utilities.selectDropdownItem(getTicketAmountInput(), ticketAmount);
        Utilities.scrollToViewElement(getBookTicketButton());
        getBookTicketButton().click();
    }

    public String getBookSuccessMessage() {
        return getBookSuccessMsg().getText();
    }

    public String getDepartStationSelected() {
        return Constant.WEBDRIVER.findElement(departStationSelected).getText();
    }

    public String getArriveStationSelected() {
        return Constant.WEBDRIVER.findElement(arriveStationSelected).getText();
    }
}
