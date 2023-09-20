package pages;


import java.io.IOException;
import java.util.List;

import org.junit.Assert;

import resources.CreateFile;
import resources.Helper;

import org.openqa.selenium.support.ui.Select;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Credits {

	private WebDriver driver;
	
	public Credits(WebDriver driver) {
		this.driver=driver;
	}
	
	public void go_to_vehicles() {
		driver.findElement(By.id("tab-categoria-vehiculo")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"creditos\"]/div/div[1]/div[1]/h2")).isEnabled());
	}
	
	public void go_to_simulator() {
		
		Helper h= new Helper(driver);
		WebElement element= driver.findElement(By.xpath("//*[@id=\"creditos\"]/div/div[2]/div[2]/div/div[1]/div/div[3]/div/a[1]"));
		h.scroll(element);
		element.click();
		Assert.assertTrue(driver.findElement(By.id("menu-sup")).isEnabled());
	}
	
	public void form(String vehicle, String mount, String cuote) throws IOException {
		Helper h= new Helper(driver);
		WebElement element= driver.findElement(By.id("tooltip1"));
		h.scroll(element);
		
		Select vehicle_type = new Select(driver.findElement(By.name("tipoCredito")));
		vehicle_type.selectByVisibleText(vehicle);
		driver.findElement(By.name("valorSolicitado")).sendKeys(mount);
		
		Select cuotes = new Select(driver.findElement(By.name("tipoCredito")));
		cuotes.selectByVisibleText(cuote);
		driver.findElement(By.id("btnSubmit")).click();
		
		CreateFile file= new CreateFile("Test");
		

		List<WebElement> elements=driver.findElements(By.className("col-xs-6 text-right cntInfo"));
		
		file.Write("Cuota: "+elements.get(0).getText());
		file.Write("Seguro de vida: "+elements.get(1).getText());
	}
}
