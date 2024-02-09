package klaar.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddSingleUserModel extends Model {

    @FindBy(css = "[data-cy=\"settings-add-user-full-name-text-field\"]")
    public WebElement fullNameInput;

    @FindBy(css = "[data-cy=\"settings-add-user-email-text-field\"]")
    public WebElement emailInput;

    @FindBy(css = "[data-cy=\"settings-add-user-select-department-dropdown-area\"] input")
    public WebElement departmentInput;

    @FindBy(css = "[data-cy=\"settings-add-user-select-title-dropdown-area\"] input")
    public WebElement titleInput;

    @FindBy(css = "[data-cy=\"settings-add-user-select-manager-dropdown-area\"] input")
    public WebElement managerInput;

    @FindBy(css = "[data-cy=\"settings-add-user-id-text-field\"]")
    public WebElement userIdInput;

    @FindBy(css = "[data-cy=\"settings-add-user-location-text-field\"]")
    public WebElement locationInput;

    @FindBy(css = "[data-cy=\"settings-add-user-select-hrbp-dropdown-area\"] input")
    public WebElement hrbpInput;

    public AddSingleUserModel(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
