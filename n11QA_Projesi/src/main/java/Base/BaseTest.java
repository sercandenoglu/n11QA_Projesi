package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends BaseLibrary {

    @BeforeMethod(description = "Web sayfası açılır")
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterMethod(description = "Tarayıcı kapatılır")
    public void closeBrowser() {
        driver.quit();
    }
}
