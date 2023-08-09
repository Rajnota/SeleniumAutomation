package demoseleniumframework.POM;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.Utilities;

public class Dashboard extends Utilities{
	
	WebDriver driver;
	
	public Dashboard(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(id="twotabsearchtextbox")
	WebElement searchboxEle;
	
	@FindBy(xpath="//*[@aria-label='mobile']")
	WebElement searchboxtext;

	
	@FindBy(xpath="//a[@class=\"a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal\"]/span")
	List<WebElement> listofmobilesEle;
	
	@FindBy(xpath="//span[@class=\"a-size-medium a-color-base a-text-normal\"]")
	List<WebElement> singleEle;
	
	By searchwait=By.xpath("//*[@aria-label='mobile']");
	
	public void searchbox(String searchbox) throws InterruptedException
	{
		searchboxEle.sendKeys(searchbox);
		Expwait(searchwait);
		System.out.println(searchboxtext.getText());	
		searchboxtext.click();	
				
	}
	
	public List<WebElement>  productlist() throws InterruptedException
	{
		Thread.sleep(2000);
		return listofmobilesEle;
		
	} 
	
	public void getProductByName() throws InterruptedException
	{
	 
		int size=listofmobilesEle.size();
		for(int i=0;i<size;i++)
		{
			String text=listofmobilesEle.get(i).getText();
			System.out.println(text);
			if(text.contains("OnePlus Nord"))
			{
			singleEle.get(i).click();
			Thread.sleep(2000);
				break;
			}
		}
		
	}
}
