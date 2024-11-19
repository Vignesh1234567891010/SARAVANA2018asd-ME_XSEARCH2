package _ME_XSEARCH2_IMPLEMENATAION;

import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
	
	WebDriver driver;
	
	public TestCases() throws MalformedURLException{
		
		System.out.println("Constructor: TestCases");
		
		WebDriverManager.chromedriver().timeout(30).setup();
		ChromeOptions options=new ChromeOptions();
		driver=new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		
	}
	
	public void endTest() {
		
		System.out.println("End Test: TestCases");
		driver.close();
		driver.quit();
		
	}
	
	public void testCase01() throws InterruptedException {
		
		System.out.println("Start Test case: testCase01");
		driver.get("https://www.wikipedia.org/");
		Thread.sleep(5000);
		
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("wikipedia")) {
			System.out.println("Test Case 01: Passed");
		}
		else {
			System.out.println("Test Case 02: Failed");
		}
		System.out.println("end Test case: testCase01");
	}
	
	public void testCase02() throws InterruptedException {
		
		System.out.println("Start Test case: testCase02");
		driver.get("https://www.wikipedia.org/");
		Thread.sleep(5000);
		
		WebElement header=driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/main/div[1]/h1/span"));
		if(header.getText().contains("Wikipedia")) {
			System.out.println("Header verification passed");
		}
		else {
			System.out.println("Header verification failed");
		}
		
		WebElement footer=driver.findElement(By.xpath("//*[@id='www-wikipedia-org']/footer/p"));
		if((footer.getText().contains("Term of Use")) && (footer.getText().contains("Privacy Policy"))) {
			System.out.println("Footer verification passed");
		}
		else {
			System.out.println("Footer verification failed");
		}
		System.out.println("end Test case: testCase02");
	}
	
	public void testCase03() throws InterruptedException{
		
		System.out.println("Start Test case: testCase03");
		driver.get("https://www.wikipedia.org/");
		Thread.sleep(5000);
		
		WebElement searchBox=driver.findElement(By.id("searchInput"));
		searchBox.sendKeys("apple");
		searchBox.submit();
		
		WebElement appleIncLink=driver.findElement(By.linkText("Apple Inc."));
		appleIncLink.click();
		Thread.sleep(5000);
		
		WebElement founderSection=driver.findElement(By.xpath("//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[9]/td"));
		if(founderSection.getText().contains("Steve Jobs")) {
			System.out.println("Founder verification passed");
		}
		else {
			System.out.println("Founder verification failed");
		}
		System.out.println("end Test case: testCase03");
	}
	
	public void testCase04() throws InterruptedException{
		
		System.out.println("Start Test case: testCase04");
		driver.get("https://www.wikipedia.org/");
		Thread.sleep(5000);
		
		WebElement searchBox=driver.findElement(By.id("searchInput"));
		searchBox.sendKeys("microsoft");
		searchBox.submit();
		
		WebElement microsoftLink=driver.findElement(By.linkText("Microsoft"));
		microsoftLink.click();
		Thread.sleep(5000);
		
		WebElement founderSection=driver.findElement(By.xpath("//*[@id='mw-content-text']/div[1]/table[1]/tbody/tr[8]/td"));
		if(founderSection.getText().contains("Bill Gates")) {
			System.out.println("Founder verification passed");
			WebElement billGatesLink=driver.findElement(By.linkText("Bill Gates"));
			billGatesLink.click();
			Thread.sleep(5000);
			String currentUrl=driver.getCurrentUrl();
			if(currentUrl.contains("Bill_Gates")) {
				System.out.println("The opened url contains Bill_Gates: Passed");
			}
			else {
				System.out.println("The opened url contains Bill_Gates: Failed");
			}
		}
		else {
			System.out.println("Founder Verification Failed");
		}
		System.out.println("end Test case: testCase04");
	}
	
	public void testCase05() throws InterruptedException{
		
		System.out.println("Start Test case: testCase05");
		driver.get("https://en.wikipedia.org/");
		
		WebElement mainMenu=driver.findElement(By.id("vector-main-menu-dropdown-checkbox"));
		mainMenu.click();
		Thread.sleep(5000);
		
		WebElement aboutLink=driver.findElement(By.linkText("About Wikipedia"));
		aboutLink.click();
		Thread.sleep(5000);
		
		String currentUrl=driver.getCurrentUrl();
		if(currentUrl.contains("About")) {
			System.out.println("The opened url contains About: passed");
		}
		else {
			System.out.println("The opened url contains About: failed");
		}
		System.out.println("end Test case: testCase05");
	}
}
