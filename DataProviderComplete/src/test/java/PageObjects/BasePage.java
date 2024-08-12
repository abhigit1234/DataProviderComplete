package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	public ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public JavascriptExecutor jse; 
	
	 
	
	public BasePage(ThreadLocal<WebDriver> driver) {
		this.driver = driver;
		this.jse=(JavascriptExecutor)this.driver.get();
	
		PageFactory.initElements(driver.get(), this);
	}

}
