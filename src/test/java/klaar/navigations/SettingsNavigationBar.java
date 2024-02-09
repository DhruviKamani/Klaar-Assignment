package klaar.navigations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.common.UISection;

public class SettingsNavigationBar extends UISection {

    @FindBy(css = "[href*=\"User-List\"]")
    public WebElement userListPageLink;

    public SettingsNavigationBar(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

}
