package com.comcat.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.comcat.crm.genric.fileUtility.ExcelUtility;
import com.comcat.crm.genric.fileUtility.FileUtility;
import com.comcat.crm.genric.webdriverutility.JavaUtility;
import com.comcat.crm.genric.webdriverutility.webDriverUtility;
import com.comcat.crm.objectrepositoryutility.ContactInfoPage;
import com.comcat.crm.objectrepositoryutility.ContactPage;
import com.comcat.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.coomcast.crm.basetest.BaseClass;

public class CreateContactWithSupportDateTest extends BaseClass  {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		 FileUtility flib= new FileUtility();
			ExcelUtility elib= new ExcelUtility();
			JavaUtility jlib= new JavaUtility();
			 webDriverUtility wlib =new webDriverUtility();
			String BROWSER=flib. getDataFromPropertiesFile("browser");
			String URL= flib. getDataFromPropertiesFile("url"); 
			String USERNAME= flib. getDataFromPropertiesFile("username"); 
			String PASSWORD= flib. getDataFromPropertiesFile("password"); 
		//read testsScript data from Excel file & generate the random number
	    String orgName=elib.getDataFromExcel("sheet3",10,2)+jlib.getRandomNumber();
		
			WebDriver driver=null;
			
			if(BROWSER.equals("chrome")) {
				driver=new ChromeDriver();
			}else if(BROWSER.equals("edge")){
				driver=new EdgeDriver();
			}
			else if(BROWSER.equals("firefox")){
				driver=new FirefoxDriver();
			}else  { 
				driver=new ChromeDriver();
			}
			
		//step1.login to app
			wlib.waitforPageLoad(driver);
			driver.get(URL);

			
		   // read the testscript data from Excel file &generate the random number
		   String lastName=elib. getDataFromExcel("contact",4,2)+jlib.getRandomNumber();
		
			LoginPage lp=new LoginPage(driver);
			  /* lp.getUsernameEdt().sendKeys("admin");
			   lp.getPasswordEdt().sendKeys("admin");
			   lp.getLoginBtn().click(); or */
		       
				lp.loginToApp(URL,USERNAME,PASSWORD);
			 
			//step2:navigate to contact module
			HomePage hp =new HomePage(driver);
			hp.getcontactsLink().click();
			//step3:click on "create Contact "button
			ContactPage cp=new ContactPage(driver);
			cp.getnewContactBtn().click();
		cp.getLastNameEdt().sendKeys(lastName);
	
	//step4:enter all the details & create new organization
	String startDate=jlib.getSystemDateYYYYDDMM();
	String endDate=jlib.getRequiredDateYYYYDDMM(30);
	
	CreatingNewContactPage cncp=new CreatingNewContactPage (driver);
	cncp.createContactWithstart_Date(lastName,startDate,endDate);
	cp.getSaveBtn().click();
	
	//verify header orgNamae info expected result
	ContactInfoPage cip= new ContactInfoPage (driver);
	String actStartDate= cip.getInfStartDate().getText();
	if(actStartDate .equals(startDate)) {
		System.out.println(startDate +" information is verified==pass");
	}else {
		System.out.println(startDate +"information is not verified==fail");
	}
	
	String actendDate = cip.getInfEndDate().getText(); 
	if(actendDate .equals(endDate)) {
		System.out.println(endDate +" information is verified==pass");
	}else {
		System.out.println(endDate +"information is not verified==fail");
	}
	
	//step5:logout
	
	}
}

