package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class CrossDriver {
    private CrossDriver(){
        //Bu veziyyetde bos private Driver yaradaraq Driverin obyekte teyin edilebilmesinin qarsisini ala bilerik
    }
    static WebDriver driver;

    public static WebDriver getDriver(String browser){
        browser=browser==null ? ConfigReader.getProperty("browser"):browser;
        if (driver==null){
            switch (browser){
                case  "chrome":
                    driver=new ChromeDriver();
                    break;

                case "edge":
                    driver=new EdgeDriver();
                    break;

                case "mozilla":
                    driver=new FirefoxDriver();

                default:
                    driver=new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver=null;
        }
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver=null;
        }
    }
}


