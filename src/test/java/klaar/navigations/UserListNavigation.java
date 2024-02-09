package klaar.navigations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.common.UISection;

public class UserListNavigation extends UISection {

    @FindBy(css = "[aria-selected=\"true\"]")
    public WebElement selectedTab;

    @FindBy(css = ".ant-tabs-nav-list>div:nth-child(0)")
    public WebElement allUsersTab;

    @FindBy(css = ".ant-tabs-nav-list>div:nth-child(2)")
    public WebElement customFieldsTab;

    public UserListNavigation(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
