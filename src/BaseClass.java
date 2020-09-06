import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {		

	static WebDriver driver; 

	@Before
	public void setUpSignupPage() { 
		System.setProperty("webdriver.chrome.driver", "/Users/shravani/Desktop/Driver/chromedriver"); 
		// Create a new instance of the Chrome driver
		driver = new ChromeDriver() ; 

		// Wait For Page To Load
		// Put a Implicit wait, this means that any search for elements on the page
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); 

		// Navigate to URL
		driver.get("http://automationpractice.com/index.php"); 

		// Maximise the window.
		driver.manage().window().maximize(); 

		// Wait For Page To Load
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		// Click on 'Sign In' button
		WebElement signInLink = driver.findElement(By.linkText("Sign in"));
		signInLink.click();
	} 

	@After
	public void browserClose() { 
		// Quit the browser	
		driver.quit(); 	
	}

}
