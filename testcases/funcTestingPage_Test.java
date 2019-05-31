package com.pack.testcases;

import org.testng.annotations.Test;

import com.pack.base.setUp;
import org.testng.Assert;

public class funcTestingPage_Test extends setUp {
	@Test(enabled = true, priority = 1)
	public void gotoFunctTestingPage() {
		obj3.hover(obj1.menuOptionServices());
		obj1.servicesMenuLink("pi-Functional-Testing").click();
		tab1= driver.getWindowHandle();
	}

	@Test(enabled = true, priority = 2)
	public void verifySecondMenuOption() throws InterruptedException {
		for (int i = 1; i < 6; i++) {
			obj4.secondMenu(obj4.array[i]).click();
			Thread.sleep(3000);
			Assert.assertTrue(obj4.secondMenuStatus(i).equals("active"), "Second menu option not clicked");
		}
		driver.navigate().refresh();
	}

	@Test(priority = 3, enabled = true, dataProvider = "socialMedia")
	public void verifySocialMediaWindows(String socialName) throws InterruptedException {
		String currentWindow = tab1;
		String link = obj4.linkedinWindow;
		obj3.hover(obj4.menuOptionInsights());
		Thread.sleep(2000);
		obj4.clickSocialMedia(socialName).click();
		Thread.sleep(5000);
		for (String winHandle : driver.getWindowHandles()) {
			if (winHandle.equals(currentWindow) || winHandle.equals(obj4.linkedinWindow) || winHandle.equals(link))
				continue;
			driver.switchTo().window(winHandle);
			System.out.println("url is" + driver.getCurrentUrl());
			Assert.assertTrue(driver.getCurrentUrl().contains(socialName.toLowerCase()), "Wrong social media window");
			obj4.linkedinWindow = driver.getWindowHandle();
			if (socialName.equals("FACEBOOK"))
				break;
		}
		driver.switchTo().window(currentWindow);
	}

	@Test(priority = 4)
	public void verifyFooter() {
		obj3.scrollToFooter();
		Assert.assertTrue(obj3.footerServices().isDisplayed(), "Footer is not displayed");
	}
}
