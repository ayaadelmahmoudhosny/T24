package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import Utils.DriverManager;

import java.io.File;
import java.io.IOException;

public class Hooks {

    private DriverManager driverManager;

    @Before
    public void driverInit() throws IOException {
        DriverManager.openApp(); //openApp
    }

    @After
    public void afterTest() {
        DriverManager.closeApp(); //closeApp
    }

    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {

        //screenshot
        File sourcePath = ((TakesScreenshot) DriverManager.driver).getScreenshotAs(OutputType.FILE);
        byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
        scenario.attach(fileContent, "image/png", "image");
    }
}