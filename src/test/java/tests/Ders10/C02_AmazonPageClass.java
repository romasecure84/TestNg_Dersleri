package tests.Ders10;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_AmazonPageClass {
    @Test
    public void test() throws InterruptedException {
        AmazonPage amazonPage=new AmazonPage();
        //amazon sehifesine gedin
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        Thread.sleep(1000);
        amazonPage.cookie.click();
        //Selenium axtarisi edin
        amazonPage.searchBox.sendKeys("Selenium", Keys.ENTER);
        //Netice yazisinin selenium icerdiyini test edin
        String expectedData="Selenium";
        String actualData=amazonPage.axtarisNeticeleri.getText();
        Assert.assertTrue(actualData.contains(expectedData));
        Driver.closeDriver();
    }
}
