import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    static WebDriver driver;


//    public static void main(String[] args) {
//
//    }ª

    @BeforeTest
    public static void init() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://my.alfabank.com.ua/login");

    }

    @Test
    public static void test() {
        LoginPage loginPage = new LoginPage(driver);
        LoginPageTest loginPageTest = new LoginPageTest(loginPage);
        loginPageTest.testErrorNotification("ee", "sdf");
    }

    @AfterTest
    public static void stop() {
        driver.quit();
    }

}
