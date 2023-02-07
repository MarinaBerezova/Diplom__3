package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Header {

    private WebDriver driver;

    private By accountProfileButton = By.xpath(".//*[text()='Личный Кабинет']");

    private By constructorButton = By.xpath(".//*[text()='Конструктор']");

    private By stellarBurgersLogo = By.xpath(".//div[starts-with(@class,'AppHeader_header__logo')]");

    public Header(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAccountProfileButton (){
        driver.findElement(accountProfileButton).click();
    }

    public void clickConstructorButton (){
        driver.findElement(constructorButton).click();
    }

    public void clickStellarBurgersLogo (){
        driver.findElement(stellarBurgersLogo).click();
    }
}
