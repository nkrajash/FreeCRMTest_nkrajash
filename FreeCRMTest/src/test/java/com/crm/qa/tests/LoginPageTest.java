/*
 * @author: Naveen Kumar Rajashekar
 */

package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	
	//Initializing PageFactory
	public LoginPageTest() {
		super();   //Call the Constructor of the Super class - TestBase
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void CRMLogoImageTest() {
		Boolean b = loginPage.validateCRMImage();
		Assert.assertTrue(b);
	}
	
	@Test(priority=3)
	public void loginTest() {
		homePage = loginPage.login(props.getProperty("username"),props.getProperty("password"));
	}
	
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}

}
