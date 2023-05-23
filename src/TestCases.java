import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.text.NumberFormat;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;

public class TestCases extends Parameters {

	@BeforeTest
	public void WebsiteLogin() {

		driver.get(Website);
		driver.manage().window().maximize();

	}

	@Test(description = "1st Test: Signup ", priority = 1)
	public void Login() throws InterruptedException {

		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[3]/a")).click();
		List<WebElement> TextFinder = driver.findElements(By.className("required-entry"));
		TextFinder.get(0).sendKeys(FirstName);
		TextFinder.get(1).sendKeys(LastName);

		WebElement EmailFinder = driver.findElement(By.id("email_address"));
		EmailFinder.sendKeys(EmailAddress);

		WebElement PasswordFinder = driver.findElement(By.id("password"));
		PasswordFinder.sendKeys(Password);

		WebElement PasswordConfirmationFinder = driver.findElement(By.id("password-confirmation"));
		PasswordConfirmationFinder.sendKeys(Password);
		driver.findElement(By.xpath("//*[@id=\"form-validate\"]/div/div[1]/button")).click();
		Thread.sleep(3000);

		boolean MessageError = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div")).getText()
				.contains("Create an Account");
		// System.out.println(MessageError);

		if (MessageError) {
			driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
			List<WebElement> SignInFinder = driver.findElements(By.className("input-text"));
			// System.out.println(SignInFinder.get(0)+" "+SignInFinder.get(1)+"
			// "+SignInFinder.size());
			SignInFinder.get(1).sendKeys(EmailAddress);
			SignInFinder.get(2).sendKeys(Password);
			driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
			Thread.sleep(3000);

			ActualText = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span")).getText();
			ActualValue = ActualText.contains(FirstName) && ActualText.contains(LastName);
			AssertJUnit.assertEquals(ActualValue, ExpectedValue);

		} else {

			Thread.sleep(3000);
			ActualText = driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[1]/span")).getText();
			ActualValue = ActualText.contains(FirstName) && ActualText.contains(LastName);

			AssertJUnit.assertEquals(ActualValue, ExpectedValue);
		}

	}
	
	@Test(description = "2nd test: Search Items Randomly")
	public void RandomSearchItems() {
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
		driver.get(Website);
		String [] Items = {"Jacket","t-shirt", "jeans for men", "jeans for women","pants"};
		int ItemIndex = rand.nextInt(0,4);
		WebElement Search = driver.findElement(By.xpath("//*[@id=\"search\"]"));
		Search.sendKeys(Items[ItemIndex]+Keys.ENTER);
		String ItemInput = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[1]/h1/span")).getText();
		System.out.println("Name of the selected item randomly: "+ItemInput.substring(20));

	}

	@Test(description = "3rd test: Adding Items To The Cart",priority = 2)
	public void AddItemsToCart() throws InterruptedException {
//		driver.get(Website);
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/a")).click();
		Thread.sleep(7000);
		int SizeIndex = rand.nextInt(0, 5);
		int ColorIndex = rand.nextInt(0, 3);
		int j = 0;
		WebElement ProductsItems = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol"));
		List<WebElement> Products = ProductsItems.findElements(By.className("product-item"));
		
		// To Add Radiant Tee
		for (int i = 0; i < 3; i++) {
			SizeIndex = rand.nextInt(0, 5);
			ColorIndex = rand.nextInt(0, 3);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			ProductsItems = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol"));
			Products = ProductsItems.findElements(By.className("product-item"));
			WebElement RadiantTeeItem = Products.get(j);
			List<WebElement> ItemSize = RadiantTeeItem.findElements(By.className("text"));
			List<WebElement> ItemColor = RadiantTeeItem.findElements(By.className("color"));
			ItemSize.get(SizeIndex).click();
			ItemColor.get(ColorIndex).click();
			RadiantTeeItem.findElement(By.xpath(
					"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[1]/form/button"))
					.click();
			}

		j++;
		
		//To Add Breathe-Easy Tank
		for (int i = 0; i < 2; i++) {
			SizeIndex = rand.nextInt(0, 5);
			ColorIndex = rand.nextInt(0, 3);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			ProductsItems = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol"));
			Products = ProductsItems.findElements(By.className("product-item"));
			WebElement BreatheEasyTankItem = Products.get(j);
			List<WebElement> ItemSize = BreatheEasyTankItem.findElements(By.className("text"));
			List<WebElement> ItemColor = BreatheEasyTankItem.findElements(By.className("color"));
			ItemSize.get(SizeIndex).click();
			ItemColor.get(ColorIndex).click();
			BreatheEasyTankItem.findElement(By.xpath(
					"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/div/div[4]/div/div[1]/form/button"))
					.click();
			}
		j++;
		
		// To Add Argus All-Weather Tank
		for (int i = 0; i < 4; i++) {
			SizeIndex = rand.nextInt(0, 5);
			ColorIndex = rand.nextInt(0, 1);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
			ProductsItems = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol"));
			Products = ProductsItems.findElements(By.className("product-item"));
			WebElement ArgusAllWeatherTank = Products.get(j);
			List<WebElement> ItemSize = ArgusAllWeatherTank.findElements(By.className("text"));
			WebElement ItemColor = ArgusAllWeatherTank
					.findElement(By.xpath("//*[@id=\"option-label-color-93-item-52\"]"));
			ItemSize.get(SizeIndex).click();
			ItemColor.click();
			ArgusAllWeatherTank.findElement(By.xpath(
					"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/div/div[3]/div/div[1]/form/button"))
					.click();

		}
		j++;

		// To Add Hero Hoodie
		SizeIndex = rand.nextInt(0, 5);
		ColorIndex = rand.nextInt(0, 3);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		ProductsItems = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol"));
		Products = ProductsItems.findElements(By.className("product-item"));
		WebElement HeroHoodie = Products.get(j);
		List<WebElement> ItemSize = HeroHoodie.findElements(By.className("text"));
		List<WebElement> ItemColor = HeroHoodie.findElements(By.className("color"));
		ItemSize.get(SizeIndex).click();
		ItemColor.get(ColorIndex).click();
		HeroHoodie.findElement(By.xpath(
				"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[1]/form/button"))
				.click();


		j=j+2;
		
		// To Add Push It Messenger Bag
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		ProductsItems = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol"));
		Products = ProductsItems.findElements(By.className("product-item"));
		WebElement FusionBackpack = Products.get(j);
		Products.get(j).click();
		WebElement quantityField = driver.findElement(By.id("qty"));
		quantityField.clear();
		quantityField.sendKeys("5");
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
	}

	@Test(description = "4th test: Complete Shipping Address Information", priority = 3)
	public void ShippingAddressInfo() throws InterruptedException {
//		Thread.sleep(4000);
		int i = 2;
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
		Thread.sleep(8000);
		String Header = driver.findElement(By.className("authentication-wrapper")).getText();
		WebElement ActionButtons = driver.findElement(By.id("checkoutSteps"));
		String Action = ActionButtons.findElement(By.className("action")).getText();
		if(Action.contains("Next")) {
		if(Header.contains("Sign In"))
		{
		WebElement EmailAddressInput = driver.findElement(By.xpath("//*[@id=\"customer-email\"]"));
		EmailAddressInput.sendKeys(EmailAddress);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebElement PasswordInput = driver.findElement(By.xpath("//*[@id=\"customer-password\"]"));
		PasswordInput.sendKeys(Password);
		driver.findElement(By.className("login")).click();
		}

		Thread.sleep(9000);
		WebElement checkout = driver.findElement(By.id("checkoutSteps"));
		List<WebElement> ShippingAddress = checkout.findElements(By.className("input-text"));
		WebElement CompanyInput = ShippingAddress.get(i);
		//Enter Street Address
		CompanyInput.sendKeys(StreetAddress);
		i++;
		//Enter Street Address
		WebElement StreetAddressInput = ShippingAddress.get(i);
		StreetAddressInput.sendKeys(StreetAddress);
		i++;
		//Enter Street Address

		StreetAddressInput = ShippingAddress.get(i);
		StreetAddressInput.sendKeys(StreetNumber);
		i++;
		//Enter Street Address
		StreetAddressInput = ShippingAddress.get(i);
		StreetAddressInput.sendKeys(BulidingNumber);
		i++;
		//Enter City 
		WebElement CityInput = ShippingAddress.get(i);
		CityInput.sendKeys(City);
		i++;
		
		//Enter State 
		List<WebElement> SelectFinder = driver.findElements(By.className("select"));
		WebElement StateInput = SelectFinder.get(0);
		Select mySelector = new Select(StateInput);
		mySelector.selectByVisibleText(State);
		StateInput.sendKeys(State);
		i++;

		//Enter Country
		WebElement CountryInput = SelectFinder.get(1);
		Select Selector = new Select(CountryInput);
		Selector.selectByVisibleText(Country);
		
		//Enter Zip Code
		WebElement ZipCodeInput = ShippingAddress.get(i);
		ZipCodeInput.sendKeys(ZipCode);
		i++;
		
		//Enter Phone Number
		WebElement PhoneNumberInput = ShippingAddress.get(i);
		PhoneNumberInput.sendKeys(PhoneNumber);
		i++;
		}
		Thread.sleep(5000);


		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
	

	}
	
	@Test(description = "5th test: Check Final Price Is Correct", priority = 4)
	public void CheckFinalPrice() throws InterruptedException{
		
		Thread.sleep(5000);
		WebElement OrderSummary = driver.findElement(By.xpath("//*[@id=\"opc-sidebar\"]/div[1]/table"));
		List<WebElement> Prices = OrderSummary.findElements(By.className("price"));
		ExpectedPrice = Prices.get(Prices.size()-1).getText();			
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a")).click();
		Thread.sleep(4000);
		WebElement OrderInfo = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[2]"));
		List<WebElement> OrderPrices = OrderInfo.findElements(By.className("price"));
		ActualPrice = OrderPrices.get(OrderPrices.size()-1).getText();
		MyAssert.assertEquals(ActualPrice, ExpectedPrice);	

	}
	
	@Test(description = "6th test: Sign In and Reorder", priority = 5)
	public void Reorder() throws InterruptedException {
			driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
			driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/div/ul/li[3]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/a")).click();
			
			List<WebElement> SignInFinder = driver.findElements(By.className("input-text"));
			SignInFinder.get(1).sendKeys(EmailAddress);
			SignInFinder.get(2).sendKeys(Password);
			driver.findElement(By.xpath("//*[@id=\"send2\"]")).click();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")).click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]")).click();
			Thread.sleep(5000);
			
			//Proceed To Check Out
			WebElement Order = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]"));
			Order.findElement(By.className("checkout")).click();
			Thread.sleep(4000);
			//Continue on Shipping Page 
			driver.findElement(By.className("continue")).click();
			//Place Order on Payments
			driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.className("order-number")).click();

			
			for(int i=0;i<4;i++) {
			Thread.sleep(3000);
			driver.findElement(By.className("order")).click();
			//Proceed To Check Out
			WebElement Orders = driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]"));
			Orders.findElement(By.className("checkout")).click();
			Thread.sleep(4000);
			//Continue on Shipping Page 
			driver.findElement(By.className("continue")).click();
			Thread.sleep(4000);
			//Place Order on Payments
			driver.findElement(By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
			Thread.sleep(3000);
			driver.findElement(By.className("order-number")).click();

			}



	}
	@Test(description = "7th test: Check All Orders Invoices Are The Same", priority = 6)
	public void CheckInvoices() {
		driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]")).click();
		List <WebElement> Total = driver.findElements(By.className("total"));
		 for(int i=1;i<Total.size()-1;i++) {
			String TotalPrices= Total.get(i).getText().replace("$", "");			
			String SecondTotalPrices= Total.get(i+1).getText().replace("$", "");
	        double TotalPricesInt = Double.parseDouble(TotalPrices);
	        double SecondTotalPricesInt = Double.parseDouble(SecondTotalPrices);
	        if(TotalPricesInt == SecondTotalPricesInt)
	        	ActualEquals=true;
	        else
	        	ActualEquals=false;

		 }
	        MyAssert.assertEquals(ActualEquals, ExpectedEquals);


	}
	

}
