package klaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.navigations.UserListNavigation;

public class UserListSettingsAllUsersPage extends UserListNavigation {

    @FindBy(css = "[data-cy=\"page-heading-field\"]")
    public WebElement heading;

    @FindBy(css = "[data-cy=\"settings-user-list-add-user-button\"]")
    public WebElement addNewUserButton;

    @FindBy(css = "[data-cy=\"settings-user-list-add-single-user-button\"]")
    public WebElement addSingleUserMenuItem;

    @FindBy(css = "[data-cy=\"user-list-search-text-field\"]")
    public WebElement searchBox;

    @FindBy(css = "[data-cy=\"user-list-user-email-field\"]")
    public WebElement tableUserName;

    public UserListSettingsAllUsersPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void WaitForLoad() {
        wait.until(ExpectedConditions
                .numberOfElementsToBeMoreThan(By.cssSelector("[data-cy=\"user-list-user-details-row\"]"),
                        1));
    }
}
