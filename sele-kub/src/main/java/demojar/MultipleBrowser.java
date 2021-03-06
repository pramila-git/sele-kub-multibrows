package demojar;

import static org.junit.Assert.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MultipleBrowser {
	WebDriver driver;
	String url="https://www.google.com/";
	Properties pro;
	@Before
	public void setUp() throws Exception {
		try{
			/*File src= new File("Property.properties");
			FileInputStream fis = new FileInputStream(src);*/
			pro=new Properties();
			pro.load(MultipleBrowser.class.getResourceAsStream("/Property.properties"));
			//pro.load(fis);
		}catch(Exception e){
			System.out.println("Exception is=="+e.getMessage());
		}
		
		/*DesiredCapabilities dcp = new DesiredCapabilities();
		dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		dcp.setCapability("name", "GoogleTest");
		dcp.setCapability("idleTimeout", 150);*/
		//driver = new RemoteWebDriver(new URL("http://35.193.7.170:4444/wd/hub"),dcp);
		//System.out.println(pro.getProperty("selenium.url"));
		//driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");
		/*System.setProperty("webdriver.chrome.driver",pro.getProperty("chrome.driver").toString());
		//Open browser instance
		driver = new ChromeDriver();*/
		//driver.get(url);
		//System.out.println("Opening Google");
		//Thread.sleep(100);
		/*
		import org.openqa.selenium.support.ui.ExpectedConditions;
		import org.openqa.selenium.support.ui.WebDriverWait;

		WebDriverWait wait;
		wait = new WebDriverWait(driver,1000);

		Thread.sleep(100);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("News"))).click();
		System.out.println("Clicked on News");
		Thread.sleep(100);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Videos"))).click();
		System.out.println("Clicked on Videos");
		Thread.sleep(100);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Images"))).click();
		System.out.println("Clicked on Images");
		Thread.sleep(100);
		wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Books"))).click();
		System.out.println("Clicked on Books");
		Thread.sleep(100);
		*/
	}

	@After
	public void tearDown() throws Exception {
		//driver.close();
		driver.quit();
	}

	@Test
	public void test() throws Exception {
		//Chrome
		DesiredCapabilities dcp = new DesiredCapabilities();
		dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.CHROME);
		dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		dcp.setCapability("name", "GoogleTestChrome");
		dcp.setCapability("idleTimeout", 150);
		//driver = new RemoteWebDriver(new URL("http://35.193.7.170:4444/wd/hub"),dcp);
		//System.out.println(pro.getProperty("selenium.url"));
		driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");
		/*System.setProperty("webdriver.chrome.driver",pro.getProperty("chrome.driver").toString());
		//Open browser instance
		driver = new ChromeDriver();*/
		driver.get(url);
		System.out.println("Opening Google");
		Thread.sleep(100);
		
		//Test
		System.out.println("Page Title:"+driver.getTitle());
		//driver.findElement(By.id("lst-ib")).sendKeys("Kubernetes");
		driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(pro.getProperty("searchword"));
		System.out.println("Data entered to search");
		Thread.sleep(100);
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.id("lst-b")).sendKeys(Keys.ENTER);
		driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(Keys.ENTER);
		System.out.println("search clicked");
		//Cookie cookie = new Cookie("zaleniumTestPassed", "true");
	    //driver.manage().addCookie(cookie);
		Thread.sleep(100);
		
		//firefox
		dcp = new DesiredCapabilities();
		dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		dcp.setCapability("name", "GoogleTestFirefox");
		dcp.setCapability("idleTimeout", 150);
		//driver = new RemoteWebDriver(new URL("http://35.193.7.170:4444/wd/hub"),dcp);
		//System.out.println(pro.getProperty("selenium.url"));
		driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");
		/*System.setProperty("webdriver.chrome.driver",pro.getProperty("chrome.driver").toString());
		//Open browser instance
		driver = new ChromeDriver();*/
		driver.get(url);
		System.out.println("Opening Google");
		Thread.sleep(100);
		
		//Test
		System.out.println("Page Title:"+driver.getTitle());
		//driver.findElement(By.id("lst-ib")).sendKeys("Kubernetes");
		driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(pro.getProperty("searchword"));
		System.out.println("Data entered to search");
		Thread.sleep(100);
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.id("lst-b")).sendKeys(Keys.ENTER);
		driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(Keys.ENTER);
		System.out.println("search clicked");
		//Cookie cookie = new Cookie("zaleniumTestPassed", "true");
	    //driver.manage().addCookie(cookie);
		Thread.sleep(100);
	}
	@Test
	public void test1() throws Exception {
		//Chrome
		DesiredCapabilities dcp = new DesiredCapabilities();
		dcp.setCapability(CapabilityType.BROWSER_NAME, BrowserType.FIREFOX);
		dcp.setCapability(CapabilityType.PLATFORM, Platform.LINUX);
		dcp.setCapability(CapabilityType.SUPPORTS_APPLICATION_CACHE, true);
		dcp.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
		dcp.setCapability("name", "GoogleTest2Firefox");
		dcp.setCapability("idleTimeout", 150);
		//driver = new RemoteWebDriver(new URL("http://35.193.7.170:4444/wd/hub"),dcp);
		//System.out.println(pro.getProperty("selenium.url"));
		driver = new RemoteWebDriver(new URL(pro.getProperty("selenium.url")),dcp);
		//System.setProperty("webdriver.chrome.driver","D:\\driver\\chromedriver_win32\\chromedriver.exe");
		/*System.setProperty("webdriver.chrome.driver",pro.getProperty("chrome.driver").toString());
		//Open browser instance
		driver = new ChromeDriver();*/
		driver.get(url);
		System.out.println("Opening Google");
		Thread.sleep(100);
		
		//Test
		System.out.println("Page Title:"+driver.getTitle());
		//driver.findElement(By.id("lst-ib")).sendKeys("Kubernetes");
		driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys("zalenium");
		System.out.println("another Data entered to search");
		Thread.sleep(100);
		//driver.findElement(By.name("btnK")).click();
		//driver.findElement(By.id("lst-b")).sendKeys(Keys.ENTER);
		driver.findElement(By.id(pro.getProperty("searchbox"))).sendKeys(Keys.ENTER);
		System.out.println("search clicked");
		//Cookie cookie = new Cookie("zaleniumTestPassed", "true");
	    //driver.manage().addCookie(cookie);
		Thread.sleep(100);
	}
}
