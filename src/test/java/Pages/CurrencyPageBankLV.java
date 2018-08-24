package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

public class CurrencyPageBankLV {

    BaseFunctions basefunc;

    private final String BANK_HOMEPAGE = "http://bank.lv";
    private final By BANK_CURRENCY_PAGE = By.xpath(".//td[@class = 'currency sectiontableentry1 currency-exchange']/a");
    private final By BANK_CURRENCY_CODE = By.xpath(".//*[@class='flag']");
    private final By BANK_CURRENCY_RATE = By.xpath(".//*[@class='value']");
    private final By BANK_DAILY_TABLE = By.xpath(".//div[@id = 'period2018-08-24']");

    WebElement dailyTable;
    WebElement currencyCode;
    WebElement rate;

    public CurrencyPageBankLV(BaseFunctions basefunc) {
        this.basefunc = basefunc;
    }

    public void openBankCurrencyPage() {

        basefunc.openPage(BANK_HOMEPAGE);
        basefunc.getElement(BANK_CURRENCY_PAGE).click();
    }

    public String getCurrencyCode() {
        dailyTable = basefunc.getElement(BANK_DAILY_TABLE);
        currencyCode = dailyTable.findElement(BANK_CURRENCY_CODE);
        return currencyCode.getText();
    }

    public Float getCurrencyRate(WebElement code) {
        dailyTable = basefunc.getElement(BANK_DAILY_TABLE);
        rate = dailyTable.findElement(BANK_CURRENCY_RATE);
        String rateForConversion = rate.getText();
        return Float.valueOf(rateForConversion);
    }

    public Map bankCurrencyTable() {
        Map<String, Float> bankCurrencyTable = new HashMap<String, Float>();

        for (WebElement code: dailyTable.findElements(BANK_CURRENCY_CODE)
             ) {

            code = dailyTable.findElement(BANK_CURRENCY_CODE);

            bankCurrencyTable.put(code.getText(), getCurrencyRate(code));

        }


return bankCurrencyTable;
    }
}
