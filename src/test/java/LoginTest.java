import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pageobject.*;

@RunWith(Parameterized.class)
public class LoginTest extends BaseUrl{

    private String page;

    private WebDriver driver;

    private TestDataGenerator generator;

    public LoginTest(String page) {
        this.page = page;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"constructorPage"},
                {"registrationPage"},
                {"forgotPasswordPage"},
                {"header"},
        };
    }

    @Before
    // Браузер можно поменять в классе BaseUrl.
    public void setUp(){
        driver = getDriver();
        generator = new TestDataGenerator();
    }

    @Test
    @DisplayName("Check user login")
    @Description("Check that user can login using 'Login' button on different pages.")
    public void checkLoginSuccess() {
        registerUser();
        clickLoginButtonOnPage(page);
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAndSubmitLoginForm(generator.getEmail(), generator.getPassword());
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertTrue(objConstructorPage.isOrderButtonDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Step("Register Test User")
    public void registerUser() {
        driver.get(testInstance + "/register");
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.fillAndSubmitRegistrationForm(generator.getName(), generator.getEmail(), generator.getPassword());
    }

    @Step("This step navigates to selected page and clicks Login button on it.")
    public void clickLoginButtonOnPage(String page) {
        switch (page) {
            case "constructorPage":
                driver.get(testInstance);
                ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
                objConstructorPage.clickLoginButton();
                break;
            case "registrationPage":
                driver.get(testInstance + "/register");
                RegistrationPage objRegistrationPage = new RegistrationPage(driver);
                objRegistrationPage.clickLoginLink();
                break;
            case "forgotPasswordPage":
                driver.get(testInstance + "/forgot-password");
                ForgotPasswordPage objForgotPasswordPage = new ForgotPasswordPage(driver);
                objForgotPasswordPage.clickLoginLink();
                break;
            case "header":
                driver.get(testInstance);
                Header objHeader = new Header(driver);
                objHeader.clickAccountProfileButton();
                break;
        }
    }
}
