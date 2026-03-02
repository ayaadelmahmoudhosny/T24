package Pages;

import Utils.Actions;
import Utils.DriverManager;
import Utils.Helper;
import org.openqa.selenium.By;

public class UnauthorisedCustomerPage extends Actions {
    Helper helper = new Helper();
    By unauthorisedCustomer = By.xpath("//a[contains(@href,'CUSTOMER.NAU.AMEND.MDI')]");
    By search = By.xpath("//a[contains(@href,'SELECT')]");
    By searchByID = By.xpath("//*[@name='value:1:1:1']");
    By findButton = By.xpath("//*[@id='defaultButton']");
    By foundMsg = By.xpath("//a[@class='textbtn' and normalize-space()='Find']");


    public void ClickUnauthorisedCustomer() throws InterruptedException {
        System.out.println(helper.SwitchToMainWindow());
        ClickButton(unauthorisedCustomer);

    }

    public void ClickSearch() {

        helper.SwitchToNextWindow();
        helper.SwitchToFrame(0);
        ClickButton(search);

    }

    public void EnterCustomerID(String Id) {
        setCustomerStringData(searchByID, Id);
    }

    public void ClickFind() throws InterruptedException {
        ClickButton(findButton);
    }

    public Boolean CustomerFound() {
        return isMsgAppear(foundMsg);
    }
}
