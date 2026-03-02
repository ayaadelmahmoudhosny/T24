package Pages;

import Utils.Actions;
import Utils.Helper;
import org.openqa.selenium.By;

public class LoginPage extends Actions {
    Helper helper=new Helper();
    By username = By.xpath("//*[@name='signOnName']");
    By password = By.xpath("//*[@name='password']");
    By signinButton = By.xpath("//*[@value='Sign in']");
    By errorMsg = By.xpath("//*[@class='message']");
    By homePage = By.xpath("//img[@alt='Customer Menu']");


    public void SetName(String userName) {
        //userName=username;
        TypeUsername(username, userName);
    }

    public void SetPassword(String userPassword) {
        //userPassword=password;
        TypePassword(password, userPassword);
    }

    public void ClickSignButton() throws InterruptedException {
        ClickButton(signinButton);
    }

    public Boolean ErrorMsgDisplay() {
        return isMsgAppear(errorMsg);
    }

    public Boolean HomePageDisplay() throws InterruptedException {
        helper.SwitchToFrame(1);
        return isHomePageDisplay(homePage);
    }

}
