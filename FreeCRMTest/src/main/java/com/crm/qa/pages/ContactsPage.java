/*
 * @author: Naveen Kumar Rajashekar
 */
package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath="//*[@name='title']")
	WebElement newContactTitle;
	
	@FindBy(id="first_name")		
	WebElement newContact_first_name;
	
	@FindBy(id="surname")		
	WebElement newContact_last_name;
	
	@FindBy(name="client_lookup")		
	WebElement newContact_company;
	
	@FindBy(xpath="//input[@value='Load From Company']/following-sibling::input[@value='Save']")		
	WebElement newContact_Savebtn;

	@FindBy(name="status")	
	WebElement newContact_status;

	@FindBy(id="fieldId_birthday")		
	WebElement newContact_birthday;
	
	@FindBy(id="btnClear")		
	WebElement newContact_btnClear;

	@FindBy(id="f_trigger_c_birthday")		
	WebElement newContact_ftriggerbday;
	
	
	//driver.findElement(By.xpath("//a[text()='Naveen']//parent:://td[@class='datalistrow']//preceeding-sibling::td[@class='datalistrow']//input[@name='contact_id']"));
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
		
	public Boolean verifyContactsLabel() {
		return contactsLabel.isDisplayed();
	}
	
	//Dynamic checkbox selection by name of the contact
	public void selectContactsByName(String name) {
		  String temp = name.toUpperCase(); 
	      boolean b = temp.matches("^[0-9].*$");
	      if(b) {
	    	  driver.findElement(By.xpath("//td[@class='a2z' and text()='Num']")).click();
	      }
	      else {
	    	  driver.findElement(By.xpath("//td[@class='a2z' and text()='" + temp.charAt(0) + "']")).click();
	      }
		driver.findElement(By.xpath("//a[text()='" + name + "']" 
					+ "//parent::td[@class='datalistrow']"
					+ "//preceding-sibling::td[@class='datalistrow']"
					+ "//input[@name='contact_id']")).click();
	}
	
	public void selectByFirstLetter(String letter) {
		  String temp = letter.toUpperCase();
	      boolean b = letter.matches("^[0-9].*$");
	      if(b) {
	    	  driver.findElement(By.xpath("//td[@class='a2z' and text()='Num']")).click();
	      }
	      else {
	    	  driver.findElement(By.xpath("//td[@class='a2z' and text()='" + temp.charAt(0) + "']")).click();
	      }
	}
	
	public void selectMultipleContactsByName(String name) {
		driver.findElement(By.xpath("//a[text()='" + name + "']" 
					+ "//parent::td[@class='datalistrow']"
					+ "//preceding-sibling::td[@class='datalistrow']"
					+ "//input[@name='contact_id']")).click();
	}
	

	public void createNewContact(String title, String ftname,String ltname, String company,String status) {
		Select select = new Select(newContactTitle);
		select.selectByVisibleText(title);
		newContact_first_name.sendKeys(ftname);
		newContact_last_name.sendKeys(ltname);
		newContact_company.sendKeys(company);
		
		Select select2 = new Select(newContact_status);
		select2.selectByVisibleText(status);
		
		newContact_birthday.click();
		newContact_btnClear.click();
		newContact_ftriggerbday.click();
		
		newContact_Savebtn.click();
		
		//Actions action2 = new Actions(driver);
	    //action2.clickAndHold(newContact_birthday).build().perform();
	    
	}
	
	
}
