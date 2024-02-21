package klaarhq.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import klaarhq.base.BasePage;

public class LoginOptionsPage extends BasePage<LoginOptionsPage> {

	public By loginKlaarLogo = By.cssSelector("[data-cy=\"login-klaar-logo\"]");
	public By loginButtons = By.className("login-button");
	
	public LoginOptionsPage(WebDriver driver) {
		super(driver);
		System.out.println(wait);
		
	}
	
	private void ClickButtonWithText(String text)
	{		
		driver.findElements(loginButtons)
		.stream()
		.filter(e -> e.getText().equals(text))
		.findFirst()
		.orElseThrow()
		.click();
	}
	
	public LoginPage LoginWithKlaar()
	{
		ClickButtonWithText("Log in with klaar");

		return new LoginPage(driver);
	}

	@Override
	public LoginOptionsPage WaitForLoad() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(loginKlaarLogo));
		return this;
	}
}
