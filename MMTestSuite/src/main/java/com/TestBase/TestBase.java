package com.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.enums.Browsers;
import com.enums.OS;

public class TestBase {
	public static WebDriver driver;
	public WebDriver selectBrowser(String browser) {
		if (System.getProperty("os.name").toLowerCase().contains(OS.WINDOW.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			} 

		} else if (System.getProperty("os.name").toLowerCase().contains(OS.MAC.name().toLowerCase())) {
			if (browser.equalsIgnoreCase(Browsers.CHROME.name())) {
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver");
				driver = new ChromeDriver();
			}
		}
		return driver;
	}
}
