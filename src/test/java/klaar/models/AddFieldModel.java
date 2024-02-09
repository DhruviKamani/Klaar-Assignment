package klaar.models;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddFieldModel extends Model {

    @FindBy(css = "[formcontrolname=\"fieldName\"]")
    public WebElement newFieldName;

    @FindBy(css = "[formcontrolname=\"fieldType\"]")
    public WebElement newFieldType;

    public AddFieldModel(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
        PageFactory.initElements(driver, this);
    }

    public void WaitForLoad() {
        wait.until(ExpectedConditions.visibilityOf(modelDialog));
    }
}
