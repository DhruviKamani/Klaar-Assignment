package klaar.tests;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import klaar.models.AddFieldModel;
import klaar.models.AddSingleUserModel;
import klaar.navigations.NavigationBar;
import klaar.navigations.SettingsNavigationBar;
import klaar.pages.EditUserCompanyPage;
import klaar.pages.EditUserPersonalPage;
import klaar.pages.LoginPage;
import klaar.pages.UserListSettingsAllUsersPage;
import klaar.pages.UserListSettingsCustomFieldsPage;
import klaar.pages.WorkSpaceSettingsPage;
import klaar.utilities.ImageComparer;

public class Tests extends TestNgBaseTest {

	private String logo1 = "src\\test\\resources\\Image1.png";
	private String logo2 = "src\\test\\resources\\Image2.png";

	private String newUserFullName;
	private String newUserEmail;
	private String newUserDepartment;
	private String newUserTitle;
	private String newUserEmployeeId;
	private String newUserLocation;
	private String userManager = "A (asas@gmail.com)";
	private String customFieldName;

	private LoginPage loginPage;
	private NavigationBar navigationBar;
	private WorkSpaceSettingsPage workSpaceSettingsPage;
	private SettingsNavigationBar settingsNavigationBar;
	private UserListSettingsAllUsersPage userListSettingsPage;
	private AddSingleUserModel addSingleUserModel;
	private EditUserPersonalPage editUserPersonalPage;
	private UserListSettingsCustomFieldsPage userListSettingsCustomFieldsPage;
	private AddFieldModel addFieldModel;
	private EditUserCompanyPage editUserCompanyPage;

	private WebDriverWait wait;

	public Tests() {
		Faker faker = new Faker();
		newUserFullName = faker.name().fullName();
		newUserEmail = faker.internet().emailAddress();
		newUserDepartment = faker.company().industry();
		newUserTitle = faker.company().profession();
		newUserEmployeeId = faker.number().digits(5);
		newUserLocation = faker.address().city();
		customFieldName = faker.number().digits(5);
	}

	@BeforeClass
	public void Setup() {
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		loginPage = new LoginPage(driver, wait);
		loginPage.logInWithKlaarButton.click();
	}

	@Test
	public void Test1() {
		loginPage.Login("deepa.nayak@gamma.klaar.team", "Klaar2021");
		navigationBar = new NavigationBar(driver, wait);
		navigationBar.settingsPageLike.click();

		workSpaceSettingsPage = new WorkSpaceSettingsPage(driver, wait);
		wait.until(ExpectedConditions.visibilityOf(workSpaceSettingsPage.workSpaceLogoHeading));
		Assert.assertEquals(workSpaceSettingsPage.header.getText(), "Workspace Details");
		Assert.assertEquals(workSpaceSettingsPage.workSpaceLogoHeading.getText(),
				"Workspace Logo");

		workSpaceSettingsPage.imageInput.sendKeys(new File(logo1).getAbsolutePath());
		workSpaceSettingsPage.ForceClick(workSpaceSettingsPage.saveLogoButton);

		wait.until(ExpectedConditions.visibilityOf(workSpaceSettingsPage.uploadedLogoCard));

		Assert.assertTrue(ImageComparer.CompareImage(driver, navigationBar.logo,
				logo1));

		workSpaceSettingsPage.imageInput.sendKeys(new File(logo2).getAbsolutePath());
		workSpaceSettingsPage.ForceClick(workSpaceSettingsPage.saveLogoButton);

		wait.until(ExpectedConditions.visibilityOf(workSpaceSettingsPage.uploadedLogoCard));

		Assert.assertTrue(ImageComparer.CompareImage(driver, navigationBar.logo,
				logo2));

		workSpaceSettingsPage.deleteLogoButton.click();
		workSpaceSettingsPage.confirmDeleteLogoButton.click();

		wait.until(ExpectedConditions.visibilityOf(workSpaceSettingsPage.chooseFileButton));
	}

	@Test(dependsOnMethods = { "Test1" })
	public void Test2() {
		settingsNavigationBar = new SettingsNavigationBar(driver, wait);
		settingsNavigationBar.userListPageLink.click();
		userListSettingsPage = new UserListSettingsAllUsersPage(driver, wait);
		wait.until(ExpectedConditions.visibilityOf(userListSettingsPage.addNewUserButton));
		Assert.assertEquals(userListSettingsPage.heading.getText(), "User List");
		Assert.assertEquals(userListSettingsPage.selectedTab.getText(), "All Users");
		userListSettingsPage.addNewUserButton.click();
		userListSettingsPage.addSingleUserMenuItem.click();
		addSingleUserModel = new AddSingleUserModel(driver, wait);
		addSingleUserModel.fullNameInput.sendKeys(newUserFullName);
		addSingleUserModel.emailInput.sendKeys(newUserEmail);
		addSingleUserModel.departmentInput.sendKeys(newUserDepartment + Keys.ENTER);
		addSingleUserModel.titleInput.sendKeys(newUserTitle + Keys.ENTER);
		addSingleUserModel.managerInput.sendKeys(userManager);
		wait.until(ExpectedConditions.visibilityOf(addSingleUserModel.activeSelectedOption))
				.click();
		addSingleUserModel.userIdInput.sendKeys(newUserEmployeeId);
		addSingleUserModel.locationInput.sendKeys(newUserLocation);
		addSingleUserModel.hrbpInput.sendKeys(userManager);
		wait.until(ExpectedConditions.visibilityOf(addSingleUserModel.activeSelectedOption))
				.click();

		addSingleUserModel.submitButton.click();

		editUserPersonalPage = new EditUserPersonalPage(driver, wait);
		wait.until(ExpectedConditions.visibilityOf(editUserPersonalPage.backButton));
		Assert.assertEquals(editUserPersonalPage.heading.getText(), "Edit User");

		editUserPersonalPage.backButton.click();

		userListSettingsPage.WaitForLoad();

		userListSettingsPage.searchBox.sendKeys(newUserFullName);

		userListSettingsPage.WaitForLoad();

		Assert.assertTrue(userListSettingsPage.tableUserName.getText().contains(newUserFullName));
	}

	@Test(dependsOnMethods = { "Test2" })
	public void Test3() {
		userListSettingsPage.customFieldsTab.click();
		userListSettingsCustomFieldsPage = new UserListSettingsCustomFieldsPage(driver, wait);
		userListSettingsCustomFieldsPage.WaitForLoad();
		userListSettingsCustomFieldsPage.addNewFieldButton.click();

		addFieldModel = new AddFieldModel(driver, wait);
		addFieldModel.WaitForLoad();
		addFieldModel.newFieldName.sendKeys(customFieldName);
		addFieldModel.newFieldType.sendKeys("Date");
		wait.until(ExpectedConditions.visibilityOf(addFieldModel.activeSelectedOption)).click();

		userListSettingsCustomFieldsPage.WaitForLoad();
		userListSettingsCustomFieldsPage.allUsersTab.click();

		userListSettingsPage.WaitForLoad();
		userListSettingsPage.searchBox.sendKeys(newUserFullName);
		userListSettingsPage.tableUserName.click();

		editUserPersonalPage.companyLink.click();

		editUserCompanyPage = new EditUserCompanyPage(driver, wait);
		editUserCompanyPage.WaitForLoad();
		// Time went above three hours
	}
}
