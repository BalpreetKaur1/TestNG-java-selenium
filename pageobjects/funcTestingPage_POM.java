package com.pack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class funcTestingPage_POM {
	
	private WebDriver driver;
	public String[] array = { "", "Quality & Functionality", "Specialist Functional Testers", "Testing Delivery Options",
			"Case Study", "Our Clients" };
	public String linkedinWindow, link;
	
  
	public funcTestingPage_POM(WebDriver driver) {
	 this.driver=driver;
	}
	
	public WebElement secondMenu(String name){
		return driver.findElement(By.partialLinkText(name));
	}
		
	public String secondMenuStatus(int index){
		return driver.findElement(By.xpath("//ul[contains(@class,'service_second_menu-list')]//li["+index+"]")).getAttribute("class");
	}
	
	public WebElement menuOptionInsights(){
		return driver.findElement(By.linkText("Insights"));
	}
	
	public WebElement clickSocialMedia(String socialMediaType){
		return driver.findElement(By.xpath("//b[text()='"+socialMediaType+"']"));
	}
}
