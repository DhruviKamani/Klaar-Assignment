package klaarhq.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import klaarhq.base.BaseTest;
import klaarhq.pages.LoginOptionsPage;
import klaarhq.pages.LoginPage;

public class LoginTests extends BaseTest {

	@BeforeEach
	public void Refresh() {
		driver.navigate().refresh();
		new LoginOptionsPage(driver).WaitForLoad().LoginWithKlaar();
	}

	@Test
	public void EmptyEmail() {
		var password = faker.number().digits(6).toString();
		var loginPage = new LoginPage(driver).WaitForLoad();
		loginPage = loginPage.LoginExpectingFailure("", password);
		assertEquals("Please enter valid email or phone number", loginPage.GetEmailError());
	}

	@Test
	public void EmptyPassword() {
		var email = properties.getProperty("email");
		var loginPage = new LoginPage(driver).WaitForLoad();
		loginPage = loginPage.LoginExpectingFailure(email, "");
		assertEquals("Please enter your password here", loginPage.GetPasswordError());
	}

	@Test
	public void EmptyEmailAndPassword() {
		var loginPage = new LoginPage(driver).WaitForLoad();
		loginPage = loginPage.LoginExpectingFailure("", "");
		assertEquals("Please enter valid email or phone number", loginPage.GetEmailError());
		assertEquals("Please enter your password here", loginPage.GetPasswordError());
	}

	@Test
	public void InvalidEmail() {
		var email = faker.internet().emailAddress();
		var password = faker.number().digits(6).toString();
		var loginPage = new LoginPage(driver).WaitForLoad();
		loginPage = loginPage.LoginExpectingFailure(email, password);
		assertEquals("Sorry! It seems like your user details are not added in Klaar. Please contact your HR.",
				loginPage.GetError());
	}

	@Test
	public void InvalidPassword() {
		var email = properties.getProperty("email");
		var password = faker.number().digits(6).toString();
		var loginPage = new LoginPage(driver).WaitForLoad();
		loginPage = loginPage.LoginExpectingFailure(email, password);
		assertTrue(loginPage.GetError().contains("Oops! Incorrect Email or Password"));
	}

	@Test
	public void SuccessfullLogin() {
		var email = properties.getProperty("email");
		var password = properties.getProperty("password");
		var loginPage = new LoginPage(driver).WaitForLoad();
		loginPage.LoginExpactingSuccess(email, password).WaitForLoad();
	}
}
