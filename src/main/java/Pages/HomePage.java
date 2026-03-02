package Pages;

import Utils.Actions;
import Utils.Helper;
import org.openqa.selenium.By;

public class HomePage extends Actions {
    Helper helper=new Helper();
    By customerMenu = By.xpath("//img[@alt='Customer Menu']");
    By customerOfiicerMenu = By.xpath("//img[@alt='Customer Officer Menu']");
    By customer = By.xpath("//img[@alt='Customer']");
    By individualCustomer = By.xpath("//a[contains(@href,'CUSTOMER,INPUT.MDI I F3')]");

    public void ClickCustomerMenu() {
        helper.SwitchToFrame(1);
        isHomePageDisplay(customerMenu);
        ClickButton(customerMenu);
    }

    public void ClickCustomerOfficerMenu() {
        ClickButton(customerOfiicerMenu);
    }

    public void ClickCustomer() {
        ClickButton(customer);
    }

    public void ClickIndividualCustomer() {
        ClickButton(individualCustomer);

    }
}
