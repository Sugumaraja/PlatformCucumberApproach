package zh.qa.platform.driverfactory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverOptionManager {
	private ChromeOptions co;
	private EdgeOptions eo;
	private FirefoxOptions fo;
	private Properties prop;
	public DriverOptionManager (Properties prop) {
		this.prop=prop;
	}
	public ChromeOptions chromeOption(){
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			co.addArguments("--incognito");
		}
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			co.addArguments("--headless");
		}
		return co;
	}
	public FirefoxOptions firefoxOption(){
		fo=new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			fo.addArguments("-private");
		}
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			fo.addArguments("--headless");
		}
		return fo;
	}
	public EdgeOptions edgeOption(){
		eo=new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("incognito"))) {
			eo.addArguments("--inPrivate");
		}
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
			eo.addArguments("--headless");
		}
		return eo;
	}
}
