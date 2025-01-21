import Base.BaseTest;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {
    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Test(description = "Başarılı giriş kontrolü")
    public void LoginSuccesfull() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword(password)
                .clickLogin();

        sleep(1500);
        Assert.assertEquals(mainPage.getAccountValue(), "TH");
    }

    @Test(description = "Başarısız giriş kontrolü")
    public void LoginUnSuccesfull() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword("Hatali.!")
                .clickLogin();

        Thread.sleep(1500);
        loginPage.errorMessageController(errorLoginMessage);
    }

    @Test(description = "Parolada maximum karakter giriş kontrolü")
    public void MaxCharacterPasswordControl() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword("1359t2e8s6t47r31t59s4e72t8r69t8s4e2t6r7135591t4e7s3r2868t2e6s7r33s")
                .clickLogin();

        Thread.sleep(1500);
        loginPage.passwordLengthController("Girilen değer en fazla 15 karakter olmalıdır.");
    }

    @Test(description = "Parolada minimum karakter giriş kontrolü")
    public void MinCharacterPasswordControl() throws InterruptedException {
        loginPage.fillEmail(email)
                .fillPassword("12345")//sınır değer
                .clickLogin();

        Thread.sleep(1500);
        loginPage.passwordLengthController("Girilen değer en az 6 karakter olmalıdır.");
    }

    @Test(description = "Boş parola giriş kontrolü")
    public void EmptyPasswordControl() throws InterruptedException {
        loginPage.fillEmail(email)
                .clearPassword()
                .clickLogin();

        Thread.sleep(1500);
        loginPage.passwordLengthController("Şifreni girebilir misin?");
    }

    @Test(description = "Boş email bilgisi giriş kontrolü")
    public void EmptyEmailControl() throws InterruptedException {
        loginPage.clearEmail()
                .fillPassword(password)
                .clickLogin();

        Thread.sleep(1500);
        loginPage.emailFormatController("Geçerli bir e-posta adresi girmelisin.");
    }

    @Test(description = "Hatalı email formatı girişi kontrolü")
    public void WrongEmailFormatControl() throws InterruptedException {
        loginPage.fillEmail("test.xyz")
                .fillPassword(password)
                .clickLogin();

        Thread.sleep(1500);
        loginPage.emailFormatController("Geçerli bir e-posta adresi girmelisin.");
    }
}
