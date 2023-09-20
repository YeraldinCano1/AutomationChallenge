package pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import resources.Helper;

import org.openqa.selenium.JavascriptExecutor;


public class Persons {

	private WebDriver driver;
	
	public Persons(WebDriver driver) {
		this.driver=driver;
	}
	
	public void close_display(String id) {
		//close-modal-btn-mb
		driver.findElement(By.id(id)).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"headerMain\"]/div[2]/div[1]/figure/a")).isEnabled());
	}
	
	public void go_to_section() {
		Helper h = new Helper(driver);
		WebElement element= driver.findElement(By.className("col-lg-6 pr-lg-0 espacioTarjetas"));
		h.scroll(element);
		List<WebElement> elements=driver.findElements(By.className("btn btn-outline-brand btn-products"));
		elements.get(3).click();
		Assert.assertTrue(driver.findElement(By.id("//*[@id=\"breadcrumbs\"]/div/ul/li[3]/a")).isEnabled());
		
	}
	
	
}
