package factory;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
 
 Info on THREAD LOCAL
 
ThreadLocal is a specially provisioned functionality by JVM to provide an isolated storage space for threads only. 
like the value of instance scoped variable are bound to a given instance of a class only. 
each object has its only values and they can not see each other value. 

so is the concept of ThreadLocal variables, they are local to the thread in the sense of object instances other thread except for the one which created it, can not see it.
 
 
 */

public class DriverFactory {

	/**
	 * This method is used to initialize the ThreadLocal driver on the basis of
	 * given browser
	 * 
	 * @param browser
	 * @return this will return tdriver.
	 */
	public WebDriver driver;

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver init_driver(String browser) {

		if (browser.equals("chrome")) {

			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\user\\Downloads\\chromedriver.exe");

			ChromeOptions coptions = new ChromeOptions();

			coptions.addArguments("--remote-allow-origins=*");
			ChromeDriver driver = new ChromeDriver(coptions);
			tlDriver.set(driver);

		} else if (browser.equals("firefox")) {

			FirefoxOptions coptions = new FirefoxOptions();

			coptions.addArguments("--remote-allow-origins=*");

			tlDriver.set(new FirefoxDriver(coptions));

		} else if (browser.equals("edge")) {

			WebDriverManager.edgedriver().setup();

			EdgeOptions coptions = new EdgeOptions();

			coptions.addArguments("--remote-allow-origins=*");

			tlDriver.set(new EdgeDriver(coptions));

		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */

	public static synchronized WebDriver getDriver() {
		return tlDriver.get();
	}

}
