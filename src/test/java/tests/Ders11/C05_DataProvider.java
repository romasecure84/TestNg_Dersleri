package tests.Ders11;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.BrcPage;
import utilities.ConfigReader;
import utilities.Driver;

public class C05_DataProvider {
    @DataProvider
    public static Object[][] loginTest() {
        return new Object[][]{{"user@gmail.com","12345"},{"user1@gmail.com","12345"},{"user2@gmail.com","12345"}};
    }

    @Test(dataProvider = "loginTest")
    public void test(String mail, String password) {
        BrcPage brcPage=new BrcPage();
        //https://www.bluerentalcars.com/ adreesine gedin
        Driver.getDriver().get(ConfigReader.getProperty("brcURL"));
        //login button'una basin
        brcPage.loginButton.click();
        //Data provider ile 3 ferqli userEmail ve 3 ferqli password girin
        brcPage.email.sendKeys(mail);
        brcPage.password.sendKeys(password);
        //login button'una basin
        brcPage.loginButton2.click();
        //Deyerleri girdiyinde ugurlu girisin olmadigini test edin
        Assert.assertTrue(brcPage.loginButton2.isDisplayed());
    }
}
