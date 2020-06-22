package pageTests;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import steps.SignUpSteps;
import java.util.Random;


@RunWith(SerenityRunner.class)
public class SignUpTests {
    @Managed(driver = "chrome")
    private WebDriver browser;

    private SignUpSteps steps;
    private Random random = new Random();

    @Test
    public void whenWrongPasswordThenRegistrationFailed() {
        steps.open();
        steps.setLoginValue("signUpTsumAutoTest-1@gmail.com");
        steps.setPasswordValue("passw"); // Using short password, it is reliably incorrect
        steps.signUp();
        // steps.resultRegistrationFailed(); // Disabled cause of incorrect encoding
        steps.errorCheck();
    }

    @Test
    public void whenCorrectEmailAndPasswordThenRegistrationChecked() {
        int num = random.nextInt(10000);

        steps.open();
        steps.setLoginValue("signUpTsumAutoTest" + num + "@mail.ru"); // Using random login
        steps.setPasswordValue("password");
        steps.signUp();
        // steps.resultRegistrationChecked(); // Disabled cause of incorrect encoding
        steps.msgCheck();
    }
}
