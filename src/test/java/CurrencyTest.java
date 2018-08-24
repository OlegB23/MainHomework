import Pages.BaseFunctions;
import Pages.CurrencyCalculator;
import Pages.CurrencyPageBankLV;
import Pages.CurrencyPageDelfi;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CurrencyTest {

    BaseFunctions basefunc = new BaseFunctions();

    @Test

    public void currencyRateTest() {
        CurrencyPageDelfi delfiPage = new CurrencyPageDelfi(basefunc);
        delfiPage.openDelfiCurrencyPage();
        HashMap delfitable = delfiPage.delfiCurrencyTable();

        CurrencyPageBankLV bankPage = new CurrencyPageBankLV(basefunc);
        bankPage.openBankCurrencyPage();
        Map bankTable = bankPage.bankCurrencyTable();

        System.out.println( bankTable);

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

        String cadRate = currencyTable.get("CAD").toString();

        System.out.println(cadRate);


        }
    }










