package com.comcat.crm.orgtest;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
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

public class DeleteOrgTest {

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
		LoginPage lp=new LoginPage(driver);
	  /* lp.getUsernameEdt().sendKeys("admin");
	   lp.getPasswordEdt().sendKeys("admin");
	   lp.getLoginBtn().click(); or */
       
		lp.loginToApp(URL,USERNAME,PASSWORD);
	 
		//step2:navigate to organization module
		
	HomePage hp=new HomePage(driver);
	  hp.getOrgLink().click();
	
	  //step3:click on "create organization"button
	  OrganizationsPage op=new OrganizationsPage(driver);
	  op.getCreateNeworgBtn().click();
	
	//step4:enter all the details & create new organization
	  CreatingNewOrganizationPage cnop=new CreatingNewOrganizationPage(driver);
	  cnop.createOrg(orgName);
	  
	
	//verify header msg expected result
	  OrganizationInformationPage  oip =new OrganizationInformationPage(driver);
			  String actOrgName= oip.getHeaderMsg().getText(); 
			  if(actOrgName.contains(orgName)) {  /*contains because this a dynamic test*/
				  System.out.println(orgName +" name is verified==pass");
			  }else {
					System.out.println(orgName +" name is not verified==fail");
				}
			  // Go back to OrganizationPage
			  hp.getOrgLink().click();
			 
			  // search organization
			  
			  op.getSearchEdt().sendKeys(orgName);
			  wlib.selectBasedOnValue(op.getsearchDD(), "Organization Name");
			  op.getSearchBtn().click();
			 
			  // In Dynamic Webtable select & delete org
			  driver.findElement(By.xpath("//a[text()='"+orgName+"']/../../td[8]/a[text()='del']")).click();
			 
			  wlib.switchtoAlertAndAccept(driver);
			  
			  System.out.println("deleted");
		
			  //step5:logout
	        //  op.logOut();
			 // driver.quit();
	    }
} 

