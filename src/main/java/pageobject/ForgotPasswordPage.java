package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotPasswordPage {

    private WebDriver driver;

    private By emailInput = By.xpath(".//form[starts-with(@class,'Auth_form')]//fieldset[1]//input");

    private By submitButton = By.xpath(".//button[text()='Восстановить']");

    private By loginLink = By.xpath(".//*[@href='/login']");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmail (String email){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void clickSubmitButton (){
        driver.findElement(submitButton).click();
    }

    public void clickLoginLink (){
        driver.findElement(loginLink).click();
    }

}
