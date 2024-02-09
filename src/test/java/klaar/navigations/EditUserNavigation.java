package klaar.navigations;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.common.UISection;

public class EditUserNavigation extends UISection {

    @FindBy(css = ".ant-tabs-tab-active")
    public WebElement selectNavItem;

    @FindBy(css = ".ant-tabs-nav-list>ant-tabs-tab:nth-child(1)")
    public WebElement companyLink;

    public EditUserNavigation(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
