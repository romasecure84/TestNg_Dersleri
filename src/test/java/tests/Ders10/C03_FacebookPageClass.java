package tests.Ders10;

import com.github.javafaker.Faker;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FacebookPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C03_FacebookPageClass {
    Faker faker;
    @Test
    public void test() {
        FacebookPage facebookPage=new FacebookPage();
        //https://www.facebook.com/ adresine gedin
        Driver.getDriver().get(ConfigReader.getProperty("facebookURL"));
        //POM'a uygun alaraq email, password qutularini ve giris edin button'unu locate edin
        faker=new Faker();
        //Faker class'dan istifade ederek email ve password deyerlerini yazdirib, giris button'una basin
        facebookPage.email.sendKeys(faker.internet().emailAddress());
        facebookPage.password.sendKeys(faker.internet().password());
        facebookPage.loginButton.click();
        //Ugurlu girisin edilmediyini test edin
        Assert.assertTrue(facebookPage.failedLogin.isDisplayed());
    }
}
