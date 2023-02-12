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
import pageobject.ConstructorPageStellarBurgers;
import pageobject.LoginPage;
import pageobject.RegistrationPage;

@RunWith(Parameterized.class)
public class RegistrationTest extends BaseUrl{

    private String password;

    private WebDriver driver;

    private TestDataGenerator generator;

    public RegistrationTest(String password) {
        this.password = password;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData() {
        return new Object[][]{
                {"123456"},
                {"1234567"},
        };
    }

    @Before
    // Браузер можно поменять в классе BaseUrl.
    public void setUp(){
        driver = getDriver();
        generator = new TestDataGenerator();
    }

    @Test
    @DisplayName("Check user registration")
    @Description("Check that user can be registered and logged in with new account successfully.")
    public void checkRegistrationSuccess() {
        driver.get(testInstance);
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.clickLoginButton();
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.clickRegistrationLink();
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.fillAndSubmitRegistrationForm(generator.getName(), generator.getEmail(), password);
        objLoginPage.waitLoginPageLoads();
        Assert.assertTrue(objLoginPage.isLoginButtonDisplayed());
        checkLoginIsSuccess(objLoginPage, objConstructorPage);
    }

    @After
    public void teardown() {
            driver.quit();
    }

    @Step("Check login is successful.")
    public void checkLoginIsSuccess(LoginPage objLoginPage, ConstructorPageStellarBurgers objConstructorPage) {
        objLoginPage.fillAndSubmitLoginForm(generator.getEmail(), password);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertTrue(objConstructorPage.isOrderButtonDisplayed());
    }
}
