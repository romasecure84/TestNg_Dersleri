package tests.Ders10;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AloTechPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_SmokeNegativeTest {
    @Test
    public void sehvIstifadeci() throws InterruptedException {
        AloTechPage aloTechPage=new AloTechPage();
        //https://demo1.alo-tech.com adresine gedin
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        //Email, Password, Login elementlerini locate edin
        aloTechPage.email.sendKeys(ConfigReader.getProperty("WrongUser"));
        aloTechPage.password.sendKeys(ConfigReader.getProperty("Password"));
        aloTechPage.loginButton.click();
        //Deyerlerini girdikde sehifeye girile bilmediyini test edin
        Assert.assertTrue(aloTechPage.loginYazi.isDisplayed());
        //Sehifeni baglayin
        Thread.sleep(2000);
        Driver.closeDriver();
    }

    @Test(groups = "qrup1")
    public void sehvPassword() throws InterruptedException {
        AloTechPage aloTechPage=new AloTechPage();
        //https://demo1.alo-tech.com adresine gedin
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        //Email, Password, Login elementlerini locate edin
        aloTechPage.email.sendKeys(ConfigReader.getProperty("User"));
        aloTechPage.password.sendKeys(ConfigReader.getProperty("WrongPass"));
        aloTechPage.loginButton.click();
        //Deyerlerini girdikde sehifeye girile bilmediyini test edin
        Assert.assertTrue(aloTechPage.loginYazi.isDisplayed());
        //Sehifeni baglayin
        Thread.sleep(2000);
        Driver.closeDriver();

    }

    @Test
    public void sehvIstifadeciSehvPassword() throws InterruptedException {
        AloTechPage aloTechPage=new AloTechPage();
        //https://demo1.alo-tech.com adresine gedin
        Driver.getDriver().get(ConfigReader.getProperty("aloTechURL"));
        //Email, Password, Login elementlerini locate edin
        aloTechPage.email.sendKeys(ConfigReader.getProperty("WrongUser"));
        aloTechPage.password.sendKeys(ConfigReader.getProperty("WrongPass"));
        aloTechPage.loginButton.click();
        //Deyerlerini girdikde sehifeye girile bilmediyini test edin
        Assert.assertTrue(aloTechPage.loginYazi.isDisplayed());
        //Sehifeni baglayin
        Thread.sleep(2000);
        Driver.closeDriver();
    }
}
