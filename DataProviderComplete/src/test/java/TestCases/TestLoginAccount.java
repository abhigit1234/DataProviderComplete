package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseClassPackage.BaseClass;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;

public class TestLoginAccount extends BaseClass{
	
	
	@Test
	public void login() {
	HomePage hp = new HomePage(driver);
	log.info("*****started login test**********");
	hp.clkMyAcc();
	log.info("clicked on my account from dropdown");
	hp.clkLogin();
	hp.setEmail(p.getProperty("email"));
	hp.setPswd(p.getProperty("password"));
	hp.clkLoginButton();
	
	MyAccountPage myacc = new MyAccountPage(driver);
	boolean b =	myacc.verifyMyAccountMessage();
	if(b==true) {
		 assertTrue(true,"My Account");
	}else {
		assertTrue(false);
	}
	
	log.info("*****ended login test**********");
	}
	
	
	
}
