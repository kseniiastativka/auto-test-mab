import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
    private WebDriver driver;

    private By allOperationsLocator
            = By.xpath("//div[@class='row thick']//h2");
    private By sourceAlfaCartLocator
            = By.xpath("//div[contains(@class, 'sourceAlfa-P2PTransfer-4rNr47')]/div[contains(@class, 'alfa-P2PCard-1_qKIb')]");
    private By targetAlfaCardLocator
            = By.xpath("//div[contains(@class, 'targetAlfa-P2PTransfer-2tVSLX')]/div[contains(@class, 'alfa-P2PCard-1_qKIb')]");
    private By inputSumLocator = By.className("sumField-P2PTransfer-2MLKLw");
    private By submitButtonLocator = By.className("button-P2PTransfer-2_1bvm");
    private By targetCardsSelectLocator = By.className("select-P2PCardSelect-2M3uEo");
    private By targetUsersCardOptionLocator = By.xpath("//div[contains(@class, 'targetAlfa-P2PTransfer-2tVSLX')]//ul/li[2]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAllOperationsText() {
        return driver.findElement(allOperationsLocator).getText();
    }

    public PaymentProductTemplatePage makeInternalPaymentInP2PBlock(String sum) {
        driver.findElement(targetAlfaCardLocator).click();
        driver.findElement(targetCardsSelectLocator).click();
        driver.findElement(targetUsersCardOptionLocator).click();
        driver.findElement(inputSumLocator).sendKeys(sum);
        driver.findElement(submitButtonLocator).click();
        return new PaymentProductTemplatePage(driver);
    }
}
