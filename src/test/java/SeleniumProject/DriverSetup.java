package SeleniumProject;

import java.io.FileInputStream;
//import java.time.Duration;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

//Setting up and launching the web browser driver.
public class DriverSetup 
{
	static WebDriver driver;
	static Scanner scanner;

	static Properties urlFile= new Properties();
 
	public static WebDriver launchBrowser()
	{
		System.out.println("Enter the browser name to launch (chrome/edge): ");
		scanner = new Scanner(System.in);
        String browserName = scanner.next();
       try 
       {
//    	    FileInputStream is used to load the property from properties file.
			FileInputStream link = new FileInputStream("C:\\Users\\2318452\\eclipse-workspace\\AlertHandling\\src\\test\\java\\SeleniumProject\\projectProp.properties");
			urlFile.load(link);

       } 
       catch (Exception e) 
       {
			e.printStackTrace();
       }

 
        switch (browserName.toLowerCase()) 
        {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get(urlFile.getProperty("baseUrl"));
                driver.manage().window().maximize();
                break;
            case "edge":
            	WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.get(urlFile.getProperty("baseUrl"));
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Invalid browser name. Please enter 'chrome' or 'edge'.");

        }
		return driver;

	}
 }

