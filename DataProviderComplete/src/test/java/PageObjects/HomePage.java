package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage{
	
	public HomePage(ThreadLocal<WebDriver> driver) {
		super(driver);
	}
	
	@FindBy(xpath = "//span[text()='My Account']")WebElement lnkMyAcc;
	@FindBy(linkText = "Register")WebElement lnkRegister;
	
	@FindBy(linkText = "Login")WebElement lnkLogin;
	@FindBy(name = "email")WebElement email;
	@FindBy(name = "password")WebElement password;
	@FindBy(xpath = "//button[@type='submit']")WebElement clkLoginBtn;
	
	
	public void clkMyAcc() {
		lnkMyAcc.click();
		
	}
	
	public void clkRegister() {
		lnkRegister.click();	
	}
	
	public void clkLogin() {
		lnkLogin.click();
	}
	

	public void setEmail(String e) {
		email.sendKeys(e);
	}
	public void setPswd(String p) {
		password.sendKeys(p);
	}
	public void clkLoginButton() {
	clkLoginBtn.click();
	}
	
	


}
