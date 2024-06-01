package zh.qa.platform.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import zh.qa.platform.baseTest.BaseTest;
import zh.qa.platform.pages.LoginPage;

public class LoginpageStepDef {

    @Given("while i am in the login page")
    public void whileIAmInTheLoginPage() {
     System.out.println(">>launch the browser");
    }

    @And("enter the valid password {string}")
    public void enter_the_valid_password(String string) {
        System.out.println(">>enter valid password "+ string);
    }
    @And("click on the login button")
    public void click_on_the_login_button() {
        System.out.println(">>click on the button");
    }
    @Then("user should able to login the platform")
    public void user_should_able_to_login_the_platform() {
        System.out.println("validating the scenario");

    }


    @And("enter the valid email id {string}")
    public void enterTheValidEmailId(String email) {
        System.out.println(">>enter valid email "+ email);
    }
}
