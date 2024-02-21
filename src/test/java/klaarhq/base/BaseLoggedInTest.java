package klaarhq.base;

import org.junit.jupiter.api.BeforeAll;

import klaarhq.pages.LoginOptionsPage;

public abstract class BaseLoggedInTest extends BaseTest {

	@BeforeAll
	public static void Login() {
		var loginPage = new LoginOptionsPage(driver).WaitForLoad().LoginWithKlaar().WaitForLoad();
		var email = properties.getProperty("email");
		var password = properties.getProperty("password");
		loginPage.LoginExpactingSuccess(email, password).WaitForLoad();
	}
}