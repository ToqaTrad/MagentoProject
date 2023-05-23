import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.Assertion;

public class Parameters {
	static WebDriver driver = new ChromeDriver();
	String Website = "https://magento.softwaretestingboard.com";
	String FirstName = "Toqa";
	String LastName = "Trad";
	String EmailAddress = "toqatrad@gmail.com";
	String Password = "Abc@123456789";
	String Company = "Automation";
	String StreetAddress="FirstStreet";
	String StreetNumber="Street #1";
	String BulidingNumber="Buliding #1, Floor #1 ";
	String City="Amman";
	String Country="Jordan";
	String ZipCode="0000";
	String PhoneNumber="0791234567";
	String State="Georgia";
	Boolean ExpectedValue= true;
	Boolean ActualValue;
	String ActualText;
	Assertion MyAssert = new Assertion();
	Random rand = new Random();
	String ExpectedPrice;
	String ActualPrice;
    boolean ExpectedEquals = true;
    boolean ActualEquals;

	
	
}
