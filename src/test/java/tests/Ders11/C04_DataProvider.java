package tests.Ders11;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C04_DataProvider {
    @DataProvider
    public static Object[][] axtarilacaqKelmeler() {
        return new Object[][]{{"java"},{"selenium"},{"samsung"},{"iphone"}};
    }

    @Test(dataProvider = "axtarilacaqKelmeler")
    public void test(String kelmeler) {
        AmazonPage amazonPage=new AmazonPage();
        //amazon sehifesine gedin
        Driver.getDriver().get(ConfigReader.getProperty("amazonURL"));
        //amazonPage.cookie.click();
        //java, selenium, samsung ve iphone ucun axtaris edin
        amazonPage.searchBox.sendKeys(kelmeler, Keys.ENTER);
        //neticelerde ataris etdiyimiz kelmelerin olmasinin test edin
        String actualData=amazonPage.axtarisNeticeleri.getText();
        Assert.assertTrue(actualData.contains(kelmeler));
    }
}
