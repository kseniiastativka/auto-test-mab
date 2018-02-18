import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    private By allOperations
            = By.xpath("//div[@class='row thick']//h2");
    private By sourceAlfaCart
            = By.xpath("//div[contains(@class, 'sourceAlfa-P2PTransfer-4rNr47')]/div[contains(@class, 'alfa-P2PCard-1_qKIb')]");
    private By targetAlfaCart
            = By.xpath("//div[contains(@class, 'targetAlfa-P2PTransfer-2tVSLX')]/div[contains(@class, 'alfa-P2PCard-1_qKIb')]");
    private By inputSum = By.className("sumField-P2PTransfer-2MLKLw");
    private By submitButton = By.className("button-P2PTransfer-2_1bvm");
    private By targetCardsSelect = By.className("select-P2PCardSelect-2M3uEo");
    private By targetUsersCardOption = By.xpath("//div[contains(@class, 'targetAlfa-P2PTransfer-2tVSLX')]//ul/li[2]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public String getAllOperationsText() {
        return driver.findElement(allOperations).getText();
    }


}
