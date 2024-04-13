package utilities;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private Driver(){
        //Bu veziyyetde bos private Driver yaradaraq Driverin obyekte teyin edilebilmesinin qarsisini ala bilerik
    }
    static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver==null){
            switch (ConfigReader.getProperty("browser")){
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

            driver.manage().window().setSize(new Dimension(1382, 744));
            driver.manage().window().setPosition(new Point(1912, 303));
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
