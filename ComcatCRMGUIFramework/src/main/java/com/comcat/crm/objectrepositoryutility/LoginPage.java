package com.comcat.crm.objectrepositoryutility;

import java.time.Duration;
/**
 * @author Ashwini
 * contains login page element & buisness lib like login()
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcat.crm.genric.webdriverutility.webDriverUtility;

public class LoginPage {
      //Rule-1 create a separate java class
      
	//Rule-2 object Creation
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(name="user_name")
	 private WebElement usernameEdt;
	
	   @FindBy(name="user_password")
	 private WebElement passwordEdt;
	
	  @FindBy(id="submitButton")
	  private WebElement loginBtn;
	  
	  
	  //Rule-3 object Initialization
	
	  //Rule-4 object Encapsulation
	  public WebElement getUsernameEdt() {
			return usernameEdt;
		}

		public WebElement getPasswordEdt() {
			return passwordEdt;
		}

		public WebElement getLoginBtn() {
			return loginBtn;
		}
		/**
		 * login toapplication based on username, password,url arguments
		 * @param url
		 * @param username
		 * @param password
		 */
		//rule-5 Provide action
		public void  loginToApp( String url ,String username,String password) {
			driver.get(url);
			driver.manage().window().maximize();
			usernameEdt.sendKeys(username);
			passwordEdt.sendKeys(password);
			loginBtn.click();
		}
}
	  
