package com.comcat.crm.contacttest;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

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
import com.comcat.crm.objectrepositoryutility.ContactPage;
import com.comcat.crm.objectrepositoryutility.CreatingNewContactPage;
import com.comcat.crm.objectrepositoryutility.CreatingNewOrganizationPage;
import com.comcat.crm.objectrepositoryutility.HomePage;
import com.comcat.crm.objectrepositoryutility.OrganizationsPage;
import com.coomcast.crm.basetest.BaseClass;

public class CreateContactWithOrgTest extends BaseClass  {

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
			
			//verify header orgNamae info expected result
			String actOrgName = driver.findElement(By.id("mouseArea_Organization Name")).getText();
			if(actOrgName .contains(orgName)) {
				System.out.println(orgName +"information is created==pass");
			}else {
				System.out.println(orgName +"information informationis not created==fail");
			}
	}
}
			
   /*  	
	
	//step 5:navigate to contact module   
	    hp.getContactsLink().click();
	    
		
		//step 6:click on "create organization"button
	    ContactPage cp=new ContactPage(driver);
	    cp.getCreateNewWOrgBtn().click();

		
		//step 7:enter all the details & create new organization
	   CreatingNewContactPage ccp=new CreatingNewContactPage(driver);
	    ccp.createContactWithOrg(lastName);
		
	   // driver.findElement(By.name("lastname")).sendKeys(contactLastName);
		//driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		CreatingNewContactPage cnp= new CreatingNewContactPage(driver);
		cnp.getLookbtn().click();
		
		//switch to child window
		wlib.switchToTabOnURL(driver, "module=Accounts");
		
		driver.findElement(By.name("search_text")).sendKeys(orgName);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgName+"']")).click();
		
		//switch to parent window
		wlib.switchToTabOnURL(driver, "Contacts&action");
	
		driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
		//verify header phone number info expected result
		
		 String headerinfo = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(headerinfo.contains(contactLastName)) {
			System.out.println(contactLastName +"header is created==pass");
		}else {
			System.out.println(contactLastName +"header is not created==fail");
		}
		
		
	
	
	}*/

