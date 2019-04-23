package helper.wait;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.helper.logger.LoggerHelper;

public class WaitHelper {
	Logger log=LoggerHelper.getLogger(WaitHelper.class);
	private WebDriver driver;
	
	public WaitHelper(WebDriver driver) {
		this.driver=driver;
	}
	
	public void WaitForElement(WebElement element,long timeOutInSeconds) {
		log.info("waiting");
		WebDriverWait wait=new WebDriverWait(driver, timeOutInSeconds);
		wait.until(ExpectedConditions. visibilityOf(element));
		log.info("Located element");
	}
}
