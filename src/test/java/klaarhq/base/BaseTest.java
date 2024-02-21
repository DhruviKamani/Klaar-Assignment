package klaarhq.base;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.github.javafaker.Faker;

public abstract class BaseTest {
	protected static WebDriver driver;
	protected static Properties properties;
	protected static Faker faker;

	@BeforeAll
	public static void Initalize() throws IOException {
		properties = new Properties();
		properties.load(BaseTest.class.getResourceAsStream("/application.properties"));

		faker = new Faker();

		driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get(properties.getProperty("baseUrl"));
	}

	@AfterAll
	public static void CleanUp() {
		driver.quit();
	}
}
