/*
 * @author: Naveen Kumar Rajashekar
 * 
 */

package FreeCRMTesting;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FreeCRMTest {
	WebDriver driver;
	String credentials;
	String credentials_info[];
	
	@BeforeMethod
	public void setup(){
		 System.setProperty("webdriver.chrome.driver", "C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		 driver=new ChromeDriver();//launch chrome browser

		 driver.manage().window().maximize(); //maximize the windows
		 driver.manage().deleteAllCookies(); // delete all the cookies
		 //dynamic wait
		 
		 driver.get("https://classic.crmpro.com");
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 
	}
	
	//Role based -permission based use case
	//admin
	//superuser
	//customer
	//seller	
	//distributor
	//delivery boy
	
	@Test(priority=1)
	public void loginWithGroupUserTest() throws InterruptedException {
		
		 credentials = Data.getUserLoginInfo().get("groupautomation"); //Get groupautomation credentials
		 credentials_info = credentials.split("_");
		 driver.findElement(By.name("username")).sendKeys(credentials_info[0]);
		 driver.findElement(By.name("password")).sendKeys(credentials_info[1]);
		 WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 //Using JavascriptExecutor
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", loginBtn);
		 
		 Thread.sleep(1000);
		 driver.switchTo().frame("mainpanel");
		 driver.findElement(By.xpath("//a[contains(text(),'Calendar')]")).click();
		 Select select = new Select(driver.findElement(By.name("slctMonth")));
		 select.selectByVisibleText(Data.monthMap().get(10));
	}
	
	@Test(priority=2)
	public void loginWithCustomerUserTest() {
		
		 credentials = Data.getUserLoginInfo().get("customer"); //Get customer credentials
		 credentials_info = credentials.split("_");
		 driver.findElement(By.name("username")).sendKeys(credentials_info[0]);
		 driver.findElement(By.name("password")).sendKeys(credentials_info[1]);
		 WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 //Using JavascriptExecutor
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", loginBtn);
		 
	}
		 
	@AfterMethod
	public void tearDown() {
		 driver.quit();
	}
		 
}
