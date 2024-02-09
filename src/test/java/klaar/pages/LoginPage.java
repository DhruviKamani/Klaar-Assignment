package klaar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends Page {

    @FindBy(css = "[data-cy=\"login-with-klaar-button\"]")
    public WebElement logInWithKlaarButton;

    @FindBy(css = "[data-cy=\"login-email-text-field\"]")
    public WebElement emailInput;

    @FindBy(css = "[data-cy=\"login-password-text-field\"]")
    public WebElement passwordInput;

    @FindBy(css = "[data-cy=\"login-submit-button\"]")
    public WebElement loginButton;

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void Login(String email, String password) {
        emailInput.sendKeys(email);
        passwordInput.sendKeys(password);
        loginButton.click();
    }
}
