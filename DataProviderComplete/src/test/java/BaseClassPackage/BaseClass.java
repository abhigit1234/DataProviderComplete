package BaseClassPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseClass {


	public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	public FileInputStream fis;
	public Properties p;
	public Logger log; 
	
public BaseClass () {
		
		try {
			fis = new FileInputStream("./src/test/resources/config.properties");
			p=new Properties();
			p.load(fis);
			
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
		}catch(IOException e) {
			System.out.println(e.getMessage());
		}
		
		}
	
	
	
	@Parameters({"browser","url"})
	@BeforeMethod
	
	public void setup(String browser,String url) {
		
		log = LogManager.getLogger(this.getClass());
		if(browser.equals("chrome")) {
			log.info("launched chrome browser");
			driver.set( new ChromeDriver());
		}else if(browser.equals("chrome")) {
			log.info("launched firefox browser");
			driver.set(new FirefoxDriver());
		}else {
			log.info("launched edge browser");
			driver.set(new EdgeDriver());
		}
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		log.info("launched url");
		
		driver.get().get(p.getProperty("url"));
	}

	@AfterMethod
	public void tearDown() {
		log.info("closed browser after execution is completed");
		driver.get().close();
		driver.remove();
	}

	
	public String firstName() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	public String lastName() {
		return RandomStringUtils.randomAlphabetic(5);
	}
	
	public String email() {
		return	RandomStringUtils.randomAlphanumeric(10)+"@gmail.com";
		
	}
	public String password() {
		return RandomStringUtils.randomAlphanumeric(8);
	}

	

}
