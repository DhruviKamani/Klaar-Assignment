package klaarhq.pages;

import org.openqa.selenium.WebDriver;

import klaarhq.base.BasePage;

public class HomePage extends BasePage<HomePage> {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@Override
	public HomePage WaitForLoad() {
		// TODO Auto-generated method stub
		return this;
	}
}
