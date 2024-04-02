package tests.Ders09;

import org.testng.annotations.Test;
import utilities.TestBaseBeforeMethodAfterMethod;

public class C01_BeforeMethodAfterMethod extends TestBaseBeforeMethodAfterMethod {

    @Test
    public void testAmazon() {
        driver.get("https://www.amazon.com.tr");
    }

    @Test
    public void testTurboaz() {
        driver.get("https://www.turbo.az");
    }
}
