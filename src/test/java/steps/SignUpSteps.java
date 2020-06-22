package steps;
import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;


@DefaultUrl("https://www.tsum.ru/registration/?backurl=%2F")
public class SignUpSteps extends PageObject {
    @FindBy(xpath = "//auth-register//input[@type='email']")
    private WebElement login;

    @FindBy(xpath = "//auth-register//input[@type='password']")
    private WebElement password;

    @FindBy(xpath = "//auth-register//*[@type='submit']")
    private WebElement registrationBtn;

    @FindBy(xpath = "//notices//notice/div[@class='notice error']/span")
    private WebElement error;

    @FindBy(xpath = "//notices//notice//span")
    private WebElement registrMsg;

    @Step
    public void setLoginValue (String keyword) {
        login.sendKeys(keyword, Keys.ENTER);
    }

    @Step
    public void setPasswordValue (String keyword) {
        password.sendKeys(keyword, Keys.ENTER);
    }

    @Step
    public void signUp() {
        registrationBtn.click();
    }

    @Step
    public void errorCheck() {
        error.isDisplayed();
    }

    @Step
    public void msgCheck() {
        registrMsg.isDisplayed();
    }

    // To-do: correct the encoding
    @Step
    public void resultRegistrationFailed() {
        assertThat(error.getText(), containsString("Пароль должен быть не менее 8 символов длиной"));
    }

    @Step
    public void resultRegistrationChecked() {
        assertThat(registrMsg.getText(), containsString("Успешная регистрация"));
    }
}
