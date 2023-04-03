import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import dev.failsafe.internal.util.Assert;

public class SetUP {
		     
	WebDriver driver;
	SoftAssert Assertion ;
	Random rand ;

	@BeforeTest
	public void SetUp() {
		 ChromeOptions options = new ChromeOptions();
		 options.addArguments("--remote-allow-origins=*");
		 driver=new ChromeDriver(options);
		 Assertion = new SoftAssert();
		 rand = new Random();
		 
		driver.get("https://magento.softwaretestingboard.com/");
	}

}





