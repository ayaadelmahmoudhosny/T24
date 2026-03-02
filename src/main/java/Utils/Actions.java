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
    WebDriverWait wait = new WebDriverWait(DriverManager.driver, Duration.ofSeconds(20));

    public void TypeUsername(By username, String name) {

        DriverManager.driver.findElement(username).sendKeys(name);
    }

    public void TypePassword(By password, String pass) {

        DriverManager.driver.findElement(password).sendKeys(pass);
    }

    public void ClickButton(By Element) {
        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(Element)
        );
        input.click();
    }


    public Boolean isMsgAppear(By msg) {

        //return DriverManager.driver.findElement(errormsg).isDisplayed();
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(msg));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }

    public Boolean isMsgContainsWord(By msg, String word) {

        //return DriverManager.driver.findElement(errormsg).isDisplayed();
        try {
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(msg));

            return element.getText().contains(word);
        } catch (TimeoutException e) {
            return false;
        }
    }

    public String GetCustomerID(By msg) {
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(msg));
        String message = element.getText();
        String customerId = message.replaceAll(".*\\s(\\d+)\\s+\\d{2}:\\d{2}:\\d{2}.*", "$1");
        return customerId;
    }

    public boolean isHomePageDisplay(By homepage) {
        // System.out.println(DriverManager.driver.getPageSource());
        // System.out.println("After Login URL: " + DriverManager.driver.getCurrentUrl());
        //DriverManager.driver.switchTo().frame(1);


        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(homepage));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }


    public void selectAddresstab(By physicalAddress) throws InterruptedException {
        DriverManager.driver.findElement(physicalAddress).click();
    }

    public void setCustomerStringData(By customerData, String data) {
        WebElement input = wait.until(
                ExpectedConditions.elementToBeClickable(customerData)
        );
        input.sendKeys(data);
        // DriverManager.driver.findElement(customername).sendKeys(name);
    }


    public void setCustomerSector(By customersector, String sector, By sectorTable) {
        DriverManager.driver.findElement(customersector).click();

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

    public void setCustomerindustry(By customerindustry, String industry, By industryTable) {
        DriverManager.driver.findElement(customerindustry).click();


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

    public void setCustomerTitle(By customertitle, String title) {
        DriverManager.driver.findElement(customertitle).click();

        By row = By.xpath("//*[@value='" + title.toUpperCase() + "']");
        DriverManager.driver.findElement(row).click();

    }


}
