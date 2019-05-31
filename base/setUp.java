package com.pack.base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.pack.pageobjects.common_POM;
import com.pack.pageobjects.funcTestingPage_POM;
import com.pack.pageobjects.homePage_POM;

public class setUp {

	protected WebDriver driver;
	protected homePage_POM obj1;
	protected common_POM obj3;
	protected funcTestingPage_POM obj4;
	protected String tab1;
	
	@Parameters({ "browserType", "baseUrl" })
	@BeforeTest
	public void startDriver(String browserType, String baseUrl) {
		this.driver = setDriver(browserType, baseUrl);
		obj1 = new homePage_POM(driver);
		obj3= new common_POM(driver);
		obj4=new funcTestingPage_POM(driver);
	}
	
	@DataProvider(name = "socialMedia")
	public static Object[][] socialMedia() {
		return new Object[][] { { "LINKEDIN" }, { "TWITTER" }, { "FACEBOOK" } };
	}
	
	@DataProvider(name="servicesMenuLinks")
	public static Object[][] linkNames() {
		return new Object[][]{{"pi-Functional-Testing"},{"pi-Test-Automation"},{"pi-Performance-Testing"}};
	}
	
	private WebDriver setDriver(String browserType, String baseUrl) {
		switch (browserType) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver","C:\\Users\\Balpreet.kaur\\Downloads\\geckodriver-v0.19.1-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(baseUrl);
			break;
		case "chrome":
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver", "C:\\selenium_drivers\\chromedriver_win32");
			break;
		default:
			System.out.println("Invalid driver type" + browserType);
			break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	@AfterTest
	public void tearDown() {
		this.driver.quit();
	}
}