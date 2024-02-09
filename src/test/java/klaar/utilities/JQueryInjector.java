package klaar.utilities;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class JQueryInjector {
    public static void Inject(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        if (!(Boolean) js.executeScript("return (typeof jQuery != \"undefined\")")) {
            js.executeScript(
                    "var headID = document.getElementsByTagName('head')[0];" +
                            "var newScript = document.createElement('script');" +
                            "newScript.type = 'text/javascript';" +
                            "newScript.src = 'https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js';" +
                            "headID.appendChild(newScript);");
            WebDriverWait waitJQ = new WebDriverWait(driver, Duration.ofSeconds(30));
            Function<WebDriver, Boolean> jQueryAvailable = WebDriver -> ((Boolean) js
                    .executeScript("return (typeof jQuery != \"undefined\")"));
            waitJQ.until(jQueryAvailable);
        }
    }
}
