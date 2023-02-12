package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConstructorPageStellarBurgers {

    private WebDriver driver;

    private By loginButton = By.xpath(".//button[text()='Войти в аккаунт']");

    private By orderButton = By.xpath(".//button[text()='Оформить заказ']");

    private By bunsTab = By.xpath(".//span[text()='Булки']");

    private By saucesTab = By.xpath(".//span[text()='Соусы']");

    private By fillingsTab = By.xpath(".//span[text()='Начинки']");

    private By currentTab = By.xpath(".//div[contains(@class,'current')]//span");

    private By ingredientsList = By.xpath(".//ul[starts-with(@class,'BurgerIngredients_ingredients__list')]");

    public ConstructorPageStellarBurgers(WebDriver driver) {
        this.driver = driver;
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public void clickBunsTab() {
        driver.findElement(bunsTab).click();
    }

    public void clickSaucesTab() {
        driver.findElement(saucesTab).click();
    }

    public void clickFillingsTab() {
        driver.findElement(fillingsTab).click();
    }

    public void waitConstructorPageLoads() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(ingredientsList));
    }

    public String getTextFromCurrentTab(){
        return driver.findElement(currentTab).getText();
    }

    public boolean isOrderButtonDisplayed (){
        return driver.findElement(orderButton).isDisplayed();
    }
}
