package klaar.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.common.UISection;

public abstract class Page extends UISection {
    public Page(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void ForceClick(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }
}
