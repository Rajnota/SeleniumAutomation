package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utilities {
	
	WebDriver driver;
	public Utilities(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void Expwait(By findBy)
	{
	WebDriverWait wait = new WebDriverWait(driver, 2000);
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
			
	

}
