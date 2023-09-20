package resources;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Helper {

private WebDriver driver;
	
	public Helper(WebDriver driver) {
		this.driver=driver;
	}
	public void scroll(WebElement Element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Element);	}
}
