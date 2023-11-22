package ottoPagePkg;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import ottoBasePkg.OttoBaseClass;

public class OttoPage extends OttoBaseClass {

//------------------------------------Home Page----------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[1]/div[1]")
	WebElement searchIcon;

	@FindBy(xpath = "//*[@id=\"HeaderSearchForm\"]/input[2]")
	WebElement searchchBox;
	// ------------------------------------Home
	// Page----------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"MainContent\"]/div/div/div/div[1]/div[2]/div[1]/div/a/div[2]/div[1]")
	WebElement item;
//------------------------------------Product Page----------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"ProductSelect-7011730751646-option-0\"]/div[2]/label")
	WebElement mediumSize;

	@FindBy(xpath = "//*[@id=\"AddToCartForm-7011730751646\"]/div[3]/div/button[2]")
	WebElement updateQty;

	@FindBy(xpath = "//*[@id=\"AddToCart-7011730751646\"]")
	WebElement addToCart;

	@FindBy(xpath = "//*[@id=\"CartContainer\"]/div[2]/button")
	WebElement checkoutBtn;
//------------------------------------Product Page----------------------------------------------------------------
//------------------------------------Checkout Page----------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement email;

	@FindBy(xpath = "//*[@id=\"TextField0\"]")
	WebElement firstName;

	@FindBy(xpath = "//*[@id=\"TextField1\"]")
	WebElement lastName;

	@FindBy(xpath = "//*[@id=\"shipping-address1\"]")
	WebElement shippingAddress;

	@FindBy(xpath = "//*[@id=\"TextField2\"]")
	WebElement city;

	@FindBy(xpath = "//*[@id=\"Select1\"]")
	WebElement state;

	@FindBy(xpath = "//*[@id=\"TextField3\"]")
	WebElement pincode;

	@FindBy(xpath = "//*[@id=\"TextField4\"]")
	WebElement phone;

	@FindBy(xpath = "//*[@id=\"app\"]/div/div/div/div[1]/div[1]/div/div[1]/div[2]/div/div/div/div/header/div[1]/h1/span[1]/a")
	WebElement logoHome;
//------------------------------------Checkout Page------------------------------------------------------------------------------
//------------------------------------Home Page-----------------------------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[2]/div[1]/ul/li[2]/a")
	WebElement shirts;

	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[2]/div[1]/ul/li[2]/ul/li[3]/a")
	WebElement printShirts;
//------------------------------------Home Page-----------------------------------------------------------------------------------
//------------------------------------Store Location Page-------------------------------------------------------------------------
	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[2]/div[3]/ul/li[4]/a")
	WebElement storeLocation;

	@FindBy(xpath = "//*[@id=\"shopify-section-header\"]/div[3]/div[2]/div/div/header/div[1]/div/div[3]/div/div/a[3]/span")
	WebElement cart;

	@FindBy(xpath = "//*[@id=\"CartDrawer\"]/form/div[1]/div/div[2]/button")
	WebElement closeCart;
//------------------------------------Store Location Page--------------------------------------------------------------------------

	public OttoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchItem() {

		searchIcon.click();
		searchchBox.sendKeys("pants", Keys.ENTER);

	}

	public void selectProduct() {
		item.click();
	}

	public void productPage() {
		mediumSize.click();
		updateQty.click();
		addToCart.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		checkoutBtn.click();
	}

	public void checkoutPage() {
		email.sendKeys("abc@gmail.com");
		firstName.sendKeys("Ab");
		lastName.sendKeys("Rahul");
		shippingAddress.sendKeys("ak apaterment near lkg school");
		city.sendKeys("Pmna");
		state.click();

		Select stateName = new Select(state);
		stateName.selectByValue("KL");

		pincode.sendKeys("679322");
		phone.sendKeys("8891140696");
		logoHome.click();

	}

	public void titleVerification() {
		String actualTitle = driver.getTitle();
		String expTitle = "Otto";

		if (actualTitle.equals(expTitle)) {
			driver.navigate().refresh();
		} else {
			System.out.println("Title verification failed");
		}
	}

	public void chooseShirt() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Actions act = new Actions(driver);
		act.moveToElement(shirts).perform();
		;

		wait.until(ExpectedConditions.visibilityOf(printShirts));
		printShirts.click();
		driver.navigate().back();

	}

	public void storeLocator() {
		storeLocation.click();
		cart.click();
		closeCart.click();
		driver.navigate().back();
	}

}
