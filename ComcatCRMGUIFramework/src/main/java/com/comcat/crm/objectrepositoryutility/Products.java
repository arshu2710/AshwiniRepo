package com.comcat.crm.objectrepositoryutility;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Products {

	
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement createProductImgBtn;

	public WebElement getcreateProductImgBtn() {
		return createProductImgBtn;
	}
	//code1
	//cod2
}
