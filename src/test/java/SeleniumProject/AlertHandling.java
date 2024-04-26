package SeleniumProject;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AlertHandling 
{
//	DriverSetup setup;
    public WebDriver driver;
    
    public WebDriver createDriver() 
    {
//	Invoking the Driver method from the DriverSetup Class
    	driver=DriverSetup.launchBrowser();
    	return driver;
    }

    public void signIn() 
    {
//    	Navigating to sign in page and clicking 'Sign in' button
        driver.findElement(By.linkText("Sign in")).click();
        driver.findElement(By.name("proceed")).click();
    }

    public void checkAlert(String expectedAlertText) 
    {
//    	Capturing the Alert message and Checking the message
    	WebDriverWait myWait= new WebDriverWait(driver,Duration.ofSeconds(10));
        Alert alertWindow = myWait.until(ExpectedConditions.alertIsPresent());
        String actualAlertText = alertWindow.getText();
        if (actualAlertText.equals(expectedAlertText)) 
        {
            System.out.println("Expected Alert message is: "+expectedAlertText);
            System.out.println("Actual message is : " + alertWindow.getText());
            System.out.println("Alert message displayed is correct");
            System.out.println("----------------------------------------------------------");
            alertWindow.accept();
        } 
        else 
        {
            System.out.println("Test Failed");
        }
    }

    public void forgotPassword() 
    {
//    	Navigating to Forgot password page and clicking 'Next' button
        driver.findElement(By.linkText("Forgot Password?")).click();
        driver.findElement(By.name("next")).click();
    }

    public void navigateBack() 
    {
//    	Navigating back to sign in page
        driver.navigate().back();
    }

    public void privacyPolicy() 
    {
//    	Navigating to privacy policy page by clicking 'Privacy Policy' button
        driver.findElement(By.linkText("Privacy Policy")).click();
    }

    public void checkNewTab() 
    {
//    	Checking whether the Privacy Policy is displayed in new tab or not
        Set<String> values = driver.getWindowHandles();
        System.out.println("No. of tabs opened : " + values.size());
        if (values.size() > 1) 
        {
            System.out.println("Page is displayed in new tab");
        }
        if (values.size() == 1) 
        {
            System.out.println("Page is not displayed in new tab");
        }
        System.out.println("----------------------------------------------------------");
    }
        
    public void changeNewTab() 
    {
// 		Closing the new tab
        Set<String> values = driver.getWindowHandles();
        List<String> windowId = new ArrayList<String>(values);
        String childId = windowId.get(1);
        driver.switchTo().window(childId);
        driver.close();
        System.out.println("New Window is Closed");
    }
    
    public void closeBrowser() 
    {
//		Closing the browser
        driver.quit();
        System.out.println("Browser Closed Successfully");
        System.out.println("----------------------------------------------------------");
    }
}
