package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	// Rule-1 create a separate java class

	// Rule-2 object Creation
	WebDriver driver;

	public ContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement newContactBtn;

	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement orgcontactEdt;

	@FindBy(name = "lastname")
	private WebElement lastNameEdt;

	public WebElement getLastNameEdt() {
		return lastNameEdt;
	}

	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;

	@FindBy(id = "search_txt")
	private WebElement SearchtextinChildwin;

	@FindBy(name = "search")
	private WebElement searchbtnChildWind;

	public WebElement getOrgcontactEdt() {
		return orgcontactEdt;
	}

	public WebElement getSearchtextinChildwin() {
		return SearchtextinChildwin;
	}

	public WebElement getSearchbtnChildWind() {
		return searchbtnChildWind;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}

	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getnewContactBtn() {
		return newContactBtn;
	}

	public void createNewContactBtn(String lastName) {
		HomePage hp = new HomePage(driver);
		hp.getcontactsLink().click();
		newContactBtn.click();
		lastNameEdt.sendKeys(lastName);
		saveBtn.click();
	}

	public void createContactWithOrg(String lastname) {
		newContactBtn.click();
		lastNameEdt.sendKeys(lastname);
		orgcontactEdt.click();

	}

}