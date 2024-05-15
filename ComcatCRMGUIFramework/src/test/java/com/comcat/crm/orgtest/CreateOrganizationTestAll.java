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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import com.comcat.crm.genric.fileUtility.ExcelUtility;
import com.comcat.crm.genric.fileUtility.FileUtility;
import com.comcat.crm.genric.webdriverutility.JavaUtility;
import com.comcat.crm.genric.webdriverutility.UtilityClassObject;
import com.comcat.crm.genric.webdriverutility.webDriverUtility;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.comcat.crm.objectrepositoryutility.OrganizationInformationPage;
import com.comcat.crm.objectrepositoryutility.OrganizationsPage;
import com.coomcast.crm.basetest.BaseClass;
@Listeners( com.comcat.crm.genric.listnerutility.ListImpClass.class)
public class CreateOrganizationTestAll extends BaseClass {

	@Test
	public void createOrganiTest() throws EncryptedDocumentException, IOException {

		UtilityClassObject.getTest().log(Status.INFO," read data from excel");
		// read testsScript data from Excel file & generate the random number
		String orgName = elib.getDataFromExcel("Sheet3", 1, 2) + jlib.getRandomNumber();

		// step1.login to app

		// step2:navigate to organization module
		UtilityClassObject.getTest().log(Status.INFO," navigate to org page");
		HomePage hp = new HomePage(driver);
		Assert.fail();
		hp.getOrgLink().click();

		// step3:click on "create organization"button
		UtilityClassObject.getTest().log(Status.INFO," navigate to create org page");
		OrganizationsPage op = new OrganizationsPage(driver);
		op.getCreateNeworgBtn().click();

		// step4:enter all the details & create new organization
		UtilityClassObject.getTest().log(Status.INFO," create a new org ");
		CreatingNewOrganizationPage cnop = new CreatingNewOrganizationPage(driver);
		cnop.createOrg(orgName);
		UtilityClassObject.getTest().log(Status.INFO, orgName +"===>create a new org ");

		// verify header orgNamae info expected result
		OrganizationInformationPage oip = new OrganizationInformationPage(driver);
		String headerinfo = oip.getHeaderInfMsg().getText();
		
		boolean status = headerinfo.contains(orgName);
		Assert.assertEquals(status, true);
		
		// verify the header organization info msg expected result
		String actualorgname = oip.getOrgNameDetail().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actualorgname, orgName);
	}
	

	@Test
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
	boolean status = actIndustries.contains(industry);
	Assert.assertEquals(status, true);
	
	String actType = ovp.getTypeDDInf().getText();
	boolean status1 = actType.contains(type);
	Assert.assertEquals(status1, true);
	
		Thread.sleep(4000);
	}
	

	@Test
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
		boolean status = actphoneNumber.contains(phoneNumber);
		Assert.assertEquals(status, true);
		
	}
}