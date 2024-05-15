package com.comcat.crm.orgtest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
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

import com.comcat.crm.genric.fileUtility.ExcelUtility;
import com.comcat.crm.genric.fileUtility.FileUtility;
import com.comcat.crm.genric.webdriverutility.JavaUtility;
import com.comcat.crm.genric.webdriverutility.webDriverUtility;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.comcat.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcat.crm.objectrepositoryutility.OrganizationsPage;

public class CreateOrgWithPhoneNumberTest {

			public static void main(String[] args) throws EncryptedDocumentException, IOException {
				/*create object */
				FileUtility flib=new FileUtility();
				ExcelUtility elib= new ExcelUtility();
				  JavaUtility jlib=new JavaUtility();
				  webDriverUtility wlib =new webDriverUtility();
				
				//read common data from from property file
				String BROWSER=flib. getDataFromPropertiesFile("browser");
				String URL= flib. getDataFromPropertiesFile("url"); 
				String USERNAME= flib. getDataFromPropertiesFile("username"); 
				String PASSWORD= flib. getDataFromPropertiesFile("password"); 
			//read testsScript data from Excel file & generate the random number
		    String orgName=elib.getDataFromExcel("sheet3",7,2)+jlib.getRandomNumber();
		    String phoneNumber=elib.getDataFromExcel("sheet3",7,3);
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
			
		    LoginPage lp=new LoginPage(driver);
			lp.loginToApp(URL ,USERNAME, PASSWORD);
		
		    HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();

			// step3:click on "create organization"button
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.CreateOrgPhone(orgName, phoneNumber);
			// step4:enter all the details & create new organization
			OrganizationInformationPage oip=new OrganizationInformationPage(driver);
			
			
			//verify header phoneNumber info expected result
			String actphoneNumber=oip.getphoneNumInf().getText();
			if(actphoneNumber .equals(phoneNumber)) {
				System.out.println( phoneNumber +" information is created==pass");
			}else {
				System.out.println(phoneNumber +"information is not created==fail");
			}
			
			//step5:logout
			driver.quit();
			}
			 
	}

