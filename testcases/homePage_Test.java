package com.pack.testcases;

import org.testng.annotations.Test;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import com.pack.base.setUp;

public class homePage_Test extends setUp {
	
	@Test(priority=1)
	public void verifyHomepageload() {
		Assert.assertTrue(obj1.homePageLogo().isDisplayed(), "Home page logo is not loaded");
	}
	
	@Test(priority=2, dataProvider = "servicesMenuLinks")
	public void verifyServicesMenuOptions(String linkName) {
		obj3.hover(obj1.menuOptionServices());
		Assert.assertTrue(obj1.servicesMenuLink(linkName).isDisplayed(),"Menu option services does not display the Functional testing link");
	}
	
	@Test(priority=3)
	public void verifySearch() {
		obj1.searchButton().click();
		obj1.searchText().sendKeys("functional testing");
		obj1.searchText().sendKeys(Keys.RETURN);
		Assert.assertTrue(obj1.searchResult().isDisplayed(), "No search Results");
	}

	
}