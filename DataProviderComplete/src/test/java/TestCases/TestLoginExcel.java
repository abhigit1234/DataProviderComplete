package TestCases;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import BaseClassPackage.BaseClass;
import PageObjects.HomePage;
import PageObjects.MyAccountPage;
import Utilities.ReadExcel;

public class TestLoginExcel extends BaseClass{
	
//	  Data is valid - login success - testPass - logout 
//	  Data is valid - login failed -testfail
	  
//	  Data is invalid - login success - testfail 
//	  Data is invalid - login failed -testpass
	 
	
	@Test(dataProviderClass = ReadExcel.class,dataProvider = "a")
	public void testLogin(String user,String pswd,String exp) {
		System.out.println(Thread.currentThread().threadId());
		HomePage hp = new HomePage(driver);
		log.info("*****started login test**********");
		hp.clkMyAcc();
		log.info("clicked on my account from dropdown");
		hp.clkLogin();
		hp.setEmail(user);
		hp.setPswd(pswd);
		hp.clkLoginButton();
		
		MyAccountPage myacc = new MyAccountPage(driver);
		boolean b =	myacc.verifyMyAccountMessage();
		if(exp.equalsIgnoreCase("valid")) {
			if(b==true) {
				assertTrue(true);
				myacc.clkLogout();
				myacc.clkContinue();
			}else {
				assertTrue(false);
			}
		}
		if(exp.equalsIgnoreCase("invalid")) {
			if(b==true) {
				assertFalse(true);
				myacc.clkLogout();
				myacc.clkContinue();
			}else {
				assertFalse(false);
			}
		}
		
		
	}
	
	
	
	
}
