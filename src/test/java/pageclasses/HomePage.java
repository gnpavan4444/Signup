package pageclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
    }
    //Page object of Home screen. Page object design pattern is followed here.

@FindBy(linkText="Sign up")
public WebElement signUpButton;
}
