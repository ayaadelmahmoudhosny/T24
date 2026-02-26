package Pages;

import Utils.Actions;
import org.openqa.selenium.By;

public class LoginPage extends Actions {

    By username =By.xpath("//*[@name='signOnName']");
    By password =By.xpath("//*[@name='password']");
    By signinButton =By.xpath("//*[@value='Sign in']");
    By errorMsg =By.xpath("//*[@class='message']");
    By homePage =By.xpath("//img[@alt='Customer Menu']");


    public void SetName(String userName){
        //userName=username;
        TypeUsername(username,userName);

    }

    public void SetPassword(String userPassword){
        //userPassword=password;
        TypePassword(password,userPassword);
    }

    public void ClickSignButton()throws InterruptedException{
        ClickButton(signinButton);
    }

    public Boolean ErrorMsgDisplay(){
       return isErrorMsgAppear(errorMsg);
    }

    public Boolean HomePageDisplay() throws InterruptedException {
    return isHomePageDisplay(homePage);
    }




}
