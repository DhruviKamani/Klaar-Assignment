package klaar.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import klaar.common.UISection;

public abstract class Model extends UISection {

    @FindBy(css = "[data-cy=\"modal-submit-button\"]")
    public WebElement submitButton;

    @FindBy(css = "[data-cy=\"modal-heading\"]")
    public WebElement modelDialog;

    @FindBy(css = ".ant-select-item-option-active")
    public WebElement activeSelectedOption;

    public Model(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }
}
