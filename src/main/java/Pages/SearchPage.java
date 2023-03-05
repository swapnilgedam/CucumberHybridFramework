package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {
	
WebDriver driver;

private ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		
		this.driver= driver;
		
		PageFactory.initElements(driver,this);
		
		elementUtils= new ElementUtils(driver);
	}
    @FindBy(linkText="HP LP3065")
	private WebElement validHpProduct;
    
    @FindBy(xpath="//input[@id='button-search']/following-sibling::p")
    private WebElement messageText;
    
    
    public boolean displayStatusOfValidProduct() {
    	
    	return elementUtils.displayStatusOfElement(validHpProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
  
    }
    
    public String getMessageText() {
    	
    return	elementUtils.getTextFromElement(messageText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
    	
    }
}
