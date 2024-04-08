package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C06_SoftAssert extends TestBaseCross {
    @Test
    public void test() throws InterruptedException {
        SoftAssert softAssert=new SoftAssert();
        //amazon sehifesine gedin
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        //title'de Amazon yazildigini test edin
        softAssert.assertTrue(driver.getTitle().contains("amazon"),"Girdiyiniz kelime movcud deyil");
        //axtaris qutusunun movcudlugunun test edin
        WebElement axtarisQutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        softAssert.assertTrue(axtarisQutusu.isEnabled(),"Axtaris qutusu movcud deyil");
        //axtaris qutusuna "Iphone" yazib axtaris edin
        axtarisQutusu.sendKeys("Iphone", Keys.ENTER);
        //axtarisin edildiyini test edin
        WebElement neticeler= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        softAssert.assertTrue(neticeler.isDisplayed(),"Neticeler movcud deyil");
        //axtaris neticesinin iphone icerdiyini test edin
        softAssert.assertTrue(neticeler.getText().contains("iphone"),"axtardiginiz kelime yoxdur");
        softAssert.assertAll();
        System.out.println("eger sistemde xeta varsa bu yazi oxunmayacaq");
    }
}
