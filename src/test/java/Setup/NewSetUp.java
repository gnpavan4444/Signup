package Setup;

import Utilities.HTMLUtility;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

public class NewSetUp {
    public static WebDriver driver;
    PropertyUtils properties;
    public static int testCasesCount=0;
    public static HashMap<Object,Object> testdata;
    public static String screenshotsPath=System.getProperty("user.dir") + File.separator + "screenshots\\";
    TestCaseScenario testCaseScenario;
    TestCaseExecutor testCaseExecutor;
    @BeforeMethod
    public void setUp() throws IOException {
        System.out.println("I am from Before Method");
        properties= new PropertyUtils();
        System.setProperty("webdriver.chrome.driver", "C:/ComputerDatabase/ChromeDriver/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get(properties.getPropertyValue("appURL"));
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);




    }

    @BeforeClass
    public void startReport() throws IOException {
        HTMLUtility.createHTMLTemplate();
    }
    @AfterMethod
    public void getResult(ITestResult result) throws IOException {
        testCasesCount=testCasesCount+1;
        if(result.getStatus()==ITestResult.SUCCESS){
            System.out.println(screenshotsPath+result.getName()+"\\"+"path");


            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"Pass",screenshotsPath+result.getName()+"\\");


        }
        else if(result.getStatus()==ITestResult.FAILURE){
            System.out.println(screenshotsPath+result.getName()+"\\"+"path");
            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"Fail",screenshotsPath+result.getName()+"\\");
        }
        else if(result.getStatus()==ITestResult.SKIP){
            System.out.println(screenshotsPath+result.getName()+"\\"+"path");
            HTMLUtility.testCaseExecutionStatus(testCasesCount,result.getName(),"No Run",screenshotsPath+result.getName()+"\\");
        }


    }
    public static String getScreenshot(WebDriver driver, String screenshotName,String methodName) throws Exception {
        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        //after execution, you could see a folder "FailedTestsScreenshots" under src folder

        String destination = System.getProperty("user.dir") + File.separator + "screenshots/"+methodName+"/"+screenshotName+".jpeg";
        File finalDestination = new File(destination);
        FileUtils.copyFile(source, finalDestination);
        System.out.println("Destination is"+destination);
        return destination;
    }
    @AfterMethod
    public void atearDown()
    {
        System.out.println("I am from After Method");
        driver.quit();
    }
    @AfterClass
    public void endReport() throws IOException {
        HTMLUtility.closeHTMLReport();


    }
}
