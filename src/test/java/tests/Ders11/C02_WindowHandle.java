package tests.Ders11;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_WindowHandle {
    @Test
    public void test() {
        //https://the-internet.herokuapp.com/windows adresine gedin
        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        //Click here buttonuna basin
        ReusableMethods.waitFor(2);
        Driver.getDriver().findElement(By.xpath("//*[text()='Click Here']")).click();
        //acilan yeni teb'in title'inin "New Window" oldugunu test edin
        ReusableMethods.switchToWindow("New Window");
        String expectedTitle="New Window";
        String acturalTitle=Driver.getDriver().getTitle();
        Assert.assertEquals(expectedTitle,acturalTitle);
        ReusableMethods.waitFor(2);
        Driver.quitDriver();
    }
}
