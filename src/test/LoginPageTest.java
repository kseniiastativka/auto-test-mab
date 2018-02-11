import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest {
    private LoginPage loginPage;

    public LoginPageTest(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

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
        loginPage.login(login, password);
        String errorNotification = loginPage.getLoginErrorNotification();
        Assert.assertTrue(errorNotification.equals("Не вдалось виконати вхід у систему. Перевірте, будь ласка, правильність введення логіну та паролю"), "Error notification is not correct: " + errorNotification);
    }


}
