import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageobject.RegistrationPage;

public class RegistrationNegativeFlowTest extends BaseUrl{

    private WebDriver driver;

    private TestDataGenerator generator;

    @Before
    // Браузер можно поменять в классе BaseUrl.
    public void setUp(){
        driver = getDriver();
        generator = new TestDataGenerator();
        driver.get(testInstance);
        driver.manage().deleteAllCookies();
    }

    @Test
    @DisplayName("Registration - password is less than 6 characters")
    @Description("Check that user registration fails if password is less than 6 characters")
    public void checkRegistrationFailsPasswordLess6Chars() {
        driver.get(testInstance + "/register");
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.fillAndSubmitRegistrationForm(generator.getName(), generator.getEmail(), "12345");
        Assert.assertTrue(objRegistrationPage.isMessageIncorrectPasswordDisplayed());
        Assert.assertTrue(objRegistrationPage.isRegisterButtonDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
