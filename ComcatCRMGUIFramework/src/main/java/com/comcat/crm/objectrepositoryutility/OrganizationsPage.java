package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationsPage {

	      //Rule-1 create a separate java class
	      
		
		//Rule-2 object Creation
		WebDriver driver;
		public OrganizationsPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(name= "search_text")
		private WebElement searchEdt;
		
		@FindBy(name= "search_field")
		private WebElement searchDD;
		
		@FindBy(name = "submit")
		private WebElement searchBtn;
		
		@FindBy(xpath= "//img[@title='Create Organization...']")
		 private WebElement createNeworgBtn;
		
		  //Rule-3 object Initialization

		//Rule-4 object Encapsulation
		public WebElement getSearchBtn() {
			return searchBtn;
		}
		 public WebElement getSearchEdt() {
				return searchEdt;
			}

			public WebElement getsearchDD() {
				return searchDD;
			}
		public WebElement getCreateNeworgBtn() {
			return createNeworgBtn;
		}
		
		public void createOrg()
		{
			createNeworgBtn.click();
			
		}
		
}
			
