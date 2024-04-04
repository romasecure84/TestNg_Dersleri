package tests.Ders10;

import org.testng.annotations.Test;
import utilities.Driver;

public class C01_DriverIlkTest {
    @Test
    public void test() {
        Driver.getDriver().get("https://www.amazon.com.tr");
        Driver.getDriver().get("https://www.turbo.az");
        Driver.closeDriver();
        Driver.getDriver().get("https://www.bina.az");
        Driver.closeDriver();
    }
}
