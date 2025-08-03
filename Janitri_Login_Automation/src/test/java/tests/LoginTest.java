
package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends BaseTest {

    @Test
    public void testLoginButtonDisabledWhenFieldAreEmpty() {
        LoginPage login = new LoginPage(driver);
        Assert.assertFalse(login.isLoginButtonEnabled(), "Login button should be disabled");
    }

    @Test
    public void testPasswordMaskedbutton() {
        LoginPage login = new LoginPage(driver);
        Assert.assertTrue(login.isPasswordMasked(), "Password should be masked");
        login.clickPasswordToggle();
        Assert.assertFalse(login.isPasswordMasked(), "Password should be unmasked");
    }

    @Test
    public void testInvalidLoginShowErrorMsg() {
        LoginPage login = new LoginPage(driver);
        login.enterCredentials("fakeuser", "fakepass");
        login.clickLogin();
        Assert.assertTrue(login.getErrorMessage().contains("invalid") || login.getErrorMessage().contains("error"), 
            "Should show error for invalid credentials");
    }
}
