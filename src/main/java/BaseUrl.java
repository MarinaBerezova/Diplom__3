import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseUrl {
    public WebDriver getDriver(){
        // Выберите браузер:
        // 1. Chrome браузер:
        //System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/chromedriver.exe");
        // 2. Яндекс.Браузер:
        System.setProperty("webdriver.chrome.driver", "/WebDriver/bin/yandexdriver.exe");

        WebDriver driver = new ChromeDriver();
        return driver;
    }

    // URL тестового приложения
    protected String testInstance = "https://stellarburgers.nomoreparties.site";
}