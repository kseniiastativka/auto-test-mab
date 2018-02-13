import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By allOperations = By.className("all-operations");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isAllOperationsPresent() {
        return Utils.isElementPresent(driver, allOperations);
    }

}
