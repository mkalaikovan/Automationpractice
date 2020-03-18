package com.app.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects extends BasePage{
	@FindBy(xpath = "//a[@title='Women']")
	private WebElement women;
	

	@FindBy(xpath = "(//a[@title='Dresses'])[2]")
	private WebElement dresses;
	
	@FindBy(xpath = "(//a[@title='T-shirts'])[2]")
	private WebElement tshirts;
				
	public HomePageObjects() {
		PageFactory.initElements(driver, this);
	}
	
	public WebElement gettshirtstab() {
		return tshirts;
	}
	
	
	
	
}
