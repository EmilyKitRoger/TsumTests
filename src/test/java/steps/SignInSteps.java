package steps;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import net.serenitybdd.core.annotations.findby.FindBy;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.StringContains.containsString;

@DefaultUrl("https://www.tsum.ru/login/?backurl=%2F")
public class SignInSteps extends PageObject {
    @FindBy(xpath = "//auth-login//input[contains(@class,'login-input')]")
    private WebElement login;

    @FindBy(xpath = "//auth-login//input[contains(@class,'pwd-input')]")
    private WebElement password;

    @FindBy(xpath = "//auth-login//*[@type='submit']")
    private WebElement loginBtn;

    @FindBy(xpath = "//notices//notice/div[@class='notice error']/span", timeoutInSeconds="5")
    private WebElement error;

    @FindBy(xpath = "//header[@class='header']//a[@href='/personal/orders/']", timeoutInSeconds="5")
    private WebElement user;

    @Step
    public void setLoginValue (String keyword) {
        login.sendKeys(keyword, Keys.ENTER);
    }

    @Step
    public void setPasswordValue (String keyword) {
        password.sendKeys(keyword, Keys.ENTER);
    }

    @Step
    public void signIn() {
        loginBtn.click();
    }

    @Step
    public void errorCheck() {
        error.isDisplayed();
    }


    @Step
    public void resultLoginChecked() {
        assertThat(user.getText(), containsString("signInTsumAutoTest-1111@gmail.com"));
    }

    // To-do: correct the encoding
    @Step
    public void resultLoginFailed() {
        assertThat(error.getText(), containsString("Указан некорректный email"));
    }
}