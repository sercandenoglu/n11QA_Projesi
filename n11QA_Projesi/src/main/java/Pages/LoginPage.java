package Pages;

import Base.BaseTest;
import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage extends BaseTest {
    @Step("E-posta alanı doldurulur")
    public LoginPage fillEmail(String text) {
        WebElement element = driver.findElement(By.cssSelector("#email[name='email']"));
        element.clear();
        element.sendKeys(text);
        screenshot();
        return this;
    }

    @Step("E-posta alanı temizleniyor")
    public LoginPage clearEmail() throws InterruptedException {
        driver.findElement(By.cssSelector("#email[name='email']")).clear();
        screenshot();
        return this;
    }

    @Step("E-posta alanına tıklanır")
    public LoginPage clickEmail() throws InterruptedException {
        driver.findElement(By.cssSelector("#email[name='email']")).click();
        screenshot();
        return this;
    }

    @Step("Parola alanı doldurulur")
    public LoginPage fillPassword(String text) {
        driver.findElement(By.cssSelector("#password[name='password']")).sendKeys(text);
        screenshot();
        return this;
    }

    @Step("Parola alanı temizlenir")
    public LoginPage clearPassword() throws InterruptedException {
        driver.findElement(By.cssSelector("#password[name='password']")).clear();
        screenshot();
        return this;
    }

    @Step("Parola alanına tıklanır")
    public LoginPage clickPassword() throws InterruptedException {
        driver.findElement(By.cssSelector("#password[name='password']")).click();
        screenshot();
        return this;
    }

    @Step("Login buttonuna tıklanır")
    public LoginPage clickLogin() {
        driver.findElement(By.cssSelector("[class='btnPrimary']")).click();
        return this;
    }

    @Step("Hata mesajı kontrolü")
    public LoginPage errorMessageController(String text) {
        String message = driver.findElement(By.cssSelector("[class='error-message']")).getText();
        Allure.addAttachment(message, "");
        screenshot();
        Assert.assertEquals(message, text);
        return this;
    }

    @Step("Parola uzunluğu hata mesajı kontrolü")
    public LoginPage passwordLengthController(String text) {
        String message = driver.findElement(By.cssSelector("[data-errormessagefor='password'] [class='errorText']")).getText();
        Allure.addAttachment(message, "");
        screenshot();
        Assert.assertEquals(message, text);
        return this;
    }

    @Step("Parola uzunluğu hata mesajı kontrolü")
    public LoginPage emailFormatController(String text) {
        String message = driver.findElement(By.cssSelector("[data-errormessagefor='email'] [class='errorText']")).getText();
        Allure.addAttachment(message, "");
        screenshot();
        Assert.assertEquals(message, text);
        return this;
    }
}
