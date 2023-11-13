package helper;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {

	public static WebDriver driver;

	@Before
	public void setup() {

		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();

		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();

	}

	@After
	public void teardown(Scenario s) throws IOException {

		if (s.isFailed()) {

			TakesScreenshot t = (TakesScreenshot) driver;
			File src = t.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("screenshots/" + s.getName() + ".png"));
		}
		driver.quit();

	}

	public void selectbyvisibletext(By location, String value) {
		WebElement ele = driver.findElement(location);
		Select s = new Select(ele);
		s.selectByVisibleText(value);
	}

	public void selectbyindex(By location, int value) {
		WebElement ele = driver.findElement(location);
		Select s = new Select(ele);
		s.selectByIndex(value);
	}

	public void selectbyvalue(By location, String value) {
		WebElement ele = driver.findElement(location);
		Select s = new Select(ele);
		s.selectByValue(value);
	}

	public void mousehover(By abc) {
		WebElement ele = driver.findElement(abc);
		Actions a = new Actions(driver);
		a.moveToElement(ele).build().perform();

	}

	public void normalclick(By location) {

		WebElement ele = driver.findElement(location);
		ele.click();
	}

	public void clickbyexecutor(By location) {
		WebElement ele = driver.findElement(location);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);
	}

	public void alertaccepted() {

		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void alertdismiss() {

		Alert a = driver.switchTo().alert();
		a.dismiss();
	}

	public void alertsendkey(String value) {
		Alert a = driver.switchTo().alert();
		a.sendKeys(value);
		a.accept();

	}

	public WebElement waitforexpectedelement(By by) {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void takesnap() throws IOException {

		TakesScreenshot t = (TakesScreenshot) driver;
		File src = t.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("screenshots/test.png"));

	}

}
