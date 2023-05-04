package com.in28minutes.datadriventests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SuccessfulLoginBasicTest {
	@Test
	public void testLoginWith28Minutes() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.bg/auth/lgn");
		
		driver.findElement(By.id("imapuser")).sendKeys("sartarus@mail.bg");
		WebElement passwordElement = driver.findElement(By.id("pass"));
		passwordElement.sendKeys("hugoboss");
		
		sleep(4);
		//driver.findElement(By.className("login_button")).click();
		passwordElement.submit();
		sleep(4);
		
		driver.quit();
	}
	
	private void sleep(int i) {
		try {
			Thread.sleep(i * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
