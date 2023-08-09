package compracticesession.demoseleniumframework;

import java.io.IOException;

import org.testng.annotations.Test;

import demoseleniumframework.POM.AddToCart;
import demoseleniumframework.POM.Dashboard;
import demoseleniumframework.POM.LoginPage;

import testcomponents.BaseTest;
import testcomponents.RerunFailedTest;

public class Standalone extends BaseTest {

	@Test(retryAnalyzer=RerunFailedTest.class)

	public void firsttest() throws InterruptedException, IOException {

		launchapplication();

		mousehover();

		LoginPage loginpage = new LoginPage(driver);

		loginpage.loginapplication("8826838002", "Nss@5155");

		Dashboard ds = new Dashboard(driver);

		ds.searchbox("Mobile");

		ds.getProductByName();

		AddToCart addtocartitem = new AddToCart(driver);

		addtocartitem.addtocart();

	}

}
