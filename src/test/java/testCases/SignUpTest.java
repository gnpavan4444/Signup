package testCases;

import PageClasses.HomePage;
import PageClasses.PersonalDetails;
import PageClasses.SignupOptionsPage;
import Setup.NewSetUp;
import Setup.TestCaseExecutor;
import Setup.TestCaseScenario;
import Utilities.ClientUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SignUpTest extends NewSetUp {
    public static int index=1;
    String currentMethodName=null;
    TestCaseExecutor testCaseExecutor;
    TestCaseScenario testCaseScenario;
    HashMap<Object,Object>hashMap;
    HomePage homePage = PageFactory.initElements(driver,HomePage.class);
    PersonalDetails personalDetails = PageFactory.initElements(driver,PersonalDetails.class);
    SignupOptionsPage signupOptionsPage = PageFactory.initElements(driver,SignupOptionsPage.class);
    ClientUtils clientUtils = new ClientUtils(driver);
    @Test
    public void silverCategoryGermanSignUp() throws Exception {
        testCaseExecutor = new TestCaseExecutor();
        currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        //System.out.println("Current method is"+currentMethodName);
       hashMap= testCaseExecutor.createHashMapForSpecificRow(currentMethodName);
       System.out.println("Hashmap is"+hashMap);
       //System.out.println("Data from excel sheet for first column is"+hashMap.get("Introduced Date"));
        signUp(hashMap,currentMethodName);



    }







    public void signUp(HashMap<Object, Object> hashMap,String currentMethodName) throws Exception {
        HomePage homePage = PageFactory.initElements(driver,HomePage.class);
        PersonalDetails personalDetails = PageFactory.initElements(driver,PersonalDetails.class);
        SignupOptionsPage signupOptionsPage = PageFactory.initElements(driver,SignupOptionsPage.class);
        ClientUtils clientUtils = new ClientUtils(driver);

        clientUtils.click(driver,homePage.signUpButton);
        clientUtils.checkElementVisibility(driver,signupOptionsPage.cookiesText);
        clientUtils.click(driver,signupOptionsPage.cookiesAllowButton);
       // String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();


        clientUtils.click(driver,signupOptionsPage.countryButton);
        NewSetUp.getScreenshot(driver,index+"SignUpPage",currentMethodName);
        ++index;
       // WebElement countryWebElement = clientUtils.dynamicXpathElements(driver,signupOptionsPage.selectCountry,"France");
        WebElement countryWebElement = signupOptionsPage.selectCountryFromList(driver,hashMap.get("Country").toString());
        clientUtils.click(driver,countryWebElement);
        WebElement chooseButtonWebElement = signupOptionsPage.selectChooseButton(driver,hashMap.get("Package").toString());
        clientUtils.click(driver,chooseButtonWebElement);
        clientUtils.waitForElement(driver,personalDetails.personalDetailsTitle);
        Assert.assertEquals(personalDetails.personalDetailsTitle.getText().toString(),"PERSONAL DETAILS");
        NewSetUp.getScreenshot(driver,index+"PersonalDetails",currentMethodName);
        ++index;
      WebElement typeOfParkingWebElement = personalDetails.selectTypeOfParking(driver,hashMap.get("Type of Parking").toString());
      clientUtils.click(driver,typeOfParkingWebElement);
      clientUtils.sendText(driver,personalDetails.firstName,hashMap.get("First name").toString());
      clientUtils.sendText(driver,personalDetails.lastName,hashMap.get("Last name").toString());
      clientUtils.sendText(driver,personalDetails.email,hashMap.get("Email address").toString());
      clientUtils.sendText(driver,personalDetails.password,hashMap.get("Password").toString());
      clientUtils.sendText(driver,personalDetails.confirmPassword,hashMap.get("Confirm Password").toString());
      clientUtils.scrollTillElementIsVisible(driver,personalDetails.mobileNumber);
      clientUtils.sendText(driver,personalDetails.mobileNumber,hashMap.get("Mobile Number").toString());
      clientUtils.scrollTillElementIsVisible(driver,personalDetails.licensePlateNumber);
      clientUtils.sendText(driver,personalDetails.licensePlateNumber,hashMap.get("License plate number").toString());
      /*if((hashMap.get("Payment method").toString()).equalsIgnoreCase("Credit card")){
          creditCardPaymentMethod(hashMap,currentMethodName);
      }
      else if((hashMap.get("Payment method").toString()).equalsIgnoreCase("Direct debit")){
          directDebitPaymentMethod(hashMap,currentMethodName);
      }
      else if((hashMap.get("Payment method").toString()).equalsIgnoreCase("PayPal")){
          paypalPaymentMethod(hashMap,currentMethodName);
      }*/


      NewSetUp.getScreenshot(driver,index+"AfterFillingPersonalDetails",currentMethodName);

        index=0;


    }
    public void creditCardPaymentMethod(HashMap<Object, Object> hashMap,String currentMethodName){
        clientUtils.scrollTillElementIsVisible(driver,personalDetails.creditCardPaymentMethod);
        clientUtils.click(driver,personalDetails.creditCardPaymentMethod);
        clientUtils.click(driver,personalDetails.enterCreditCardDetailsButton);


    }
    public void directDebitPaymentMethod(HashMap<Object, Object> hashMap,String currentMethodName){
        clientUtils.scrollTillElementIsVisible(driver,personalDetails.directDebitPaymentMethod);
        clientUtils.click(driver,personalDetails.directDebitPaymentMethod);

    }
    public void paypalPaymentMethod(HashMap<Object, Object> hashMap,String currentMethodName){
        clientUtils.scrollTillElementIsVisible(driver,personalDetails.paypalPaymentMethod);
        clientUtils.click(driver,personalDetails.paypalPaymentMethod);
    }
}
