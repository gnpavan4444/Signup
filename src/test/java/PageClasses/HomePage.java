package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

WebDriver driver;
@FindBy(linkText="Sign up")
public WebElement signUpButton;
}
