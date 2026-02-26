
package StepDefinitions;

import Pages.AddCustomer;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class AddCustomerStepDef {
    AddCustomer customer=new AddCustomer();

    @And("User clicks on customer menu")
    public void userClicksOnCustomerMenu() {
        // Write code here that turns the phrase above into concrete actions

        customer.ClickCustomerMenu();

    }

    @And("User clicks on customer menu officer")
    public void userClicksOnCustomerMenuOfficer() {
        // Write code here that turns the phrase above into concrete actions
        customer.ClickCustomerOfficerMenu();
    }

    @And("User clicks on customer")
    public void userClicksOnCustomer() {
        // Write code here that turns the phrase above into concrete actions
        customer.ClickCustomer();
    }

    @And("User clicks on individual customer")
    public void userClicksOnIndividualCustomer() {
        // Write code here that turns the phrase above into concrete actions
        customer.ClickIndividualCustomer();

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
            String nationality)  {    // Write code here that turns the phrase above into concrete actions
        String windowName=customer.SwitchtoNewWindow();
        System.out.println("window name "+windowName);
        System.out.println("full name "+fullname);
        System.out.println("short name "+shortname);
        System.out.println("family name "+familyname);
        System.out.println("mnemonic "+mnemonic);
        System.out.println("nationality "+nationality);
        System.out.println("gender  "+gender);
        System.out.println("sector  "+sector);
        System.out.println("industry  "+industry);
        System.out.println("title  "+title.toUpperCase());
       Assert.assertEquals(windowName ,"CUSTOMER");

       customer.SetCustomerdata(fullname,shortname,familyname,title
               ,gender,nationality,sector,mnemonic,industry);


    }

    @And("^User Taps on physical address to enter(.+) info$")
    public void userTapsOnPhysicalAddressToEnterStreetInfo(String Street)throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
    customer.SetAddress(Street);
    //Thread.sleep(3000);
    }

    @And("User taps on commit")
    public void userTapsOnCommit() {
        // Write code here that turns the phrase above into concrete actions
        customer.ClickCommit();
    }

    @Then("User moves to next page")
    public void userMovesToNextPage() {
        // Write code here that turns the phrase above into concrete actions
      Assert.assertTrue(customer.CompleteMgs());
    }
}
