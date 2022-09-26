package Pages;

import java.io.FileNotFoundException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Base.BaseClass;

public class loginPage extends BaseClass {
	public loginPage(WebDriver driver) throws FileNotFoundException{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "/html/body/div/div/form/div[1]/input")
	@CacheLookup
	WebElement usernameField;
	
	@FindBy(xpath = "/html/body/div/div/form/div[2]/input")
	@CacheLookup
	WebElement passwordField;
	
	@FindBy(id = "log-in")
	@CacheLookup
	WebElement signInbutton;
	
	public void setusernameField(String uname) {
		usernameField.sendKeys(uname);
	}
	
	public void setpasswordField(String pswd) {
		passwordField.sendKeys(pswd);
		
	}
	
	public void clicksignInbutton() {
		signInbutton.click();
		
	}

}
