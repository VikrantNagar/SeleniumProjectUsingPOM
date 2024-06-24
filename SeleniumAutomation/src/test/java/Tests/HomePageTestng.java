package Tests;

import java.io.IOException;
import org.testng.annotations.Test;
import Helpers.HomePageHelper;
import Utility.TestBase;

public class HomePageTestng extends TestBase {

	@Test
	public void test_homepageTest() throws IOException, InterruptedException {

		HomePageHelper homepageHelper = new HomePageHelper(getDriver());
		homepageHelper.testHomePage();

	}
}
