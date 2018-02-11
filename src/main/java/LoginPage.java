import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private WebDriver driver; // TODO why not private?

    private By loginLocator = By.id("login");
    private By passwordLocator = By.id("password");
    private By loginButtonLocator = By.id("loginButton");
    private By otpLocator = By.id("otp");
    private By otpSubmitButtonLocator = By.id("nextButton");
    private By notificationContentLocator = By.className("notification_content");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }


//        Assert.assertTrue(isElementPresent(By.className("all-operations")), "No such block 'all-operations' on the main page");

    public LoginPage login(String login, String password) {
        driver.findElement(loginLocator).sendKeys(login);
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        if (isElementPresent(otpLocator)) {
            driver.findElement(otpLocator).sendKeys("0000");
            driver.findElement(otpSubmitButtonLocator).click();
        }
        return this; // TODO what do we return? LoginPage or HomePage?
    }

    public String getLoginErrorNotification() {
        if (isElementPresent(notificationContentLocator)) {
            return driver.findElement(notificationContentLocator).getText();
        }
        return "";
    }

    // TODO extract to separate utils class
    public boolean isElementPresent(By locator) {
        try {
            driver.findElement(locator);
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }


}
