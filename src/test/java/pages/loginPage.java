package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import helper.Base;

public class loginPage extends Base {

	By usernametab = By.cssSelector("input#user-name");
	By passwordtab = By.cssSelector("input#password");
	By loginbtn = By.cssSelector("input#login-button");
	By homepagelogo = By.cssSelector("span.title");

	public void user_enter(String string1) {

		waitforexpectedelement(usernametab).click();
		waitforexpectedelement(usernametab).sendKeys(string1);

	}

	public void user_enter_password() {
		waitforexpectedelement(passwordtab).click();
		waitforexpectedelement(passwordtab).sendKeys("secret_sauce");

	}

	public void user_clicked_on_login_button() {

		waitforexpectedelement(loginbtn).click();

	}

	public void user_verified_sucessful_login_home() {

		Assert.assertTrue(driver.findElement(loginbtn).isDisplayed());

	}

}
