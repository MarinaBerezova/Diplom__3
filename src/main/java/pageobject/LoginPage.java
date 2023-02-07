package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;

    private By emailInput = By.xpath(".//form[starts-with(@class,'Auth_form')]//fieldset[1]//input");

    private By passwordInput = By.xpath(".//input[@name='Пароль']");

    private By submitButton = By.xpath(".//button[text()='Войти']");

    private By registrationLink = By.xpath(".//*[@href='/register']");

    private By forgotPasswordLink = By.xpath(".//*[@href='/forgot-password']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
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

    public void clickRegistrationLink (){
        driver.findElement(registrationLink).click();
    }

    public void clickForgotPasswordLink (){
        driver.findElement(forgotPasswordLink).click();
    }

    public void fillAndSubmitLoginForm (String email, String password){
        waitLoginPageLoads();
        setEmail(email);
        setPassword(password);
        clickSubmitButton();
    }

    public void waitLoginPageLoads () {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(submitButton));
    }

    public boolean isLoginButtonDisplayed (){
        return driver.findElement(submitButton).isDisplayed();
    }
}
