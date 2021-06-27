/*
 * @author: Naveen Kumar Rajashekar
 */
package com.crm.qa.pages;

//import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'User: group automation')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	@FindBy(xpath="//td[contains(text(),'CRMPRO')]")
	WebElement homePageLogo;
	
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink() {
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealsLink() {
		dealsLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTasksLink() {
		tasksLink.click();
		return new TasksPage();
	}

	public Boolean validateCRMPROImage() {
		return homePageLogo.isEnabled();
	}
	
	public Boolean verifyUserName() {
		return userNameLabel.isDisplayed();
	}
	
	public void clickOnNewContactLink()  throws InterruptedException {
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
		newContactLink.click();
		//action.moveToElement(contactsLink).moveToElement(newContactLink).click().build().perform();
	}
	
}
