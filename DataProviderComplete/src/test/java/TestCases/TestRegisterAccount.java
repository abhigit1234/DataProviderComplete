package TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import BaseClassPackage.BaseClass;
import PageObjects.HomePage;
import PageObjects.RegisterAccount;
import Utilities.ReadDataProviderRegistration;

public class TestRegisterAccount extends BaseClass{
	HomePage hp;
	RegisterAccount rg;
	
	@Test(dataProviderClass = ReadDataProviderRegistration.class,dataProvider = "reg")
	public void test1(String[] s) {
		log.info("****started register my account********");
		hp = new HomePage(driver);
		rg = new RegisterAccount(driver);
		log.info("click on my acc");	
		log.trace("null");
		hp.clkMyAcc();
		log.info("click on Regisetr from frop down menu");
		
		hp.clkRegister();
		
		rg.setFname(s[0]);
		rg.setLname(s[1]);
		rg.setemail(s[2]);
		rg.setPswd(s[3]);
		rg.clkAgree();
		rg.clkSubmitBtn();
		log.info("verified success message after login");
		System.out.println(rg.verifySuccessRegisterd()); 
		
		assertEquals(rg.verifySuccessRegisterd(),"Your Account Has Been Created!");	
		log.info("clicked on logout");
		
		rg.clkLogout();
		log.info("click on Continuew button to return home page");
		
		rg.clkBtnContinue();
		
		log.info("****ended register my account********");
	}
	
	
	
}
