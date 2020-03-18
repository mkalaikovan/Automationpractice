BasePage.Java
=============

package com.app.pages;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	public static WebDriver driver;
	public String browser = "chrome";

	public BasePage() {
		if (driver == null) {
			if (browser.equals("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Pranith\\Desktop\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browser.equals("firefox")) {
				System.setProperty("webdriver.gecko.driver", "Firefox Driver Server Path");
				driver = new FirefoxDriver();
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			driver.get("http://automationpractice.com/index.php/");
			WebElement v =driver.findElement(By.xpath("//div//li//li//a[@title='T-shirts']"));
			Actions act=new Actions(driver);
			act.moveToElement(v).build().perform();
			
			WebElement a = driver.findElement(By.id("//div[@class]//label"));
			Select sel = new Select(a);
			sel.selectByValue("id_gender1");
			
			WebElement b = driver.findElement(By.id("//*[@id='firstname']"));
			Select sel1 = new Select(b);
			sel1.selectByValue("firstname");
			
			WebElement c = driver.findElement(By.id("//*[@id='lastname']"));
			Select sel2 = new Select(c);
			sel2.selectByValue("lastname");
			
			WebElement d = driver.findElement(By.id("//*[@id='email']"));
			Select sel3 = new Select(d);
			sel3.selectByValue("email");
			
			WebElement e = driver.findElement(By.id("//*[@id='old_passwd']"));
			Select sel4 = new Select(e);
			sel4.selectByValue("old_passwd");
			
			WebElement f = driver.findElement(By.id("//*[@id='passwd']"));
			Select sel5 = new Select(f);
			sel5.selectByValue("passwd");
			
			WebElement g = driver.findElement(By.id("//*[@id='confirmation']"));
			Select sel6 = new Select(g);
			sel6.selectByValue("confirmation");
			
			driver.findElement(By.name("submitIdentity")).click();
			
			WebDriverWait wait=new WebDriverWait(driver,10);
	        WebElement  w= wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pers_details")));
	        System.out.println(w.getAttribute("value"));//printing the order number
			
		}
	}

	public boolean elementFound(WebElement element) {
		boolean res = false;
		try {
			res = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return res;
	}

	public void setText(WebElement element, String name) {
		if (name != null) {
			element.click();
			element.clear();
			element.sendKeys(name);
		}
	}

	public String getTxtAttribute(WebElement element) {
		return element.getAttribute("value");
	}

	public String selectFromDropDown(WebElement element, String option) {
		Select obj = new Select(element);
		obj.selectByValue(option);
		return obj.getFirstSelectedOption().getText();
	}

	public boolean isElementVisible(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 90);
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getTitlte() {
		return driver.getTitle();
	}	
	
	public void quitDriver() {
		driver.quit();
	}
}

