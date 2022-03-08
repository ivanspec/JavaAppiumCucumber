package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.LoginPage;

public class LoginStep {

    LoginPage Login = new LoginPage();

    @Given("User open the app")
    public void useropenTheApp() throws InterruptedException {
        Login.loginMenu();
    }


    @When("User fill username and password existing")
    public void userFillUsernameAndPasswordExisting() {
        Login.setUsernameAndPassword();
        Login.btnLogin();
    }

    @Then("User successful login")
    public void userSuccessfulLogin() throws InterruptedException {
        Login.AssertAlert();
        Login.closeAlert();

    }


}
