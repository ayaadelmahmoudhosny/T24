package StepDefinitions;

import Pages.LoginPage;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class LoginStepDefinition {

    LoginPage login = new LoginPage();

    @Given("^User login with username (.+) and password (.+)$")
    public void userLoginWithUsernameNameAndPasswordPassword(String username, String password) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions

        login.SetName(username);
        login.SetPassword(password);
    }

    @When("User taps on Sign Button")
    public void userTapsOnSignButton() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        login.ClickSignButton();
    }


    @Then("^User goes to (.+)$")
    public void userGoesToOptions(String options) throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions


        if (options.equalsIgnoreCase("invalid"))
            Assert.assertTrue(login.ErrorMsgDisplay());
        else
            Assert.assertTrue(login.HomePageDisplay());


    }
}
