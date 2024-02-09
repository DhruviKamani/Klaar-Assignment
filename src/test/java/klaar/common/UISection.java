package klaar.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UISection {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public UISection(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }
}
