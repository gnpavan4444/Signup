package pageclasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class PersonalDetails {
    WebDriver driver;
    public PersonalDetails(WebDriver driver){
        this.driver=driver;
    }
    //Page objects of Personal details screen. Page object design pattern is followed here.
    // Also this class contains few reusable methods for locating web elements
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
    @FindBy(xpath="//SPAN[@class='ng-scope'][text()='Direct debit']")
    public WebElement directDebitPaymentMethod;
    @FindBy(name= "country")
    public WebElement directDebitCountry;

    @FindBy(name="ddIban")
    public WebElement directDebitIBAN;
    @FindBy(name = "ddBIC")
    public WebElement directDebitBIC;
    @FindBy(id="paypal")
    public WebElement paypalPaymentMethod;
    @FindBy(xpath="//SPAN[@class='ng-scope'][text()='Credit card']")
    public WebElement creditCardPaymentMethod;
    @FindBy(xpath = "//button[@class='button primary fixed-width fixed-height']")
    public WebElement enterCreditCardDetailsButton;
    @FindBy(xpath = "//button[@class='button primary fixed-width fixed-height']")
    public WebElement signupButton;
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
    @FindBy(xpath = "//INPUT[@name='email']/../..//DIV[@class='textfield-error showError ng-binding ng-scope']")
    public WebElement emailValidationErrorMessage;
    @FindBy(xpath = "//INPUT[@name='email']/../..//div[@class='textfield-error showError ng-scope']")
    public WebElement emailEmptyFieldErrorValidationMessage;

    @FindBy(xpath = "//INPUT[@name='password']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement passwordValidationErrorMessage;
    @FindBy(xpath = "//INPUT[@name='confirmPassword']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement confirmPasswordValidationErrorMessage;
    @FindBy(xpath = "//INPUT[@name='mobileNumber']/../..//DIV[@class='textfield-error showError ng-scope']")
    public WebElement mobileNumberValidationErrorMessage;
//INPUT[@name='vrn1']
@FindBy(xpath = "//INPUT[@name='vrn1']/../..//DIV[@class='textfield-error showError ng-scope']")
public WebElement licensePlateValidationErrorMessage;
@FindBy(xpath = "//DIV[contains(text(),'The VRN must contain between 3 and 10 characters.')]")
public WebElement licensePlateInvalidNumberErrorMessage;
@FindBy(name="cardnumber")
public WebElement creditCardNumberFieldFrance;
@FindBy(name="cardholder")
public WebElement creditCardHolderNameFrance;
@FindBy(name="expirymonth")
public WebElement creditCardExpiryMonthFrance;
@FindBy(name="expiryyear")
public WebElement creditCardExpiryYearFrance;
@FindBy(name="cvv")
public WebElement creditCardCVVFrance;
@FindBy(xpath = "//BUTTON[text()='Save']")
public WebElement parkingReminderPreferencesSave;
@FindBy(xpath = "//SPAN[@class='ng-scope'][contains(text(),'welcome you as ParkNow customer')]")
public WebElement welcomeTextParkMobile;
@FindBy(xpath = "//SPAN[@class='ng-scope'][text()='Go to your account']")
public WebElement goToYourAccountButton;
@FindBy(xpath = "(//SPAN[@class='ng-scope'][text()='Log Out'])[2]")
public WebElement logoutButton;
public void selectMobileNumberCountry(String countryCode){
    Select select = new Select(mobileNumberCountry);
    select.selectByVisibleText("countryCode");

}
//Reusable methods using Page Objects
public WebElement selectTypeOfParking(WebDriver driver,String parkingType){
    String xpath = "//SPAN[@class='ng-scope'][text()='typeOfParking']";
    String newXpath = xpath.replace("typeOfParking",parkingType);
    return driver.findElement(By.xpath(newXpath));
}
    public WebElement selectDirectDebitCountry(WebDriver driver,String country){
        String xpath = ".//div[text()=' country']";
        String newXpath= xpath.replace("country",country);
        return driver.findElement(By.xpath(newXpath));
    }



}
