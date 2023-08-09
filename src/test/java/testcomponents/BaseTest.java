package testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public WebDriver driver;

	public WebDriver intializebrowser() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resource\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		// Chrome browser

		if (browserName.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

		}
		// Edge browser

		else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

		}
		//Firefox browser
		
		else if (browserName.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();

		}

		driver.manage().window().maximize();
		return driver;

	}

	// URl name

	public void launchapplication() throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resource\\GlobalData.properties");
		prop.load(fis);
		String urlName = prop.getProperty("url");

		driver = intializebrowser();

		driver.get(urlName);
	}

	// Get Screenshot

	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = ((TakesScreenshot) driver);

		File Scrfile = ts.getScreenshotAs(OutputType.FILE);

		File destfile = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");

		FileUtils.copyFile(Scrfile, destfile);

		return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
	}

	// MouseHover method

	public void mousehover() {

		Actions action = new Actions(driver);

		action.moveToElement(driver.findElement(By.xpath("//*[@id=\"nav-link-accountList\"]")))
				.click(driver.findElement(By.className("nav-action-inner"))).build().perform();
	}
}
