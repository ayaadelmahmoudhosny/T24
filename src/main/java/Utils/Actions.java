package Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Actions {

    public void TypeUsername (By username, String name)
    {

        DriverManager.driver.findElement(username).sendKeys(name);
    }
    public void TypePassword (By password, String pass)
    {

        DriverManager.driver.findElement(password).sendKeys(pass);
    }

    public void ClickButton(By Element){
        DriverManager.driver.findElement(Element).click();

    }



    public Boolean isErrorMsgAppear(By errormsg){

        //return DriverManager.driver.findElement(errormsg).isDisplayed();
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(5));
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(errormsg));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public boolean isHomePageDisplay(By homepage) {
       // System.out.println(DriverManager.driver.getPageSource());
       // System.out.println("After Login URL: " + DriverManager.driver.getCurrentUrl());
        DriverManager.driver.switchTo().frame(1);
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10)
        );

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homepage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String getPageTitle(){
        ArrayList<String> windows =new ArrayList<>(DriverManager.driver.getWindowHandles());
        DriverManager.driver.switchTo().window(windows.get(1));
        return DriverManager.driver.getTitle();
    }

    public void selectAddresstab(By physicalAddress) throws InterruptedException {
        DriverManager.driver.findElement(physicalAddress).click();
       // System.out.println(DriverManager.driver.getPageSource());
        //Thread.sleep(3000);

    }

    public void setCustomerName(By customername,String name)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));

        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(customername)
        );
        input.sendKeys(name);
       // DriverManager.driver.findElement(customername).sendKeys(name);
    }

    public void setFemale(By female)
    {
        DriverManager.driver.findElement(female).click();
    }
    public void setMale(By male)
    {
        DriverManager.driver.findElement(male).click();
    }

    public void setCustomerSector(By customersector,String sector)
    {
        DriverManager.driver.findElement(customersector).click();
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));


        By sectorTable = By.xpath("//table[@id='dropDownTable:fieldName:SECTOR']");
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(sectorTable));

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.driver;

        By row = By.xpath("//table[@id='dropDownTable:fieldName:SECTOR']//tr[contains(.,'"
                + sector + "')]");

        int maxScroll = 10;

        for (int i = 0; i < maxScroll; i++) {

            if (!DriverManager.driver.findElements(row).isEmpty()) {

                WebElement Sector = DriverManager.driver.findElement(row);

                js.executeScript("arguments[0].scrollIntoView({block:'center'});", Sector);
                Sector.click();
                return;
            }

            js.executeScript("arguments[0].scrollTop += 100;", table);
        }

        throw new RuntimeException("Sector not found in dropdown menu: " + sector);

    }
    public void setCustomerindustry(By customerindustry,String industry)
    {
        DriverManager.driver.findElement(customerindustry).click();
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(20));


        By industryTable = By.xpath("//table[@id='dropDownTable:fieldName:INDUSTRY']");
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(industryTable));

        JavascriptExecutor js = (JavascriptExecutor) DriverManager.driver;

        By row = By.xpath("//table[@id='dropDownTable:fieldName:INDUSTRY']//tr[contains(.,'"
                + industry + "')]");

        int maxScroll = 10;

        for (int i = 0; i < maxScroll; i++) {

            if (!DriverManager.driver.findElements(row).isEmpty()) {

                WebElement Industry = DriverManager.driver.findElement(row);

                js.executeScript("arguments[0].scrollIntoView({block:'center'});", Industry);
                Industry.click();
                return;
            }

            js.executeScript("arguments[0].scrollTop += 100;", table);
        }

        throw new RuntimeException("Industry not found in dropdown menu: " + industry);


    }
    public void setCustomerTitle(By customertitle,String title)
    {
        DriverManager.driver.findElement(customertitle).click();

        By row =By.xpath("//*[@value='"+title.toUpperCase()+"']");
        DriverManager.driver.findElement(row).click();

    }

    public Boolean isCompleteMsgDisplay(By completeMsg)
    {
        WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(10));
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(completeMsg));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

}
