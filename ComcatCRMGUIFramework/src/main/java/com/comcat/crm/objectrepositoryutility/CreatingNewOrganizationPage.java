package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.comcat.crm.genric.webdriverutility.webDriverUtility;

public class CreatingNewOrganizationPage {
	webDriverUtility wlib= new webDriverUtility();
	   //Rule-1 create a separate java class
    
	
			//Rule-2 object Creation
			WebDriver driver;
			public CreatingNewOrganizationPage (WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			@FindBy(name= "accountname")
			 private WebElement orgNameEdt;
			
			@FindBy(name= "industry")
			private WebElement industryDD;
			
			@FindBy(name= "accounttype")
			private WebElement typeDD;
			
			@FindBy(xpath= "(//input[@name='button'])[1]")
			private WebElement saveBtn;
			
			
			@FindBy(xpath= "//img[@title='Create Organization...']")
			 private WebElement createNeworgBtn;
			
			@FindBy(id= "phone")
			 private WebElement phoneNumEdt;
			
			public WebElement getcreateNeworgBtn() {
				return createNeworgBtn;
			}

			public WebElement getOrgNameEdt() {
				return orgNameEdt;
			}
			public WebElement getindustryDD() {
				return industryDD;
			}

			public WebElement gettypeDD() {
				return typeDD;
			}

			
			public WebElement getSaveBtn() {
				return saveBtn;
			}
			public void createOrg(String orgName) {
	        	   createNeworgBtn.click();
	        	   orgNameEdt.sendKeys(orgName);
	        	   saveBtn.click();
			}
			public void createOrg(String orgName,String industry, String type) throws InterruptedException {
				createNeworgBtn.click();
				orgNameEdt.sendKeys(orgName);
				
				  Thread.sleep(3000);
		wlib.selectBasedOnValue(industryDD, industry);
		wlib.selectBasedOnValue(typeDD, type);
		saveBtn.click();
//			 Select sel = new Select(industryDD);
//			   sel.selectByIndex(10);
//			   Select sel1 = new Select(typeDD);
//			   sel1.selectByIndex(7);
//			   saveBtn.click();
		}

			public void CreateOrgPhone(String orgName, String phoneNumber)
			{
				createNeworgBtn.click();
				orgNameEdt.sendKeys(orgName);
				phoneNumEdt.sendKeys(phoneNumber);
				saveBtn.click();
			}     
}
	

			
			  

