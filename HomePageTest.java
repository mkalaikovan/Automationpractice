package com.app.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.app.pages.BasePage;
import com.app.pages.HomePageObjects;

public class HomePageTest {
	
	BasePage bp;
	HomePageObjects hp;
	
	public HomePageTest()
	{
		bp = new BasePage();
		hp = new HomePageObjects();
	}
	
	@Test
	public void verifydisplayalltab() {
		//Assert.assertTrue(bp.elementFound(hp.getwomentab()),"Not found");
		//Assert.assertTrue(bp.elementFound(hp.getdressestab()),"dresses Not found");
		Assert.assertTrue(bp.elementFound(hp.gettshirtstab()),"tshirt Not found");
		
	}
	@Test
	public void verifytshirttab()
	{
		hp.gettshirtstab().click();
		Assert.assertTrue(hp.getTitlte().contains("T-shirt"),"t shirt not found");
	}
}