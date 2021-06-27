/*
 * @author: Naveen Kumar Rajashekar
 */
package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtils;

public class HomePageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	ContactsPage contactsPage;
	DealsPage dealsPage;
	TasksPage tasksPage;
	
	//Initializing PageFactory
	public HomePageTest() {
		super();   //Call the Constructor of the Super class - TestBase
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtils = new TestUtils();
		loginPage = new LoginPage();
		homePage = loginPage.login(props.getProperty("username"),props.getProperty("password"));
		contactsPage = new ContactsPage();
		dealsPage = new DealsPage();
		tasksPage = new TasksPage();
	}
	
	@Test(priority=1)
	public void homePageTitleTest() {
		String title = homePage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","Home page title not matched.");
	}
	
	@Test(priority=2)
	public void CRMPROLogoImageTest() {
		testUtils.switchToFrame();
		Boolean b = homePage.validateCRMPROImage();
		Assert.assertTrue(b);
	}
	
	
	@Test(priority=3)
	public void CRMPROUserNameTest() {
		testUtils.switchToFrame();
		Boolean b = homePage.verifyUserName();
		Assert.assertTrue(b);
	}
	
	@Test(priority=4)
	public void verifyContactsLinkTest() {
		testUtils.switchToFrame();
		contactsPage = homePage.clickOnContactsLink();
	}
	
	
	@Test(priority=5)
	public void verifyDealsLinkTest() {
		testUtils.switchToFrame();
		dealsPage = homePage.clickOnDealsLink();
	}
	
	
	@Test(priority=6)
	public void verifyTasksLinkTest() {
		testUtils.switchToFrame();
		tasksPage = homePage.clickOnTasksLink();
	}
	
	
	@AfterMethod
	public void tearDown() {
		super.tearDown();
	}
	
}
