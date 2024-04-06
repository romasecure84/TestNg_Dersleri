package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class TestBaseReport {

    protected static ExtentReports extentReports; //extent report'a ilk teyini edir
    protected static ExtentTest extentTest;
    // test pass veya failed kimi bilgileri yaddasa yazir. Elave olaraq screenshot ucun de istifade ede bilerik
    protected static ExtentHtmlReporter extentHtmlReporter; // Html report'u yaradir

    // Test emeliyatina baslamazdan once (test methodundan once deyil, butun test emeliyatindan once)
    @BeforeTest(alwaysRun = true) //alwaysRun : her zaman run et
    public void setUpTest() {
        extentReports = new ExtentReports(); // report'lamani basladir

        //report yarandiqdan sonra yaddasa yazilacagi yeri teyin etmek ucun
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());// ustuste yazmasin deye
        String filePath = System.getProperty("user.dir") + "/target/Report/report"+date+".html";
        //yaratmaq istediyimiz report'u(html formatinda) basladiriq, filePath ile dosya yolunu teyin edirik
        extentHtmlReporter = new ExtentHtmlReporter(filePath);
        extentReports.attachReporter(extentHtmlReporter);
        // istediyimiz melumatlari bura elave edirik
        extentReports.setSystemInfo("Environment","QA");
        extentReports.setSystemInfo("Browser", ConfigReader.getProperty("browser")); // chrome, firefox
        extentReports.setSystemInfo("Automation Engineer", "Rafail");
        extentHtmlReporter.config().setDocumentTitle("Report");
        extentHtmlReporter.config().setReportName("TestNG Reports");
    }
    // Her test metodundan sonra eger testde xeta varsa screenshot alib reporta elave edir
    @AfterMethod(alwaysRun = true) //Her test methodundan sonra run olur
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) { // eger testin necicesi ugurlu deyilse
            String screenshotLocation = ReusableMethods.getScreenshot(result.getName());
            extentTest.fail(result.getName());
            extentTest.addScreenCaptureFromPath(screenshotLocation);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) { // eger test islemeden kecilmez ise
            extentTest.skip("Test Case is skipped: " + result.getName()); // Ignore olanlar
        }
        Driver.closeDriver();
    }
    // Report'landırmayı sonlandırmak ucun
    @AfterTest(alwaysRun = true)
    public void tearDownTest() {
        extentReports.flush();
    }
}

