package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreatingNewContactPage {
	 //Rule-1 create a separate java class
    
	//Rule-2 object Creation
	WebDriver driver;
	public CreatingNewContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="lastname")
	 private WebElement lastNameEdt;
	
	@FindBy(xpath="(//input[@name='button'])[1]")
	private WebElement saveBtn;
	
	@FindBy(name="support_start_date")
	private WebElement startdatecontactEdt;
	
	@FindBy(name="support_end_date")
	private WebElement enddatecontactEdt;
	
	
	public WebElement getstartdatecontactEdt() {
		return startdatecontactEdt;
	}

	public WebElement getEnddateEdt() {
		return enddatecontactEdt;
	}

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	
		public void createContactWithstart_Date(String lastname,String startdate, String enddate) {
			{
				
				lastNameEdt.sendKeys(lastname);
				startdatecontactEdt.clear();
				enddatecontactEdt.clear();
				startdatecontactEdt.sendKeys(startdate);
				enddatecontactEdt.sendKeys(enddate);
		}
	
		}
}
	
	

