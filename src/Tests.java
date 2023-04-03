import java.time.Duration;
import java.util.List;
import org.openqa.selenium.support.ui.Select;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Tests extends SetUP {
	@Test(priority = 1)

	public void Test1SignUP() {

		driver.findElement(
				By.cssSelector("body > div.page-wrapper > header > div.panel.wrapper > div > ul > li:nth-child(3) > a"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"firstname\"]")).sendKeys("Manar");
		driver.findElement(By.id("lastname")).sendKeys("Jdawneh" + Keys.TAB);
		driver.findElement(By.name("email")).sendKeys("manarmalik@gmail.com");
		driver.findElement(By.name("password")).sendKeys("ZainMalikGhina??!!");
		driver.findElement(By.name("password_confirmation")).sendKeys("ZainMalikGhina??!!");
		driver.findElement(By.cssSelector("#form-validate > div > div.primary > button")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		String ExpectedName = "Manar Jdawneh";
		String Contactinfo = driver
				.findElement(By.xpath("//*[@id=\"maincontent\"]/div[2]/div[1]/div[3]/div[2]/div[1]/div[1]")).getText();
		// To take first line of contact info
		String ActualName = Contactinfo.split("\n")[0];
		System.out.println(ActualName);
		Assertion.assertEquals(ActualName, ExpectedName);
		Assertion.assertAll();

	}

	@Test(priority = 2)
	public void Test2RandomSearch() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		String[] Items = { "Jacket", "t-shirt", "jeans for men", "jeans for women", "pants" };
		int RandomNum = rand.nextInt(5);
		driver.findElement(By.id("search")).sendKeys(Items[RandomNum] + Keys.ENTER);
		String SearchResult = driver.findElement(By.className("base")).getText();
		System.out.println(SearchResult);
		driver.get("https://magento.softwaretestingboard.com/");
	}

	@Test(priority = 3, invocationCount = 3)

	public void Test3RandomAdditionRadiantTee() throws InterruptedException {
		// Add Radiant Tee
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/a/span/span/img"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// Find and save sizes in webelement
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement DivContainSize = driver.findElement(By
				.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[3]/div[1]/div"));
		List<WebElement> Size = DivContainSize.findElements(By.tagName("div"));
		// System.out.println(Size.size());
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement DivContaincolors = driver.findElement(By
				.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[3]/div[2]/div"));
		List<WebElement> Color = DivContaincolors.findElements(By.tagName("div"));

		// Pick Size and Color Randomly then Addition
		Thread.sleep(3000);
		int RandomSize = rand.nextInt(Size.size());
		Size.get(RandomSize).click();

		Thread.sleep(3000);
		int RandomColor = rand.nextInt(Color.size());
		Color.get(RandomColor).click();
		// Add to cart
		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[1]/div/div/div[4]/div/div[1]/form/button"))
				.click();
	}

	@Test(priority = 4, invocationCount = 2)

	public void Test3RandomAdditionBreath_EasyTank() throws InterruptedException {
		// Add Breath_EasyTank
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/a/span/span/img"));

		// Add Sizes to WebElement List
		WebElement DivContainSize = driver.findElement(By.cssSelector(
				"#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(2) > div > div > div.swatch-opt-1812 > div.swatch-attribute.size > div"));
		List<WebElement> Size = DivContainSize.findElements(By.tagName("div"));

		// Add Colores to WebElement List
		WebElement DivContaincolors = driver.findElement(By.cssSelector(
				"#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(2) > div > div > div.swatch-opt-1812 > div.swatch-attribute.color > div"));
		List<WebElement> Color = DivContaincolors.findElements(By.tagName("div"));

		// Pick Size and Color Randomly then Addition
		Thread.sleep(3000);
		int RandomSize = rand.nextInt(Size.size());
		Size.get(RandomSize).click();

		Thread.sleep(3000);
		int RandomColor = rand.nextInt(Color.size());
		Color.get(RandomColor).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[2]/div/div/div[4]/div/div[1]/form/button"))
				.click();
	}

	@Test(priority = 5, invocationCount = 4)

	public void Test3RandomAdditionArgusAll_WeatherTank() throws InterruptedException {
		// Add Argus All-Weather Tank
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/a/span/span/img"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement DivContainSize = driver.findElement(By
				.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/div/div[2]/div[1]/div"));
		List<WebElement> Size = DivContainSize.findElements(By.tagName("div"));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement DivContaincolors = driver.findElement(By
				.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/div/div[2]/div[2]/div"));
		List<WebElement> Color = DivContaincolors.findElements(By.tagName("div"));

		// Pick Size and Color Randomly then Addition
		Thread.sleep(3000);
		int RandomSize = rand.nextInt(Size.size());
		Size.get(RandomSize).click();

		Thread.sleep(3000);
		int RandomColor = rand.nextInt(Color.size());
		Color.get(RandomColor).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[3]/div/div/div[3]/div/div[1]/form/button"))
				.click();
	}

	@Test(priority = 6)

	public void Test3RandomAdditionHeroHoodie() throws InterruptedException {
		// Add HeroHoodie
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// Select the Item
		driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/a/span/span/img"));

		// Add Sizes to WebElement List
		WebElement DivContainSize = driver.findElement(By.cssSelector(
				"#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(4) > div > div > div.swatch-opt-158 > div.swatch-attribute.size > div"));
		List<WebElement> Size = DivContainSize.findElements(By.tagName("div"));

		// Add Colores to WebElement List
		WebElement DivContaincolors = driver.findElement(By.cssSelector(
				"#maincontent > div.columns > div > div.widget.block.block-static-block > div.block.widget.block-products-list.grid > div > div > ol > li:nth-child(4) > div > div > div.swatch-opt-158 > div.swatch-attribute.color > div"));
		List<WebElement> Color = DivContaincolors.findElements(By.tagName("div"));

		// Pick Size and Color Randomly then Addition
		Thread.sleep(3000);
		int RandomSize = rand.nextInt(Size.size());
		Size.get(RandomSize).click();

		Thread.sleep(3000);
		int RandomColor = rand.nextInt(Color.size());
		Color.get(RandomColor).click();

		Thread.sleep(3000);
		driver.findElement(By.xpath(
				"//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[4]/div/div/div[3]/div/div[1]/form/button"))
				.click();
	}

	@Test(priority = 7)
	public void Test3AddFusionBackpack() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		// Select the Item
		driver.findElement(
				By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[3]/div/div/ol/li[5]/div/a/span/span/img"))
				.click();
		driver.findElement(By.xpath("//*[@id=\"qty\"]")).clear();
		Thread.sleep(3000);
		driver.findElement(By.name("qty")).sendKeys("5");

		// SelectBag
		driver.findElement(By.xpath("//*[@id=\"product-addtocart-button\"]")).click();
		Thread.sleep(3000);
	}

	@Test(priority = 8)
	public void Test4CheckOut() throws InterruptedException {

		Thread.sleep(10000);
		// Enter to Cart
		driver.findElement(By.xpath("/html/body/div[1]/header/div[2]/div[1]/a")).click();
		// Procced to Gheckout
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.xpath("//*[@id=\"top-cart-btn-checkout\"]")).click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
		// Fill the Information
		driver.findElement(By.name("company")).sendKeys("QA Course");
		driver.findElement(By.name("street[0]")).sendKeys("Aljabir");
		driver.findElement(By.name("street[1]")).sendKeys(" ");
		driver.findElement(By.name("street[2]")).sendKeys(" ");
		driver.findElement(By.name("city")).sendKeys("Az zarqa");
		Select drpState = new Select(driver.findElement(By.name("region_id")));
		drpState.selectByVisibleText("Armed Forces Middle East");
		driver.findElement(By.name("postcode")).sendKeys("13110");
		Select drpCountry = new Select(driver.findElement(By.name("country_id")));
		drpCountry.selectByVisibleText("Jordan");
		driver.findElement(By.name("telephone")).sendKeys("0786286969");
//		// Payment Method
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//		driver.findElement(By.xpath("//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input"))
//				.click();
		Thread.sleep(10000);
		driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/div/button")).click();
	}

	@Test(priority = 9)
	public void Test5PlaceOrder() throws InterruptedException {
		Thread.sleep(10000);
		// Place Order
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();

		// Go to Order using Order Number
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a")).click();
		int ExpectedPrice = 571;
		String ActualPrice = driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[1]/td/span")).getText();
		String PriceNum = ActualPrice.replace("$", "");
		int ActualPriceNum = new Double(PriceNum).intValue();
		System.out.println(ActualPriceNum);
		Assertion.assertEquals(ActualPriceNum, ExpectedPrice);
		Assertion.assertAll();
	}
}
