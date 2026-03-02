package Pages;

import Utils.Actions;
import Utils.Helper;
import org.openqa.selenium.By;

public class IndividualCustomerPage extends Actions {
    Helper helper = new Helper();
    By fullName = By.xpath("//*[@name='fieldName:NAME.1:1']");
    By shortName = By.xpath("//*[@name='fieldName:SHORT.NAME:1']");
    By familyName = By.xpath("//*[@name='fieldName:FAMILY.NAME']");
    By mneMonic = By.xpath("//*[@name='fieldName:MNEMONIC']");
    By genderFemale = By.xpath("//*[@value='FEMALE']");//radio
    By genderMale = By.xpath("//*[@value='MALE']");//radio
    By Title = By.xpath("//*[@name='fieldName:TITLE']");//dropdown-noscroll
    By Nationality = By.xpath("//*[@name='fieldName:NATIONALITY']");
    By Industry = By.xpath("//img[@dropfield='fieldName:INDUSTRY']");//dropdown
    By industryTable = By.xpath("//table[@id='dropDownTable:fieldName:INDUSTRY']");
    By Sector = By.xpath("//img[@dropfield='fieldName:SECTOR']");//dropdown
    By sectorTable = By.xpath("//table[@id='dropDownTable:fieldName:SECTOR']");

    By addressTab = By.xpath("//table[@id='headtab']//a[contains(@href,'tab2')]");
    By Street = By.xpath("//table[@id='tab2']//input[@name='fieldName:STREET:1']");

    By commitButton = By.xpath("//*[@title='Commit the deal']");
    By completeMsg = By.xpath("//table[@id='messages']//td[@class='message']");

    String customerID;
// extract customer id ,search and find in unauthorized customer
    //utiliy class frame and window handel method 1 (switch frame), method 2(switch window)


    public String SwitchtoNewWindow() {
        return helper.SwitchToNextWindow();
    }

    public void SetCustomerdata(String fullname, String shortname, String familyname, String title
            , String gender, String nationality, String sector, String mnemonic, String industry) {
        setCustomerStringData(fullName, fullname);
        setCustomerStringData(shortName, shortname);
        setCustomerStringData(familyName, familyname);
        setCustomerStringData(mneMonic, mnemonic);
        setCustomerStringData(Nationality, nationality);//need to be improved

        if (gender.equals("Female"))
            ClickButton(genderFemale);
        else
            ClickButton(genderMale);


        setCustomerindustry(Industry, industry, industryTable);
        setCustomerSector(Sector, sector, sectorTable);
        setCustomerTitle(Title, title);


    }

    public void SetAddress(String Address) throws InterruptedException {
        selectAddresstab(addressTab);
        setCustomerStringData(Street, Address);

    }

    public void ClickCommit() {
        ClickButton(commitButton);
    }

    public Boolean CompleteMgs(String msg) {
        // return isMsgAppear(completeMsg);
        customerID = GetCustomerID(completeMsg);
        System.out.println(customerID);
        return isMsgContainsWord(completeMsg, msg);
    }

    public String ReturnCustomerId() {
        return customerID;
    }
}
