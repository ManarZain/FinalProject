import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class Reorder extends SetUP {

	List<String> OrdersCost = new ArrayList<String>();

	@Test(priority = 1)
	public void SignIN() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		// Sign in with email and password
		driver.findElement(By.cssSelector(
				"body > div.page-wrapper > header > div.panel.wrapper > div > ul > li.authorization-link > a")).click();
		driver.findElement(By.name("login[username]")).sendKeys("manarmalik@gmail.com");
		driver.findElement(By.name("login[password]")).sendKeys("ZainMalikGhina??!!" + Keys.ENTER);
	}

	@Test(priority = 2, invocationCount = 5)
	public void Test6Reorder() throws InterruptedException {

		// Select My Account from drop down list
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		WebElement MyAccountdiv = driver.findElement(By.className("links"));
		List<WebElement> MyAccount = MyAccountdiv.findElements(By.tagName("a"));
		MyAccount.get(0).click();
		// My orders
		driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")).click();
		// reorder
		driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tbody/tr[1]/td[6]/a[2]")).click();
		Thread.sleep(10000);
		// Proceed to check out
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/div[1]/ul/li[1]/button")).click();
		// Next
		Thread.sleep(15000);
		driver.findElement(By.cssSelector("#shipping-method-buttons-container > div > button")).click();
		Thread.sleep(10000);
		// Place Order
		driver.findElement(
				By.xpath("//*[@id=\"checkout-payment-method-load\"]/div/div/div[2]/div[2]/div[4]/div/button")).click();
		// Click on order number to take its cost
		driver.findElement(By.xpath("//*[@id=\"maincontent\"]/div[3]/div/div[2]/p[1]/a"));
		// Add Order Cost to Array list for comparison
		OrdersCost
				.add(driver.findElement(By.xpath("//*[@id=\"my-orders-table\"]/tfoot/tr[5]/td/strong/span")).getText());
	}

	@Test(priority = 3)
	public void Test7CostCheck() throws InterruptedException {
		// System.out.println(OrdersCost);
		// Select My Account from drop down list
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("/html/body/div[1]/header/div[1]/div/ul/li[2]/span/button")).click();
		WebElement MyAccountdiv = driver.findElement(By.className("links"));
		List<WebElement> MyAccount = MyAccountdiv.findElements(By.tagName("a"));
		MyAccount.get(0).click();
		// My orders
		driver.findElement(By.xpath("//*[@id=\"block-collapsible-nav\"]/ul/li[2]/a")).click();

		for (int i = 0; i<5; i++) {

			List<WebElement> td = driver.findElements(By.className("price"));
			String Actual =td.get(i).getText() ;
			String Expected =td.get(i+1).getText() ;
			System.out.println(Actual);
			Assertion.assertEquals(Actual, Expected, "");
			Assertion.assertAll();
		}
		System.out.println("They Are all equal");
	}

}
