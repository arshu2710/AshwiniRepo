package com.comcat.crm.contacttest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

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
/**
 * @author Ashwini
 */
public class CreateContactTestAll extends BaseClass {

	@Test
	public void createContactTest() throws EncryptedDocumentException, IOException {

		
		/* read the testscript data from Excel file & generate the random number*/
		String lastName = elib.getDataFromExcel("contact", 1, 2) + jlib.getRandomNumber();

		// step2:navigate to contact module
		HomePage hp = new HomePage(driver);
		hp.getcontactsLink().click();

		// step3:click on "create Contact "button
		ContactPage cp = new ContactPage(driver);
		cp.createNewContactBtn(lastName);
		
		ContactInfoPage cpi =new ContactInfoPage(driver);
		

		String actHeader = cpi.getHeaderMsg().getText();
		boolean status = actHeader.contains(lastName);
		Assert.assertEquals(status, true);
	

		// verify header orgNamae info expected result
		String actLastName = cpi.getContInf().getText();
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(actLastName, lastName);
		
	}
	

	@Test
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
			ContactInfoPage cpi =new ContactInfoPage(driver);
			
			
			
			//verify header orgNamae info expected result
			String actOrgName = cpi.getcontactOrgInf().getText();
			boolean status1 = actOrgName.contains(orgName);
			Assert.assertEquals(status1, true);

	}
	
	@Test
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
		boolean status = actStartDate.contains(startDate);
		Assert.assertEquals(status, true);

		String actendDate = cip.getInfEndDate().getText();
		//SoftAssert soft=new SoftAssert();
		//soft.assertEquals(actendDate, endDate);
		boolean status1 = actendDate.contains(endDate);
		Assert.assertEquals(status1, true);
		
		//step5:logout
		
	}
}
	


	
		

