package klaar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkSpaceSettingsPage extends Page {

    @FindBy(css = "[data-cy=\"page-heading\"]")
    public WebElement header;

    @FindBy(css = "[data-cy=\"settings-workspace-logo-heading\"]")
    public WebElement workSpaceLogoHeading;

    @FindBy(css = "[data-cy=\"settings-choose-workspace-logo-button\"]")
    public WebElement chooseFileButton;

    @FindBy(css = ".ant-upload-btn>input")
    public WebElement imageInput;

    @FindBy(css = "[data-cy=\"settings-workspace-logo-save-upload-button\"]")
    public WebElement saveLogoButton;

    @FindBy(css = "[data-cy=\"settings-workspace-uploaded-logo-card\"]")
    public WebElement uploadedLogoCard;

    @FindBy(css = "[data-cy=\"settings-workspace-logo-delete-button\"]")
    public WebElement deleteLogoButton;

    @FindBy(css = "[data-cy=\"settings-workspace-logo-confirm-delete-button\"]")
    public WebElement confirmDeleteLogoButton;

    public WorkSpaceSettingsPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
