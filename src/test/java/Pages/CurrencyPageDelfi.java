package Pages;

import org.openqa.selenium.By;

import java.util.HashMap;

public class CurrencyPageDelfi {
    private final String DELFI_HOMEPAGE = "http://delfi.lv";
    private final By CURRENCY_PAGE = By.xpath(".//*[@title = 'Valūta']");
    private final By DELFI_CURRENCY_CODE = By.xpath(".//*[@class='currency-table-code']");
    private final By DELFI_CURRENCY_RATE_INTEGER = By.xpath(".//*[@class='currency-table-rate-integer']");
    private final By DELFI_CURRENCY_RATE_FRACTION = By.xpath(".//*[@class='currency-table-rate-fraction']");

    BaseFunctions basefunc;

    public CurrencyPageDelfi(BaseFunctions basefunc) {
        this.basefunc = basefunc;
    }

    public void openDelfiCurrencyPage() {
        basefunc.openPage(DELFI_HOMEPAGE);
        basefunc.getElement(CURRENCY_PAGE).click();
    }

    public String getCurrencyCode() {
        return basefunc.getElement(DELFI_CURRENCY_CODE).getText();
    }

    public Float getCurrencyRate() {
        String rate = basefunc.getElement(DELFI_CURRENCY_RATE_INTEGER).getText() + basefunc.getElement(DELFI_CURRENCY_RATE_FRACTION).getText();
        return Float.valueOf(rate);
    }

    public HashMap delfiCurrencyTable() {
        HashMap<String, Float> delfiCurrencyTable = new HashMap<String, Float>();
        for (String code : delfiCurrencyTable.keySet()
                ) {
            delfiCurrencyTable.put(getCurrencyCode(), getCurrencyRate());
        }
        return delfiCurrencyTable;
    }
}
