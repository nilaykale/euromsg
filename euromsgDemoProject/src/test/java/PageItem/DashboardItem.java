package PageItem;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
public class DashboardItem {

	private static WebElement element =null;

	static WebDriverWait wait;

	public static WebElement click_UyeOl(WebDriver driver) {

		element = driver.findElement(By.xpath("//div[@class=\"page-home-square mb-3\"]"));

		return element;
	}

	public static WebElement click_YeniListe(WebDriver driver){

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn btn-labeled btn-purple\"]")));
		return element;
	}

	public static WebElement textbox_isim(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Listeye isim ver']")));

		return element;
	}

	public static WebElement click_Kaydet(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"btn-label\"]")));
		return element;
	}

	public static WebElement click_UyeEkle(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn btn-labeled btn-purple dropdown-toggle\"]")));
		return element;
	}

	public static WebElement click_FormEkle(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Form ile Ekle')]")));
		return element;
	}

	public static WebElement textbox_Ad(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		return element;
	}

	public static WebElement textbox_Soyad(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("lastName")));
		return element;
	}

	public static WebElement textbox_Email(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		return element;
	}

	public static WebElement click_Checkbox(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@class=\"checkbox-label\"]")));
		return element;
	}

	public static WebElement click_UyeKaydet(WebDriver driver) {

		WebDriverWait wait = new WebDriverWait(driver, 10);
		element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class=\"btn btn-labeled btn-success\"]")));
		return element;
	}

	public static Object[] get_LastItem(WebDriver driver) throws InterruptedException {

		Thread.sleep(1000);
		List<WebElement> rowElements = driver.findElements(By.xpath("//div[@class=\"table-responsive ng-star-inserted\"]/table/tbody/tr"));
		int rowsize = rowElements.size();

		List<WebElement> columnElements = driver.findElements(By.xpath("//div[@class=\"table-responsive ng-star-inserted\"]/table/tbody/tr[1]/td"));
		int columnSize = columnElements.size();

		Object[] items = new Object[columnSize];
		for(int j=1; j<=columnSize; j++) {

			items [j-1] = driver.findElement(By.xpath("//div[@class=\"table-responsive ng-star-inserted\"]/table/tbody/tr[" + rowsize + "]/td[" + j + "]")).getText();
		}
		return items;
	}
}