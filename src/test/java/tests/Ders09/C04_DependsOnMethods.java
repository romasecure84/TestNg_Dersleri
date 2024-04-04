package tests.Ders09;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBaseBeforeClassAfterClass;

public class C04_DependsOnMethods extends TestBaseBeforeClassAfterClass {
    @Test
    public void test1() throws InterruptedException {
        //amazon ana sehifesine gedin
        driver.get("https://www.amazon.com.tr");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"sp-cc-rejectall-link\"]")).click();
    }
    @Test(dependsOnMethods = "test1")
    public void test2() {
        //iphone axtarisi edin
        driver.findElement(By.xpath("//*[@id=\"twotabsearchtextbox\"]")).sendKeys("Iphone", Keys.ENTER);

    }
    @Test(dependsOnMethods = "test2")
    public void test3() {
        //Neticenin iphone icerdiyini test edin
        WebElement netice= driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        Assert.assertTrue(netice.getText().contains("Iphone"));
    }
}
