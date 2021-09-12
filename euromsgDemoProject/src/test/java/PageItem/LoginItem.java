package PageItem;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
public class LoginItem {

	private static WebElement element =null;

	static WebDriverWait wait;

	public static WebElement textbox_email(WebDriver driver) {

		element = driver.findElement(By.id("exampleInputEmail1"));

		return element;
	}

	public static WebElement textbox_password(WebDriver driver) {

		element = driver.findElement(By.id("exampleInputPassword1"));

		return element;
	}

	public static WebElement click_recaptcha(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@id=\"recaptcha-anchor\"]"));

		return element;
	}

	public static WebElement button_login(WebDriver driver) {

		element = driver.findElement(By.xpath("//*[@class=\"btn btn-block btn-primary mt-3\"]"));
		return element;
	}
}