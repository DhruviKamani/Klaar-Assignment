package klaarhq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import klaarhq.base.BasePage;

public class LoginPage extends BasePage<LoginPage> {

	public By loginHeading = By.cssSelector("[data-cy=\"login-heading\"]");
	public By emailInput = By.cssSelector("[data-cy=\"login-email-text-field\"]");
	public By passwordInput = By.cssSelector("[data-cy=\"login-password-text-field\"]");
	public By loginButton = By.cssSelector("[data-cy=\"login-submit-button\"]");
	public By emailError = By.cssSelector("[data-cy=\"login-email-missing-error-message\"]>div:nth-child(2)");
	public By passwordError = By.cssSelector("[data-cy=\"login-password-missing-error-message\"]>div:nth-child(2)");
	public By error = By.cssSelector("[data-cy=\"login-page-alert-error-message\"]");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public String GetEmailError()
	{
		wait.until(d -> !driver.findElement(emailError).getText().equals(""));
		return driver.findElement(emailError).getText();
	}
	
	public String GetPasswordError()
	{
		wait.until(d -> !driver.findElement(passwordError).getText().equals(""));
		return driver.findElement(passwordError).getText();
	}
	
	public String GetError()
	{
		wait.until(d -> !driver.findElement(error).getText().equals(""));
		return driver.findElement(error).getText();
	}

	private void FillDetails(String email, String password)
	{
		driver.findElement(emailInput).clear();
		driver.findElement(emailInput).sendKeys(email);
		driver.findElement(passwordInput).clear();
		driver.findElement(passwordInput).sendKeys(password);
		driver.findElement(loginButton).click();
	}
	
	public LoginPage LoginExpectingFailure(String email, String password)
	{
		FillDetails(email, password);

		return new LoginPage(driver);
	}
	
	public HomePage LoginExpactingSuccess(String email, String password)
	{
		FillDetails(email, password);
		
		return new HomePage(driver);
	}

	@Override
	public LoginPage WaitForLoad() {
		wait.until(d -> d.findElement(loginHeading).getText().equals("Log in"));
		return this;
	}
}
