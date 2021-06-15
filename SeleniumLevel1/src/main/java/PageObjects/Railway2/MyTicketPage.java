package PageObjects.Railway2;

import Common.Constant.Constant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class MyTicketPage {
    //Locators
    private final By departStationInput = By.xpath("//select[@name='FilterDpStation']");
    private final By arriveStationInput = By.xpath("//select[@name='FilterArStation']");
    private final By departDateInput = By.xpath("//input[@name='FilterDpDate']");
    private final By statusInput = By.xpath("//select[@name='FilterStatus']");
    private final By applyFilterBtn = By.xpath("//input[@value='Apply Filter']");

    //Elements
    protected WebElement getDeleteButton(int number) {
        By deleteBtn = By.xpath("//td[1][.='"+number+"']/..//input[@value='Delete']");
        return Constant.WEBDRIVER.findElement(deleteBtn);
    }

    protected WebElement getCancelButton(int number) {
        By cancelBtn = By.xpath("//td[1][.='"+number+"']/..//input[@value='Cancel']");
        return Constant.WEBDRIVER.findElement(cancelBtn);
    }

    protected WebElement getDepartStationInput() {
        return Constant.WEBDRIVER.findElement(departStationInput);
    }

    protected WebElement getArriveStationInput() {
        return Constant.WEBDRIVER.findElement(arriveStationInput);
    }

    protected WebElement getDepartDateInput() {
        return Constant.WEBDRIVER.findElement(departDateInput);
    }

    protected WebElement getStatusInput() {
        return Constant.WEBDRIVER.findElement(statusInput);
    }

    protected WebElement getApplyFilterBtn() {
        return Constant.WEBDRIVER.findElement(applyFilterBtn);
    }

    //Methods
    public void deleteTicket(int number) {
        this.getDeleteButton(number).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public void cancelTicket(int number) {
        this.getCancelButton(number).click();
        Constant.WEBDRIVER.switchTo().alert().accept();
    }

    public void selectDepartStation(String departStation) {
        Select station = new Select(this.getDepartStationInput());
        station.selectByVisibleText(departStation);
    }

    public void selectArriveStation(String arriveStation) {
        Select station = new Select(this.getArriveStationInput());
        station.selectByVisibleText(arriveStation);
    }

    public void enterDepartDate(String date) {
        this.getDepartDateInput().sendKeys(date);
    }

    public void selectStatus(String st) {
        Select status = new Select(this.getStatusInput());
        status.selectByVisibleText(st);
    }

    public void submitFilter() {
        this.getApplyFilterBtn().click();
    }
}
