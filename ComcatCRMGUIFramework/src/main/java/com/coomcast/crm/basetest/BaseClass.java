package com.coomcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcat.crm.genric.databaseutility.DataBaseUtility;
import com.comcat.crm.genric.fileUtility.ExcelUtility;
import com.comcat.crm.genric.fileUtility.FileUtility;
import com.comcat.crm.genric.webdriverutility.JavaUtility;
import com.comcat.crm.genric.webdriverutility.UtilityClassObject;
import com.comcat.crm.genric.webdriverutility.webDriverUtility;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;

public class BaseClass {
	// create object */
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public webDriverUtility wlib = new webDriverUtility();
	public DataBaseUtility dblib = new DataBaseUtility();
	public WebDriver driver = null;
	
	public static WebDriver sdriver = null;
	
	
	//@BeforeSuite(groups= {"smokeTest", "regressionTest"})
	@BeforeSuite
	public void configBs() throws SQLException {
		System.out.println("=====Connect to DB, Report Config====");
		dblib.getDbconnection();
		
		}

	// @Parameters("BROWSER")
//	@BeforeClass(groups= {"smokeTest", "regressionTest"})
	@BeforeClass
	public void configBC(/*String browser*/) throws IOException {
		System.out.println("======Launch the Browser=======");
		//String BROWSER = flib.getDataFromPropertiesFile("browser");**
				//browser;
	 
		String BROWSER=System.getProperty("browser" , flib.getDataFromPropertiesFile("browser")); /* mvn cmd */
		
		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else {
			driver = new ChromeDriver();
		}
		sdriver=driver;
		UtilityClassObject.setDriver(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
   
//	@BeforeMethod(groups= {"smokeTest", "regressionTest"})
	@BeforeMethod
	public void configBM() throws IOException {
		System.out.println("===Login====");
		
	// URL = flib.getDataFromPropertiesFile("url");
	//String USERNAME = flib.getDataFromPropertiesFile("username");
		//String PASSWORD = flib.getDataFromPropertiesFile("password");
		String URL=System.getProperty("url" ,flib.getDataFromPropertiesFile("url"));   /* mvn cmd */
		String USERNAME=System.getProperty("username" ,flib.getDataFromPropertiesFile("username"));  /* mvn cmd */
		String PASSWORD=System.getProperty("password" ,flib.getDataFromPropertiesFile("password"));  /* mvn cmd */
		
		LoginPage lp = new LoginPage(driver);
		lp.loginToApp(URL, USERNAME, PASSWORD);
	}

	//@AfterMethod(groups= {"smokeTest", "regressionTest"})
	@AfterMethod
	public void configAM() throws InterruptedException {
		System.out.println("======Logout=====");
		HomePage hp = new HomePage(driver);
		hp.logout();

	}

	//@AfterClass(groups= {"smokeTest", "regressionTest"})
	@AfterClass
	public void configAC() {
		System.out.println("======Close the Browser=======");
		driver.quit();
	}

	//@AfterSuite(groups= {"smokeTest", "regressionTest"})
	@AfterSuite
	public void configAs() {
		System.out.println("=====Close DB, Report backUp====");
		dblib.closeDbconnection();
		
	}
}
