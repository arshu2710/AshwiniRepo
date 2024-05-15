package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateNewProductpage {

	@FindBy (xpath="//img[@alt='Create Product...']")
	private WebElement createnewproductBtn;

	public WebElement getCreatenewproductBtn() {
		return createnewproductBtn;
	}
}
