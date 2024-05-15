package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class OrganizationInformationPage {
	   //Rule-1 create a separate java class
    
	
			//Rule-2 object Creation
			WebDriver driver;
			public OrganizationInformationPage(WebDriver driver) {
				this.driver=driver;
				PageFactory.initElements(driver,this);
			}
			
			@FindBy(xpath = "//span[@class='dvHeaderText']")
			private WebElement headerInfMsg;
			
			@FindBy(id= "dtlview_Organization Name")
			private WebElement orgNameDetail;
			
			@FindBy(className = "dvHeaderText")
			private WebElement headerMsg;
			
			@FindBy(id="mouseArea_Industry")
			private WebElement industryDDInf;
			
			@FindBy(id = "dtlview_Type")
			private WebElement TypeDDInf;
			
			@FindBy(id = "dtlview_Phone")
			private WebElement phoneNumInf;
			
			//Rule-3 object Initialization
			
			public WebElement getindustryDDInf() {
				return industryDDInf;
			}

			public WebDriver getDriver() {
				return driver;
			}

			public WebElement getphoneNumInf() {
				return phoneNumInf;
			}

			public WebElement getTypeDDInf() {
				return TypeDDInf;
			}
			
			public WebElement getHeaderMsg() {
				return headerMsg;
			}

			public WebElement getHeaderInfMsg() {
				return headerInfMsg;
			}

			public WebElement getOrgNameDetail() {
				return orgNameDetail;
			}

			
			}
			
