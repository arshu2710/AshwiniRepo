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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.comcat.crm.genric.fileUtility.ExcelUtility;
import com.comcat.crm.genric.fileUtility.FileUtility;
import com.comcat.crm.genric.webdriverutility.JavaUtility;
import com.comcat.crm.genric.webdriverutility.webDriverUtility;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.comcat.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcat.crm.objectrepositoryutility.OrganizationsPage;
import com.coomcast.crm.basetest.BaseClass;


public class CreateOrganizationWithIndustriesTest2 {


	public static void main(String[] args) throws EncryptedDocumentException, IOException, InterruptedException {
		
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
    String orgName=elib.getDataFromExcel("Sheet3",4,2)+jlib.getRandomNumber();
    String industry=elib.getDataFromExcel("Sheet3",4,3);
    String type=elib.getDataFromExcel("Sheet3",4,4);
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
			
			//step2:navigate to organization module
				HomePage hp=new HomePage(driver);
				  hp.getOrgLink().click();
			//step3:click on "create organization"button
				  OrganizationsPage op=new OrganizationsPage(driver);
				  op.getCreateNeworgBtn().click();
			
			//step4:enter all the details & create new organization
				  CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
				  cnop.createOrg(orgName, industry, type);
				
			//verify the industries and type info 
				  OrganizationInformationPage ovp=new OrganizationInformationPage(driver);
			String actIndustries = ovp.getindustryDDInf().getText();
			
			
			if(actIndustries .equalsIgnoreCase(industry)) {
				System.out.println(industry +" information is verified==pass");
			}else {
				System.out.println(industry +" information not verified==fail");
			}
			
			String actType = ovp.getTypeDDInf().getText();
			
			if(actType .equalsIgnoreCase(type)) {
				System.out.println(type +" information verified==pass");
			}else {
				System.out.println(type +" information not verified==fail");
			}
			
			//step5:logout
			
			hp.logout();
			driver.quit();
			}


	}


