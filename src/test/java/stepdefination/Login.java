package stepdefination;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.LoginPage;
import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.CommonUtils;

public class Login {
	WebDriver driver;
	private LoginPage loginPage;
private	AccountPage accountPage;
	
	
	
	@Given("User navigates to login page")
	public void user_navigates_to_login_page() {
		 driver=DriverFactory.getDriver();
		 HomePage homePage= new HomePage(driver);
		 homePage.clickOnMyAccount();
		 loginPage=homePage.selectLoginOption();
	
	   
	}

	@When("^User enters valid email address (.+)into email field$")
	public void user_enters_valid_email_address_into_email_field(String emailText ) throws Throwable {
		
	   
		loginPage.enterEmailAddress(emailText);
		
	    
	}

	@And("^User enters valid password (.+) into password field$")
	public void user_enters_valid_password_into_password_field(String passwordText) throws Throwable {
		loginPage.enterPassword(passwordText);
	
	    
	}

	@And("^User clicks on Login button$")
	public void user_clicks_on_Login_button() throws Throwable {
		
		accountPage=loginPage.clickOnLoginButton();
		
	
	    
	}

	@Then("User should get successfuly logged in")
	public void user_should_get_successfuly_logged_in() throws Throwable {
		
		
		
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
	    
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field() throws Throwable {
		

		
		loginPage.enterEmailAddress(CommonUtils.getEmailWithTimeStamp());
		
		
	    
	}

	@When("User enters invalid password {string} into password field")
	public void user_enters_invalid_password_into_password_field(String invalidPasswordText) throws Throwable {
		
		loginPage.enterPassword(invalidPasswordText);
	
	    
	}
	
	
	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() throws Throwable {
		
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
	    
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() throws Throwable {
		
		
		loginPage.enterEmailAddress("");
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() throws Throwable {
		
		loginPage.enterPassword("");
		
	    
	}



}
