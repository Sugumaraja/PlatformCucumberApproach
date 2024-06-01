package zh.qa.platform.driverfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import zh.qa.platform.frameworkexception.FrameworkException;

public class DriverFactory {
	private WebDriver driver;
	private Properties prop;
	private DriverOptionManager dom;
	public static ThreadLocal<WebDriver> localDriver=new ThreadLocal<WebDriver>();
	public static String highlight=null;
	
public WebDriver initbrowser(Properties prop) {
	dom=new DriverOptionManager(prop);
	String browser=prop.getProperty("browser");
	System.out.println("The browser passed is :"+ browser);
	highlight=prop.getProperty("highlight");
	switch (browser.toLowerCase().trim()) {
	case "chrome":
		localDriver.set(new ChromeDriver(dom.chromeOption()));
//		driver=new ChromeDriver(dom.chromeOption());
		break;
	case "firefox":
		localDriver.set(new FirefoxDriver(dom.firefoxOption()));
//		driver=new FirefoxDriver(dom.firefoxOption());
		break;
	case "edge":
		localDriver.set(new EdgeDriver(dom.edgeOption()));
//		driver=new EdgeDriver(dom.edgeOption());
		break;
	default:
		System.out.println("please pass the right browser"+browser);
		break;
	}
	getDriver().manage().deleteAllCookies();
	getDriver().manage().window().maximize();
//	getDriver().get(prop.getProperty("url"));
	return getDriver();
}

public static WebDriver getDriver() {
	return localDriver.get();
}

public Properties initProp() {
	prop=new Properties();
	FileInputStream fp=null;
	String envName=System.getProperty("env");
	try {
	if(envName==null) {
		System.out.println("you have passed the envName:null... hence running in the qa env");
		fp=new FileInputStream("./src/test/resources/Config/Qa_configuration.properties");
	}
	else {
		switch (envName.toLowerCase().trim()) {
		case "qa":
			System.out.println("you have passed the envName:"+envName+"....hence running in the qa env");
			fp=new FileInputStream("./src/test/resources/Config/Qa_configuration.properties");
			break;
		case "dev":
			System.out.println("you have passed the envName:"+envName+"....hence running in the dev env");
			fp=new FileInputStream("./src/test/resources/Config/Dev_configuration.properties");
			break;
		case "staging":
			System.out.println("you have passed the envName:"+envName+"....hence running in the staging env");
			fp=new FileInputStream("./src/test/resources/Config/Staging_configuration.properties");
			break;
		default:
			System.out.println("you have passed the envName:"+envName+"...Please pass the right environment	");
			throw new FrameworkException("Please pass the right environment env passed is :"+ envName);
//			break;
		}}}
	catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	try {
		prop.load(fp);
	} catch (IOException e) {
		e.printStackTrace();
	}	
//	try {
//		FileInputStream fp = new FileInputStream("./src/test/resources/Config/Qa_configuration.properties");
//		try {
//			prop.load(fp);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	} catch (FileNotFoundException e) {
//		e.printStackTrace();
//	}
	return prop;
}

public static String getScreenshot(String methodName) {
	File source= ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
	String path=System.getProperty("user.dir")+"/screenshot/"+methodName+"_"+System.currentTimeMillis()+".png";
	File Destination=new File(path);
	
	try {
		FileHandler.copy(source, Destination);
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	return path;
}

}
