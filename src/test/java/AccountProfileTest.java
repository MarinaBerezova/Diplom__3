import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.*;

public class AccountProfileTest extends BaseUrl {

    private WebDriver driver;
    private TestDataGenerator generator;

    @Before
    // Браузер можно поменять в классе BaseUrl.
    public void setUp() {
        driver = getDriver();
        generator = new TestDataGenerator();
        driver.get(testInstance);
        driver.manage().deleteAllCookies();
    }

    @Test
    @DisplayName("Check entrance to Account Profile by button in header")
    @Description("Check that user can navigate to Account Profile by clicking button in header.")
    public void checkAccountProfileButtonHeader() {
        registerUserAndLogin();
        Header objHeader = new Header(driver);
        objHeader.clickAccountProfileButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.waitAccountProfilePageLoads();
        Assert.assertEquals(generator.getName(), objAccountProfilePage.getAccountNameValue());
        Assert.assertEquals(generator.getEmail(), objAccountProfilePage.getAccountEmailValue());
    }

    @Test
    @DisplayName("Check navigation to Constructor by clicking on Logo")
    @Description("Check that user can navigate from Account Profile to Constructor by clicking on Logo in header.")
    public void checkRedirectToConstructorByLogo() {
        registerUserAndLogin();
        Header objHeader = navigateToAccountProfile();
        objHeader.clickStellarBurgersLogo();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertTrue(objConstructorPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Check navigation to Constructor by clicking 'Constructor' button")
    @Description("Check that user can navigate from Account Profile to Constructor by clicking 'Constructor' button in header.")
    public void checkRedirectToConstructorByButton() {
        registerUserAndLogin();
        Header objHeader = navigateToAccountProfile();
        objHeader.clickConstructorButton();
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertTrue(objConstructorPage.isOrderButtonDisplayed());
    }

    @Test
    @DisplayName("Check logout")
    @Description("Check that user can logout by clicking button on Account Profile page.")
    public void checkLogoutSuccess() {
        LoginPage objLoginPage = registerUserAndLogin();
        Header objHeader = navigateToAccountProfile();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.clickExitButton();
        objLoginPage.waitLoginPageLoads();
        Assert.assertTrue(objLoginPage.isLoginButtonDisplayed());
        objHeader.clickAccountProfileButton();
        Assert.assertTrue(objLoginPage.isLoginButtonDisplayed());
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Step("Register Test User and Login")
    public LoginPage registerUserAndLogin() {
        driver.get(testInstance + "/register");
        RegistrationPage objRegistrationPage = new RegistrationPage(driver);
        objRegistrationPage.fillAndSubmitRegistrationForm(generator.getName(), generator.getEmail(), generator.getPassword());
        LoginPage objLoginPage = new LoginPage(driver);
        objLoginPage.fillAndSubmitLoginForm(generator.getEmail(), generator.getPassword());
        return objLoginPage;
    }

    @Step("Navigate to Account Profile page")
    public Header navigateToAccountProfile() {
        Header objHeader = new Header(driver);
        objHeader.clickAccountProfileButton();
        AccountProfilePage objAccountProfilePage = new AccountProfilePage(driver);
        objAccountProfilePage.waitAccountProfilePageLoads();
        return objHeader;
    }
}