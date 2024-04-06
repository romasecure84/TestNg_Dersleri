package tests.Ders11;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.IOException;

public class C01_ScreenShotReusableMethod {
    @Test
    public void testAll() throws IOException {
        //Hepsiburada sehifesine gedin
        Driver.getDriver().get("https://global.hepsiburada.com/tr");
        //Sehifenin screenshot'unu alin
        ReusableMethods.getScreenshot("butun ekran resmi");
        //Sehifeni baglayin
        Driver.closeDriver();
    }

    @Test
    public void testWE() throws IOException {
        //amazon sehifesine gedin
        AmazonPage amazonPage=new AmazonPage();
        //iphone axtarisi edin
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        ReusableMethods.waitFor(1);
        amazonPage.searchBox.sendKeys("iphone", Keys.ENTER);
        //axtaris neticesi webelementinin screenshot'unu alin
        ReusableMethods.getScreenshotWebElement("web elementin screenshot'u",amazonPage.axtarisNeticeleri);
    }
}
