import static org.junit.Assert.*; 
import org.junit.Test; 
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

//This test checks end to end registration flow[happy path] by entering valid data in all fields
public class SignupTestsT1 extends BaseClass{

	@Test 
	public void registerUser() { 

		// Check whether sign up section is visible
		String signupHeader = "CREATE AN ACCOUNT";
		assertEquals("Signup page not available", signupHeader, "CREATE AN ACCOUNT"); 

		// Generate new user and emailID every time 
		String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
		String emailID = "User"+userName+"@gmail.com";

		// Enter generated email id
		WebElement enteredEmail = driver.findElement(By.name("email_create"));
		enteredEmail.sendKeys(emailID);

		// Tap on create an account button
		WebElement createAccountButton = driver.findElement(By.name("SubmitCreate"));
		createAccountButton.click();

		// Check existence and select title radio button
		WebElement maleRadioBtn = driver.findElement(By.id("id_gender1"));
		WebElement femaleRadioBtn = driver.findElement(By.id("id_gender2"));

		if (maleRadioBtn.isDisplayed() == true && maleRadioBtn.isSelected() == false) {
			maleRadioBtn.click();
		}
		else if (femaleRadioBtn.isDisplayed() == true && maleRadioBtn.isSelected() == false) {
			femaleRadioBtn.click();
		}
		else
			return;

		// Enter first name
		WebElement firstName = driver.findElement(By.id("customer_firstname"));
		firstName.sendKeys("John");

		// Enter last name
		WebElement lastName = driver.findElement(By.id("customer_lastname"));
		lastName.sendKeys("Doe");

		// Creating the JavascriptExecutor interface object by Type casting
		JavascriptExecutor js = (JavascriptExecutor) driver; 

		// Scroll the web page upwards 
		js.executeScript("window.scrollBy(0,200)");

		// Enter password
		WebElement password=driver.findElement(By.id("passwd"));	
		password.sendKeys("password");

		// Select day from drop-down
		Select drpDate = new Select(driver.findElement(By.id("days")));
		drpDate.selectByValue("2");

		// Select month from drop-down
		Select drpMonth = new Select(driver.findElement(By.id("months")));
		drpMonth.selectByValue("11");

		// Select year from drop-down
		Select drpYear = new Select(driver.findElement(By.id("years")));
		drpYear.selectByValue("1994");

		// Scroll-up the page
		js.executeScript("window.scrollBy(0,200)");

		// Enter Address
		WebElement address = driver.findElement(By.id("address1"));
		address.sendKeys("1186 Roseville Pkwy");

		// Enter City
		WebElement city = driver.findElement(By.id("city"));
		city.sendKeys("Roseville");

		// Select state from drop-down
		Select drpState = new Select(driver.findElement(By.id("id_state")));
		drpState.selectByValue("5");

		// Enter zip code
		WebElement zipCode = driver.findElement(By.id("postcode"));
		zipCode.sendKeys("95661");

		// Scroll-up the page
		js.executeScript("window.scrollBy(0,200)");

		// Enter mobile number
		WebElement mobileNumber = driver.findElement(By.id("phone_mobile"));
		mobileNumber.sendKeys("77777777");

		// Tap register button
		WebElement registerButton = driver.findElement(By.id("submitAccount"));
		registerButton.click(); 

		// Check whether user lands on my account page
		String myaccountActualHeader = driver.findElement(By.className("info-account")).getText();
		String myAccountExpectedHeader = "Welcome to your account. Here you can manage all of your personal information and orders.";
		assertEquals("User not on myAccount page", myaccountActualHeader,myAccountExpectedHeader);
	} 

}

