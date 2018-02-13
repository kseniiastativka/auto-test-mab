import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By loginLocator = By.id("login");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("loginButton");
    private By otpLocator = By.id("otp");
    private By otpSubmitButtonLocator = By.id("nextButton");
    private By notificationContentLocator = By.className("notification_content");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }



    public LoginPage loginWithIncorrectCreds(String login, String password) {
        tryLogin(login, password);
        return this;
    }

    public HomePage loginWithCorrectCreds(String login, String password) {
        tryLogin(login, password);
        return new HomePage(driver);
    }

    public String getLoginErrorNotification() {
        if (Utils.isElementPresent(driver, notificationContentLocator)) {
            return driver.findElement(notificationContentLocator).getText();
        }
        return "";
    }

    public LoginPage open() {
        driver.get("https://my.alfabank.com.ua");
        return this;
    }

    private void tryLogin(String login, String password) {
        WebElement loginInput = driver.findElement(loginLocator);
        loginInput.clear();
        loginInput.sendKeys(login);

        WebElement passwordInput = driver.findElement(passwordLocator);
        passwordInput.clear();
        passwordInput.sendKeys(password);

        driver.findElement(loginButtonLocator).click();
        if (Utils.isElementPresent(driver, otpLocator)) {
            driver.findElement(otpLocator).sendKeys("0000");
            driver.findElement(otpSubmitButtonLocator).click();
        }
    }
}
