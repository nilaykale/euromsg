package euromsgDemoProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageItem.LoginItem;
import utils.ExcelUtils;

import org.testng.annotations.DataProvider;


public class LoginTest {

	WebDriver driver =null;
	ExtentReports extent = new ExtentReports();
	@BeforeTest
	public void setUpTest(){
		// start reporters
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");

		// create ExtentReports and attach reporter(s)
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		// creates a toggle for the given test, adds all log events under it    
		ExtentTest test = extent.createTest("Kaydedilenler");
		test.log(Status.INFO, "This step shows usage of log(status, details)");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\nilay\\eclipse-workspace\\imdb\\lib\\chromedriver.exe");
		driver =new ChromeDriver();
	}

	@Test(dataProvider="test1data")
	public  void Login(String email, String password) throws InterruptedException {

		System.out.println(email+" | "+password);	
		driver.get("https://console.euromsg.com/login?returnUrl=%2Fhome");
		LoginItem.textbox_email(driver).sendKeys(email);
		LoginItem.textbox_password(driver).sendKeys(password);
		//Login.click_recaptcha(driver).click();
		Thread.sleep(20000);
		LoginItem.button_login(driver).click();
		Thread.sleep(20000);

	}

	@DataProvider(name="test1data")
	public Object[][] getData() {
		String excelPath="C:\\Users\\nilay\\eclipse-workspace\\euromsgDemoProject\\excel\\Login.xlsx";
		ExcelUtils excel = new ExcelUtils(excelPath, "Sayfa1");
		Object data [][] = excel.testData();
		return data;
	}
}
