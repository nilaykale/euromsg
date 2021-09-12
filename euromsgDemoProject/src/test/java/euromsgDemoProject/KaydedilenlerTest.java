package euromsgDemoProject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import PageItem.DashboardItem;
import utils.ExcelUtils;
import org.testng.Assert;

import org.testng.annotations.DataProvider;


public class KaydedilenlerTest {
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

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--user-data-dir=C:\\Users\\nilay\\AppData\\Local\\Google\\Chrome\\User Data");
		options.addArguments("--profile-directory=Profile 3");
		driver = new ChromeDriver(options);
		driver.get("https://console.euromsg.com/home");
		//driver =new ChromeDriver();

	}

	@BeforeTest
	public void üyeOl() {
		DashboardItem.click_ÜyeOl(driver).click();
		DashboardItem.click_YeniListe(driver).click();
		DashboardItem.textbox_isim(driver).sendKeys("Liste1");
		DashboardItem.click_Kaydet(driver).click();
		DashboardItem.click_ÜyeEkle(driver).click();
		DashboardItem.click_FormEkle(driver).click();
	}

	@Test(dataProvider="test2data")
	public void üyeEkle(String ad, String soyad, String email) throws InterruptedException{

		DashboardItem.textbox_Ad(driver).sendKeys(ad);
		DashboardItem.textbox_Soyad(driver).sendKeys(soyad);
		DashboardItem.textbox_Email(driver).sendKeys(email);
		DashboardItem.click_Checkbox(driver).click();
		DashboardItem.click_ÜyeKaydet(driver).click();
		Object[] kayıt =DashboardItem.get_LastItem(driver);

		Assert.assertEquals(email, kayıt[0]);
		Assert.assertEquals(ad, kayıt[1]);		
		Assert.assertEquals(soyad, kayıt[2]);

	}

	@AfterTest
	public void sonuc() {
		extent.flush();
	}
	@DataProvider(name="test2data")
	public Object[][] getData() {
		String excelPath="C:\\Users\\nilay\\eclipse-workspace\\euromsgDemoProject\\excel\\Uye.xlsx";
		ExcelUtils excel = new ExcelUtils(excelPath, "Sayfa1");
		Object data [][] = excel.testData();
		return data;
	}
}
