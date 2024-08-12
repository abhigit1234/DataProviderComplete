package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
	
	public MyAccountPage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//h2[text()='My Account']")WebElement validateMyAccMessage;
	@FindBy(linkText = "Logout")WebElement lnkLogout;
	@FindBy(linkText = "Continue")WebElement lnkContinue;
		
	public boolean verifyMyAccountMessage() {
		boolean b =validateMyAccMessage.isDisplayed();
		System.out.println(b);
		return b;
	}
	
	public void clkLogout() {
	jse.executeScript("arguments[0].click()",lnkLogout);
	}

	public void clkContinue() {
		jse.executeScript("arguments[0].click()",lnkContinue);
	}

	
	
	
}
