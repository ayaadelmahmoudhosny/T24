package Utils;

import java.util.ArrayList;

public class Helper {

    public void SwitchToFrame(int frameindex)
    {
        DriverManager.driver.switchTo().frame(frameindex);
    }

    public String SwitchToNextWindow() {
        ArrayList<String> windows = new ArrayList<>(DriverManager.driver.getWindowHandles());
        DriverManager.driver.switchTo().window(windows.get(1));
        return DriverManager.driver.getTitle();
    }

    public String SwitchToMainWindow() throws InterruptedException {
        ArrayList<String> windows = new ArrayList<>(DriverManager.driver.getWindowHandles());
        DriverManager.driver.close();
        DriverManager.driver.switchTo().window(windows.get(0));
        DriverManager.driver.switchTo().frame(1);
        return DriverManager.driver.getTitle();
    }

}
