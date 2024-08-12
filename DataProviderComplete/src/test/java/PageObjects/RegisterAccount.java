package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterAccount extends BasePage {

	public RegisterAccount(ThreadLocal<WebDriver> driver) {
		super(driver);
	}

	@FindBy(name = "firstname")
	WebElement fname;
	@FindBy(name = "lastname")
	WebElement lname;
	@FindBy(name = "email")
	WebElement email;
	@FindBy(name = "password")
	WebElement password;
	@FindBy(name = "agree")
	WebElement agree;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement clkBtnSubmit;
	@FindBy(xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement verifyAccRegSucc;
	@FindBy(linkText = "Logout")
	WebElement lnkLogout;
	@FindBy(linkText = "Continue")
	WebElement lnkContinue;

	public void setFname(String fn) {
		fname.sendKeys(fn);
	}

	public void setLname(String ln) {
		lname.sendKeys(ln);
	}

	public void setemail(String e) {
		email.sendKeys(e);
	}

	public void setPswd(String p) {
		password.sendKeys(p);
	}

	public void clkAgree() {
		jse.executeScript("arguments[0].click()", agree);
	}

	public void clkSubmitBtn() {
		jse.executeScript("arguments[0].click()", clkBtnSubmit);
	}

	public String verifySuccessRegisterd() {
		try {
			return verifyAccRegSucc.getText();
		} catch (Exception e) {
			return e.getMessage();
		}

	}

	public void clkLogout() {
		jse.executeScript("arguments[0].click()", lnkLogout);
	}

	public void clkBtnContinue() {
		jse.executeScript("arguments[0].click()", lnkContinue);
	}

}
