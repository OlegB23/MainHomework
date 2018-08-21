package Pages;

import org.openqa.selenium.*;

public class CurrencyCalculator {

    BaseFunctions basefunc;

    public CurrencyCalculator(BaseFunctions basefunc) {
        this.basefunc = basefunc;
    }

    private final By DELFI_CURRENCY_CALCULATOR = By.xpath(".//*[@class = 'currency-calc']");
    private final By SET_AUD = By.xpath(".//*[@value = 'CAD']");
    private final By AMOUNT_INPUT_FIELD = By.xpath(".//input[@class = 'currency-input currency-amout']");
    private final By SUBMIT_BUTTON = By.xpath(".//*[@class = 'currency-submit']");
    private final By CALCULATOR_RESULTS = By.xpath(".//*[@class = 'currency-result']");
    WebElement currencyTable;

    public void setCurrency() {
        currencyTable = basefunc.getElement(DELFI_CURRENCY_CALCULATOR);
        WebElement currency = currencyTable.findElement(SET_AUD);
        currency.click();
    }

    public void typeAmountToBeConverted() {
        currencyTable = basefunc.getElement(DELFI_CURRENCY_CALCULATOR);
        WebElement inputField = currencyTable.findElement(AMOUNT_INPUT_FIELD);
        inputField.sendKeys("1", "0", "0");
    }

    public void submitButton() {
        currencyTable.findElement(SUBMIT_BUTTON).click();
    }

    public String calculatorResult() {
        return currencyTable.findElement(CALCULATOR_RESULTS).getText();
    }
}
