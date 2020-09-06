import static org.junit.Assert.*;
import java.util.List; 
import org.junit.Test; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


//This test checks end to end registration flow with validating error messages i.e by missing required fields, entering invalid data in mandatory fields
public class SignupTestsT2 extends BaseClass {

	// Check error displayed when tried to register with empty field of emailID	
	@Test 
	public void validateEmailMissingError() { 

		// Tap on create an account button without entering any email ID
		WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
		createAccountButton.click();

		// AssertEquals is a method which will compare two values, if both matches it will run fine but in case if does not match then if will throw an 
		// exception and fail the test
		List<WebElement> error = driver.findElements(By.xpath("//*[@id='create_account_error']/ol/li"));
		for(WebElement missingEmailError : error) { 
			String actualMissingEmailError = missingEmailError.getText();  
			String expectedMissingEmailError = "Invalid email address.";
			assertEquals("error not shown,test failed", actualMissingEmailError, expectedMissingEmailError);
		}

	}

	// Check error displayed when incorrect email address is entered
	@Test
	public void validateIncorrectEmailError() {

		// Passing an emailID with an invalid domain
		String emailID = "test@com";

		// Enter email ID
		WebElement enteredEmail = driver.findElement(By.name("email_create"));
		enteredEmail.sendKeys(emailID);

		// Tap on create an account button
		WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
		createAccountButton.click();

		List<WebElement> error = driver.findElements(By.xpath("//*[@id='create_account_error']/ol/li"));
		for(WebElement invalidEmailError : error) { 
			String actualInvalidEmailError = invalidEmailError.getText();  
			String expectedInvalidEmailError = "Invalid email address.";
			assertEquals("error not shown,test failed", actualInvalidEmailError, expectedInvalidEmailError);
		}

	}

	// Check error displayed when existing email Address is entered 
	@Test
	public void validateExistingEmailAddressEntry() {

		// Passing a valid email address
		String emailID = "test@gmail.com";

		// Enter email ID
		WebElement enteredEmail = driver.findElement(By.name("email_create"));
		enteredEmail.sendKeys(emailID);

		// Tap on create an account button
		WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
		createAccountButton.click();

		List<WebElement> error = driver.findElements(By.xpath("//*[@id='create_account_error']/ol/li"));
		for(WebElement existingEmailEntryError : error) { 
			String actualError = existingEmailEntryError.getText();  
			String expectedError = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
			assertEquals("error not shown,test failed", actualError, expectedError);
		}
	}

	// Check error displayed when passed empty values for mandatory fields while registering
	@Test
	public void validateAllInfoMissingErrors() {

		// Passing a valid email address
		String emailID = "user123@gmail.com";

		// Enter email ID
		WebElement enteredEmail = driver.findElement(By.name("email_create"));
		enteredEmail.sendKeys(emailID);

		// Tap on create an account button
		WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
		createAccountButton.click();

		// Scroll the web page upwards 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");

		// Tap register button
		WebElement registerButton = driver.findElement(By.id("submitAccount"));
		registerButton.click(); 

		List<WebElement> error = driver.findElements(By.xpath("//*[@id='center_column']/div"));
		for(WebElement missingInfoError : error) { 
			String actualmissingInfoError = missingInfoError.getText();  
			String expectedmissingInfoError = "There are 8 errors\n" + 
					"You must register at least one phone number.\n" + 
					"lastname is required.\n" + 
					"firstname is required.\n" + 
					"passwd is required.\n" + 
					"address1 is required.\n" + 
					"city is required.\n" + 
					"The Zip/Postal code you've entered is invalid. It must follow this format: 00000\n" + 
					"This country requires you to choose a State.";		       
			assertEquals("errors not shown,test failed", actualmissingInfoError, expectedmissingInfoError);
		}

	}

}
