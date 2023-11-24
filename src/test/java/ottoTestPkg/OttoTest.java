package ottoTestPkg;

import org.testng.annotations.Test;

import ottoBasePkg.OttoBaseClass;
import ottoPagePkg.OttoPage;

public class OttoTest extends OttoBaseClass {

	@Test
	public void test() {
		OttoPage cp = new OttoPage(driver);
		cp.searchItem();
		cp.selectProduct();
		cp.productPage();
		cp.checkoutPage();
		cp.titleVerification();
		cp.chooseShirt();
		cp.storeLocator();

	}
}
