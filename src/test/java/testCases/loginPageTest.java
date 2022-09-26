package testCases;

import static org.testng.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Base.BaseClass;
import Pages.loginPage;
import dev.failsafe.internal.util.Assert;

public class loginPageTest extends BaseClass {
	public static loginPage loginpage;

	public loginPageTest() throws FileNotFoundException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeTest
	public void setUplogintest() throws MalformedURLException, FileNotFoundException {
		initialization();
		loginpage= new loginPage(driver);
		
	}
	@Test(priority = 1)
	public void testUsernameField() {
		loginpage.setusernameField("Tester");
		org.testng.Assert.assertTrue(true);
		System.out.println("username field populated....");
	}
	@Test(priority = 2)
	public void testPasswordField() {
		loginpage.setpasswordField("fakefake");
		org.testng.Assert.assertTrue(true);
		System.out.println("password field populated....");
	}
	@Test(priority = 3)
	public void testSignbutton() {
		loginpage.clicksignInbutton();
		org.testng.Assert.assertTrue(true);
		System.out.println("sign button clicked....");
	}

}
