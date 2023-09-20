package test;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.Credits;
import pages.Persons;

public class Tests {

	private WebDriver driver;
	
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.bancolombia.com/personas");
		
	}
	
	@Test
	public void test_one() throws IOException {
		//se utiliza el chromedriver de la version 114.0.5735.90
		
		Persons p = new Persons(driver);
		Credits c = new Credits(driver);
		
		p.close_display("close-modal-btn-mb");
		p.go_to_section();
		c.go_to_vehicles();
		c.go_to_simulator();
		c.form("Motos", "19350355", "48");
		
		
	}
	
	@After
	public void after() {
		//driver.quit();
	}
	
	
}
