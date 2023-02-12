package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountProfilePage {

    private WebDriver driver;

    private By exitButton = By.xpath(".//button[text()='Выход']");

    private By name = By.name("Name");

    private By email = By.name("name");

    private By profileInfo = By.xpath(".//ul[starts-with(@class,'Profile_profileList')]");

    public AccountProfilePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickExitButton (){
        driver.findElement(exitButton).click();
    }

    public void waitAccountProfilePageLoads() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(profileInfo));
    }

    public String getAccountNameValue (){
        return driver.findElement(name).getAttribute("value");
    }

    public String getAccountEmailValue (){
        return driver.findElement(email).getAttribute("value");
    }
}
