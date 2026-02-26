package Pages;

import Utils.Actions;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;

public class AddCustomer extends Actions {
    By customerMenu =By.xpath("//img[@alt='Customer Menu']");
    By customerOfiicerMenu =By.xpath("//img[@alt='Customer Officer Menu']");
    By customer =By.xpath("//img[@alt='Customer']");
    By individualCustomer =By.xpath("//a[contains(@href,'CUSTOMER,INPUT.MDI I F3')]");

    By fullName =By.xpath("//*[@name='fieldName:NAME.1:1']");
    By shortName =By.xpath("//*[@name='fieldName:SHORT.NAME:1']");
    By familyName =By.xpath("//*[@name='fieldName:FAMILY.NAME']");
    By mneMonic =By.xpath("//*[@name='fieldName:MNEMONIC']");
    By genderFemale =By.xpath("//*[@value='FEMALE']");//radio
    By genderMale =By.xpath("//*[@value='MALE']");//radio
    By Title =By.xpath("//*[@name='fieldName:TITLE']");//dropdown-noscroll
    By Nationality =By.xpath("//*[@name='fieldName:NATIONALITY']");
    By Industry =By.xpath("//img[@dropfield='fieldName:INDUSTRY']");//dropdown
    By Sector =By.xpath("//img[@dropfield='fieldName:SECTOR']");//dropdown

    By addressTab=By.xpath("//table[@id='headtab']//a[contains(@href,'tab2')]");
    By Street=By.xpath("//table[@id='tab2']//input[@name='fieldName:STREET:1']");

    By commitButton =By.xpath("//*[@title='Commit the deal']");
    By completeMsg=By.xpath("//table[@id='messages']//td[@class='message']");

    public void ClickCustomerMenu(){
        isHomePageDisplay(customerMenu);
        ClickButton(customerMenu);
    }
    public void ClickCustomerOfficerMenu(){
        ClickButton(customerOfiicerMenu);
    }
    public void ClickCustomer(){
        ClickButton(customer);
    }
    public void ClickIndividualCustomer() {
        ClickButton(individualCustomer);

    }
    public String SwitchtoNewWindow(){
        return getPageTitle();
    }

    public void SetCustomerdata(String fullname,String shortname,String familyname,String title
            ,String gender,String nationality, String sector,String mnemonic,String industry) {
       setCustomerName(fullName,fullname);
       setCustomerName(shortName,shortname);
       setCustomerName(familyName,familyname);
       setCustomerName(mneMonic,mnemonic);
       setCustomerName(Nationality,nationality);//need to be improved

        if(gender.equals("Female"))
            setFemale(genderFemale);
        else
            setMale(genderMale);


       setCustomerSector(Sector,sector);
       setCustomerindustry(Industry,industry);
       setCustomerTitle(Title,title);



    }

    public void SetAddress (String Address) throws InterruptedException {
       selectAddresstab(addressTab);
       setCustomerName(Street,Address);

    }

    public void ClickCommit(){
        ClickButton(commitButton);
    }

    public Boolean CompleteMgs()
    {
        return isCompleteMsgDisplay(completeMsg);
    }
}
