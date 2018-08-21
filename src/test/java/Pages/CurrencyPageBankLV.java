package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;

public class CurrencyPageBankLV {

    BaseFunctions basefunc;

    private final String BANK_HOMEPAGE = "http://bank.lv";
    private final By BANK_CURRENCY_PAGE = By.xpath(".//td[@class = 'currency sectiontableentry1 currency-exchange']/a");
    private final By BANK_CURRENCY_CODE = By.xpath(".//*[@class='flag']");
    private final By BANK_CURRENCY_RATE = By.xpath(".//*[@class='value']");
    private final By BANK_DAILY_TABLE = By.xpath(".//div[@id = 'period2018-08-21']");

    WebElement dailyTable;

    public CurrencyPageBankLV(BaseFunctions basefunc) {
        this.basefunc = basefunc;
    }

    public void openBankCurrencyPage() {

        basefunc.openPage(BANK_HOMEPAGE);
        basefunc.getElement(BANK_CURRENCY_PAGE).click();
    }

    public String getCurrencyCode() {
        dailyTable = basefunc.getElement(BANK_DAILY_TABLE);
        WebElement currencyCode = dailyTable.findElement(BANK_CURRENCY_CODE);
        return currencyCode.getText();
    }

    public Float getCurrencyRate() {
        dailyTable = basefunc.getElement(BANK_DAILY_TABLE);
        WebElement rate = dailyTable.findElement(BANK_CURRENCY_RATE);
        String rateForConversion = rate.getText();
        return Float.valueOf(rateForConversion);
    }

    public HashMap bankCurrencyTable() {
        HashMap<String, Float> bankCurrencyTable = new HashMap<String, Float>();
        for (String code : bankCurrencyTable.keySet()
                ) {
            bankCurrencyTable.put(getCurrencyCode(), getCurrencyRate());
        }
        return bankCurrencyTable;
    }
}
