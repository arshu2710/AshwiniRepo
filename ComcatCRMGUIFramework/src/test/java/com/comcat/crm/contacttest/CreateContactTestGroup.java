package com.comcat.crm.contacttest;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.LoginPage;
import com.comcat.crm.objectrepositoryutility.OrganizationsPage;
import com.coomcast.crm.basetest.BaseClass;

public class CreateContactTestGroup extends BaseClass {

	@Test(groups= {"smokeTest", "regressionTest"})
	public void CreateContactTest() throws EncryptedDocumentException, IOException {

		// get data from properties file

		// read the testscript data from Excel file & generate the random number
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// step2:navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getcontactsLink().click();

		// step3:click on "create Contact "button
		ContactPage cp = new ContactPage(driver);
		cp.createNewContactBtn(lastName);

		// verify header orgNamae info expected result
		String actLastName = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (actLastName.equals(lastName)) {
			System.out.println(lastName + " information is verified==pass");
		} else {
			System.out.println(lastName + "information is not verified==fail");
		}
	}

	@Test(groups= "regressionTest")
	public void creatContactWithOrgTest()throws IOException, EncryptedDocumentException {
		// create object */
				
			
		   // read the testscript data from Excel file & generate the random numbe
		
		   String orgName=elib. getDataFromExcel("contact",7,2)+jlib.getRandomNumber();
		   String contactLastName=elib. getDataFromExcel("contact",7,3);
		
		   //step2:navigate to contact module
			HomePage hp =new HomePage(driver);
		hp.getOrgLink().click();
			
			
			//step3:click on "create Contact "button
			OrganizationsPage cnp= new OrganizationsPage(driver);
			cnp.getCreateNeworgBtn().click();
	
		// step4:enter all details & create mew organization
	
			CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
			cnop.createOrg(orgName);
			
			//verify header orgNamae info expected result
			String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actOrgName .contains(orgName)) {
				System.out.println(orgName +"information is created==pass");
			}else {
				System.out.println(orgName +"information informationis not created==fail");
			}
}

	@Test(groups= "regressionTest")
	public void CreateContactWithSupportDateTest()throws IOException, EncryptedDocumentException {
				
			   // read the testscript data from Excel file &generate the random number
			   String lastName=elib. getDataFromExcel("contact",4,2)+jlib.getRandomNumber();
				//step2:navigate to contact module
				HomePage hp =new HomePage(driver);
				hp.getcontactsLink().click();
				//step3:click on "create Contact "button
				ContactPage cp=new ContactPage(driver);
				cp.getnewContactBtn().click();
				cp.getLastNameEdt().sendKeys(lastName);
		
		//step4:enter all the details & create new organizati
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
	


	
		

