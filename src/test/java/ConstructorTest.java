import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pageobject.ConstructorPageStellarBurgers;

public class ConstructorTest extends BaseUrl {

    private WebDriver driver;
    private TestDataGenerator generator;

    @Before
    // Браузер можно поменять в классе BaseUrl.
    public void setUp() {
        driver = getDriver();
        generator = new TestDataGenerator();
    }

    @Test
    @DisplayName("Check 'Sauces' tab selection")
    @Description("Check that user can navigate through the list of ingredients using tab selection")
    public void checkSaucesTabSelection() {
        driver.get(testInstance);
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertEquals("Булки", objConstructorPage.getTextFromCurrentTab());
        objConstructorPage.clickSaucesTab();
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertEquals("Соусы", objConstructorPage.getTextFromCurrentTab());
    }

    @Test
    @DisplayName("Check 'Fillings' tab selection")
    @Description("Check that user can navigate through the list of ingredients using tab selection")
    public void checkFillingsTabSelection() {
        driver.get(testInstance);
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertEquals("Булки", objConstructorPage.getTextFromCurrentTab());
        objConstructorPage.clickFillingsTab();
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertEquals("Начинки", objConstructorPage.getTextFromCurrentTab());
    }

    @Test
    @DisplayName("Check 'Buns' tab selection")
    @Description("Check that user can navigate through the list of ingredients using tab selection")
    public void checkBunsTabSelection() {
        driver.get(testInstance);
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertEquals("Булки", objConstructorPage.getTextFromCurrentTab());
        objConstructorPage.clickSaucesTab();
        objConstructorPage.clickBunsTab();
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertEquals("Булки", objConstructorPage.getTextFromCurrentTab());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
