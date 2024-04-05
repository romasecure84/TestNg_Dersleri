package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AloTechPage {
    public AloTechPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id='data-email']")
    public WebElement email;
    @FindBy(xpath = "//*[@id='password']")
    public WebElement password;
    @FindBy(xpath = "(//*[text()='Login'])[2]")
    public WebElement loginButton;
    @FindBy(xpath = "(//*[text()='Login'])[1]")
    public WebElement loginYazi;
}
