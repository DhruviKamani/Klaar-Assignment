package klaar.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.navigations.UserListNavigation;

public class UserListSettingsCustomFieldsPage extends UserListNavigation {

    @FindBy(css = "[nztype=\"primary\"]")
    public WebElement addNewFieldButton;

    public UserListSettingsCustomFieldsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void WaitForLoad() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.className(".ng-star-inserted"), 0));
    }
}
