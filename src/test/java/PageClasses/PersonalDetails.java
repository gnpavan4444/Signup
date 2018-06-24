package PageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetails {
    WebDriver driver;
    public PersonalDetails(WebDriver driver){
        this.driver=driver;
    }
    @FindBy(xpath= "//SPAN[@class='ng-scope'][text()='Personal Details']")
    public WebElement personalDetailsTitle;
    @FindBy(xpath= "//SPAN[@class='ng-scope'][text()='Personal']")
    public WebElement personalButton;
    @FindBy(xpath = "//SPAN[@class='ng-scope'][text()='Company']")
    public WebElement companyButton;
    @FindBy(name="firstName")
    public WebElement firstName;
    @FindBy(name="lastName")
    public WebElement lastName;
    @FindBy(name="email")
    public WebElement email;
    @FindBy(name="password")
    public WebElement password;
    @FindBy(name="confirmPassword")
    public WebElement confirmPassword;
    @FindBy(className = "selectize-input focus")
    public WebElement mobileNumberCountry;
    @FindBy(id="mobileNumber")
    public WebElement mobileNumber;
    @FindBy(className="entry-vehicle-country")
    public WebElement licensePlateCountry;
    @FindBy(name = "vrn1")
    public WebElement licensePlateNumber;
    @FindBy(id="iban")
    public WebElement directDebitPaymentMethod;
    @FindBy(id="paypal")
    public WebElement paypalPaymentMethod;
    @FindBy(id="cc")
    public WebElement creditCardPaymentMethod;
    @FindBy(xpath = "//SPAN[@class='ng-scope'][text()='Enter card details']")
    public WebElement enterCreditCardDetailsButton;
    @FindBy(xpath = "//button[text()='Agree']")
    public WebElement creditCardAgreeButton;
    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement creditCardCancelButton;
    @FindBy(xpath="//LABEL[@for='personal']")
    public WebElement personalElement;
    @FindBy(xpath="//LABEL[@for='business']")
    public WebElement companyName;
    @FindBy(name = "companyRegistrationNumber")
    public WebElement businessRegistrationNumber;
    @FindBy(xpath = "//INPUT[@name='firstName']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement firstNameValidationErrorMessage;
    @FindBy(xpath = "//INPUT[@name='lastName']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement lastNameValidationErrorMessage;

    @FindBy(xpath = "//INPUT[@name='password']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement passwordValidationErrorMessage;
    @FindBy(xpath = "//INPUT[@name='confirmPassword']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement confirmPasswordValidationErrorMessage;
    @FindBy(xpath = "//INPUT[@name='mobileNumber']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement mobileNumberValidationErrorMessage;
//INPUT[@name='vrn1']
@FindBy(xpath = "//INPUT[@name='vrn1']/../..//DIV[@class='textfield-error showError ng-scope']")
public WebElement licensePlateValidationErrorMessage;

public void selectMobileNumberCountry(String countryCode){
    Select select = new Select(mobileNumberCountry);
    select.selectByVisibleText("countryCode");

}
public WebElement selectTypeOfParking(WebDriver driver,String parkingType){
    String xpath = "//SPAN[@class='ng-scope'][text()='typeOfParking']";
    String newXpath = xpath.replace("typeOfParking",parkingType);
    return driver.findElement(By.xpath(newXpath));
}



}
