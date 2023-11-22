package ottoBasePkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class OttoBaseClass {
	public static WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ottostore.com");
		Thread.sleep(10000); // to handle popup message, if it appears click close
	}

}
