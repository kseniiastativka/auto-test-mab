import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentProductTemplatePage {
    private WebDriver driver;

    private By ammountToBeTrasfered = By.className("customAmountText");

    public PaymentProductTemplatePage(WebDriver driver) {
        this.driver = driver;
    }
}
