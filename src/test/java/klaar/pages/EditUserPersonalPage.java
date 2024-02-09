package klaar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.navigations.EditUserNavigation;

public class EditUserPersonalPage extends EditUserNavigation {

    @FindBy(css = "[data-cy=\"page-heading-field\"]")
    public WebElement heading;

    @FindBy(className = "back-btn")
    public WebElement backButton;

    public EditUserPersonalPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
