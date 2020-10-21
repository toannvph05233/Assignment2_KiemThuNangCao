package com.javacodegeeks.testng.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGSeleniumBrowserCfgExample {
	private WebDriver driver;	
	String title = "";
	private By bySearchButton = By.name("btnK");
	private By byButtonfirst = By.name("btnI");
	
	@BeforeMethod
	public void initDriver() throws Exception {
			System.setProperty("webdriver.chrome.driver", "D:/FPT/kiemthunangcao/chromedriver_win32/chromedriver.exe");
			driver = new ChromeDriver();
	}
	@Test()
	public void Google() {
		System.out.println("Search number in google");
		driver.navigate().to("http://www.google.com");		
		title = driver.getTitle();
		Assert.assertEquals("Google", title);
	}
	
	//Test ButtonSearch
	@Test
	public void getAttribute_ButtonName() {
		driver.navigate().to("http://www.google.com");
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Name of the button is:- " + googleSearchBtn.getAttribute("name"));
		Assert.assertEquals("btnK", googleSearchBtn.getAttribute("name"));
	}

	@Test
	public void getAttribute_Id() {
		driver.navigate().to("http://www.google.com");
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Id of the button is:- "+ googleSearchBtn.getAttribute("id"));
		Assert.assertEquals("", googleSearchBtn.getAttribute("id"));
	}

	@Test
	public void getAttribute_class() {
		driver.navigate().to("http://www.google.com");
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Class of the button is:- "+ googleSearchBtn.getAttribute("class"));
		Assert.assertEquals("gNO89b", googleSearchBtn.getAttribute("class"));

	}
	@Test
	public void getAttribute_value() {
		driver.navigate().to("http://www.google.com");
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Class of the button is:- "+ googleSearchBtn.getAttribute("value"));
		Assert.assertEquals("Tìm với Google", googleSearchBtn.getAttribute("value"));

	}

	@Test
	public void getAttribute_InvalidAttribute() {
		driver.navigate().to("http://www.google.com");
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("status of the button is:- "+ googleSearchBtn.getAttribute("status"));
		Assert.assertEquals(null, googleSearchBtn.getAttribute("status"));
	}
	
	@Test
	public void getAttribute_ButtonLabel() {
		driver.navigate().to("http://www.google.com");
		WebElement googleSearchBtn = driver.findElement(bySearchButton);
		System.out.println("Label of the button is:- "+ googleSearchBtn.getAttribute("aria-label"));
		Assert.assertEquals("Tìm với Google", googleSearchBtn.getAttribute("aria-label"));

	}
	
	//Test Openfirst
	@Test
	public void getAttribute_ButtonOpenFirst_Label() {
		driver.navigate().to("http://www.google.com");
		WebElement googleButtonfirst = driver.findElement(byButtonfirst);
		System.out.println("Label of the button is:- "+ googleButtonfirst.getAttribute("aria-label"));
		Assert.assertEquals("Xem trang đầu tiên tìm được", googleButtonfirst.getAttribute("aria-label"));

	}
	@Test
	public void getAttribute_ButtonOpenFirst_Value() {
		driver.navigate().to("http://www.google.com");
		WebElement googleButtonfirst = driver.findElement(byButtonfirst);
		System.out.println("value of the button is:- "+ googleButtonfirst.getAttribute("value"));
		Assert.assertEquals("Xem trang đầu tiên tìm được", googleButtonfirst.getAttribute("value"));
		
	}
	@Test
	public void getAttribute_ButtonOpenFirst_Class() {
		driver.navigate().to("http://www.google.com");
		WebElement googleButtonfirst = driver.findElement(byButtonfirst);
		System.out.println("class of the button is:- "+ googleButtonfirst.getAttribute("class"));
		Assert.assertEquals("RNmpXc", googleButtonfirst.getAttribute("class"));
		
	}
	
	//Test Enghlish
	@Test()
	public void GoogleEnghlish_ButtonOpenFirst() {
		driver.navigate().to("http://www.google.com");	
		driver.findElement(By.id("SIvCob")).click();
		WebElement googleButtonfirst = driver.findElement(byButtonfirst);
		System.out.println("value of the button is:- "+ googleButtonfirst.getAttribute("value"));
		Assert.assertEquals("I'm Feeling Lucky", googleButtonfirst.getAttribute("value"));
	}
	
	@Test()
	public void GoogleEnghlish_ButtonSearch() {
		driver.navigate().to("http://www.google.com");	
		driver.findElement(By.id("SIvCob")).click();
		WebElement googleButtonSearch = driver.findElement(bySearchButton);
		System.out.println("value of the button is:- "+ googleButtonSearch.getAttribute("value"));
		Assert.assertEquals("Google Search", googleButtonSearch.getAttribute("value"));
	}
	
	

	// Test Search and submit.
	@Test()
	public void searchGoogleNumber() {
		System.out.println("Search number in google");
		driver.navigate().to("http://www.google.com");		
		WebElement element = driver.findElement(By.name("q"));
		
		System.out.println("Enter " + 5);
		element.sendKeys("5");
		
		System.out.println("submit");
		element.submit();
		title = driver.getTitle();
		Assert.assertEquals("5 - Tìm với Google", title);
	}
	
	@Test()
	public void searchGoogleCharacters() {
		System.out.println("Search number in google");
		driver.navigate().to("http://www.google.com");		
		WebElement element = driver.findElement(By.name("q"));
		
		System.out.println("Enter -");
		element.sendKeys("-");
		
		System.out.println("submit");
		element.submit();
		title = driver.getTitle();
		Assert.assertEquals("- - Tìm với Google", title);
	}
	
	@Test()
	public void searchGoogleSpecial() {
		System.out.println("Search number in google");
		driver.navigate().to("http://www.google.com");		
		WebElement element = driver.findElement(By.name("q"));
		
		System.out.println("Enter #");
		element.sendKeys("#");
		
		System.out.println("submit");
		element.submit();
		title = driver.getTitle();
		Assert.assertEquals("# - Tìm với Google", title);
	}
	
	
	@Test(dataProvider = "searchStrings")
	public void searchGoogle(final String searchKey) {
		  
		System.out.println("Search " + searchKey + " in google");
		driver.navigate().to("http://www.google.com");		
		WebElement element = driver.findElement(By.name("q"));
		
		System.out.println("Enter " + searchKey);
		element.sendKeys(searchKey);
		
		System.out.println("submit");
		element.submit();
		 (new WebDriverWait(driver, 5)).until(new ExpectedCondition<Boolean>() {
	            public Boolean apply(WebDriver d) {
	            	System.out.println("-------------------------");
	            	System.out.println(d.getTitle());
	            	
	            	System.out.println("-------------------------");
	                return d.getTitle().toLowerCase().startsWith(searchKey.toLowerCase());
	            }
	        });
		System.out.println("Got " + searchKey + " results");
	}

	@DataProvider
	private Object[][] searchStrings() {
		return new Object[][] { {"jhonToan"},{"FPT"}};
	}

	@AfterMethod
	public void quitDriver() throws Exception {
		driver.quit();
	}	
}
