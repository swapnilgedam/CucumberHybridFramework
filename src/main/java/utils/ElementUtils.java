package utils;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtils {

	WebDriver driver;

	public ElementUtils(WebDriver driver) {

		this.driver = driver;
	}

	public void clickOnElement(WebElement element, long durationInSecond) {

		WebElement webelement = waitForElement(element, durationInSecond);

		webelement.click();
	}

	public void typeTextIntoElement(WebElement element, String textToBeTyped, long durationInSecond) {

		WebElement webelement = waitForElement(element, durationInSecond);
		webelement.click();
		webelement.clear();
		webelement.sendKeys(textToBeTyped);
	}

	public WebElement waitForElement(WebElement element, long durationInSecond) {

		WebElement webelement = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecond));
			webelement = wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Throwable e) {

			e.printStackTrace();
		}
		return webelement;
	}
	
	public void selectOptionInDropdown(WebElement element, String dropDownOption,long durationInSecond) {
		WebElement webelement = waitForElement(element, durationInSecond);
		Select select= new Select(webelement);
		select.selectByVisibleText(dropDownOption);
	}
	
	public void acceptAlert(long durationInSecond) {
		Alert 	alert=	waitForAlert(durationInSecond);
		alert.accept();
	}
	
	public void dismissAlert(long durationInSecond) {
		Alert 	alert=	waitForAlert(durationInSecond);
		alert.dismiss();
		
	}
	
	
	public Alert waitForAlert(long durationInSecond) {
		Alert alert= null;
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecond));
	    alert=wait.until(ExpectedConditions.alertIsPresent());
		}catch(Throwable e) {
			e.printStackTrace();
		}
		return alert;
	}
	
	
	public void mouseHoverAndClick(WebElement element,long durationInSecond) {
		
		
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSecond);
		
		Actions action= new Actions(driver);
		action.moveToElement(webElement).click().build().perform();
	}
	
	public WebElement waitForVisibilityOfElement(WebElement element,long durationInSecond) {
		
		WebElement webElement=null;
		try {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(durationInSecond));
		
		 webElement = wait.until(ExpectedConditions.visibilityOf(element));
	}catch(Throwable e) {
		
		e.printStackTrace();
	}
	
	return  webElement;
	
	
	
	}
	
	public void javaScriptClick(WebElement element,long durationInSecond) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSecond);
		
		JavascriptExecutor	jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].click();", webElement);
		
	}
	
	public void javaScriptType(WebElement element,long durationInSecond,String textToBeTyped) {
		
		WebElement webElement = waitForVisibilityOfElement(element,durationInSecond);
		JavascriptExecutor	jse=((JavascriptExecutor)driver);
		jse.executeScript("arguments[0].value='"+textToBeTyped+"'", webElement);
	}
	
	
	public String getTextFromElement(WebElement element,long durationInSecond) {
		
		WebElement webelement = waitForElement(element, durationInSecond);
		
		return webelement.getText();
	}
	
	public boolean displayStatusOfElement(WebElement element,long durationInSecond) {
		
	try {
	WebElement webElement = waitForVisibilityOfElement(element,durationInSecond);
	return webElement.isDisplayed();
			
	}catch(Throwable e) {
		
		
		return false;
	}
			
			
			
			
	}			
}
