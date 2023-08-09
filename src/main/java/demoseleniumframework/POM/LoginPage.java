package demoseleniumframework.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}

	
	@FindBy(id="ap_email")
	WebElement emailEle;
	
	@FindBy(id="continue")
	WebElement continueEle;
	
	@FindBy(id="ap_password")
	WebElement passwordEle;
	
	@FindBy(id="signInSubmit")
	WebElement signEle;
	
	@FindBy(id="input-box-otp")
	WebElement otpEle;
	
	@FindBy(id="cvf-submit-otp-button")
	WebElement submitEle;
	
	
	
	
		

	public void loginapplication(String email, String password) throws InterruptedException {
		
		{
			
				emailEle.sendKeys(email);
				continueEle.click();
				passwordEle.sendKeys(password);
				signEle.click();	
				//Thread.sleep(9000);
				
				//submitEle.click();
			
		}
		
	}
}

