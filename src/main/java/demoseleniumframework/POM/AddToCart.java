package demoseleniumframework.POM;



import java.util.Set;

import javax.swing.text.html.HTMLDocument.Iterator;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utilities;

public class AddToCart extends Utilities {
	WebDriver driver;
	
	public AddToCart(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

	@FindBy(id="add-to-cart-button")
	WebElement addtocartEle;
	
	@FindBy(xpath="//div[@class=\"a-row a-spacing-top-small\"]/span")
	WebElement checkoutEle;
	
	By checkwait=By.xpath("//div[@class=\"a-row a-spacing-top-small\"]/span");
			
	
	public void addtocart()
	{
		
		String parent=driver.getWindowHandle();
		Set<String>st=driver.getWindowHandles();
		java.util.Iterator<String> it=  st.iterator();
		
		while(it.hasNext())
		{
			String child=it.next();
			System.out.println(child);
		
		//String child ="";
		if(!parent.equals(child))
		{
			driver.switchTo().window(child);
			String Title=driver.switchTo().window(child).getCurrentUrl();
			System.out.println(Title);
			if(Title.contains("https://www.amazon.in/OnePlus-Misty-Green"))
			{
				JavascriptExecutor js=(JavascriptExecutor)driver;
				js.executeScript("window.scrollBy(0,200)");
				
				addtocartEle.click();
				Expwait(checkwait);
				checkoutEle.click();
				
				driver.quit();
			}
		}
		}
		
		
	}



	
}
