package pageTests;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SignInSteps;

@RunWith(SerenityRunner.class)
public class SignInTests {
    @Managed(driver = "chrome")
    private WebDriver browser;

    @Steps
    SignInSteps steps;

    @Test
    public void whenWrongEmailAndPasswordThenLoginFailed() {
        steps.open();
        steps.setLoginValue("login");
        steps.setPasswordValue("password");
        steps.signIn();
        //steps.resultLoginFailed();
        steps.errorCheck();
    }

    @Test
    public void whenCorrectEmailAndPasswordThenLoginChecked() {
        steps.open();
        steps.setLoginValue("signInTsumAutoTest-1111@gmail.com");
        steps.setPasswordValue("password");
        steps.signIn();
        steps.resultLoginChecked();
    }
}