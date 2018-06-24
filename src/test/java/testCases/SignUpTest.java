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
    HomePage homePage;
     PersonalDetails personalDetails;
     SignupOptionsPage signupOptionsPage;
    ClientUtils clientUtils;
    @Test
    public void silverCategoryGermanSignUp() throws Exception {
        testCaseExecutor = new TestCaseExecutor();
        currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        hashMap= testCaseExecutor.createHashMapForSpecificRow(currentMethodName);
       System.out.println("Hashmap is"+hashMap);
       signUp(hashMap,currentMethodName);
    }

    @Test
    public void passwordValidations() throws Exception {
        testCaseExecutor = new TestCaseExecutor();
        currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
        hashMap= testCaseExecutor.createHashMapForSpecificRow(currentMethodName);
        homePage = PageFactory.initElements(driver,HomePage.class);
        personalDetails = PageFactory.initElements(driver,PersonalDetails.class);
        signupOptionsPage = PageFactory.initElements(driver,SignupOptionsPage.class);
        clientUtils = new ClientUtils(driver);
        clientUtils.click(driver,homePage.signUpButton);
        logger.info("Signup button is clicked");
        logger.info("Checking the Cookies text visibility");
        clientUtils.checkElementVisibility(driver,signupOptionsPage.cookiesText);
        clientUtils.click(driver,signupOptionsPage.cookiesAllowButton);
        logger.info("Clicked the Cookies text allow button");
        // String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();


        clientUtils.click(driver,signupOptionsPage.countryButton);
        logger.info("Clicked the Country button in Signup options page");
        logger.info("Taking the screenshot of Signup page");
        NewSetUp.getScreenshot(driver,index+"SignUpPage",currentMethodName);
        ++index;
        // WebElement countryWebElement = clientUtils.dynamicXpathElements(driver,signupOptionsPage.selectCountry,"France");
        WebElement countryWebElement = signupOptionsPage.selectCountryFromList(driver,hashMap.get("Country").toString());
        logger.info("Selecting the country");
        clientUtils.click(driver,countryWebElement);
        WebElement chooseButtonWebElement = signupOptionsPage.selectChooseButton(driver,hashMap.get("Package").toString());
        logger.info("Clicking on the Choose button");
        clientUtils.click(driver,chooseButtonWebElement);
        logger.info("Waiting for personal details screen to load");
        clientUtils.waitForElement(driver,personalDetails.personalDetailsTitle);
        logger.debug("Taking screenshot for personal details screen");
        NewSetUp.getScreenshot(driver,index+"PersonalDetails",currentMethodName);
        ++index;
        WebElement typeOfParkingWebElement = personalDetails.selectTypeOfParking(driver,hashMap.get("Type of Parking").toString());
        logger.info("Clicking on the type of parking web element either Personal or Company type");
        clientUtils.click(driver,typeOfParkingWebElement);
        clientUtils.sendText(driver,personalDetails.firstName,hashMap.get("First name").toString());
        clientUtils.sendText(driver,personalDetails.lastName,hashMap.get("Last name").toString());
        clientUtils.sendText(driver,personalDetails.email,hashMap.get("Email address").toString());
        clientUtils.sendText(driver,personalDetails.password,hashMap.get("Password").toString());
        clientUtils.click(driver,personalDetails.confirmPassword);
        Assert.assertTrue(clientUtils.checkElementVisibility(driver,personalDetails.passwordValidationErrorMessage));
        clientUtils.sendText(driver,personalDetails.confirmPassword,hashMap.get("Confirm Password").toString());
        clientUtils.click(driver,personalDetails.mobileNumber);
        Assert.assertTrue(clientUtils.checkElementVisibility(driver,personalDetails.confirmPasswordValidationErrorMessage));


    }







    public void signUp(HashMap<Object, Object> hashMap,String currentMethodName) throws Exception {
         homePage = PageFactory.initElements(driver,HomePage.class);
         personalDetails = PageFactory.initElements(driver,PersonalDetails.class);
        signupOptionsPage = PageFactory.initElements(driver,SignupOptionsPage.class);
         clientUtils = new ClientUtils(driver);

        clientUtils.click(driver,homePage.signUpButton);
        logger.info("Signup button is clicked");
        logger.info("Checking the Cookies text visibility");
        clientUtils.checkElementVisibility(driver,signupOptionsPage.cookiesText);
        clientUtils.click(driver,signupOptionsPage.cookiesAllowButton);
        logger.info("Clicked the Cookies text allow button");
       // String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();


        clientUtils.click(driver,signupOptionsPage.countryButton);
        logger.info("Clicked the Country button in Signup options page");
        logger.info("Taking the screenshot of Signup page");
        NewSetUp.getScreenshot(driver,index+"SignUpPage",currentMethodName);
        ++index;
       // WebElement countryWebElement = clientUtils.dynamicXpathElements(driver,signupOptionsPage.selectCountry,"France");
        WebElement countryWebElement = signupOptionsPage.selectCountryFromList(driver,hashMap.get("Country").toString());
        logger.info("Selecting the country");
        clientUtils.click(driver,countryWebElement);
        WebElement chooseButtonWebElement = signupOptionsPage.selectChooseButton(driver,hashMap.get("Package").toString());
        logger.info("Clicking on the Choose button");
        clientUtils.click(driver,chooseButtonWebElement);
        logger.info("Waiting for personal details screen to load");
        clientUtils.waitForElement(driver,personalDetails.personalDetailsTitle);
        logger.info("Checking the title text of Personal details screen");
        Assert.assertEquals(personalDetails.personalDetailsTitle.getText().toString(),"PERSONAL DETAILS");
        logger.debug("Taking screenshot for personal details screen");
        NewSetUp.getScreenshot(driver,index+"PersonalDetails",currentMethodName);
        ++index;
      WebElement typeOfParkingWebElement = personalDetails.selectTypeOfParking(driver,hashMap.get("Type of Parking").toString());
      logger.info("Clicking on the type of parking web element either Personal or Company type");
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
      if((hashMap.get("Payment method").toString()).equalsIgnoreCase("Credit card")){
          creditCardPaymentMethod(hashMap,currentMethodName);
      }
      else if((hashMap.get("Payment method").toString()).equalsIgnoreCase("Direct debit")){
          directDebitPaymentMethod(hashMap,currentMethodName);
      }
      else if((hashMap.get("Payment method").toString()).equalsIgnoreCase("PayPal")){
          paypalPaymentMethod(hashMap,currentMethodName);
      }


      NewSetUp.getScreenshot(driver,index+"AfterFillingPersonalDetails",currentMethodName);

        index=0;


    }
    public void creditCardPaymentMethod(HashMap<Object, Object> hashMap,String currentMethodName){
        homePage = PageFactory.initElements(driver,HomePage.class);
        personalDetails = PageFactory.initElements(driver,PersonalDetails.class);
        signupOptionsPage = PageFactory.initElements(driver,SignupOptionsPage.class);
        clientUtils = new ClientUtils(driver);
        clientUtils.scrollTillElementIsVisible(driver,personalDetails.creditCardPaymentMethod);
        clientUtils.click(driver,personalDetails.creditCardPaymentMethod);
        clientUtils.click(driver,personalDetails.enterCreditCardDetailsButton);


    }
    public void directDebitPaymentMethod(HashMap<Object, Object> hashMap,String currentMethodName){
        homePage = PageFactory.initElements(driver,HomePage.class);
        personalDetails = PageFactory.initElements(driver,PersonalDetails.class);
        signupOptionsPage = PageFactory.initElements(driver,SignupOptionsPage.class);
        clientUtils = new ClientUtils(driver);
        clientUtils.scrollTillElementIsVisible(driver,personalDetails.directDebitPaymentMethod);
        clientUtils.click(driver,personalDetails.directDebitPaymentMethod);

    }
    public void paypalPaymentMethod(HashMap<Object, Object> hashMap,String currentMethodName){
        homePage = PageFactory.initElements(driver,HomePage.class);
        personalDetails = PageFactory.initElements(driver,PersonalDetails.class);
        signupOptionsPage = PageFactory.initElements(driver,SignupOptionsPage.class);
        clientUtils = new ClientUtils(driver);
        clientUtils.scrollTillElementIsVisible(driver,personalDetails.paypalPaymentMethod);
        clientUtils.click(driver,personalDetails.paypalPaymentMethod);
    }
}
