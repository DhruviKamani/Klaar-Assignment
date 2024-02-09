package klaar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.navigations.EditUserNavigation;

public class EditUserCompanyPage extends EditUserNavigation {

    public EditUserCompanyPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void WaitForLoad() {
        wait.until(driver -> selectNavItem.getText() == "Company");
    }
}
