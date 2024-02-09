package klaar.navigations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.common.UISection;

public class NavigationBar extends UISection {

    @FindBy(css = "[data-cy=\"settings-nav-menu-button\"]")
    public WebElement settingsPageLike;

    @FindBy(css = "[data-cy=\"side-menu-logo\"]")
    public WebElement logo;

    public NavigationBar(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }
}
