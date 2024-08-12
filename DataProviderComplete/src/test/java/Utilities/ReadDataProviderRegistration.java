package Utilities;

import org.testng.annotations.DataProvider;

import BaseClassPackage.BaseClass;

public class ReadDataProviderRegistration extends BaseClass{


	@DataProvider(name="reg")
	public Object[][] excel(){
		Object[][] data = {{firstName(),lastName(),email(),password()},{firstName(),lastName(),email(),password()}};
	return data;
	}
}
