package com.in28minutes.datadriventests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


//Коментара ми е, ме понякога уин понякога люн, щото отваря през зареждане различни страници!!!

public class UnSuccessfulLoginBasic1Test {
	@Test
	public void testUnsuccessfulLoginWith28Minutes() {
		WebDriverManager.chromedriver().setup();
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mythos\\Desktop\\Drivers\\chromedriver.exe"); 
		WebDriver driver = new ChromeDriver();
		driver.get("https://mail.bg/auth/lgn");
		
		driver.findElement(By.id("imapuser")).sendKeys("*******@mail.bg");
		WebElement passwordElement = driver.findElement(By.id("pass"));
		passwordElement.sendKeys("ukh");
		
		//driver.findElement(By.className("login_button")).click();
		passwordElement.submit();
		
		String errorMessageText = driver.findElement(By.id("footer_left")).getText();
		System.out.println(errorMessageText);
		assertEquals(errorMessageText,"© 2022 Mail.bg");
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
