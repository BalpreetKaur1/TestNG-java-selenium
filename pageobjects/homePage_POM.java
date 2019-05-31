package com.pack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class homePage_POM {
	
	private WebDriver driver;
	
	public homePage_POM(WebDriver driver){
		this.driver=driver;
	}
	
	public WebElement homePageLogo(){
		return driver.findElement(By.id("p_lt_ctl04_etHeaderLogo_ucEditableImage_imgImage"));
	}
	
	public WebElement menuOptionServices(){
		return driver.findElement(By.xpath("//ul[@id='mb1']//li[1]"));
	}
	
	public WebElement servicesMenuLink(String name) {
		return driver.findElement(By.className(name));
	}
	
	public WebElement searchButton(){
		return driver.findElement(By.className("js_header_search-btn"));
	}
	
	public WebElement searchText(){
		return driver.findElement(By.id("p_lt_ctl02_SmartSearchBox_txtWord"));
	}
	
	public WebElement searchResult() {
		return driver.findElement(By.id("search-listing"));
	}
		
}