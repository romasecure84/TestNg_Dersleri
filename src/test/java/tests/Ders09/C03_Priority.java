package tests.Ders09;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C03_Priority extends TestBaseBeforeMethodAfterMethod {
    @Test(priority = -5)
    public void testAmazon() {
        driver.get("https://www.amazon.com.tr");
    }

    @Test(priority = 100)//priority deyerinin teyin etmezsek default olaraq 0 deyerinin alacaqdir
    public void testTurboaz() {
        driver.get("https://www.turbo.az");
    }

    @Test(priority = 1)
    public void testBinaaz() {
        driver.get("https://www.bina.az");
    }
}
