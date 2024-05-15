package com.comcat.crm.orgtest;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.time.Duration;
	import java.util.Properties;
	import java.util.Random;

	import org.apache.poi.EncryptedDocumentException;
	import org.apache.poi.ss.usermodel.Cell;
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
	import org.openqa.selenium.interactions.Actions;
	import org.openqa.selenium.support.PageFactory;
	import org.testng.annotations.Test;

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

	public class CreateOrganizationTestGroup extends BaseClass {
		@Test(groups= {"smokeTest", "regressionTest"})
		public void createOrganiTest() throws EncryptedDocumentException, IOException {

			// read testsScript data from Excel file & generate the random number
			String orgName = elib.getDataFromExcel("Sheet3", 1, 2) + jlib.getRandomNumber();

			// step1.login to app

			// step2:navigate to organization module

			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();

			// step3:click on "create organization"button
			OrganizationsPage op = new OrganizationsPage(driver);
			op.getCreateNeworgBtn().click();

			// step4:enter all the details & create new organization
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName);

			// verify header msg expected result
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);
			String headerinfo = oip.getHeaderInfMsg().getText();
			if (headerinfo.contains(orgName)) {
				System.out.println(orgName + " name is verified==pass");
			} else {
				System.out.println(orgName + " name is not verified==fail");
			}
			// verify the header organization info msg expected result
			String actualorgname = oip.getOrgNameDetail().getText();
			if (actualorgname.equals(orgName)) {
				System.out.println(actualorgname + "is created==PASS");
			} else {
				System.out.println(actualorgname + "is not created==FAIL");
			}
		}

		@Test(groups= "regressionTest")
		public void createOrganizationWithIndustriesTest2() throws EncryptedDocumentException, IOException, InterruptedException {
			// read testsScript data from Excel file & generate the random number
			String orgName = elib.getDataFromExcel("Sheet3", 4, 2) + jlib.getRandomNumber();
			String industry = elib.getDataFromExcel("Sheet3", 4, 3);
			String type = elib.getDataFromExcel("Sheet3", 4, 4);

			// step1.login to app

			// step2:navigate to organization module
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
			
			Thread.sleep(4000);
		}
		}
		

		@Test(groups= "regressionTest")
		public void createOrgWithPhoneNumberTest() throws EncryptedDocumentException, IOException {
	//read testsScript data from Excel file & generate the random number
			String orgName = elib.getDataFromExcel("Sheet3", 7, 2) + jlib.getRandomNumber();
			String phoneNumber = elib.getDataFromExcel("Sheet3", 7, 3);
			HomePage hp = new HomePage(driver);
			hp.getOrgLink().click();

	// step3:click on "create organization"button
			CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
			cnop.CreateOrgPhone(orgName, phoneNumber);
	// step4:enter all the details & create new organization
			OrganizationInformationPage oip = new OrganizationInformationPage(driver);

	//verify header phoneNumber info expected result
			String actphoneNumber = oip.getphoneNumInf().getText();
			if (actphoneNumber.equals(phoneNumber)) {
				System.out.println(phoneNumber + " information is created==pass");
			} else {
				System.out.println(phoneNumber + "information is not created==fail");
			}
		}
	}

