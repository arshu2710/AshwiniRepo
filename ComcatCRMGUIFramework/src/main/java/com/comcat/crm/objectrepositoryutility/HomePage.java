package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcat.crm.genric.webdriverutility.webDriverUtility;

public class HomePage {
	webDriverUtility wlib= new webDriverUtility();
	  //Rule-1 create a separate java class
    
		//Rule-2 object Creation
		WebDriver driver;
		public HomePage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		@FindBy(linkText= "Organizations")
		  private WebElement orgLink;
		 
		@FindBy(linkText = "Contacts")
		  private WebElement contactsLink;
		
		@FindBy(linkText = "Products")
		  private WebElement productsLink;
		
		@FindBy(name = "search_text")
		  private WebElement searchEdt;
		
		public WebElement getSearchEdt() {
			return searchEdt;
		}
		public WebElement getproductsLink() {
			return productsLink;
		}
		
		@FindBy(linkText= "Campaigns")
		  private WebElement CampaignsLink;
		
		@FindBy(linkText= "More")
		  private WebElement MoreLink;
		
		@FindBy(xpath= "//img[@src='themes/softed/images/user.PNG']")
		private WebElement adminImg;
		
		@FindBy(xpath = "//a[@href='index.php?module=Users&action=Logout']")
		  private WebElement logout;

	
		  //Rule-3 object Initialization
		
		  public WebElement getlogout() {
			return logout;
		}
		public WebElement getCampaignsLink() {
			return CampaignsLink;
		}
		
		public WebElement getadminImg() {
			return adminImg;
		}
		public WebElement getOrgLink() {
			return orgLink;
		}
		public WebElement getcontactsLink() {
			return contactsLink;
		}
		//Rule-4 object Encapsulation
		public WebElement getHomepage() {
			return orgLink;
		}
		public WebElement getMoreLink() {
			return MoreLink;
		}
			//rule-5 Provide action
		public void navigateToCampaignPage() {
			Actions act=new Actions(driver);
				act.moveToElement(MoreLink).perform();
			CampaignsLink.click();
		}
		
		public void logout() throws InterruptedException
			{
			Thread.sleep(4000);
				wlib.mousemovement(driver, adminImg);
				logout.click();
			}
}
