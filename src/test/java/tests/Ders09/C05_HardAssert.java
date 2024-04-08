package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;
import utilities.TestBaseCross;

public class C05_HardAssert extends TestBaseCross {
    @Test
    public void test() throws InterruptedException {
        //amazon sehifesine gedin
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='sp-cc-rejectall-link']")).click();
        //title'de Amazon yazildigini test edin
        Assert.assertTrue(driver.getTitle().contains("Amazon"));
        //axtaris qutusunun movcudlugunun test edin
        WebElement axtarisQutusu=driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        Assert.assertTrue(axtarisQutusu.isEnabled());
        //axtaris qutusuna "Iphone" yazib axtaris edin
        axtarisQutusu.sendKeys("Iphone", Keys.ENTER);
        //axtarisin edildiyini test edin
        WebElement neticeler= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(neticeler.isDisplayed());
        //axtaris neticesinin iphone icerdiyini test edin
        Assert.assertTrue(neticeler.getText().contains("Iphone"));
    }
}
