package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class Config extends WebDriverFunction {
	
	@BeforeSuite
	public void startTestSuite(){
		getCurrentTime();
	}
	
	@BeforeMethod
	public void beforeEachTestMethod(){
		// Init the browser
		System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir")+"/drivers/chromedriver.exe"));

		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
		System.out.println (" chrome driver open ++++++++++++++++ ");
		// open browser	
		driver.get("http://www.booking.com");
	}
	
	@AfterMethod
	public void afterEachTestMethod(){
		comparedateTime();
		System.out.println("Comparing date and Time");
       // close browser
		driver.close();
		System.out.println (" Test is ended and browser is closeded +++++++ ");
	}
	
	@AfterSuite
	public void tearDown(){
		DateAddHour ();
		System.out.println("I added time calculation, lets see what happened");
		driver.quit();
		System.out.println (" Terminated WD +++++++ ");
	}

}