package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties properties;
	public static FileInputStream fileInputStream;
	public static DesiredCapabilities desiredCapabilities;
	
	public BaseClass() throws FileNotFoundException {
		
		try {
		properties = new Properties();
		fileInputStream=new FileInputStream("Configuration/configuration.properties");
		properties.load(fileInputStream);
	}
		catch (IOException e) {
			// TODO: handle exception
			e.getMessage();
		}

	}	
	
public void initialization() throws MalformedURLException {
	desiredCapabilities=new DesiredCapabilities();
	String browserName=properties.getProperty("browser");
	if (browserName.equals("chrome")){
		desiredCapabilities.setBrowserName("chrome");
		driver= new RemoteWebDriver(new URL("http://127.0.0.1:51375"), desiredCapabilities);
		System.out.println("Test initialized...chrome");
	}
		
		else if(browserName.equals("firefox")){
			desiredCapabilities.setBrowserName("firefox");
			driver= new RemoteWebDriver(new URL("http://127.0.0.1:51375"),desiredCapabilities);
		}
	
		else if(browserName.equals("msedge")) {
			desiredCapabilities.setBrowserName("MicrosoftEdge");
			driver= new RemoteWebDriver(new URL("http://127.0.0.1:51375"), desiredCapabilities);
		}
	else {
		System.out.println("Sorry, browser not supported. Please use either msedge, firefox or chrome");
	}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get(properties.getProperty("url"));
	}
}
