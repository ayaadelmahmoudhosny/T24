
package StepDefinitions;

import Pages.HomePage;
import Pages.IndividualCustomerPage;
import Pages.UnauthorisedCustomerPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddCustomerStepDef {
    IndividualCustomerPage customer = new IndividualCustomerPage();
    UnauthorisedCustomerPage uncustomer =new UnauthorisedCustomerPage();

    HomePage home =new HomePage();

    @And("User clicks on customer menu")
    public void userClicksOnCustomerMenu() {

        home.ClickCustomerMenu();

    }

    @And("User clicks on customer menu officer")
    public void userClicksOnCustomerMenuOfficer() {
        home.ClickCustomerOfficerMenu();
    }

    @And("User clicks on customer")
    public void userClicksOnCustomer() {
        home.ClickCustomer();
    }

    @And("User clicks on individual customer")
    public void userClicksOnIndividualCustomer() {
        home.ClickIndividualCustomer();

    }

    @When("^User Enter (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) info$")
    public void userEnterInfo(
            String fullname,
            String shortname,
            String familyname,
            String title,
            String gender,
            String sector,
            String mnemonic,
            String industry,
            String nationality) {

        String windowName = customer.SwitchtoNewWindow();
        Assert.assertEquals(windowName, "CUSTOMER");
        customer.SetCustomerdata(fullname, shortname, familyname, title
                , gender, nationality, sector, mnemonic, industry);
    }

    @And("^User Taps on physical address to enter(.+) info$")
    public void userTapsOnPhysicalAddressToEnterStreetInfo(String Street) throws InterruptedException {

        customer.SetAddress(Street);
    }

    @And("User taps on commit")
    public void userTapsOnCommit() {
        customer.ClickCommit();
    }

    @Then("User moves to next page")
    public void userMovesToNextPage() throws InterruptedException {
        Assert.assertTrue(customer.CompleteMgs("Complete"));
        uncustomer.ClickUnauthorisedCustomer();
        uncustomer.ClickSearch();
        uncustomer.EnterCustomerID(customer.ReturnCustomerId());
        uncustomer.ClickFind();
        Assert.assertTrue(uncustomer.CustomerFound());
    }
}
