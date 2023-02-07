package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {

    private WebDriver driver;

    private By nameInput = By.xpath(".//form[starts-with(@class,'Auth_form')]//fieldset[1]//input");

    private By emailInput = By.xpath(".//form[starts-with(@class,'Auth_form')]//fieldset[2]//input");

    private By passwordInput = By.xpath(".//input[@name='Пароль']");

    private By submitButton = By.xpath(".//button[text()='Зарегистрироваться']");

    private By loginLink = By.xpath(".//*[@href='/login']");

    private By incorrectPasswordMessage = By.xpath(".//*[text()='Некорректный пароль']");

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setName (String name){
        driver.findElement(nameInput).sendKeys(name);
    }

    public void setEmail (String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void setPassword (String password){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickSubmitButton (){
        driver.findElement(submitButton).click();
    }

    public void clickLoginLink (){
        driver.findElement(loginLink).click();
    }

    public void fillAndSubmitRegistrationForm (String name, String email, String password){
        setName(name);
        setEmail(email);
        setPassword(password);
        clickSubmitButton();
    }

    public boolean isMessageIncorrectPasswordDisplayed() {
        return driver.findElement(incorrectPasswordMessage).isDisplayed();
    }

    public boolean isRegisterButtonDisplayed() {
        return driver.findElement(submitButton).isDisplayed();
    }
}
