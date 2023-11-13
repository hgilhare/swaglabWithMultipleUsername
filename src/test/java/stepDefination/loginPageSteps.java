package stepDefination;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.loginPage;

public class loginPageSteps {

	loginPage p = new loginPage();

	@Given("user enter {string}")
	public void user_enter(String string) {
		p.user_enter(string);

	}

	@Then("user enter password")
	public void user_enter_password() {
		p.user_enter_password();

	}

	@Then("user clicked on login button")
	public void user_clicked_on_login_button() {
		p.user_clicked_on_login_button();

	}

	@Then("user verified sucessful login home")
	public void user_verified_sucessful_login_home() {
		p.user_verified_sucessful_login_home();
	}

}
