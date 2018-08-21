import Pages.BaseFunctions;
import Pages.CurrencyCalculator;
import Pages.CurrencyPageBankLV;
import Pages.CurrencyPageDelfi;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class CurrencyTest {

    BaseFunctions basefunc = new BaseFunctions();

    @Test

    public void currencyRateTest() {
        CurrencyPageDelfi delfiPage = new CurrencyPageDelfi(basefunc);
        delfiPage.openDelfiCurrencyPage();
        HashMap delfitable = delfiPage.delfiCurrencyTable();

        CurrencyPageBankLV bankPage = new CurrencyPageBankLV(basefunc);
        bankPage.openBankCurrencyPage();
        HashMap bankTable = bankPage.bankCurrencyTable();

        for (Object code : delfitable.keySet()
                ) {
            Assert.assertFalse("Rate is not correct in " + code, code.equals(bankTable));
        }
    }


    @Test
    public void currencyCalculatorTest() {
        CurrencyPageDelfi currencyPage = new CurrencyPageDelfi(basefunc);
        CurrencyCalculator currencyCalculator = new CurrencyCalculator(basefunc);

        currencyPage.openDelfiCurrencyPage();
        currencyCalculator.setCurrency();
        currencyCalculator.typeAmountToBeConverted();
        currencyCalculator.submitButton();

        HashMap currencyTable = currencyPage.delfiCurrencyTable();

        for (String key : currencyTable.keySet()) {

        }
    }
}









