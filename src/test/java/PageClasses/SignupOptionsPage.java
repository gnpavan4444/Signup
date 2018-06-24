package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class SignupOptionsPage {
    WebDriver driver;
    @FindBy(xpath = "//P[contains(text(),'We use cookies')]")
    public WebElement cookiesText;
    @FindBy(className = "optanon-button-allow")
    public WebElement cookiesAllowButton;
    @FindBy(name= "country")
    public WebElement countryButton;
    @FindBy(xpath = ".//div[text()=' country']")
    public WebElement selectCountry;
    @FindBy(xpath= ".//div[text()=' Austria']")
    public WebElement selectCountryAustria;
    @FindBy(xpath = ".//div[text()=' Germany']")
    public WebElement selectCountryGermany;
    @FindBy(xpath = ".//div[text()=' Switzerland']")
    public WebElement selectCountrySwitzerland;
    @FindBy(xpath= "//BUTTON[@class='button ng-scope secondary']")
    public WebElement chooseButton;
    public WebElement selectCountryFromList(WebDriver driver,String country){
        String xpath = ".//div[text()=' country']";
        String newXpath= xpath.replace("country",country);
       return driver.findElement(By.xpath(newXpath));
    }

    public WebElement selectChooseButton(WebDriver driver,String category){
        String xpath = "//H1[@class='package-title ng-binding'][text()='category']/../../../..//BUTTON[@class='button ng-scope secondary']";
        String newXpath = xpath.replace("category",category);
        return driver.findElement(By.xpath(newXpath));
    }


}
