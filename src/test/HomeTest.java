import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class HomeTest extends BaseTest {

    @DataProvider(name = "validAmounts")
    private Object[][] createValidAmounts() {
        return new Object[][]{
                {"1,01"},
                {"345.99"},
                {"1.00"},
                {"2"}
        };
    }
    @Test(dataProvider = "validAmounts")
    public void testPaymentWithAmount(String sum) {

    }
}
