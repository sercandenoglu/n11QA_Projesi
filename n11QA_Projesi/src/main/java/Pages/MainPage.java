package Pages;

import Base.BaseTest;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPage extends BaseTest {

    @Step("Kullanıcı bilgisi alınır")
    public String getAccountValue(){
        screenshot();
        //Hesabın adı soyad Test Hesabı olduğu için TH verisi geri dönmeli
        return driver.findElement(By.cssSelector("[class='myAccount myAccountElliptical']")).getText();
    }
}
