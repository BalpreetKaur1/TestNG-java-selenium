package com.pack.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class common_POM {
	
	private WebDriver driver;
	  
	public common_POM(WebDriver driver) {
	 this.driver=driver;
	}
	
	public WebElement footerServices(){
		return driver.findElement(By.linkText("Services"));
	}
	
	public void hover(WebElement element){
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	
	public void scrollToFooter(){
		  JavascriptExecutor jse = ((JavascriptExecutor) driver);
		  jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
}
