/*
 * @author: Naveen Kumar Rajashekar
 */
package com.crm.qa.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtils;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	TestUtils testUtils;
	ContactsPage contactsPage;
	String sheetName = "contacts";
	
	//Initializing PageFactory
		public ContactsPageTest() {
			super();   //Call the Constructor of the Super class - TestBase
		}
		
		@BeforeMethod
		public void setUp() {
			initialization();
			testUtils = new TestUtils();
			loginPage = new LoginPage();
			contactsPage = new ContactsPage();
			homePage = loginPage.login(props.getProperty("username"),props.getProperty("password"));
			//switch to Frame and then click on the Contacts
			testUtils.switchToFrame();
			//contactsPage = homePage.clickOnContactsLink();
		}

		@Test(priority=1)
		public void verifyContactsPageLabel() {
			contactsPage = homePage.clickOnContactsLink();
			Assert.assertTrue(contactsPage.verifyContactsLabel(),"contacts label missing on the page.");
		}
		
		
		@Test(priority=2)
		public void selectsSingleContactsTest() {
			contactsPage = homePage.clickOnContactsLink();
			contactsPage.selectContactsByName("Naveen Kumar Rajashekar");
			contactsPage.selectContactsByName("navya namoju");
			contactsPage.selectContactsByName("Nandhini Murugesan");
			contactsPage.selectContactsByName("12345@Naveen Kerudi");
			contactsPage.selectContactsByName("01Kane William"); 
		}
		
		@Test(priority=3)
		public void selectsMultipleContactsTest(){
			contactsPage = homePage.clickOnContactsLink();
			contactsPage.selectByFirstLetter("N");
			contactsPage.selectMultipleContactsByName("Naveen Kumar Rajashekar");
			contactsPage.selectMultipleContactsByName("navya namoju");
			contactsPage.selectMultipleContactsByName("Nandhini Murugesan");
			contactsPage.selectByFirstLetter("1");
			contactsPage.selectMultipleContactsByName("12345@Naveen Kerudi");
			contactsPage.selectMultipleContactsByName("01Kane William"); 
		}
		
		@DataProvider()
		public Object [][] getCRMTestData () throws IOException{
			Object data  [][] = TestUtils.getTestData(sheetName);
			return data;
		}
		
		
		@Test(priority=4, dataProvider = "getCRMTestData")
		public void validateCreateNewContact(String title, String ftname,String ltname, String company,String status) throws InterruptedException {
			homePage.clickOnNewContactLink();
			//contactsPage.createNewContact("Mr.","Tom","Peter","Google","Active");
			contactsPage.createNewContact(title,ftname,ltname,company,status);
		}
		
		@AfterMethod
		public void tearDown() {
			super.tearDown();
		}
}

//Note:
//Enable a test runner class called - testng.xml file to run all the test classes execution in a sequence. 
//Instead of running say 100 test classes each test  java file class one by one as TestNG Suite
