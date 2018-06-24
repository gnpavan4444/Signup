package Utilities;

import Setup.PropertyUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ClientUtils {
    static WebDriver driver;

    PropertyUtils propertyUtils = new PropertyUtils();
    public ClientUtils(WebDriver driver){
        this.driver=driver;
    }


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
    public  void sendText(WebDriver driver, WebElement webElement,String text) {
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.clear();
            webElement.sendKeys(text);
        }
        catch(Exception e){


        }


    }
    public void waitForPresenceOfLocated(WebElement byElement){
        WebDriverWait wait = new WebDriverWait(driver, Integer.parseInt(propertyUtils.getPropertyValue("timeoutForWait")));
        wait.until(ExpectedConditions.visibilityOf (byElement));
    }
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
    public void scrollTillElementIsVisible(WebDriver driver,WebElement webElement){
        while(!checkElementVisibility(driver,webElement)){
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
            javascriptExecutor.executeScript("window.scrollBy(0,40)");
        }


    }
    public WebElement dynamicXpathElements(WebDriver driver,WebElement webElement,String text){
       String webElementText= webElement.toString().replace("country",text);
       System.out.println("Web Element text is"+webElementText);
       WebElement dynamicXpathElement = driver.findElement(By.xpath(webElementText));
       System.out.println("Web Element is"+dynamicXpathElement);
       return dynamicXpathElement;
    }
    public void selectElementFromDropdown(WebDriver driver,WebElement webElement,String text){
        try{
            (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
            Select selectDropdownElement = new Select(webElement);
            selectDropdownElement.selectByVisibleText(text);
        }
        catch (Exception e){

        }

    }
    public void waitForElement(WebDriver driver,WebElement webElement){
        (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(webElement));
    }


}
