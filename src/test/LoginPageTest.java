import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends BaseTest {

    @DataProvider(name = "invalidCreds")
    private Object[][] createInvalidCreds() {
        return new Object[][]{
                {";lskrg", ""},
                {"", "ddfd3663"},
                {"s;lkf'q", "sfsdfwe"}
        };
    }

    @Test(dataProvider = "invalidCreds")
    public void testErrorNotification(String login, String password) {
        loginPage.loginWithIncorrectCreds(login, password);
        String errorNotification = loginPage.getLoginErrorNotification();
        Assert.assertTrue(errorNotification.equals("Не вдалось виконати вхід у систему. Перевірте, будь ласка, правильність введення логіну та паролю"), "Error notification is not correct: " + errorNotification);
    }

    @Test
    public void testTransitionToHomePage() {
        HomePage homePage = loginPage.loginWithCorrectCreds("****", "****"); //TODO DELETE creds
        Assert.assertTrue(homePage.isAllOperationsPresent(), "No such block 'all-operations' on the main page");
    }


}
