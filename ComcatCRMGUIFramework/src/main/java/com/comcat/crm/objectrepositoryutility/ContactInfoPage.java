package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInfoPage {
	// Rule-1 create a separate java class

	// Rule-2 object Creation
	WebDriver driver;

	public ContactInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "dtlview_Support Start Date")
	private WebElement infStartDate;

	@FindBy(id = "dtlview_Support End Date")
	private WebElement infEndDate;

	@FindBy(className = "dvHeaderText")
	private WebElement headerMsg;

	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement contactheaderMsg;

	public WebElement getcontactheaderMsg() {
		return contactheaderMsg;
	}

	public WebElement getContactOrgInf() {
		return contactOrgInf;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getcontactOrgInf() {
		return contactOrgInf;
	}

	@FindBy(id = "dtlview_Last Name")
	private WebElement contInf;


	@FindBy(id="mouseArea_Organization Name")
	private WebElement contactOrgInf;
	
	public WebElement getContInf() {
		return contInf;
	}

	public WebElement getHeaderMsg() {
		return headerMsg;
	}

	public WebElement getInfStartDate() {
		return infStartDate;
	}

	public WebElement getInfEndDate() {
		return infEndDate;
	}

}