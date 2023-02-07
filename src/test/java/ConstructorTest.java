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
        driver.get(testInstance);
        driver.manage().deleteAllCookies();
    }

    @Test
    @DisplayName("Check 'Buns', 'Sauces' and 'Fillings' tab selection")
    @Description("Check that user can navigate through the list of ingredients using tab selection")
    public void checkTabSelection() {
        driver.get(testInstance);
        ConstructorPageStellarBurgers objConstructorPage = new ConstructorPageStellarBurgers(driver);
        objConstructorPage.waitConstructorPageLoads();
        Assert.assertEquals("Булки", objConstructorPage.getTextFromCurrentTab());
        objConstructorPage.clickSaucesTab();
        Assert.assertEquals("Соусы", objConstructorPage.getTextFromCurrentTab());
        objConstructorPage.waitConstructorPageLoads();
        objConstructorPage.clickFillingsTab();
        Assert.assertEquals("Начинки", objConstructorPage.getTextFromCurrentTab());
        objConstructorPage.waitConstructorPageLoads();
        objConstructorPage.clickBunsTab();
        Assert.assertEquals("Булки", objConstructorPage.getTextFromCurrentTab());
    }

    @After
    public void teardown() {
        driver.quit();
    }
}
