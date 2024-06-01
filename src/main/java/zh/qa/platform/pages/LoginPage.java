package zh.qa.platform.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import io.qameta.allure.Step;
import zh.qa.platform.listeners.AllureListener;
import zh.qa.platform.utils.EleUtils;
@Listeners(AllureListener.class)
public class LoginPage {
	private WebDriver driver;
	private EleUtils ele;
	private By userName=By.id("username");
	private By passWord=By.id("password");


	public LoginPage(WebDriver driver) {
		this.driver=driver;
		ele=new EleUtils(driver);
	}
	@Step
	public void launchApplication(String url){
		ele.launchURL(url);
	}
	@Step("I am getting the current driver url")
	public String loginPageURL()  {
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ele.sendTextWithWait(userName, "Sugumarraja@blueehr.com", 10000);
		ele.sendTextWithWait(passWord, "Sugumarraja@blueehr.com", 10000);
		return ele.getURL();
	}
	

}
