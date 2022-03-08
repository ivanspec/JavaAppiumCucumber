package stepdefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page.RegisterPage;

public class RegisterStep {
    RegisterPage Register = new RegisterPage();

    @Given("^User open the application$")
    public void UserOpenTheApplication() {
        Register.loginMenu();
        Register.clickRegister();
    }

    @When("^User fill username and password$")
    public void UserFillUsernameAndPassword() {
        Register.setUsernameAndPassword();
        Register.clickBtnSignUp();
    }

    @Then("^Sucessfull register$")
    public void sucessfullRegister() {
        Register.assertAlert();
        Register.closeBtnAlert();
    }

}
