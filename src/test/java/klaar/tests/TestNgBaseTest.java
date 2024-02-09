package klaar.tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class TestNgBaseTest {

    protected static String baseUrl;
    protected static WebDriver driver;

    @BeforeSuite
    public void initTestSuite() {
        baseUrl = "https://dev.klaarhq.com/";
        driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        driver.quit();
    }
}
