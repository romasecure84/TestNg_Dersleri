package tests.Ders11;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseReport;

public class C03_ReportluTest extends TestBaseReport {
    @Test
    public void test() {
        //https://www.bluerentalcars.com/ adresine gedin
        //login button'una basin
        //test data user email: user@gmail.com
        //test data password: 1234 datalarini girib login'e basin
        // login button'una basin
        //Deyerleri girildiyinde sehifeye ugurlu girilmeyin mumkun oldugunu test edin

        BrcPage brcPage=new BrcPage();
        extentTest=extentReports.createTest("login test", "giris sehifesinin test edilmesi");
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        extentTest.info("Sayta gedildi");
        brcPage.loginButton.click();
        extentTest.info("logine basildi");
        brcPage.email.sendKeys(ConfigReader.getProperty("brcUser"));
        brcPage.password.sendKeys(ConfigReader.getProperty("brcPass"));
        extentTest.info("email ve password girildi");
        brcPage.loginButton2.click();
        extentTest.info("giris login buttonuna basildi");
        ReusableMethods.waitFor(2);
        extentTest.pass("test ugurla kecildi");
    }
}
