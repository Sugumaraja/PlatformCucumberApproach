package zh.qa.platform.baseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import zh.qa.platform.driverfactory.DriverFactory;
import zh.qa.platform.pages.LoginPage;

public class BaseTest {
	protected WebDriver driver;
	protected DriverFactory df;
	protected LoginPage logpage;
	protected Properties prop;
//	private String browserName=null;

//	@Parameters({ "browser" })
//	@BeforeTest
	@Before
	public void setup() {
		df = new DriverFactory();
		prop = df.initProp();
//		if (browserName != null) {
//			prop.setProperty("browser", browserName);
//		}
		driver = df.initbrowser(prop);
		logpage = new LoginPage(driver);
	}

//	@AfterTest
	@After
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}
