package utilities;

import setup.PropertyUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientUtils {
    static WebDriver driver;

    PropertyUtils propertyUtils = new PropertyUtils();
    public ClientUtils(WebDriver driver){
        this.driver=driver;
    }

  //Reusable method to perform click event on web element
    public  void click(WebDriver driver, WebElement webElement) {
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        }
        catch (StaleElementReferenceException sere) {
            // simply retry finding the element in the refreshed DOM
            webElement.click();
        }


    }
    //Reusable method to send text to web element
    public  void sendText(WebDriver driver, WebElement webElement,String text) {
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch(Exception e){


        }


    }
    //Reusable method to check whether web element is visible or not
    public boolean checkElementVisibility( WebDriver driver, WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(propertyUtils.getPropertyValue("timeoutForWait")));
            wait.until(ExpectedConditions.visibilityOf (webElement));
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
    //Reusable method to scroll till element is visible
    public void scrollTillElementIsVisible(WebDriver driver,WebElement webElement){
        try{
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
            javascriptExecutor.executeScript("arguments[0].scrollIntoView();",webElement );
        }
        catch (Exception e){

        }



    }

    //Reusable method to wait with a time out of 10 seconds till the element is clickable
    public void waitForElement(WebDriver driver,WebElement webElement){
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
        }
        catch (Exception e){

        }

    }


}
