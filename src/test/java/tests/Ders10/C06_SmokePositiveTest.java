package tests.Ders10;

import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C06_SmokePositiveTest {
    @Test(groups = "qrup1")
    public void positiveTest() {
        BrcPage brcPage=new BrcPage();
        //https://www.bluerentalcars.com/ adresine gedin
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        //email, password ve login button'larini locate edin
        brcPage.loginButton.click();
        brcPage.email.sendKeys(ConfigReader.getProperty("brcUser"));
        brcPage.password.sendKeys(ConfigReader.getProperty("brcPass"));
        brcPage.loginButton2.click();
        //Deyerleri girildiyinde sehifeye ugurlu bir sekilde girilebildiyinin test edin
        //Assert.assertTrue ile kontrol edilir!
    }
}
